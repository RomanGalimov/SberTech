package com.company;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // write your code here

        Scanner sc = new Scanner(System.in);
        String drink;
        iceCream iceCream = new iceCream();
        surpriseCream surpriceCream = new surpriseCream();
        ExtraCream extraCream = new ExtraCream();

        System.out.println("Добрый день! В какую емкость налить мороженное? \n 1)Стаканчик \n 2) Рожок ");
        int z = sc.nextInt();
        if (z == 1) {
            iceCream.setCupCream(iceCream.cupCreamtype2);
            extraCream.setCupCream(iceCream.cupCreamtype2);
            surpriceCream.setCupCream(iceCream.cupCreamtype2);
        } else {
            iceCream.setCupCream(iceCream.cupCreamtype1);
            extraCream.setCupCream(iceCream.cupCreamtype1);
            surpriceCream.setCupCream(iceCream.cupCreamtype1);
        }

        System.out.println("Какое мороженное Вы хотите? \n 1) Обычное \n 2) 'Сюрприз' \n 3) 'Экстра' ");

        int k = sc.nextInt();
        switch (k) {
            case (1): {

                System.out.println("Выберите вкус:\n 1) Сливочное \n 2) Клубничное \n 3) Шоколадное");
                k = sc.nextInt();

                iceCream.setTypeCream(ToppingSelected.CreamSelected(k));

                boolean bol = false;
                while (bol != true) {
                    System.out.println("Стоимость: " + iceCream.price() + " рублей. \n Какой топпинг добавить? \n 1) Орешки \n 2) Шоколад \n 3) Конфетки \n 4) Варенье \n 5) Закончить");
                    z = sc.nextInt();
                    if (z <= 4) {
                        ToppingSelected.ToppingSelected(z, iceCream);
                    } else {
                        iceCream.printIceCream();
                        bol = true;
                    }
                }
                break;
            }
            case (2): {
                Random random = new Random();
                k = random.nextInt(2);
                surpriceCream.setTypeCream(ToppingSelected.CreamSelected(k));

                for (int i = 0; i < 2; i++) {
                    k = random.nextInt(3);

                    ToppingSelected.ToppingSelected(k, surpriceCream);

                }

                surpriceCream.price();

                System.out.println("Случайное мороженное: ");
                surpriceCream.printIceCream();
                break;
            }

            case (3): {

                System.out.println("Выберите вкус:\n 1) Сливочное \n 2) Клубничное \n 3) Шоколадное");
                k = sc.nextInt();

                extraCream.setTypeCream(ToppingSelected.CreamSelected(k));

                System.out.println("Выберите напиток: \n 1) Квас \n 2) Морсик \n 3) Компотик ");
                k = sc.nextInt();
                if (k == 1) {
                    drink = ExtraCream.drinkType3;
                } else if (k == 2) {
                    drink = ExtraCream.drinkType1;
                } else {
                    drink = ExtraCream.drinkType2;
                }

                extraCream.setDrink(drink);
                extraCream.price();
                System.out.println("Ура!");
                extraCream.printIceCream();

            }

        }


    }
}
