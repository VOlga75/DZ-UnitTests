import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ContactTests {
    Contact sut;

    @BeforeEach
    public void init() {
        sut = new Contact("Валя", "25-15-30");
    }

    @Test
    public void testFindNamberPhone() {
        //String original = sut.getNamberPhone();
        String findNum = "25-15-30";
        boolean rez = sut.findNamberPhone(findNum);
        Assertions.assertTrue(rez);
    }

    @Test
    public void hamcrestFindNamberPhone() {
        //String original = sut.getNamberPhone();
        String findNum = "25-15-30";
        boolean rez = sut.findNamberPhone(findNum);
        assertThat(rez, equalTo(Boolean.TRUE));
        //Assertions.assertTrue(rez);
    }

    @Test
    public void testToString() {
        String waitRez = "Имя: Валя, телефон: 25-15-30";
        String rez = sut.toString();
        Assertions.assertEquals(waitRez, rez);
    }

    @Test
    public void hamcrestToString() {
        String rez = sut.toString();
        assertThat(rez, equalTo("Имя: Валя, телефон: 25-15-30"));
    }
}
