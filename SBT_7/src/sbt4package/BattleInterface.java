package sbt4package;

import java.util.ArrayList;

/**
 * Created by dmitr on 14.12.2016.
 */
@FunctionalInterface
public interface BattleInterface { //с какой целью оставлен этот интерфейс?
    ArrayList<String> methodBattle(Squad squad1, Squad squad2);
}
