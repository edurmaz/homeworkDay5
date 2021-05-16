  
package adapter;

import core.abstracts.VerificationService;
import entities.concretes.User;

public class GoogleUserVerificationAdapter implements VerificationService {
    @Override
    public boolean isValid(User user) {
        GoogleVerificationService googleValidService = new GoogleVerificationService();
        return googleValidService.isValidGoogle();
    }
}