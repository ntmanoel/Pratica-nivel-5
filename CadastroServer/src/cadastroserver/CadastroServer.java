package cadastroserver;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class CadastroServer {

    public static void main(String[] args) {
        int port = 4321;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                new ServerThread(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {


// Read login and password
                        // Read command 'L'
            String command = (String) in.readObject();

            if ("L".equals(command)) {
                // Simulate fetching entities
                List<String> entities = new ArrayList<>();
                entities.add("pêra");
                entities.add("framboesa");

                // Send entities to the client
                out.writeObject(entities);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
