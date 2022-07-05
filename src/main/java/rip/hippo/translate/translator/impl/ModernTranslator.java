package rip.hippo.translate.translator.impl;

import net.md_5.bungee.api.ChatColor;
import rip.hippo.translate.translator.Translator;

/**
 * @author Hippo
 */
public final class ModernTranslator implements Translator {

  @Override
  public String translate(String string) {
    StringBuilder stringBuilder = new StringBuilder();

    int i = 0;
    int end = string.length() - 1;
    while (i < string.length()) {
      char c = string.charAt(i);

      if (c == '&' && i != end) {
        char next = string.charAt(++i);
        if (next == '#') {
          StringBuilder hex = new StringBuilder();
          hex.append(next);
          try {
            for (int j = 0; j < 6; j++) {
              hex.append(string.charAt(++i));
            }
          } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("Invalid hex code, expected 6 characters, got " + hex.length(), e);
          }

          stringBuilder.append(ChatColor.of(hex.toString()));
        } else {
          ChatColor color = ChatColor.getByChar(next);
          if (color == null) {
            stringBuilder.append(c).append(next);
          } else {
            stringBuilder.append(color);
          }
        }
      } else {
        stringBuilder.append(c);
      }
      i++;
    }

    return stringBuilder.toString();
  }
}
