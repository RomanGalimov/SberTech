package ClientPackage;


import java.io.*;

/**
 * Created by dmitr on 28.11.2016.
 */
public class Client implements Serializable {

    private String FIO;
    private Card cardClient;
    public byte version = 100;
    public byte count = 0;

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

    public void setStream(String fileName) {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(fileName));
            dos.writeUTF(FIO);
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
            dis.readUTF();
            System.out.println("Фамилия считана из файла!");
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
            bw.write(FIO);
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
        StreamTokenizer st = null;
        try {
            br = new BufferedReader(new FileReader(nameFile));
            st = new StreamTokenizer(br);
            String s = "";
            while (st.nextToken() != StreamTokenizer.TT_EOF) {
                s += st.sval;
                s += " ";
            }
            System.out.println(s);
            //System.out.println(br);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
