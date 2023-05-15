package Observer;

import Model.Book;
import Model.Client;

public interface Publisher {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers(Client client, Book book);
}
