package Controller;

import Bridge.*;

public class Database {
    private static Database instance;
    private TextFile[] textFiles;
    private Database() {
        //String f1 = "C:\\Users\\Octavia\\IdeaProjects\\designPatternsL1\\src\\file1.csv";
        //String f2 = "C:\\Users\\Octavia\\IdeaProjects\\designPatternsL1\\src\\file.txt";
        textFiles = new TextFile[] {
                new CSVFile(new CSVSaver("C:\\Users\\Octavia\\IdeaProjects\\designPatternsL1\\src\\file1.csv")),
                new TXTFile(new TXTSaver("C:\\Users\\Octavia\\IdeaProjects\\designPatternsL1\\src\\file.txt"))
        };
    }

    public static Database getInstance() {
        if(instance == null)
        {
            synchronized(Database.class){
                if(instance == null) {
                    instance = new Database();
                }

            }
        }

        return instance;
    }

    public TextFile[] getTextFiles() {
        return textFiles;
    }

    public void print() {
        System.out.println("singleton");
    }
}
