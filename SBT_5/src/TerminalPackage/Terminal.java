package TerminalPackage;

import ClientPackage.Card;
import ClientPackage.Client;
import MyException.*;

/**
 * Created by dmitr on 28.11.2016.
 */
public interface Terminal {

    long checkMoney() throws AccountBlockedException, PinNotFoundException;
    void addMoney(int money) throws AccountBlockedException, PinNotFoundException;
    void takeMoney(int money) throws NoMoneyNoHoneyException, AccountBlockedException, PinNotFoundException;
    Client addClient(String FIO) throws DuplicateException;
    void deleteClient(Client client) throws PinNotFoundException;
    void addCard(Client client,Card card) throws DuplicateException;
    void deleteCard(Client client) throws NoCardException, PinNotFoundException;
}
