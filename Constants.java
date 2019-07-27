
/**
 * Constants
 * @author  Shalin Shah
 * Email: shalin@alumni.usc.edu
 */
public class Constants {

    public static int [] VALUES = null; // populated automatically
    public static int [] WEIGHTS = null; // populated automatically

    /* Change the following to the files that contain the weights and values
     * of the problem instance */
    public static String DATA_FILE_WEIGHTS = "weights.txt";
    public static String DATA_FILE_VALUES = "values.txt";
    public static String DELIMITER = ",";
    public static int NUMBER_OBJECTS = 5000;
    public static int MAX_WEIGHT = 20908;

    /* Lagrangian Relaxation Parameters */
    public static double INITIAL_LAMBDA = 0;
    public static double INITIAL_INCREMENT = 1;
    public static double LAMBDA_TOLERANCE = 0.01;

    /* Variables for random improvement */
    public static final int REMOVED = 2;
    public static final int LOOP = 100;
    public static final int INNER_LOOP = 100;

    static
    {
        try
        {
            DataProcessor.processData();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    /** Creates a new instance of Constants */
    public Constants() {
    }

}
