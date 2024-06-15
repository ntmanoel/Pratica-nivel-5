package cadastroclient;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Collection;

public class CadastroClient {

    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 4321;

        try (Socket socket = new Socket(hostname, port);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            // Enviar login e senha
            String login = "op1";
            String senha = "op1";
            out.writeObject(login);
            out.writeObject(senha);

            // Enviar comando 'L'
            out.writeObject("L");

            // Receber a coleção de entidades
            Collection<?> entidades = (Collection<?>) in.readObject();

            // Apresentar o nome de cada entidade recebida
            for (Object entidade : entidades) {
                System.out.println(entidade.toString());  // Assumindo que toString() retorna o nome
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
