package core.abstracts;

import entities.concretes.User;

public interface VerificationService {
    boolean isValid(User user);
}