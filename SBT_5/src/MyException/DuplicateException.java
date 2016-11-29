package MyException;

/**
 * Created by dmitr on 27.11.2016.
 */
public class DuplicateException extends Exception {
    public DuplicateException(){
        super("Найден дубликат аккаунта/карты! Чтобы избежать в дальнейшем данной ошибки, необходимо... ");
    }
}
