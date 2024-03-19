import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {
        // Hardcoded credentials (example for demonstration purposes only)
        String username = "admin";
        String password = "password123";

        // Check if the provided credentials match the hardcoded ones
        return username.equals(username) && password.equals(password);
    }
}
