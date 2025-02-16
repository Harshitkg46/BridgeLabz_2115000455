import java.io.*;
public class CountTheOccurence {
   public static void main(String[] args) {
       String filePath = "example.txt";
       String targetWord = "hello";
       int wordCount = 0;
       try (FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr)) {
           String line;
           while ((line = br.readLine()) != null) {
               String[] words = line.split("\\s+");
               for (String word : words) {
                   if (word.equalsIgnoreCase(targetWord)) {
                       wordCount++;
                   }
               }
           }
           System.out.println("The word '" + targetWord + "' appears " + wordCount + " times.");
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
