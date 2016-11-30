package com.company;

import ClientPackage.Card;
import ClientPackage.Client;
import MyException.DuplicateException;
import MyException.PinNotFoundException;
import TerminalPackage.TerminalMethodClass;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TerminalMethodClass tmc=null;
        boolean bol = true;


        while (bol) {
            System.out.println("Вас приветствует терминал банка! Что Вы хотите сделать? \n 1) Стать клиентом банка? \n 2) Начать работу со своей картой? \n 3)Закончить!");
            Scanner sc = new Scanner(System.in);
            int k = sc.nextInt();
            switch (k) {
                case (1): {
                    System.out.println("Введите Ваше имя:");
                    String FIO = sc.next();
                    System.out.println("Введите Вашу Фамилию:");
                    FIO+=" ";
                    FIO += sc.next();
                    Client client = null;
                    try {
                        tmc = new TerminalMethodClass();
                        client = tmc.addClient(FIO);
                    } catch (DuplicateException e) {
                        e.printStackTrace();
                        break;
                    }
                    System.out.println("Введите желаемый номер карты, и желаемый пин-код: ");
                    long number = sc.nextLong();
                    int pin = sc.nextInt();
                    Card card = new Card(number, pin);
                    try {
                        tmc.addCard(client, card);
                    } catch (DuplicateException e) {
                        e.printStackTrace();
                        break;
                    }

                    break;
                }
                case(2):{
                    System.out.println("Введите свой номер карты и пин-код : ");
                    long numberCard=sc.nextLong();
                    int pin = sc.nextInt();
                    try {
                        tmc=new TerminalMethodClass(numberCard,pin);
                    } catch (PinNotFoundException e) {
                        e.printStackTrace();
                        break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }

                }
            }


        }


    }
}
