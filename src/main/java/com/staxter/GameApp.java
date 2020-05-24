package com.staxter;

import com.staxter.game.InitiatorPlayerEngine;
import com.staxter.game.Player;
import com.staxter.game.ResponderPlayerEngine;

import java.io.IOException;

/**
 * The GameApp program implements an application that either Initiator or
 *  Responder Player which sends or receives messages to other Player
 *
 */
public class GameApp {
    public static void main(String[] args) throws Exception {
        if (args.length == 1) {
            Thread responder =
                    new Thread(new Player(new ResponderPlayerEngine(Integer.valueOf(args[0])), "Responder"));
            responder.start();
            responder.join();
        } else if (args.length == 2) {
            Thread initiator =
                    new Thread(new Player(new InitiatorPlayerEngine(args[0], Integer.valueOf(args[1])), "Initiator"));
            initiator.start();
            initiator.join();
        }
    }
}
