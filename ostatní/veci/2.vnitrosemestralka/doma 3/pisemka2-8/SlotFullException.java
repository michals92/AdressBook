/**
 * No free slot in PCI bus.
 */
public class SlotFullException extends PciException {
    public SlotFullException() {
        super();
    }
    
    public SlotFullException(String msg) {
        super(msg);
    }

    public SlotFullException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public SlotFullException(Throwable cause) {
        super(cause);
    }
}
