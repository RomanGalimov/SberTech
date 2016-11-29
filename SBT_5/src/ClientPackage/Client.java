package ClientPackage;

import MyException.AccountBlockedException;
import MyException.NoMoneyNoHoneyException;
import TerminalPackage.Terminal;

/**
 * Created by dmitr on 28.11.2016.
 */
public class Client {

    private String FIO;
    private Card cardClient;

    public Client(String FIO) {
        this.FIO = FIO;
    }

    public Client(String FIO, Card cardClient) {
        this.FIO = FIO;
        this.cardClient = cardClient;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public Card getCardClient() {
        return cardClient;
    }

    public void setCardClient(Card cardClient) {
        this.cardClient = cardClient;
    }

}
