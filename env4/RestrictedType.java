
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

    // unbounded below
    public RestrictedType(boolean l, Number u) {
        super();
        lower = null;
        if (u.getClass() == Integer.class) {
            type = DataType.Int;
            upper = u;
        } else if (u.getClass() == Float.class) {
            type = DataType.Float;
            upper = u.floatValue();
        } else {
            throw new RuntimeException("Invalid data type in declaration");
        }
    }

    // unbounded above
    public RestrictedType(Number l, boolean u) {
        super();
        upper = null;
        if (l.getClass() == Integer.class) {
            type = DataType.Int;
            lower = l;
        } else if (l.getClass() == Float.class) {
            type = DataType.Float;
            lower = l.floatValue();
        } else {
            throw new RuntimeException("Invalid data type in declaration");
        }
    }

    public String toString() {
        String prefix = super.toString();
        String l, u;
        if (lower == null) {
            l = "-infinity";
        } else {
            l = lower.toString();
        }
        if (upper == null) {
            u = "infinity";
        } else {
            u = upper.toString();
        }
        return prefix + " : " + l + " .. " + u;
    }
}