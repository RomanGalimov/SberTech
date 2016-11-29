package MyException;

/**
 * Created by dmitr on 27.11.2016.
 */
public class PinNotFoundException extends Exception  {
    public PinNotFoundException(){
        super("Данный пароль не найден! Чтобы избежать в дальнейшем, попейте тэнотэн!");
    }
}
