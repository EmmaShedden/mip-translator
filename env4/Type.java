
import java.util.*;

public class Type extends Object {
    protected DataType type;

    public Type() {
        type = DataType.Null;
    }

    public Type(DataType t) {
        type = t;
    }

    public String toString() {
        if (type == DataType.Int) {
            return "Integer";
        } else {
            return "Float";
        }
    }
}