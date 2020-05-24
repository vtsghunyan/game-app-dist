package com.staxter.game;

public class Player implements Runnable {
    private final PlayerEngine engine;
    private final String name;

    public Player(PlayerEngine engine, String name) {
        this.engine = engine;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " player is started");
        try {
            engine.handle(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
