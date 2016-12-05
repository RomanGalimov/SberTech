package ClientPackage;

import java.io.*;

/**
 * Created by dmitr on 28.11.2016.
 */
public class Card implements Serializable {


    private long numberCard;
    private int pin;
    private long money;
    private boolean statusBlock;
    public byte version = 100;
    public byte count = 0;

    public Card() {

    }

    public Card(long numberCard, int pin) {
        this.numberCard = numberCard;
        this.pin = pin;
        this.money = 0;
        this.statusBlock = true;
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

    public void setStream(String fileName) {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(fileName));
            dos.writeLong(numberCard);
            dos.writeInt(pin);
            dos.writeLong(money);
            dos.writeBoolean(statusBlock);
            System.out.println("Запись в файл произведена!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dos.flush();
                dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void getStream(String fileName) {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream(fileName));
            numberCard = dis.readLong();
            pin = dis.readInt();
            money = dis.readLong();
            statusBlock = dis.readBoolean();
            System.out.println("Значения для карты считаны из файла!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setWriter(String nameFile) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(nameFile));
            bw.write(String.valueOf(numberCard));
            bw.write(pin);
            bw.write(String.valueOf(money));
            bw.write(String.valueOf(statusBlock));
            System.out.println("Записан в файл!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.flush();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setReader(String nameFile) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(nameFile));
            System.out.println(br);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}