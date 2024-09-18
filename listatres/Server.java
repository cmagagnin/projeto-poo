package listatres;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.HashMap;

public class Server {
    private static final int PORT = 7777;
    private static Map<String, PrintWriter> clientWriters = new HashMap<>();
    private static boolean isRunning = true; // Variável para controlar o estado do servidor

    public static void main(String[] args) {
        System.out.println("Servidor de chat iniciado na porta 7777...");

        // Inicia a thread do servidor para enviar mensagens
        new ServerSender().start();

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (isRunning) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    new ClientHandler(clientSocket).start();
                } catch (IOException e) {
                    if (!isRunning) {
                        System.out.println("O servidor foi encerrado...");
                    } else {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Thread para lidar com cada cliente conectado
    private static class ClientHandler extends Thread {
        private Socket socket;
        private String clientName;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                // Solicita o nome do cliente
                out.println("Qual seu nickname:");
                clientName = in.readLine();

                synchronized (clientWriters) {
                    clientWriters.put(clientName, out);
                }

                broadcastMessage("Servidor: " + clientName + " entrou no chat!");

                String message;
                System.out.println(clientName + " está online!");
                while ((message = in.readLine()) != null) {
                    if (message.equalsIgnoreCase("EXIT")) {
                        break;
                    }
                    broadcastMessage(clientName + ": " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeConnection();
            }
        }

        private void broadcastMessage(String message) {
            synchronized (clientWriters) {
                for (PrintWriter writer : clientWriters.values()) {
                    writer.println(message);
                }
            }
        }

        private void closeConnection() {
            if (clientName != null) {
                synchronized (clientWriters) {
                    clientWriters.remove(clientName);
                    broadcastMessage("Servidor: " + clientName + " saiu do chat.");
                }
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Thread para permitir que o servidor envie mensagens aos clientes
    private static class ServerSender extends Thread {
        private BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

        public void run() {
            try {
                String serverMessage;
                while ((serverMessage = consoleInput.readLine()) != null) {
                    if (serverMessage.equalsIgnoreCase("EXIT")) {
                        shutdownServer();
                        break;
                    }
                    broadcastMessage("Servidor: " + serverMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void broadcastMessage(String message) {
            synchronized (clientWriters) {
                for (PrintWriter writer : clientWriters.values()) {
                    writer.println(message);
                }
            }
        }

        private void shutdownServer() {
            System.out.println("Encerrando o servidor...");
            isRunning = false;
            broadcastMessage("Encerrand o servidor...");

            try {
                synchronized (clientWriters) {
                    for (PrintWriter writer : clientWriters.values()) {
                        writer.close();
                    }
                    clientWriters.clear();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}