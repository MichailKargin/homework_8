package auth;

import accounts.UserProfile;

/**
 * Created by 12 on 02.06.2018.
 */
public interface AuthorizationService {

    UserProfile authorizeUser (String login, String password);
    boolean isAuthorized (String login);

}


