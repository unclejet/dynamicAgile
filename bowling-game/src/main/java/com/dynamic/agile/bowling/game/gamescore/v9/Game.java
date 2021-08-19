package com.dynamic.agile.bowling.game.gamescore.v9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/8/18 下午12:15
 * @description：
 */
public class Game {
    private List<Frame> frames;
    private Frame currentFrame;

    public Game() {
        frames = new ArrayList<>(12);
        currentFrame = new Frame(); //摆球
        frames.add(currentFrame);
    }

    //todo 每一投都需要摆球
    public void roll(int hitPins) {
//        if(currentFrame.isFinished()) {
//            startNextFrame();
//        }

    }

    public int score() {
        return 0;
    }
}
