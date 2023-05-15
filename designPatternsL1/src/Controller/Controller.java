package Controller;

import Bridge.*;
import Command.AddPurchaseCommand;
import Model.Book;
import Model.Client;
import Repository.RepoBooks;
import Repository.RepoClients;
import Repository.RepoPurchases;

import java.util.ArrayList;
import java.util.HashMap;

public class Controller {
    private RepoBooks booksRepository;
    private RepoClients clientsRepository;
    private RepoPurchases purchasesRepository;
    private AddPurchaseCommand addPurchaseCommand;
    private Database db;
    public Controller()
    {
        booksRepository = new RepoBooks();
        clientsRepository = new RepoClients();
        purchasesRepository = new RepoPurchases(booksRepository, clientsRepository);

        db = Database.getInstance();
    }

    public void getClientsController() {
        //ArrayList<Client> clients = clientsRepository.getClients();
        System.out.println(clientsRepository.toString());
    }

    public void getPurchasesController() {
        HashMap<Client, Book> purchases = purchasesRepository.getPurchases();
        System.out.println(purchases.toString());
    }

    public void getBooksController()
    {
        //ArrayList<Book> books = booksRepository.toString();
        System.out.println(booksRepository.toString());
    }

    public void addBookController(String title, String author, int id)
    {
        Book newBook = new Book(title, author, id);
        for(Book b: booksRepository.getBooks())
            if(b.getId() == id)
            {
                System.out.println("id already exists");
                return;
            }
        booksRepository.addBook(newBook);
        for (TextFile textFile : db.getTextFiles()) {
            textFile.save(newBook.toString());
        }
    }

    public void addClientController(String name, int id)
    {
        Client newClient = new Client(name, id);
        for(Client c: clientsRepository.getClients())
            if(c.getId() == id)
            {
                System.out.println("id already exists");
                return;
            }
        clientsRepository.addClient(newClient);
    }

    public void addPurchaseController(int idClient, int idBook)
    {
        int okClient = 0;
        int okBook = 0;
        for(Client c: clientsRepository.getClients())
            if(c.getId() == idClient)
            {
                okClient = 1;
                break;
            }
        if(okClient == 0)
        {
            System.out.println("client id not valid");
            return;
        }

        Client newClient = new Client("", idClient);
        Book newBook = new Book("", "", idBook);
        for(Client client: clientsRepository.getClients())
            if(client.getId() == idClient)
            {
                newClient = client;
                break;
            }

        for(Book book: booksRepository.getBooks())
            if(book.getId() == idBook)
            {
                newBook = book;
                break;
            }

        //System.out.println(newBook);
        addPurchaseCommand = new AddPurchaseCommand(purchasesRepository, newClient, newBook);
        addPurchaseCommand.execute();
        //purchasesRepository.addPurchase(newClient, newBook);
    }
}
