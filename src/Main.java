
public class Main {
    public static void main(String[] args) {
        // create file of random unsorted integers from 0 to 9999999
//        int n = 10000000;
//        int minValue = 0;
//        int maxValue = 10000000;
//        String filename = "integers.txt";
//        Util.createFileOfRandomUnsortedIntegersWithDuplicates(n, minValue, maxValue, filename);
        
        int n = 10000000;
        String inputFilename = "integers.txt";
        
        long start = System.currentTimeMillis();
        
        // step 1. create a bitset will all bits 0
        FastSorter fs = new FastSorter(n, inputFilename);
        
        // step 2. set bits to 1 for integers in the input file
        fs.readFileAndLoadToBitSet();
        
        // step 3. write sorted integers to output file
        fs.sortAndStoreToFile();
        
        long finish = System.currentTimeMillis();
        
        long timeElapsed = (finish - start) / 1000;
        
        System.out.println("10 million integers sorted in " + timeElapsed + " seconds.");
        
    }
}
