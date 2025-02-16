import java.io.*;
public class ReadUserInput {
   public static void main(String[] args) {
       String filePath = "output.txt";
       try (InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw)) {
           System.out.println("Enter text (type 'exit' to stop):");
           String line;
           while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
               bw.write(line);
               bw.newLine();
           }
           System.out.println("User input saved to " + filePath);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
