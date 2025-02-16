import java.io.*;
public class PerformanceComparison {
   public static void main(String[] args) {
       int iterations = 1_000_000;
       String word = "hello";
       String filePath = "largefile.txt";
       compareStringConcatenation(iterations, word);
       compareFileReading(filePath);
   }
   private static void compareStringConcatenation(int iterations, String word) {
       long startTime = System.nanoTime();
       StringBuffer stringBuffer = new StringBuffer();
       for (int i = 0; i < iterations; i++) {
           stringBuffer.append(word);
       }
       long stringBufferTime = System.nanoTime() - startTime;
       startTime = System.nanoTime();
       StringBuilder stringBuilder = new StringBuilder();
       for (int i = 0; i < iterations; i++) {
           stringBuilder.append(word);
       }
       long stringBuilderTime = System.nanoTime() - startTime;
       System.out.println("StringBuffer Time: " + stringBufferTime + " ns");
       System.out.println("StringBuilder Time: " + stringBuilderTime + " ns");
       System.out.println(stringBufferTime > stringBuilderTime ? "StringBuilder is faster" : "StringBuffer is faster");
   }
   private static void compareFileReading(String filePath) {
       long fileReaderTime = countWordsUsingFileReader(filePath);
       long inputStreamReaderTime = countWordsUsingInputStreamReader(filePath);
       System.out.println("FileReader Time: " + fileReaderTime + " ns");
       System.out.println("InputStreamReader Time: " + inputStreamReaderTime + " ns");
       System.out.println(fileReaderTime > inputStreamReaderTime ? "InputStreamReader is faster" : "FileReader is faster");
   }
   private static long countWordsUsingFileReader(String filePath) {
       long startTime = System.nanoTime();
       int wordCount = 0;
       try (FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr)) {
           String line;
           while ((line = br.readLine()) != null) {
               wordCount += line.split("\\s+").length;
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
       long endTime = System.nanoTime();
       System.out.println("Word count using FileReader: " + wordCount);
       return endTime - startTime;
   }
   private static long countWordsUsingInputStreamReader(String filePath) {
       long startTime = System.nanoTime();
       int wordCount = 0;
       try (FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr)) {
           String line;
           while ((line = br.readLine()) != null) {
               wordCount += line.split("\\s+").length;
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
       long endTime = System.nanoTime();
       System.out.println("Word count using InputStreamReader: " + wordCount);
       return endTime - startTime;
   }
}
