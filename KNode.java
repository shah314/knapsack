
import java.util.*;

/**
 * The knapsack node in the branch and bound tree.
 * @author  Shalin Shah
 * Email: shalin@alumni.usc.edu
 */
public class KNode implements Comparable
{
    private BitSet knapsack = null;
    private double maxValue = 0;
    private boolean pruned = false;
    private boolean fathomed = false;
    private int size = 0;
    private int index = 0;
    private int value;
    private int weight;
    
    /** Creates a new instance of KNode */
    public KNode(BitSet k, int ind, int w, int v) {
        knapsack = k;
        index = ind;
        weight = w;
        value = v;
    }
    
    public KNode(BitSet set, int ind)
    {
        knapsack = set;
        index = ind;
        weight = Util.calculateValue(set);
        value = Util.calculateValue(set);
    }
    
    public int getIndex()
    {
        return index;
    }
    
    public int weight()
    {
        if(knapsack == null)
            return 0;
        
        return weight;
    }
    
    public int value()
    {
        if(knapsack == null)
            return 0;
        
        return value;
    }
    
    public void fathom()
    {
        fathomed = true;
    }
    
    public void prune()
    {
        pruned = true;
    }
    
    public boolean isFathomed()
    {
        return fathomed;
    }
    
    public boolean isPruned()
    {
        return pruned;
    }
    
    public void addOne()
    {
        value+=Constants.VALUES[index];
        weight+=Constants.WEIGHTS[index];
        knapsack.set(index, true);
        index++;
        maxValue = Relaxation.calculateValue(knapsack, index);
    }
    
    public void addZero()
    {
        knapsack.set(index, false);
        index++;
        maxValue = Relaxation.calculateValue(knapsack, index);
    }
    
    public int size()
    {
        return size;
    }
    
    public double maxValue()
    {
        return maxValue;
    }
    
    public int compareTo(Object obj) {
        KNode o = (KNode)obj;

        if(o.maxValue() > this.maxValue())
            return -1;
        else if(o.maxValue() < this.maxValue())
            return 1;
        
        if(knapsack.equals(o.getKnapsackContents()) && o.getIndex() == index)
            return 0;
        
        // unreachable
        return -1;
    }
    
    public BitSet getKnapsackContents()
    {
        return knapsack;
    }
}
