
public class EmploymentOfficeException extends Exception {

    public EmploymentOfficeException(String s, Throwable t){
        super(s, t);
    }

    public EmploymentOfficeException(Throwable t){
        super(t);
    }

    public EmploymentOfficeException(String s){
        super(s);
    }

    public EmploymentOfficeException(){
        super();
    }
}
