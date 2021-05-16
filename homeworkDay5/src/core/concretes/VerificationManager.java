package core.concretes;

import core.abstracts.VerificationService;
import entities.concretes.User;

import java.util.regex.Pattern;

public class VerificationManager implements VerificationService {

    public boolean isValidEmail(String email) {

        String regexEmail = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regexEmail);

        if (email == null) {
            return false;
        }
        return pattern.matcher(regexEmail).matches();
    }

    public boolean isValidPassword(String password) {

        if (password == null || password.length() < 6) {
            return false;
        }
        return true;
    }

    public boolean isValidName(String name) {

        if (name == null || name.length() < 2) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isValid(User user) {

        if (!isValidEmail(user.getEmail())) {
            System.out.println("Yanl�� Email Bi�imi");
            return false;
        }

        if (!isValidName(user.getFirstName())) {
            System.out.println("�sminiz minimum 2 karakter i�ermeli");
            return false;
        }

        if (!isValidName(user.getLastName())) {
            System.out.println("Soyisminiz minimum 2 karakter i�ermeli");
            return false;
        }

        if (!isValidPassword(user.getPassword())) {
            System.out.println("�ifreniz minimum 6 karakter olmal�");
            return false;
        }
        return true;
    }
}