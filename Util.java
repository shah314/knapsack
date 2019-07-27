
import java.util.*;

/**
 * Utility functions
 * @author  Shalin Shah
 * Email: shalin@alumni.usc.edu
 */
public class Util {
    
    /** Creates a new instance of Util */
    public Util() {
    }
    
    public static Random random = new Random();
    public static int generateRandomNumber(int min, int max)
    {
        int r;
        r = (int) (random.nextDouble() * (max - min + 1)) + min;
        return r;
    }
    
    public static double generateDoubleRandom(double min, double max)
    {
        double r;
        r = (double) (random.nextDouble() * (max - min)) + min;
        return r;
    }
    
    public static boolean isValidSolution(KNode sack)
    {
        if(sack.weight() <= Constants.MAX_WEIGHT)
        {
            return true;
        }
        
        return false;
    }
    
    public static boolean isValidSolution(BitSet sack) 
    {
        int weight = calculateWeight(sack);
        if(weight <= Constants.MAX_WEIGHT) 
        {
            return true;
        }
        
        return false;
    }

    public static int calculateWeight(BitSet set)
    {
        int weight = 0;
        for(int i=0; i<Constants.NUMBER_OBJECTS; i++)
        {
            if(set.get(i) == true)
            {
                weight+=Constants.WEIGHTS[i];
            }
        }
        return weight;
    }
    
    public static int calculateValue(BitSet set)
    {
        int value = 0;
        for(int i=0; i<Constants.NUMBER_OBJECTS; i++)
        {
            if(set.get(i) == true)
            {
                value+=Constants.VALUES[i];
            }
        }
        return value;
    }
    
    public static BitSet createEmptyKnapsack()
    {
       return new BitSet(Constants.NUMBER_OBJECTS);
    }
}
