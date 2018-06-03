package accounts;

import java.util.*;

/**
 * Created by 12 on 02.06.2018.
 */
public class ImplAccountService implements  AccountService {
    private final Map <String, UserProfile> loginToProfile;

    public ImplAccountService(){
        loginToProfile = new HashMap<String, UserProfile>();
    }

    @Override
    public void addNewUser (UserProfile userProfile){
        if (loginToProfile.containsKey(userProfile.getLogin())){
            throw new IllegalArgumentException("Пользователь с данным логином уже существует");
        }
        loginToProfile.put(userProfile.getLogin(),userProfile);
    }

    @Override
    public void updateUser (UserProfile newUserProfile) {
        if (loginToProfile.containsKey(newUserProfile.getLogin())) {
            loginToProfile.put(newUserProfile.getLogin(), newUserProfile);
        } else {
            throw new IllegalArgumentException("Пользователь с таким логином не существует");
        }
    }
    @Override
    public UserProfile getUserByLogin (String login){
        return loginToProfile.get(login);
    }

}
