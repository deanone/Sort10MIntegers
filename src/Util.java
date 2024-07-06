import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {
    public static void createFileOfRandomUnsortedIntegersWithDuplicates(int n, int minValue, int maxValue, String filename) {
        Random rn = new Random();
        List<Integer> numbersOfToBeSorted= new ArrayList<>();
        int count = 0;
        try {
            FileWriter myWriter = new FileWriter(filename);
            while (count < n) {
                int val = minValue + rn.nextInt(maxValue - minValue + 1);
                if (numbersOfToBeSorted.contains(val)) {
                    continue;
                }
                myWriter.write(String.valueOf(val) + "\n");
                count++;
            }
            myWriter.close();  
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
