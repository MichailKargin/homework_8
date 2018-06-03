package messages;

import accounts.UserProfile;
import java.util.*;


/**
 * Created by 12 on 02.06.2018.
 */
public interface MessageService {

    void sendMessage (UserProfile from, UserProfile to, String message);

    List <Message> getMessageHistory (UserProfile user1, UserProfile user2);

}
