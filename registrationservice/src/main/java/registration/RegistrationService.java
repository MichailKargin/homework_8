package registration;

/**
 * Created by 12 on 02.06.2018.
 */
public interface RegistrationService {

    void registerNewUser (String name, String password, String email);
    boolean isRegisteredUser (String name);

}
