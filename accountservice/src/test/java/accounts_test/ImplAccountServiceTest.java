package accounts_test;

import accounts.AccountService;
import accounts.ImplAccountService;
import accounts.UserProfile;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by 12 on 02.06.2018.
 */
public class ImplAccountServiceTest {

    AccountService accountService;

    @Before
    public void setUp(){

        accountService = new ImplAccountService();

    }

    @Test
    public  void addNewUserTest() {
        UserProfile newUser = new UserProfile("user1", "123456", "user1@gmail.com");

        accountService.addNewUser(newUser);

        UserProfile storedUser = accountService.getUserByLogin("user1");

        assertEquals(newUser, storedUser);

    }

    @Test(expected = IllegalArgumentException.class)
    public void addDuplicateUserTest(){

        UserProfile newUser = new UserProfile("user1","qwerty","user1@gmail.com");
        UserProfile newUser2 = new UserProfile("user1","qwerty123","user@gmail.com");

        accountService.addNewUser(newUser);
        accountService.addNewUser(newUser2);

    }

    @Test
    public void updateUserTest(){
        UserProfile newUser = new UserProfile("user1", "qwerty","user1@gmail.com");
        accountService.addNewUser(newUser);

        UserProfile updatedUser = new UserProfile("user1", "qwerty123","user1@gmail.com");
        accountService.updateUser(updatedUser);

        UserProfile storedUser = accountService.getUserByLogin("user1");

        assertEquals(updatedUser, storedUser);

    }


    @Test(expected = IllegalArgumentException.class)
    public void updateNonstoredUserTest() {
        UserProfile updatedUser = new UserProfile("user1", "qwerty123", "user1@mail.com");
        accountService.updateUser(updatedUser);
    }

}
