
public class Main {
    public static void main(String[] args) {
        int n = 10_000_000;
        String inputFilename = "integers.txt";       
        long start = System.currentTimeMillis();
 
        // step 1. create a bitset will all bits 0
        FastSorter fs = new FastSorter(n, inputFilename);
        
        // step 2. set bits to 1 for integers in the input file
        fs.readFileAndLoadToBitSet();
        
        // step 3. write sorted integers to output file
        fs.sortAndStoreToFile();
        
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("1M integers sorted in " + timeElapsed + " milliseconds.");
        
    }
}
