package Bridge;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
// Concrete Implementation
public class CSVSaver implements TextSaver {
    private String filename;

    public CSVSaver(String filename) {
        this.filename = filename;
    }

    public void saveText(String text) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            String[] lines = text.split("\\r?\\n");
            for (String line : lines) {
                String[] values = line.split(",");
                for (int i = 0; i < values.length; i++) {
                    if (i > 0) {
                        writer.print(",");
                    }
                    writer.print("\"" + values[i] + "\"");
                }
                writer.println();
            }
        } catch (IOException e) {
            System.err.println("Error!! " + e.getMessage());
        }
    }
}