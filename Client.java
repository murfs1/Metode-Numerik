import java.io.*;
import java.net.*;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in)) ) {

            System.out.println("Selamat datang di Grup Chat!");
            System.out.print("Masukkan nama Anda: ");
            String clientName = consoleIn.readLine();
            out.println(clientName);

            ServerMessageReader serverMessageReader = new ServerMessageReader(in);
            Thread readerThread = new Thread(serverMessageReader);
            readerThread.start();

            String message;
            while (true) {
                message = consoleIn.readLine();
                out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ServerMessageReader implements Runnable {
        private BufferedReader in;

        public ServerMessageReader(BufferedReader in) {
            this.in = in;
        }

        public void run() {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
