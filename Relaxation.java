
import java.util.*;

/**
 * Factory class for relaxations
 * @author  Shalin Shah
 * Email: shalin@alumni.usc.edu
 */
public class Relaxation {
    
    /** Creates a new instance of Relaxation */
    public Relaxation() {
    }
    
    public static double calculateValue(BitSet set, int index)
    {
        return LagrangianRelaxation.calculateValue(set, index);
    }
    
    public static double calculateValue()
    {
        return LagrangianRelaxation.calculateValue();
    }
}
