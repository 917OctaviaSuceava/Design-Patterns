package Observer;

import Model.Book;
import Model.Client;

public interface Subscriber {
    void update(Client client, Book book);
}
