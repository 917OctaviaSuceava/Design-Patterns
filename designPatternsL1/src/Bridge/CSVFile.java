package Bridge;

// Refined Abstraction
public class CSVFile extends TextFile {
    public CSVFile(TextSaver textSaver) {
        super(textSaver);
    }

    public void save(String text) {
        textSaver.saveText(text);
    }
}


