package ClientPackage;



import java.io.*;

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

    public void setStream(String fileName) throws IOException {
        DataOutputStream dos=new DataOutputStream(new FileOutputStream(fileName));
        dos.writeUTF(FIO);
        System.out.println("Запись в файл произведена!");
    }

    public void getStream(String fileName) throws IOException {
        DataInputStream dis=new DataInputStream(new FileInputStream(fileName));
        dis.readUTF();
        System.out.println("Фамилия считана из файла!");
    }
}
