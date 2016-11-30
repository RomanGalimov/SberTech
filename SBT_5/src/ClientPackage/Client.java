package ClientPackage;


import java.io.*;

/**
 * Created by dmitr on 28.11.2016.
 */
public class Client implements Serializable {

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
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName));
        dos.writeUTF(FIO);
        dos.flush();
        dos.close();
        System.out.println("Запись в файл произведена!");
    }

    public void getStream(String fileName) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(fileName));
        dis.readUTF();
        dis.close();
        System.out.println("Фамилия считана из файла!");
    }

    public void setWriter(String nameFile) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(nameFile));
        bw.write(FIO);
        System.out.println("Записан в файл!");
        bw.flush();
        bw.close();
    }

    public void setReader(String nameFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(nameFile));
        System.out.println(br);
        br.close();
    }
}
