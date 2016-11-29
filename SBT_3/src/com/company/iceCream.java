package com.company;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dmitr on 10.11.2016.
 */
public class iceCream {
    private int price;
    private String typeCream;
    private String cupCream;
    private ArrayList<String> toppingList = new ArrayList();

    public static final String cupCreamtype1="Рожок";
    public static final String cupCreamtype2="Стаканчик";
    public static final String typeCream1="Сливочное";
    public static final String typeCream2="Шоколадное";
    public static final String typeCream3="Клубничное";

    public ArrayList<String> getToppingList() {
        return toppingList;
    }
    //public static HashMap<String, Integer> priceList = new HashMap<String,Integer>();

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTypeCream() {
        return typeCream;
    }

    public void setTypeCream(String typeCream) {
        this.typeCream = typeCream;
    }

    public String getCupCream() {
        return cupCream;
    }

    public void setCupCream(String cupCream) {
        this.cupCream = cupCream;
    }

    public void setToppingList(ArrayList<String> toppingList) {
        this.toppingList = toppingList;
    }


    public iceCream() {
        this.cupCream = cupCreamtype1;
        this.price = 0;
        this.typeCream = typeCream1;
    }

    int price() {
        int priceValue = 0;
        //priceList.put(cupCreamtype1,100);
        if (this.cupCream.equals(cupCreamtype1)) {
            priceValue += 100;
        } else if (this.cupCream.equals(cupCreamtype2)) {
            priceValue += 150;
        } else priceValue = 0;
        for (int i = 0; i < this.toppingList.size(); i++) {
            if (this.toppingList.get(i).toString().equals(ToppingSelected.toppingType1)) {
                priceValue += 30;
            } else if (this.toppingList.get(i).equals(ToppingSelected.toppingType2)) {
                priceValue += 20;
            } else if (this.toppingList.get(i).equals(ToppingSelected.toppingType3)) {
                priceValue += 15;
            } else if (this.toppingList.get(i).equals(ToppingSelected.toppingType4)) {
                priceValue += 10;
            } else priceValue += 0;


        }
        setPrice(priceValue);
        return priceValue;
    }

    public void printIceCream() {
        System.out.println("Вы набрали на сумму: " + price + "\n Вкус: " + typeCream + "\n Посуда: " + cupCream + "\n Топпинги: ");
        for (int i = 0; i < toppingList.size(); i++) {
            System.out.println(toppingList.get(i));
        }
    }

}
