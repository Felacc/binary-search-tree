package ics124.assignment4;

public class BstMissingKeyException extends RuntimeException {

    public BstMissingKeyException() {
        super();
    }

    public BstMissingKeyException(int x) {
        this(x + " not found in tree");
    }
    
    public BstMissingKeyException(String msg) {
        super(msg);
    }
}
