package Bridge;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// Concrete Implementation
public class TXTSaver implements TextSaver {
    private String filename;

    public TXTSaver(String filename) {
        this.filename = filename;
    }

    public void saveText(String text) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println(text);
        } catch (IOException e) {
            System.err.println("Error!! " + e.getMessage());
        }
    }
}