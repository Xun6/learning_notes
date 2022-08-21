package com.geekbang.game.particle;

public interface BattleChoice {

    boolean canEnable();

    String getChoiceId();

    String getChoiceName();

    int execute();
}
