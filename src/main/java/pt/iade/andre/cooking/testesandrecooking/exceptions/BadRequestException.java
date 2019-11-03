package pt.iade.andre.cooking.testesandrecooking.exceptions;

/**
 *
 * @author Rafael Vieira Rangel
 */
public class BadRequestException extends Exception {

    /**
     * Creates a new instance of <code>BadRequestException</code> without detail
     * message.
     */
    public BadRequestException() {
        // EMPTY
    }

    /**
     * Constructs an instance of <code>BadRequestException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public BadRequestException(String msg) {
        super(msg);
    }
}
