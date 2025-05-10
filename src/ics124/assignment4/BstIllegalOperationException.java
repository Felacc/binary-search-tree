package ics124.assignment4;

public class BstIllegalOperationException extends RuntimeException {

    /**
     * Creates a new instance of <code>BstIllegalOperation</code> without detail message.
     */
    public BstIllegalOperationException() {
    }


    /**
     * Constructs an instance of <code>BstIllegalOperation</code> with the specified detail message.
     * @param msg the detail message.
     */
    public BstIllegalOperationException(String msg) {
        super(msg);
    }
}
