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
    
    // create file of random unsorted integers from 0 to 9999999
//    int n = 1_000_000;
//    int min = 0;
//    int max = 10_000_000;
//    String filename = "integers.txt";
//    long start = System.currentTimeMillis();
//    Util.createFileOfRandomUnsortedIntegersWithoutDuplicates(n, min, max, filename);
//    long finish = System.currentTimeMillis();
//    long timeElapsed = (finish - start) / 1000;
//    System.out.println("10 million created in " + timeElapsed + " seconds.");
}
