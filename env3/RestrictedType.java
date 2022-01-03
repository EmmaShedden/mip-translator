
import java.util.*;

public class RestrictedType extends Type {
    private Number lower, upper;

    public RestrictedType(DataType t) {
        super(t);
        throw new RuntimeException("Cannot construct RestrictedType without bounds");
    }

    public RestrictedType(Number l, Number u) {
        super();
        if (l.getClass() == Integer.class && u.getClass() == Integer.class) {
            type = DataType.Int;
            lower = l;
            upper = u;
        } else if (l.getClass() == Float.class || u.getClass() == Float.class) {
            type = DataType.Float;
            lower = l.floatValue();
            upper = u.floatValue();
        } else {
            throw new RuntimeException("Invalid data type in declaration");
        }
    }

    public String toString() {
        String prefix = super.toString();
        return prefix + " : " + lower.toString() + " .. " + upper.toString();
    }
}