import java.util.Map;
import java.util.Set;

/**
 * Created by Aysar on 2/10/2015.
 *
 * Design the data structures for an online book reader system
 *
 * How does user interface with it:
 * User signs up, searches for book, reads book online
 *
 * Core Objects: User, Book, Book viewer
 *
 *
 */
public class OnlineBookReader {

    private static Set<User> users;
    public class User {
        String name;
        String email;
        String passwordHash;

        public boolean isLoggedIn(){return true;}
        public void login(){}
        public void encrypt(String password){}
    }

    public class Book {
        String name;
        String author;
        String description;
        View[] pages;
    }

    public class View {
        String contents;
    }

    public class BookViewer {
        int currentPage;
        public View viewPage(int i, Book book){
            return null;
        }
    }

    public class Library {
        Map<String, Book> books;
    }

}
