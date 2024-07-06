import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {
    public static void createFileOfRandomUnsortedIntegersWithoutDuplicates(int n, int min, int max, String filename) {
        Random random = new Random();
        List<Integer> numbersToBeSorted= new ArrayList<>();
        int count = 0;
        try {
            FileWriter myWriter = new FileWriter(filename);
            while (count < n) {
                int val = random.nextInt(max - min) + min;
                if (numbersToBeSorted.contains(val)) {
                    continue;
                }
                myWriter.write(String.valueOf(val) + "\n");
                numbersToBeSorted.add(val);
                count++;
            }
            myWriter.close();  
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
