import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.BitSet;

public class FastSorter {
    private int n;
    private String inputFilename;
    private String outputFilename;
    BitSet bs;
    
    public FastSorter(int n, String inputFilename) {
        this.n = n;
        this.inputFilename = inputFilename;
        this.outputFilename = inputFilename.split("\\.")[0] + "_sorted.txt";
        bs = new BitSet(n);
    }
    
    public void readFileAndLoadToBitSet() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFilename));
            String line;
            while ((line = br.readLine()) != null) {
               int bitIndex = Integer.parseInt(line);
               bs.set(bitIndex);
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    public void sortAndStoreToFile() {
        try {
            FileWriter myWriter = new FileWriter(outputFilename);
            for (int bitIndex = 0; bitIndex < n; bitIndex++) {
                if (bs.get(bitIndex)) {
                    myWriter.write(String.valueOf(bitIndex) + "\n");
                }
            }
            myWriter.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
