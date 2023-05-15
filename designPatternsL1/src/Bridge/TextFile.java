package Bridge;

// Abstraction
public abstract class TextFile {
    protected TextSaver textSaver;

    protected TextFile(TextSaver textSaver1) {
        textSaver = textSaver1;
    }

    public abstract void save(String text);
}