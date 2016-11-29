package TerminalPackage;

import ClientPackage.Card;
import ClientPackage.Client;
import MyException.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by dmitr on 28.11.2016.
 */
public class TerminalMethodClass implements Terminal {

    public static ArrayList<Client> clients = new ArrayList<>();
    private static int i = 0;

    public TerminalMethodClass(String FIO) throws DuplicateException {
        addClient(FIO);
    }

    public TerminalMethodClass(Client client, int pin) throws PinNotFoundException, InterruptedException {
        if (checkPin(client, pin)) {
            System.out.println("Вы получили доступ к терминалу!");
        } else throw new PinNotFoundException();
    }

    public static boolean checkPin(Client client, int pin) throws InterruptedException {
        if (pin == client.getCardClient().getPin()) {
            return true;
        } else if (i < 3) {
            i++;
            return false;
        } else if(i==3) {
            TimeUnit.SECONDS.sleep(3);
            return  false;
        }
        return false;
    }

    @Override
    public long checkMoney(Client client) throws AccountBlockedException {
        if (client.getCardClient().isStatusBlock()) {
            return client.getCardClient().getMoney();
        } else throw new AccountBlockedException();
    }

    @Override
    public void addMoney(Client client, int money) throws AccountBlockedException {
        if (client.getCardClient().isStatusBlock() & (money%100)==0) {
            client.getCardClient().setMoney(client.getCardClient().getMoney() + money);
        } else if (client.getCardClient().isStatusBlock())throw new AccountBlockedException();
        else {System.out.println("Сумма должна быть кратная 100");}
    }

    @Override
    public void takeMoney(Client client, int money) throws NoMoneyNoHoneyException {
        if (client.getCardClient().getMoney() >= money & (money%100)==0) {
            client.getCardClient().setMoney(client.getCardClient().getMoney() - money);
        } else if((money%100)!=0){System.out.println("Сумма должна быть кратная 100");}
        else throw new NoMoneyNoHoneyException();
    }

    @Override
    public void addClient(String FIO) throws DuplicateException {
        for (Client e : clients) {
            if (FIO.equals(e.getFIO())) {
                throw new DuplicateException();
            }
        }
        clients.add(new Client(FIO));
    }

    @Override
    public void deleteClient(Client client) {
        clients.remove(client);
    }

    @Override
    public void addCard(Client client, Card card) throws DuplicateException {
        for (Client e : clients) {
            if (card.getNumberCard() == e.getCardClient().getNumberCard() && client.getCardClient() == null) {
                throw new DuplicateException();
            }
        }
        client.setCardClient(card);

    }

    @Override
    public void deleteCard(Client client) throws NoCardException {
        if (client.getCardClient() != null) {
            client.setCardClient(null);
        } else throw new NoCardException();
    }



}
