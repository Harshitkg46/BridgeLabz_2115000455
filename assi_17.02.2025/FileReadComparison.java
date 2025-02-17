import java.io.*;
public class FileReadComparison {
   public static void main(String[] args) throws IOException {
       String filePath = "largefile.txt";
       long start = System.nanoTime();
       try (FileReader fr = new FileReader(filePath)) {
           while (fr.read() != -1) {}
       }
       long end = System.nanoTime();
       System.out.println("FileReader Time: " + (end - start) / 1e6 + " ms");
       start = System.nanoTime();
       try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath))) {
           while (isr.read() != -1) {}
       }
       end = System.nanoTime();
       System.out.println("InputStreamReader Time: " + (end - start) / 1e6 + " ms");
   }
}
