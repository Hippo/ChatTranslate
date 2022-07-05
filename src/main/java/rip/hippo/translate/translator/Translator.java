package rip.hippo.translate.translator;

/**
 * @author Hippo
 */
@FunctionalInterface
public interface Translator {
  String translate(String string);
}
