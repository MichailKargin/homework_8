package accounts;

/**
 * Created by 12 on 02.06.2018.
 */
public interface AccountService {

    void addNewUser (UserProfile userProfile);
    void updateUser (UserProfile newUserProfile);

    UserProfile getUserByLogin (String login);


}
