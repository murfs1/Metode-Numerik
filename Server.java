import java.io.*;
import java.net.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Server {
    private static final int PORT = 12345;
    private static Set<PrintWriter> clientWriters = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("Server sedang berjalan...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private String clientName;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                System.out.println("Koneksi dari " + socket.getInetAddress() + " telah terhubung.");

                out.println("Masukkan nama Anda:");
                clientName = in.readLine();

                broadcast(clientName + " bergabung dengan grup chat!");

                clientWriters.add(out);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(clientName + ": " + message);
                    broadcast(clientName + ": " + message);
                }
            } catch (IOException e) {
                System.out.println("Koneksi dengan " + clientName + " terputus.");
            } finally {
                if (clientName != null) {
                    System.out.println(clientName + " keluar dari grup chat.");
                    broadcast(clientName + " keluar dari grup chat.");
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void broadcast(String message) {
            for (PrintWriter writer : clientWriters) {
                writer.println(getTimestamp() + " " + message);
            }
        }

        private String getTimestamp() {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            return "[" + sdf.format(new Date()) + "]";
        }
    }
}
