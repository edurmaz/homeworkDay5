import adapter.GoogleUserVerificationAdapter;
import business.abstracts.UserService;
import business.concretes.UserManager;
import core.concretes.ValidatorManager;
import core.concretes.VerificationManager;
import dataAccess.concretes.UserDao;
import entities.concretes.User;

public class Main {

    public static void main(String[] args) {
        User user1 = new User(1, "Emre", "DURMAZ", "emredrmz89@gmail.com", "123456");

        User user2 = new User(1, "Engin", "Demiroð", "engindemirog@gmail.com", "12345");

        UserService service = new UserManager(new VerificationManager(),
                new UserDao(), new ValidatorManager());


        service.register(user1);
        service.login(user1.getEmail(), user1.getPassword());

        System.out.println("-------------------");

        service.register(user2);
        service.login(user2.getEmail(), user2.getPassword());

        System.out.println(" ");
        System.out.println("------Google------");
        System.out.println(" ");

        UserService googleService = new UserManager(new GoogleUserVerificationAdapter(),
                new UserDao(), new ValidatorManager());

        googleService.register(user1);

        System.out.println("-------------------");

        googleService.register(user2);

    }
}