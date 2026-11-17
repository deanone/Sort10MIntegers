import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        if (args.length != 1) {
            throw new IllegalArgumentException("No arguments provided.");
        }
        
        int n = 100_000;
        String inputFilename = "integers.txt";
        String choice = args[0];
        
        if ("quicksort".equals(choice)) {
          
          String outputFilename = inputFilename.split("\\.")[0] + "_sorted.txt";
          List<Integer> arr = new ArrayList<>();
          
          try {
              BufferedReader br = new BufferedReader(new FileReader(inputFilename));
              String line;
              while ((line = br.readLine()) != null) {
                  arr.add(Integer.parseInt(line));
              }
              br.close();
          } catch (IOException ioe) {
              ioe.printStackTrace();
          }
          
          // measure only the time needed for sorting operations, not I/O
          long start = System.currentTimeMillis();
          Quicksort.run(arr, 0, 100_000-1);
          long finish = System.currentTimeMillis();
          long timeElapsed = finish - start;
          
          try {
              FileWriter myWriter = new FileWriter(outputFilename);
              for (int i = 0; i < n; i++) {
                  myWriter.write(String.valueOf(arr.get(i)) + "\n");
              }
              myWriter.close();
          } catch(IOException ioe) {
              ioe.printStackTrace();
          }
          
          System.out.println("Quicksort: " + n + " integers sorted in " + timeElapsed + " milliseconds.");
        } else if("bitmapsort".equals(choice)) {    
            // step 1. create a bitset will all bits 0
            BitmapSort fs = new BitmapSort(n, inputFilename);
            
            // step 2. set bits to 1 for integers in the input file
            fs.readFileAndLoadToBitSet();
            
            long start = System.currentTimeMillis();
            // step 3. write sorted integers to output file
            fs.sortAndStoreToFile();
            
            long finish = System.currentTimeMillis();
            long timeElapsed = finish - start;
            System.out.println("Bitmapsort: " + n + " integers sorted in " + timeElapsed + " milliseconds.");
        } else {
            System.out.println("You need to select one of the 2 choices: (a) quicksort, (b) bitmapsort");
        }
    }
}
