
/**
 * Requred PCI card in not in any slot of the PCI bus.
 */
public class NoSuchCardException extends PciException {
    public NoSuchCardException() {
        super();
    }
    
    public NoSuchCardException(String msg) {
        super(msg);
    }

    public NoSuchCardException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public NoSuchCardException(Throwable cause) {
        super(cause);
    }

}
