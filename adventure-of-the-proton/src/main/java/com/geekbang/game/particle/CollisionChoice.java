package com.geekbang.game.particle;

import static com.geekbang.game.AOTPAppMain.Game;
import static com.geekbang.game.util.Constants.COLLISION_CHOICE;

public class CollisionChoice implements BattleChoice{

    @Override
    public boolean canEnable() {
        return true;
    }

    @Override
    public String getChoiceId() {
        return COLLISION_CHOICE;
    }

    @Override
    public String getChoiceName() {
        return "粒子撞击";
    }


    @Override
    public int execute() {

        Particle enemy = Game.getEnemy();
        Particle theProton = Game.getTheProton();

        if (enemy.getEnergy() == theProton.getEnergy()) {
            return 0;
        } else if (enemy.getEnergy() < theProton.getEnergy()) {
            return 1;
        } else if (enemy.getEnergy() > theProton.getEnergy()) {
            return -1;
        }

        return 1;
    }
}
