import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class FileHelperTest {

  @TempDir
  private File tempDir;
  private final String fileName = "tempFile.txt";
  private File tempFile;
  private final List<String> testContent = List.of("Hello World!", "This is a test.");

  @BeforeEach
  void setUp() throws IOException {
    tempFile = new File(tempDir, fileName);
    tempFile.createNewFile();
  }

  @AfterEach
  void tearDown() {
    tempFile.delete();
  }

  @Test
  void testFileWriter() {
    FileHelper.writeToFile(tempFile.getAbsolutePath(), String.join("\n", testContent));
    List<String> fileContent = FileHelper.readFromFile(tempFile.getAbsolutePath());

    assertEquals(2, fileContent.size());

    for (int i = 0; i < testContent.size(); i++) {
      assertEquals(testContent.get(i), fileContent.get(i));
    }
  }

  @Test
  void testBufferedFileWriter() {
    FileHelper.writeToFileBufferedWriter(tempFile.getAbsolutePath(),
        String.join("\n", testContent));
    List<String> fileContent = FileHelper.readFromFileBufferedReader(tempFile.getAbsolutePath());

    assertEquals(2, fileContent.size());

    for (int i = 0; i < testContent.size(); i++) {
      assertEquals(testContent.get(i), fileContent.get(i));
    }
  }

  @Test
  void readFromFileError() {
    assertThrows(RuntimeException.class, () -> FileHelper.readFromFile(tempDir.getAbsolutePath()),
        "The file cannot be accessed!");
  }

  @Test
  void readFromFileBufferedReaderError() {
    assertThrows(RuntimeException.class,
        () -> FileHelper.readFromFileBufferedReader(tempDir.getAbsolutePath()),
        "The file cannot be accessed!");
  }
}