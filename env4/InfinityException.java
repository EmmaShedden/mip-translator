
// note infinity is only implemented for integers in this grammar
// as opposed to regular java where it's only implemented for doubles & floats
// and it should only be seen in the range specification in a type def, 
// not the right hand side expression in an assignment
public class InfinityException extends RuntimeException {
    public boolean pos = true;

    public InfinityException(){
        super("Cannot perform arithmetic on infinite values");
    }

    public InfinityException(String message){
        super(message);
    }
}
