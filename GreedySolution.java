
import java.util.*;

/**
 * Greedy algorithm - Used as the incumbent in the branch and bound procedure
 * @author  Shalin Shah
 * Email: shalin@alumni.usc.edu
 */
public class GreedySolution 
{    
    public static void main(String [] args) throws Exception
    {
        DataProcessor.processData();
        System.out.println(runGreedyAlgorithm().value());
        System.out.println(runGreedyAlgorithm().getKnapsackContents());
    }
    
    /** Run the greedy algorithm for the 0/1 knapsack problem */
    public static KNode runGreedyAlgorithm()
    {
        List l = new ArrayList();
        int greedyEstimate = 0;
        for(int i=0; i < Constants.NUMBER_OBJECTS; i++)
        {
            int w = Constants.WEIGHTS[i];
            int v = Constants.VALUES[i];
            double ratio = (double)v/(double)w;
            CompareObject o = new CompareObject();
            o.valueWeightRatio = ratio;
            o.objectNumber = i;
            l.add(o);
        }
        
        Collections.sort(l);
        KNode sack = new KNode(Util.createEmptyKnapsack(), 0, 0, 0);
        BitSet s = sack.getKnapsackContents();
        Iterator it = l.iterator();
        while(it.hasNext())
        {
           CompareObject obj = (CompareObject)it.next();
           int ono = obj.objectNumber;
           s.set(ono, true);
           KNode temp = new KNode(s, 0);
           if(!Util.isValidSolution(temp.getKnapsackContents()))
           {
                s.set(ono, false);
           }
        }
        return new KNode(s, 0);
    }
}
