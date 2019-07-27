
import java.io.*;
import java.util.*;

/**
 * Process the data from the files specified in Constants.java
 * @author  Shalin Shah
 * Email: shalin@alumni.usc.edu
 */
public class DataProcessor 
{    
    /** Process the data */
    public static void processData() throws Exception
    {
        Constants.VALUES = new int [Constants.NUMBER_OBJECTS];
        Constants.WEIGHTS = new int [Constants.NUMBER_OBJECTS];
        
        File weights = new File(Constants.DATA_FILE_WEIGHTS);
        File values = new File(Constants.DATA_FILE_VALUES);
        
        BufferedReader wreader = new BufferedReader(new FileReader(weights));
        BufferedReader vreader = new BufferedReader(new FileReader(values));
        
        String buffer = wreader.readLine();
        int i = 0;
        while(buffer != null && i < Constants.NUMBER_OBJECTS)
        {
            StringTokenizer token = new StringTokenizer(buffer, Constants.DELIMITER);
            while(token.hasMoreTokens() && i < Constants.NUMBER_OBJECTS)
            {
                String tok = token.nextToken();
                tok = tok.trim();
                Constants.WEIGHTS[i] = Integer.parseInt(tok);
                i++;
            }
        }        
        
        buffer = vreader.readLine();
        i = 0;
        while(buffer != null && i < Constants.NUMBER_OBJECTS)
        {
            StringTokenizer token = new StringTokenizer(buffer, Constants.DELIMITER);
            while(token.hasMoreTokens() && i < Constants.NUMBER_OBJECTS)
            {
                String tok = token.nextToken();
                tok = tok.trim();
                Constants.VALUES[i] = Integer.parseInt(tok);
                i++;
            }
        }
    }
}
