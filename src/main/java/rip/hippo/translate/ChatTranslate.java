package rip.hippo.translate;

import rip.hippo.translate.translator.Translator;
import rip.hippo.translate.translator.impl.LegacyTranslator;
import rip.hippo.translate.translator.impl.ModernTranslator;
import rip.hippo.version.BukkitVersion;

/**
 * @author Hippo
 */
public final class ChatTranslate {

  private static Translator translator;
  private ChatTranslate() {
    throw new IllegalStateException();
  }

  public static String translate(String string) {
    return getTranslator().translate(string);
  }

  private static Translator getTranslator() {
    if (translator == null) {
      BukkitVersion current = BukkitVersion.getCurrent();
      if (current.isGreaterThanOrEqual(new BukkitVersion(1, 16))) {
        translator = new ModernTranslator();
      } else {
        translator = new LegacyTranslator();
      }
    }
    return translator;
  }
}
