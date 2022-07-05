package rip.hippo.translate.translator.impl;

import org.bukkit.ChatColor;
import rip.hippo.translate.translator.Translator;

/**
 * @author Hippo
 */
public final class LegacyTranslator implements Translator {
  @Override
  public String translate(String string) {
    return ChatColor.translateAlternateColorCodes('&', string);
  }
}
