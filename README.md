<h1>Branch and Bound for the 0/1 Knapsack Problem</h1>
<h3>Shalin Shah</h3>
<p>A Java implementation of the branch and bound algorithm for the 0/1 knapsack problem. The code uses Lagrangian relaxation to prune the search tree. It uses best first search.</p>
<p>A sample instance of 5000 items is included. This instance has the weights in weights.txt and values (profits) in values.txt. The file solution.txt contains some information about the problem instance. The algorithm takes about 50 seconds to solve the 5000 instance (depends on the constraint though).</p>
<pre>Compile and run "java BranchAndBound"</pre>
<pre>Change the following in Constants.java:
  DATA_FILE_WEIGHTS
  DATA_FILE_VALUES
  DELIMITER
  MAX_WEIGHT
  NUMBER_OBJECTS</pre>
<b>Cite this code:</b>
<pre>
@misc{shah2014bknapsack,
  title={Branch and Bound for the 0/1 Knapsack Problem},
  author={Shah, Shalin},
  year={2014}
}
</pre>
<p>Other instances are available <a href="https://people.sc.fsu.edu/~jburkardt/datasets/knapsack_01/knapsack_01.html">here</a>.</p>
<p>(The code is written in an old version of Java but compiles and runs fine.)</p>
