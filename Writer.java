import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Dzet
 * class fo help to writing
 * any data in file
 */
public class Writer {

    private FileWriter fileWriter;

    public Writer(String fileName) throws IOException {
        fileWriter = new FileWriter(new File(fileName));
    }

    public void write(String str) throws IOException {
        if (str != null) fileWriter.write(str);
    }

    public void write(char cr) throws IOException {
        fileWriter.write(cr);
    }

    public void close() throws IOException {
        fileWriter.close();
    }

    public void write(int i) throws IOException {
        fileWriter.write(String.valueOf(i));
    }

    public void write(long l) throws IOException {
        fileWriter.write(String.valueOf(l));
    }
}
