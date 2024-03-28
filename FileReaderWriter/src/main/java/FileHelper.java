import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

  public static List<String> readFromFile(String path) {
    File fileToRead = new File(path);

    if (fileToRead.exists() && fileToRead.isFile() && fileToRead.canRead()) {
      try {
        return Files.readAllLines(fileToRead.toPath());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    } else {
      throw new RuntimeException(new IOException("The file cannot be accessed!"));
    }
  }

  public static List<String> readFromFileBufferedReader(String path) {
    File fileToRead = new File(path);

    if (fileToRead.exists() && fileToRead.isFile() && fileToRead.canRead()) {
      try {
        BufferedReader reader = new BufferedReader(new FileReader(fileToRead));
        String temp;
        List<String> content = new ArrayList<>();

        while ((temp = reader.readLine()) != null) {
          content.add(temp);
        }

        reader.close();

        return content;
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    } else {
      throw new RuntimeException(new IOException("The file cannot be accessed!"));
    }
  }

  public static void writeToFile(String path, String content) {
    try {
      Files.write(Path.of(path), content.getBytes(), StandardOpenOption.CREATE);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void writeToFileBufferedWriter(String path, String content) {
    File fileToWrite = new File(path);
    try {
      boolean fileExists = fileToWrite.exists();
      if (!fileExists) {
        fileExists = fileToWrite.createNewFile();
      }

      if (fileExists && fileToWrite.isFile() && fileToWrite.canWrite()) {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileToWrite));
        writer.write(content);
        writer.close();
      } else {
        throw new RuntimeException(new IOException("The file cannot be accessed!"));
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
