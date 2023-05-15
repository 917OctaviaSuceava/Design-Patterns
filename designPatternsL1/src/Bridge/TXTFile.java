package Bridge;

// Refined Abstraction
public class TXTFile extends TextFile {
    public TXTFile(TextSaver textSaver) {
        super(textSaver);
    }

    public void save(String text) {
        textSaver.saveText(text);
    }
}