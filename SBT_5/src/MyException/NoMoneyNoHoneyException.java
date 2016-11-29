package MyException;

/**
 * Created by dmitr on 27.11.2016.
 */
public class NoMoneyNoHoneyException extends Exception {
    public NoMoneyNoHoneyException(){
        super("Нет средств, милорд! Чтобы избежать в дальнейшем эту ошибку, возьмите кредит!");
    }
}
