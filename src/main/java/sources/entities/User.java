package sources.entities;

public class User {
    private String login;
    private String password;
    private String userType;

    public User(String login, String password, String userType) {
        this.login = login;
        this.password = password;
        this.userType = userType;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }
}