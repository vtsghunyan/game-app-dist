package com.staxter.game;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Responder player engine who receives and replies messages.
 *
 */
public class ResponderPlayerEngine implements PlayerEngine {
    private final AtomicInteger counter = new AtomicInteger(0);
    private final ServerSocket serverSocket;

    public ResponderPlayerEngine(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    /**
     * This method is used to handle Responder player's behaviour
     *
     * @param name the name of the player
     */
    public void handle(String name) throws Exception {
        Socket socket = serverSocket.accept();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            while (counter.getAndIncrement() < MESSAGE_DEFAULT_COUNT) {
                String message = in.readLine();
                System.out.println("\n" + name + " received >> " + message);
                Thread.sleep(2000);
                out.println(message + counter.get());
                out.flush();
                System.out.println(name + " replied >> " + message + counter.get());
            }
        }
    }
}
