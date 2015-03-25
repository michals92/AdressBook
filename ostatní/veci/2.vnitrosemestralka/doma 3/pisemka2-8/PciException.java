
/**
 * Exceptions for PCI bus errors.
 */
public class PciException extends Exception {
    public PciException() {
        super();
    }
    
    public PciException(String msg) {
        super(msg);
    }

    public PciException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public PciException(Throwable cause) {
        super(cause);
    }
}
