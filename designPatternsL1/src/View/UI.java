package View;

import Bridge.*;
import Controller.Controller;

import java.util.Scanner;

public class UI {
    private Controller controller;
    public UI()
    {
        controller = new Controller();
    }
    public void menu()
    {
        System.out.println("""
                Choose an option:
                   0 - exit
                   1 - see books
                   2 - see clients
                   3 - see purchases
                   4 - add book
                   5 - add client
                   6 - add purchase
                """);
    }

    public void getInputBook()
    {
        System.out.println();
    }

    public void start()
    {

        while(true)
        {
            menu();
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            if(option == 0)
                return;
            else if(option == 1)
                controller.getBooksController();
            else if(option == 2)
                controller.getClientsController();
            else if(option == 3)
                controller.getPurchasesController();
            else if(option == 4)
            {
                System.out.println("title of the book: ");
                scanner.nextLine();
                String title = scanner.nextLine();
                System.out.println("author of the book: ");
                String author = scanner.nextLine();
                System.out.println("id of the book: ");
                int id = scanner.nextInt();
                controller.addBookController(title, author, id);

            }
            else if(option == 5)
            {
                System.out.println("name of the client: ");
                scanner.nextLine();
                String name = scanner.nextLine();
                System.out.println("id of the client: ");
                int id = scanner.nextInt();
                controller.addClientController(name, id);
            }
            else if(option == 6)
            {
                System.out.println("id of the client: ");
                int id1 = scanner.nextInt();
                System.out.println("id of the book: ");
                int id = scanner.nextInt();
                controller.addPurchaseController(id1, id);
            }
        }
    }
}
