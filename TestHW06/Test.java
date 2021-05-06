import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;
public class Test{
    public static void main(String[] args) {
        File fileIn = new File("SortedWolves.csv");
        Scanner fileScan = null;
        Scanner wolfScan = null;
        PrintWriter filePrint = null;
        double[] allWeights = new double[10];
        int index = 0;
        try {
            fileScan = new Scanner(fileIn);
            String line = null;
            while (fileScan.hasNextLine()) {
                line = fileScan.nextLine();
                System.out.println(line);
                wolfScan = new Scanner(line);
                wolfScan.useDelimiter(",");
                wolfScan.nextInt(); //consume unused rank token
                allWeights[index] = wolfScan.nextDouble();
                index++;
            }
            filePrint = new PrintWriter(fileIn);
            filePrint.println("Testing");
            System.out.println(allWeights[0]);
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (filePrint != null) {
                filePrint.close();
            }
        }

    }
}
