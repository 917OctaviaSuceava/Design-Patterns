package Repository;

import Model.Book;
import Model.Client;
import Observer.Subscriber;

import java.util.HashMap;

public class RepoPurchases implements Subscriber {
    private HashMap<Client, Book> purchases;

    private RepoBooks bookRepository;
    private RepoClients clientRepository;

    public RepoPurchases()
    {
        purchases = new HashMap<>();
        bookRepository = new RepoBooks();
        clientRepository = new RepoClients();
    }

    public RepoPurchases(RepoBooks bookRepository, RepoClients clientRepository) {
        purchases = new HashMap<>();
        this.bookRepository = bookRepository;
        this.clientRepository = clientRepository;
        bookRepository.subscribe(this);
        clientRepository.subscribe(this);
    }

    public HashMap<Client, Book> getPurchases() {
        return purchases;
    }

    public void addPurchase(Client client, Book book)
    {
        System.out.println(client);
        System.out.println(book);
        if(bookRepository.getBooks().contains(book))
            purchases.put(client, book);
        else update(client, book);
    }

    @Override
    public void update(Client client, Book book) {
        System.out.println("Client with id " + client.getId() + " is now subscribed to book with id " + book.getId());
    }

    @Override
    public String toString() {
        return "RepoPurchases{" +
                "purchases=" + purchases +
                '}';
    }
}
