package Command;

import Model.Book;
import Model.Client;
import Repository.RepoPurchases;

public class AddPurchaseCommand implements Command {
    private final RepoPurchases purchasesRepo;
    private Client client;
    private Book book;

    public AddPurchaseCommand(RepoPurchases purchasesRepo, Client client1, Book book1) {
        this.purchasesRepo = purchasesRepo;
        book = book1;
        client = client1;
    }

    @Override
    public void execute() {
        purchasesRepo.addPurchase(client, book);
    }
}