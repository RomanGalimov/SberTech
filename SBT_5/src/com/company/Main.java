package com.company;

import ClientPackage.Card;
import ClientPackage.Client;
import MyException.AccountBlockedException;
import MyException.DuplicateException;
import MyException.NoMoneyNoHoneyException;
import MyException.PinNotFoundException;
import TerminalPackage.TerminalMethodClass;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TerminalMethodClass tmc = null;
        boolean bol = true;
        boolean bol1 = true;

        Card card = new Card(555, 555);
        Client client1 = new Client("KEK", card);
        TerminalMethodClass.clients.add(client1);

        while (bol) {
            System.out.println("Вас приветствует терминал банка! Что Вы хотите сделать? \n 1) Стать клиентом банка? \n 2) Начать работу со своей картой? \n 3)Закончить!");
            Scanner sc = new Scanner(System.in);
            tmc = null;
            int k = sc.nextInt();
            switch (k) {
                case (1): {
                    System.out.println("Введите Ваше имя:");
                    String FIO = sc.next();
                    System.out.println("Введите Вашу Фамилию:");
                    FIO += " ";
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
                    card = new Card(number, pin);
                    try {
                        tmc.addCard(client, card);
                    } catch (DuplicateException e) {
                        e.printStackTrace();
                        break;
                    }

                    break;
                }
                case (2): {
                    System.out.println("Введите свой номер карты : ");
                    long numberCard = sc.nextLong();
                    System.out.println("и пин-код : ");
                    int pin = sc.nextInt();
                    try {
                        tmc = new TerminalMethodClass(numberCard, pin);
                    } catch (PinNotFoundException e) {
                        e.printStackTrace();
                        break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                    while (bol1) {
                        System.out.println("Что дальше? \n 1) Посмотреть сколько денег? \n 2) Внести деньги? \n 3) Получить? \n 4) Закончить?  ");
                        int l = sc.nextInt();
                        if (l == 1) {
                            try {
                                System.out.println("На Вашем счету : " + tmc.checkMoney());
                            } catch (AccountBlockedException e) {
                                e.printStackTrace();
                                break;
                            } catch (PinNotFoundException e) {
                                e.printStackTrace();
                                break;
                            }
                        } else if (l == 2) {
                            try {
                                System.out.println("Введите сумму кратную 100 : ");
                                l = sc.nextInt();
                                tmc.addMoney(l);
                                System.out.println("На Вашем счету : " + tmc.checkMoney());
                            } catch (PinNotFoundException e) {
                                e.printStackTrace();
                                break;
                            } catch (AccountBlockedException e) {
                                e.printStackTrace();
                                break;
                            }
                        } else if (l == 3) {
                            try {
                                System.out.println("Введите сумму кратную 100 : ");
                                l = sc.nextInt();
                                tmc.takeMoney(l);
                                System.out.println("На Вашем счету : " + tmc.checkMoney());
                            } catch (NoMoneyNoHoneyException e) {
                                e.printStackTrace();
                                break;
                            } catch (AccountBlockedException e) {
                                e.printStackTrace();
                                break;
                            } catch (PinNotFoundException e) {
                                e.printStackTrace();
                                break;
                            }
                        } else if (l >= 4) bol1 = false;
                        //break;
                    }
                }
                case (3):
                    bol = false;
            }


        }


    }
}
