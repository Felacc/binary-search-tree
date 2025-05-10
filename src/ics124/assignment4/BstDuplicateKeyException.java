package ics124.assignment4;

public class BstDuplicateKeyException extends RuntimeException {

    public BstDuplicateKeyException() {
        super();
    }
    
    public BstDuplicateKeyException(int x) {
        this(x + " already in tree");
    }
    public BstDuplicateKeyException(String msg) {
        super(msg);
    }

}
