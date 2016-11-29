package MyException;

/**
 * Created by dmitr on 30.11.2016.
 */
public class NoCardException extends Exception {
    public NoCardException(){
        super("У Вас и так нет карты! Чтобы избежать в дальнейшем этой ошибки, заведите себе карту!)");
    }
}
