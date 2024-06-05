package sources.database;

import sources.entities.User;
import java.util.ArrayList;
import java.util.List;

public class InMemoryUser {

    private List<User> users;

    public InMemoryUser() {
        users = new ArrayList<>();
        initializeUsers();
    }

    private void initializeUsers() {
        users.add(new User("admin", "adminpass", "Адміністратор"));
        users.add(new User("user", "userpass", "Користувач"));
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserByCredentials(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}