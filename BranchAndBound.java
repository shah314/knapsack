
import java.util.*;
import java.io.*;

/**
 * Best First Branch and Bound Algorithm for the 0/1 Knapsack problem.
 * This algorithm uses Lagrangian relaxation to prune the Branch and Bound tree.
 * @author  Shalin Shah
 * Email: shalin@alumni.usc.edu
 */
public class BranchAndBound
{    
    public static void main(String [] args)
    {   
        long start = System.currentTimeMillis();
        LagrangianRelaxation.calculateLambda();
        KNode incumbent = GreedySolution.runGreedyAlgorithm();
        System.out.println("Greedy Solution - " + incumbent.value());
        incumbent = RandomSearch.randomSearch(incumbent);
        System.out.println("Improved Greedy Solution - " + incumbent.value());
        incumbent = runBranchAndBound(incumbent);
        long end = System.currentTimeMillis();
        System.out.println((end-start) + " milliseconds.");
        System.out.println("Optimum Value: " + incumbent.value());
        System.out.println("Weight: " + incumbent.weight());
        System.out.println(incumbent.getKnapsackContents());
    }

    public static KNode runBranchAndBound(KNode in)
    {
        KNode incumbent = new KNode((BitSet)in.getKnapsackContents().clone(), 0, in.weight(), in.value());
        TreeSet heap = new TreeSet();
        KNode node1 = new KNode(new BitSet(Constants.NUMBER_OBJECTS), 0, 0, 0);
        KNode node2 = new KNode(new BitSet(Constants.NUMBER_OBJECTS), 0, 0, 0);
        node1.addOne();
        node2.addZero();
        
        if(node1.maxValue() > incumbent.value())
            heap.add(node1);
            
        if(node2.maxValue() > incumbent.value())
            heap.add(node2);
        
        boolean heapEmpty = false;
        
        while(!heap.isEmpty())
        {   
            KNode node = (KNode)heap.first();
            heap.remove(node);
            
            while(node.getIndex() == Constants.NUMBER_OBJECTS)
            {
                node.fathom();
                if(node.value() > incumbent.value() && Util.isValidSolution(node))
                {
                    incumbent = node;
                }
                
                if(!heap.isEmpty())
                {
                    node = (KNode)heap.first();
                    heap.remove(node);
                }
                else
                {
                    heapEmpty = true;
                    break;
                }
            }
            
            if(heapEmpty)
            {
                break;
            }
            
            /* Expand the node */
            KNode node3 = new KNode((BitSet)node.getKnapsackContents().clone(), node.getIndex(), node.weight(), node.value());
            KNode node4 = new KNode((BitSet)node.getKnapsackContents().clone(), node.getIndex(), node.weight(), node.value());
            node3.addOne();
            node4.addZero();
            
            if(node3.maxValue() > incumbent.value() && Util.isValidSolution(node3))
                heap.add(node3);
            
            if(node4.maxValue() > incumbent.value() && Util.isValidSolution(node4))
                heap.add(node4);
        }
        
        return incumbent;
    }
}