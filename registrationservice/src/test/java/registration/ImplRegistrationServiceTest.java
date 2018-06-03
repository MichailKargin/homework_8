package registration;


import accounts.AccountService;
import accounts.UserProfile;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;;

/**
 * Created by 12 on 02.06.2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class ImplRegistrationServiceTest {
    @Mock
    AccountService accountService;

    RegistrationService registrationService;

    @Before
    public void setUp(){
        registrationService = new ImplRegistrationService(accountService);
    }

    @Test
    public void registerNewUserTest(){

        String login = "user1";
        String password = "pass";
        String email = "user1@gmail.com";
        UserProfile newUser = new UserProfile(login, password, email);

        registrationService.registerNewUser(login, password, email);
            verify(accountService).addNewUser(newUser);

    }

    @Test(expected = IllegalArgumentException.class)
    public void registerDuplicateUserTest() {
        String login = "user1";
        String password = "pass";
        String email = "user1@gmail.com";
        UserProfile newUser = new UserProfile(login, password, email);
        doThrow(new IllegalArgumentException()).when(accountService).addNewUser(newUser);
        registrationService.registerNewUser(login, password, email);
    }


    @Test
    public void isRegisteredUserTest(){
        String login = "user1";
        String password = "pass";
        String email = "user1@gmail.com";
        UserProfile userProfile = new UserProfile(login, password, email);
        when(accountService.getUserByLogin(login)).thenReturn(userProfile);

        assertEquals(registrationService.isRegisteredUser(login), true);
        assertEquals()
    }

    @Test
    public void isRegisteredUserTestUnregistered(){
        String login = "unregister";
        when(accountService.getUserByLogin(login)).thenReturn(null);

        assertEquals(registrationService.isRegisteredUser(login), false);
    }
}
