package CSGFramework.Exceptions;

/**
 * Exception user for writers when a user tries
 * to write to wrong file type.
 */
public class WrongFileTypeException extends Exception {
    public WrongFileTypeException(){super("Exception: This method cannot write to given file");}
}
