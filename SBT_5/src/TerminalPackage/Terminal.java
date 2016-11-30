package TerminalPackage;

import ClientPackage.Card;
import ClientPackage.Client;
import MyException.*;

/**
 * Created by dmitr on 28.11.2016.
 */
public interface Terminal {

    long checkMoney(Client client) throws AccountBlockedException, PinNotFoundException;
    void addMoney(Client client,int money) throws AccountBlockedException, PinNotFoundException;
    void takeMoney(Client client,int money) throws NoMoneyNoHoneyException, AccountBlockedException, PinNotFoundException;
    Client addClient(String FIO) throws DuplicateException;
    void deleteClient(Client client) throws PinNotFoundException;
    void addCard(Client client,Card card) throws DuplicateException;
    void deleteCard(Client client) throws NoCardException, PinNotFoundException;
}
