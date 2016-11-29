package TerminalPackage;

import ClientPackage.Card;
import ClientPackage.Client;
import MyException.AccountBlockedException;
import MyException.DuplicateException;
import MyException.NoCardException;
import MyException.NoMoneyNoHoneyException;

/**
 * Created by dmitr on 28.11.2016.
 */
public interface Terminal {

    long checkMoney(Client client) throws AccountBlockedException;
    void addMoney(Client client,int money) throws AccountBlockedException;
    void takeMoney(Client client,int money) throws NoMoneyNoHoneyException, AccountBlockedException;
    void addClient(String FIO) throws DuplicateException;
    void deleteClient(Client client);
    void addCard(Client client,Card card) throws DuplicateException;
    void deleteCard(Client client) throws NoCardException;
}
