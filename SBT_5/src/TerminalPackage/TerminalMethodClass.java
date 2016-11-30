package TerminalPackage;

import ClientPackage.Card;
import ClientPackage.Client;
import MyException.*;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by dmitr on 28.11.2016.
 */
public class TerminalMethodClass implements Terminal {

    public static ArrayList<Client> clients = new ArrayList<>();
    private static int i = 0;
    private boolean terminalOpen = false;

    public TerminalMethodClass() throws DuplicateException {
        terminalOpen = false;
    }

    public TerminalMethodClass(long numberCard, int pin) throws PinNotFoundException, InterruptedException {
        if (checkPin(numberCard, pin)) {
            terminalOpen = true;
            System.out.println("Вы получили доступ к терминалу!");
        } else throw new PinNotFoundException();
    }

    public boolean checkPin(long numberCard, int pin) throws InterruptedException {
        for (Client e : clients) {
            if (e.getCardClient().getNumberCard()==numberCard & e.getCardClient().getPin()==pin) {
                terminalOpen=true;
                return true;
            }
        }
        i++;
        if (i < 3) {
            TimeUnit.SECONDS.sleep(3);
        }
        terminalOpen = false;
        return false;
    }

    @Override
    public long checkMoney(Client client) throws AccountBlockedException, PinNotFoundException {
        if (!terminalOpen) {
            throw new PinNotFoundException();
        }
        if (client.getCardClient().isStatusBlock()) {
            return client.getCardClient().getMoney();
        } else throw new AccountBlockedException();
    }

    @Override
    public void addMoney(Client client, int money) throws AccountBlockedException, PinNotFoundException {
        if (!terminalOpen) {
            throw new PinNotFoundException();
        }
        if (client.getCardClient().isStatusBlock() & (money % 100) == 0) {
            client.getCardClient().setMoney(client.getCardClient().getMoney() + money);
        } else if (client.getCardClient().isStatusBlock()) throw new AccountBlockedException();
        else {
            System.out.println("Сумма должна быть кратная 100");
        }
    }

    @Override
    public void takeMoney(Client client, int money) throws NoMoneyNoHoneyException, PinNotFoundException {
        if (!terminalOpen) {
            throw new PinNotFoundException();
        }
        if (client.getCardClient().getMoney() >= money & (money % 100) == 0) {
            client.getCardClient().setMoney(client.getCardClient().getMoney() - money);
        } else if ((money % 100) != 0) {
            System.out.println("Сумма должна быть кратная 100");
        } else throw new NoMoneyNoHoneyException();
    }

    @Override
    public Client addClient(String FIO) throws DuplicateException {
        for (Client e : clients) {
            if (FIO.equals(e.getFIO())) {
                throw new DuplicateException();
            }
        }
        Client client=new Client(FIO);
        clients.add(client);
        return  client;
    }

    @Override
    public void deleteClient(Client client) throws PinNotFoundException {
        if (!terminalOpen) {
            throw new PinNotFoundException();
        }
        clients.remove(client);
    }

    @Override
    public void addCard(Client client, Card card) throws DuplicateException {
        for (Client e : clients) {
            if (e.getCardClient() != null ) {
                if(card.getNumberCard() == e.getCardClient().getNumberCard())
                throw new DuplicateException();
            }
        }
        client.setCardClient(card);

    }

    @Override
    public void deleteCard(Client client) throws NoCardException, PinNotFoundException {
        if (!terminalOpen) {
            throw new PinNotFoundException();
        }
        if (client.getCardClient() != null) {
            client.setCardClient(null);
        } else throw new NoCardException();
    }

    public void serialOutFile(Client client) {
        try {
            FileOutputStream fos = new FileOutputStream("temp.out");
             ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(client);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }

    public Client serialInFile()
    {
        try {
            FileInputStream fis = new FileInputStream("temp.out");
            ObjectInputStream oin = new ObjectInputStream(fis);
            return (Client) oin.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
