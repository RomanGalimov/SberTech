package com.company;

import java.security.PublicKey;

/**
 * Created by dmitr on 24.11.2016.
 */
public class ToppingSelected {

    public static final String toppingType1="Орешки";
    public static final String toppingType2="Шоколад";
    public static final String toppingType3="Конфетки";
    public static final String toppingType4="Варенье";

    public static String CreamSelected(int k) {
        if (k == 1) {
            return iceCream.typeCream1;
        } else if (k == 2) {
            return iceCream.typeCream3;
        } else {
            return iceCream.typeCream2;
        }

    }
    public static iceCream ToppingSelected(int z,iceCream iceCream)
    {
        if (z <= 1) {
            iceCream.getToppingList().add(toppingType1);
        } else if (z == 2) {
            iceCream.getToppingList().add(toppingType2);
        } else if (z == 3) {
            iceCream.getToppingList().add(toppingType3);
        } else if (z == 4) {
            iceCream.getToppingList().add(toppingType4);
        } else if (z == 5) {

            iceCream.printIceCream();
        }
        return  iceCream;
    }
}
