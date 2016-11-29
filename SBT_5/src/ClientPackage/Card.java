package ClientPackage;

import java.io.*;

/**
 * Created by dmitr on 28.11.2016.
 */
public class Card {


    private long numberCard;
    private int pin;
    private long money;
    private boolean statusBlock;

    public Card() {

    }

    public Card(long numberCard, int pin) {
        this.numberCard = numberCard;
        this.pin = pin;
        this.money = 0;
        this.statusBlock=true;
    }


    public boolean isStatusBlock() {
        return statusBlock;
    }

    public void setStatusBlock(boolean statusBlock) {
        this.statusBlock = statusBlock;
    }

    public long getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(long numberCard) {
        this.numberCard = numberCard;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public void setStream(String fileName) throws IOException {
        DataOutputStream dos=new DataOutputStream(new FileOutputStream(fileName));
        dos.writeLong(numberCard);
        dos.writeInt(pin);
        dos.writeLong(money);
        dos.writeBoolean(statusBlock);
        System.out.println("Запись в файл произведена!");
    }

    public void getStream(String fileName) throws IOException {
        DataInputStream dis=new DataInputStream(new FileInputStream(fileName));
        numberCard=dis.readLong();
        pin=dis.readInt();
        money=dis.readLong();
        statusBlock=dis.readBoolean();
        System.out.println("Значения для карты считаны из файла!");
    }


}
