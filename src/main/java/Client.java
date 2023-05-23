import java.io.*;
import java.net.Socket;
import java.util.Scanner;

//import static Main.PORT_NUMBER;

//Класс клиента задающий слова поиска
public class Client {
    public static void main(String[] args) {
        final String CLIENT_IP = "127.0.0.1";
        try (Socket socket = new Socket(CLIENT_IP, Main.PORT_NUMBER);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println(in.readLine());

            System.out.println("Вводите через пробел слова которые нужно найти:");
            out.println(scanner.nextLine());

            int character;
            StringBuilder jsonAnswer = new StringBuilder();
            while ((character = in.read()) != -1) {
                jsonAnswer.append((char) character);
            }
            System.out.println(jsonAnswer);

        } catch (
                IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}