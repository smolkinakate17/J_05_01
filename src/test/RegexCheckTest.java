import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegexCheckTest {
    private static final String EMAIL="email";
    private static final String PHONE="телефон";
    private static final String USERNAME="username";
    private static final String INN="ИНН";
    private static final String NONE="none";

    @Test
    void check() {
        Assertions.assertEquals(EMAIL,RegexCheck.check("user.name@example.com"));
        Assertions.assertEquals(NONE,RegexCheck.check("@example.com"));
        Assertions.assertEquals(USERNAME,RegexCheck.check("user.name.example.com"));
        Assertions.assertEquals(NONE,RegexCheck.check("user.name@example"));
        Assertions.assertEquals(EMAIL,RegexCheck.check("user_name1@some.example.com"));
        Assertions.assertEquals(PHONE,RegexCheck.check("+7-(123)-456-78-90"));
        Assertions.assertEquals(PHONE,RegexCheck.check("+7(123)456-78-90"));
        Assertions.assertEquals(PHONE,RegexCheck.check("+7-123-456-78-90"));
        Assertions.assertEquals(PHONE,RegexCheck.check("+71234567890"));
        Assertions.assertEquals(NONE,RegexCheck.check("71234567890"));
        Assertions.assertEquals(INN,RegexCheck.check("1234567890"));
        Assertions.assertEquals(INN,RegexCheck.check("000000000000"));
        Assertions.assertEquals(NONE,RegexCheck.check("7777-8888-9999"));
        Assertions.assertEquals(USERNAME,RegexCheck.check("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.$1234_"));
        Assertions.assertEquals(USERNAME,RegexCheck.check("aaaa1111"));
        Assertions.assertEquals(NONE,RegexCheck.check("a"));
        Assertions.assertEquals(NONE,RegexCheck.check("qwerty 456"));
        Assertions.assertEquals(NONE,RegexCheck.check("4abc"));
        Assertions.assertEquals(NONE,RegexCheck.check("$asdfghjk"));
        Assertions.assertEquals(NONE,RegexCheck.check(""));
    }
}