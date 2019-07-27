
import java.util.*;

/**
 * This class implements lagrangian relaxation to prune the branch and bound tree.
 * @author  Shalin Shah
 * Email: shalin@alumni.usc.edu
 */
public class LagrangianRelaxation {
    
    public static double lambda = Constants.INITIAL_LAMBDA;
    public static double [] SOLUTION = new double [Constants.NUMBER_OBJECTS];
    public static double [] VALUES = new double[Constants.NUMBER_OBJECTS];
    
    /** Creates a new instance of LagrangianRelaxation */
    public LagrangianRelaxation() {
    }
    
    public static void calculateLambda()
    {
        lambda = Constants.INITIAL_LAMBDA;
        double increment = Constants.INITIAL_INCREMENT;
        double tolerance = Constants.LAMBDA_TOLERANCE;
        boolean found = false;
        
        while(true)
        {   
            while(true)
            {
                BitSet solution = calculateSolution();
                if(Util.isValidSolution(solution))
                {
                    lambda = lambda - increment;
                    break;
                }
                lambda = lambda + increment;
            }
            if(increment < tolerance)
            {
                lambda+=increment;
                break;
            }
            increment/=2;
        }
    }
    
    public static BitSet calculateSolution()
    {
        double [] solution = new double[Constants.NUMBER_OBJECTS];
        KNode knapsack = new KNode(new BitSet(Constants.NUMBER_OBJECTS), 0);
        
        for(int i=0; i<Constants.NUMBER_OBJECTS; i++)
        {
            double w = lambda * (double)Constants.WEIGHTS[i];
            double v = (double)Constants.VALUES[i] - w;
            solution[i] = v;
        }
        
        SOLUTION = solution;
        
        for(int i=0; i<Constants.NUMBER_OBJECTS; i++)
        {
            if(solution[i] < 0)
            {
                knapsack.getKnapsackContents().set(i, false);
            }
            else
            {
                knapsack.getKnapsackContents().set(i, true);
            }
        }
        
        return knapsack.getKnapsackContents();
    }
    
    /* Calculate the upper bound on the valuu
     */
    public static double calculateValue()
    {
        double value = lambda * (double)Constants.MAX_WEIGHT;
        for(int i=0; i<Constants.NUMBER_OBJECTS; i++)
        {
            if(SOLUTION[i] > 0)
            {
                value+=SOLUTION[i];
            }
        }
        
        return value;
    }
    
    /** Calculate the maximum value possible to be achieved
     * when a partial knapsack is passed in 
     * This function is used for two purposes:
     * 1) To prune the branch and bound tree
     * 2) To find the best node to branch on
     */
    public static double calculateValue(BitSet set, int index)
    {
        int size = index;
        double value = lambda * (double)Constants.MAX_WEIGHT;
        for(int i=0; i<size; i++)
        {
            if(set.get(i) == true)
            {
                value+=SOLUTION[i];
            }
        }
        
        if(VALUES[index-1] != 0)
            return value+=VALUES[index-1];
        
        double value1 = 0;
        for(int i=size; i<Constants.NUMBER_OBJECTS;i++)
        {
            if(SOLUTION[i] > 0)
            {
                value1+=SOLUTION[i];
            }
        }
        
        VALUES[index-1] = value1;
        return value+value1;
    }
}
