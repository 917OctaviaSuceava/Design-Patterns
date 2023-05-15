package Repository;

import Model.Book;
import Model.Client;
import Observer.Publisher;
import Observer.Subscriber;

import java.util.ArrayList;

public class RepoClients implements Publisher {
    private ArrayList<Client> clients;
    private ArrayList<Subscriber> subscribers;

    public RepoClients()
    {
        clients = new ArrayList<>();
        subscribers = new ArrayList<>();
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void addClient(Client client)
    {
        clients.add(client);
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(Client client, Book book) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(client, book);
        }
    }

    @Override
    public String toString() {
        return "clients: " + clients.toString();
    }
}
