
import java.util.*;

/**
 * A compare object used for sorting.
 * @author  Shalin Shah
 * Email: shalin@alumni.usc.edu
 */
public class CompareObject implements Comparable
{
    public int objectNumber;
    public double valueWeightRatio;
    
    public int compareTo(Object obj) 
    {
        CompareObject object = (CompareObject)obj;
        double w = object.valueWeightRatio;
        double w1 = this.valueWeightRatio;
        if(w1 <  w)
            return 1;
    
        if(w1 == w)
            return 0;
    
        return -1;
    }
}