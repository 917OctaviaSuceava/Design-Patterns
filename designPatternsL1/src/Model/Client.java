package Model;

public class Client {
    private String name;
    private int id;

    public Client(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Client()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
