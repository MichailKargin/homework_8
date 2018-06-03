package registration;

import accounts.*;

/**
 * Created by 12 on 02.06.2018.
 */
public class ImplRegistrationService implements RegistrationService  {

    private final AccountService accountService;

    public ImplRegistrationService(AccountService accountService){
        this.accountService  = accountService;
    }

    @Override
    public void registerNewUser (String login, String password, String email){
        UserProfile userProfile = new UserProfile(login, password, email);

        accountService.addNewUser(userProfile);
    }

    @Override
    public boolean isRegisteredUser (String login){
        return accountService.getUserByLogin (login) != null;
    }

}
