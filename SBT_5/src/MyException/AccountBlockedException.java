package MyException;

/**
 * Created by dmitr on 27.11.2016.
 */
public class AccountBlockedException extends Exception {
    public AccountBlockedException(){
        super("Аккаунт заблокирован! Чтобы избежать в дальнейшем блокировки аккаунта, необходимо...");
    }
}
