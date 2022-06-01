import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {

    public static boolean signUp(String login, String password, String confirmPassword) {
        boolean isAuthOK = true;
        try {
            if (login.length() > 20 || !login.matches("^[a-zA-Z0-9_.]+$")) {
                throw new WrongLoginException();
            }
            if (password.length() >= 20 || !password.matches("^[a-zA-Z0-9_]+$") || !password.equals(confirmPassword)) {
                throw new WrongPasswordException();
            }

        } catch (WrongLoginException e) {
            System.out.println("Неправильный формат логина");
            isAuthOK = false;
        } catch (WrongPasswordException e) {
            if (!password.equals(confirmPassword)) {
                System.out.println("Пароли не совпадают");
            } else {
                System.out.println("Неправильный формат пароля");
            }
            isAuthOK = false;
        } catch (Exception e) {
            isAuthOK = false;
        } finally {
            return isAuthOK;
        }
    }

    public static void main(String[] args) {
        if (signUp("java_skypro.go", "D_1hWiKjjP_9", "D_1hWiKjjP_9")) {
            System.out.println("Авторизация прошла успешно");
        }
    }

}