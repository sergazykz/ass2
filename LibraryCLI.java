
public class LibraryCLI {
    public static void main(String[] args) {
        Librarian librarian = new Librarian("1", "Sergazy");
        Book book = new Book("777", "Kemel Adam");

        librarian.addItem(book);

    }
}
class Book implements CatalogItem {
    private String id;
    private String title;

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public String getIdentifier() { return id; }

    @Override
    public String getTitle() { return title; }

    @Override
    public void checkout(User user) {
        System.out.println(title + " has been checked out by " + user.getName());
    }

    @Override
    public void returnItem() {
        System.out.println(title + " has been returned.");
    }
}

class Librarian extends User implements LibrarianActions {
    public Librarian(String id, String name) {
        super(id, name);
    }

    @Override
    public void accessCatalog() {
        System.out.println(name + " has access to manage the catalog.");
    }

    @Override
    public void addItem(CatalogItem item) {
        System.out.println(item.getTitle() + " added to the catalog.");
    }

    @Override
    public void removeItem(String itemId) {
        System.out.println("Item " + itemId + " removed from the catalog.");
    }
}

interface CatalogItem {
    String getIdentifier();
    String getTitle();
    void checkout(User user);
    void returnItem();
}
abstract class User {
    protected String id;
    protected String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    abstract void accessCatalog();

    public String getName() {
        return name;
    }
}

interface LibrarianActions {
    void addItem(CatalogItem item);
    void removeItem(String itemId);
}

interface PatronActions {
    void checkoutItem(String itemId);
    void returnItem(String itemId);
}