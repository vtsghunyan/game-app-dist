package com.staxter.game;

import java.io.IOException;

public interface PlayerEngine {
    int MESSAGE_DEFAULT_COUNT = 10;

    void handle(String name) throws Exception;
}
