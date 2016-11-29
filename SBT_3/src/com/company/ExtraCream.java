package com.company;

import java.util.ArrayList;

/**
 * Created by dmitr on 11.11.2016.
 */
public class ExtraCream extends iceCream {

    private String drink;
    public static final String drinkType1="Морсик";
    public static final String drinkType2="Компотик";
    public static final String drinkType3="Квас";

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    @Override
    public void setToppingList(ArrayList<String> toppingList) {
        System.out.println("Топпинги сюда нельзя добавлять!");
    }

    public ExtraCream() {
        super();
    }


    @Override
    public void printIceCream() {
        System.out.println("Вы набрали на сумму: " + getPrice() + "\n Вкус: " + getTypeCream() + "\n Посуда: " + getCupCream() + "\n Напиток: " + getDrink());
    }


    public int price() {
        int priceValue = super.price();
//        if (super.getCupCream().equals("Рожок")) {
//            priceValue += 100;
//        } else if (super.getCupCream().equals("Стаканчик")) {
//            priceValue += 150;
//        } else {
//            priceValue = 0;
//        }

        if (this.drink.equals(drinkType1)) {
            priceValue += 40;
        } else if (this.drink.equals(drinkType2)) {
            priceValue += 35;
        } else if (this.drink.equals(drinkType3)) {
            priceValue += 50;
        } else {
            priceValue += 0;
        }
        setPrice(priceValue);
        return priceValue;
    }


}
