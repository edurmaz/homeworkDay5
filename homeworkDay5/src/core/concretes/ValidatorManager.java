package core.concretes;

import core.abstracts.ValidatorService;

public class ValidatorManager implements ValidatorService {
    @Override
    public void verificationMail() {
        System.out.println("Do�rulama maili g�nderildi...");
    }
}