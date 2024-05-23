package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameServer {
    private static final int PORT = 12345;
    private volatile boolean running = true; //volatila pt thread
    private ServerSocket serverSocket;
    public static void main(String[] args) {
        new GameServer().startServer();
    }

    public void startServer() {
        ExecutorService pool = Executors.newFixedThreadPool(10); //for multiple clients
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Game server is running...");

            while (running) {
                try{
                    Socket clientSocket = serverSocket.accept();
                    pool.execute(new ClientThread(this, clientSocket));

                }catch (IOException e){
                    if(running)
                    System.err.println("Error acceping client conn: " + e.getMessage());
                    else System.out.println("Server stopped.");
                }
                 }
        } catch (IOException e) {
            System.err.println("Error at starting the server: " + e.getMessage());
        }
        finally {
            pool.shutdown();
        }
    }

        public void stopServer() {
            running = false;
            if (serverSocket != null && !serverSocket.isClosed()) {
                try {
                    serverSocket.close(); // close the server socket to break out of the accept call
                    System.out.println("Server is stopping..");
                } catch (IOException e) {
                    System.err.println("Error closing server socket: " + e.getMessage());
                }
            }

        }


}

