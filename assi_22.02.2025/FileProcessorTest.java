
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;

class FileProcessor {
    public void writeToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }

    public String readFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.readLine();
        }
    }
}

public class FileProcessorTest {
    FileProcessor fileProcessor = new FileProcessor();
    String filename = "test.txt";

    @AfterEach
    public void cleanUp() {
        File file = new File(filename);
        file.delete();
    }

    @Test
    public void testWriteToFile() throws IOException {
        fileProcessor.writeToFile(filename, "Hello, World!");
        assertTrue(new File(filename).exists());
    }

    @Test
    public void testReadFromFile() throws IOException {
        fileProcessor.writeToFile(filename, "Hello, World!");
        assertEquals("Hello, World!", fileProcessor.readFromFile(filename));
    }

    @Test
    public void testFileNotFound() {
        assertThrows(IOException.class, () -> fileProcessor.readFromFile("nonexistent.txt"));
    }
}
