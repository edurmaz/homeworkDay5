package business.concretes;

import business.abstracts.UserService;
import core.abstracts.ValidatorService;
import core.abstracts.VerificationService;
import dataAccess.abstracts.UserDaoService;
import entities.concretes.User;

public class UserManager implements UserService {
    VerificationService verificationService;
    UserDaoService userDaoService;
    ValidatorService validatorService;


    public UserManager(VerificationService verificationService, UserDaoService userDaoService, ValidatorService validatorService) {
        super();
        this.verificationService = verificationService;
        this.userDaoService = userDaoService;
        this.validatorService = validatorService;
    }

    @Override
    public void register(User user) {

        if (!verificationService.isValid(user)) {
            System.out.println("Kullanýcý bilgileri yanlýþ. Lütfen tekrar deneyiniz.(Kaydedilemedi)");
        } else if (!userDaoService.checkEmail(user)) {
            System.out.println("Email adresinizi kontrol ediniz...");

        } else {
            userDaoService.add(user);
            validatorService.verificationMail();
        }
    }

    @Override
    public void login(String email, String password) {

        if (userDaoService.loginCheck(email, password)) {

            System.out.println("giriþ baþarýlý");

        } else {
            System.out.println("giriþ baþarýsýz");
        }
    }

}