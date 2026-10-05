import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/* User class representing a user in the hurricane relief application */
/**
 * @author Nyesh1
 */

public class User {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String email;
    private String password;
    private String userName;
    private Location location;
    private UUID id;
    private ArrayList<ReliefRequest> requests;

    public User(String firstName, String lastName, Date birthDate,
                String email, String password, String username) {
        // TODO: implement
    }

    public boolean isMatch(String userName, String password) {
        return false;
    }

    public String getFirstName() {
        return null;
    }

    public String getLastName() {
        return null;
    }

    public Date getBirthDate() {
        return null;
    }

    public String getEmail() {
        return null;
    }

    public String getPassword() {
        return null;
    }

    public String getUsername() {
        return null;
    }
}