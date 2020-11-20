package com.dynamic.agile.bowling.game.dapv2;

class SpareScoreRule extends ScoreRule {

    @Override
    int score() {
//            return countTwoRollPins() + nextRollPins();
        return 0;
    }
}
