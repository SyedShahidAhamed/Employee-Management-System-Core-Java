package auth;

public class LoginService {
    private final String USERNAME = "user123";
    private final String PASSWORD = "admin123";
    public boolean login(String username , String password)
    {
             return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}
