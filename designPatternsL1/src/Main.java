import Bridge.*;
import Controller.Database;
import View.UI;

public class Main {
    public static void main(String[] args) {
        UI ui = new UI();
        ui.start();
        //singleton();
        //bridge();
    }

    public static void bridge()
    {
        String text = "some text here, and\n some, text\n here.";

        TextFile[] textFiles = new TextFile[] {
                new CSVFile(new CSVSaver("C:\\Users\\Octavia\\IdeaProjects\\designPatternsL1\\src\\file1.csv")),
                new TXTFile(new TXTSaver("C:\\Users\\Octavia\\IdeaProjects\\designPatternsL1\\src\\file.txt"))
        };

        for (TextFile textFile : textFiles) {
            textFile.save(text);
        }
    }

    public static void singleton()
    {
        Database db = Database.getInstance();
        db.print();
        System.out.println("-------");

        Database db1 = Database.getInstance();
        db1.print();
    }
}