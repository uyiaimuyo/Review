import java.sql.Time;
import java.util.Map;
import java.util.Set;

/**
 * Created by Aysar on 2/10/2015.
 *
 * Explain how you would design a chat server. In particular, provide details about the
 various backend components, classes, and methods. What would be the hardest
 problems to solve?
 *
 * How users interact?  user enters name and is logged on to chat server, can broadcast
 * messages to other logged on users, can send private messages to another user
 *
 * Basically multi client - server architecture
 *
 * The client subscribes to a channel whereby they'd poll the server every couple
 * seconds for any new updates/messages
 * They can also send a message to subbed channel
 *
 * The server accepts new subscribers and keeps track of time a message is sent
 * from clients.  When a client polls, the server checks time difference from
 * their last poll and new poll and returns any new messages that happened in that timeframe
 *
 * Core Objects: Client, Server,
 *
 * Things to think about:
 * - scalability, what happens when lots of users talking at once, need to
 * output them in some sort of order
 * - ddos
 *
 */
public class ChatServer {

    public class Client {
        String username;
        long id;
        Client[] contacts;
        void subscribe(String channel) {}
        boolean sendMessage(String message) {return true; }
        void poll(String channel) { // update clientside chat interface
         }
    }

    public class Server {
        Set<Client> clients;
        Map<Time, String> messages;
        boolean login(Client c) { return true; }
        Response callback() {
            return new Response();
        }
    }

    public class Response {

    }
}
