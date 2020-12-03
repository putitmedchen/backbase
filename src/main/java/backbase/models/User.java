package backbase.models;

import lombok.Builder;
import lombok.Getter;
import net.bytebuddy.utility.RandomString;

@Getter
@Builder
public class User {

    private String username;
    private String email;
    private String password;

    public static User generateRandomUser() {
        String username = "testUser" + RandomString.make(4);
        String email = RandomString.make(5) + "@gmail.com";
        String password = "P4SSW0RD";
        return User.builder()
                .username(username)
                .email(email)
                .password(password)
                .build();
    }

}
