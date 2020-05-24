package com.staxter.game;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Initiator player engine who initiates sending end receiving messages.
 *
 */
public class InitiatorPlayerEngine implements PlayerEngine {
    private final AtomicInteger counter = new AtomicInteger(0);
    private Socket socket;

    public InitiatorPlayerEngine(String host, int port) throws IOException {
        socket = new Socket(host, port);
    }

    /**
     * This method is used to handle Initiator player's behaviour
     *
     * @param name the name of the player
     */
    public void handle(String name) throws Exception {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            while (counter.getAndIncrement() < MESSAGE_DEFAULT_COUNT) {
                String message = "message";
                out.println(message);
                out.flush();
                System.out.println(name + " sent >> " + message);
                message = in.readLine();
                System.out.println("\n" +name + " received >> " + message);
                System.out.println("Message count = " + counter.get() + "\n");
            }
        }
    }
}
