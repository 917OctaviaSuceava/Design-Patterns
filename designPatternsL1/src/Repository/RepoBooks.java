package Repository;

import Model.Book;
import Model.Client;
import Observer.Publisher;
import Observer.Subscriber;

import java.util.ArrayList;

public class RepoBooks implements Publisher {
    private ArrayList<Book> books;
    private ArrayList<Subscriber> subscribers;

    public RepoBooks()
    {
        books = new ArrayList<>();
        subscribers = new ArrayList<>();
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

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(Book book)
    {
        books.add(book);
    }

    @Override
    public String toString() {
        return "books: " + books.toString();
    }
}
