package com.company;

import ClientPackage.Card;
import ClientPackage.Client;
import MyException.DuplicateException;
import MyException.PinNotFoundException;
import TerminalPackage.TerminalMethodClass;

public class Main {

    public static void main(String[] args) {
        Client client1=new Client("KOKO");
        Client client2=new Client("FIO");
        Client client3=new Client("FIO");
        Card card1=new Card(6400,6400);
        Card card2=new Card(6500,6500);
        Card card3=new Card(6600,6600);
        client1.setCardClient(card1);
        client1.setCardClient(card2);
        client1.setCardClient(card3);
        TerminalMethodClass.clients.add(client1);
        TerminalMethodClass.clients.add(client2);
        TerminalMethodClass.clients.add(client3);
        //Client client4=new Client("FIO");
        try {
            TerminalMethodClass tm=new TerminalMethodClass(client1,6300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (PinNotFoundException e) {
            e.printStackTrace();
        }
    }
}
