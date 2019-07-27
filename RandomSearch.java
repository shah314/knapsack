
import java.util.*;

/**
 * Random Search on a filled knapsack.
 * @author  Shalin Shah
 * Email: shalin@alumni.usc.edu
 */
public class RandomSearch 
{    
    public static KNode randomSearch(KNode sack)
    {
        int i = 0;
        
        for(int n = 0; n < Constants.LOOP; n++)
        {
            BitSet array = sack.getKnapsackContents();
        
            // remove a certain number of knapsack objects
            for(int k = 0; k < Constants.LOOP; k++)
            {
                int rand = Util.generateRandomNumber(0, Constants.NUMBER_OBJECTS-1);
                if(array.get(rand) == true)
                {
                    array.set(rand, false);
                    i++;
                }
            
                if(i >= Constants.REMOVED)
                {
                    i = 0;
                    break;
                }
            }
            
            for(int m = 0; m < Constants.INNER_LOOP; m++)
            {
                int rand = Util.generateRandomNumber(0, Constants.NUMBER_OBJECTS-1);
                if(array.get(rand) == false)
                {
                    array.set(rand, true);
                    KNode temp = new KNode(array, 0);
                    if(!Util.isValidSolution(temp.getKnapsackContents()))
                    {
                        array.set(rand, false);
                    }
                }
            }
            
            KNode tem = new KNode(array, 0);
            if(Util.calculateValue(tem.getKnapsackContents()) > Util.calculateValue(sack.getKnapsackContents()))
                sack = new KNode((BitSet)array.clone(), 0);
        } 
          
        return sack;
    }
}
