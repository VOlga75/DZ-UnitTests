import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PhoneBookTest {
    final static String nameGroop1 = "Родня";
    final static String nameGroop2 = "МЧС и ЖКХ";

    static PhoneBook sut = new PhoneBook();
    Contact sutContact = new Contact("МАМА", "325-259");

    @BeforeAll
    public static void init() {
        List<Contact> family = new ArrayList();
        family.add(new Contact("Иван", "10-01-01"));
        family.add(new Contact("Катя", "325-259"));

        Contact c2 = new Contact("МАМА", "325-259");
        Contact c3 = new Contact("Комфорт", "12-568-2");
        Contact c4 = new Contact("МЧС", "112");

        sut.phoneGroup.put(nameGroop1, family);
        sut.phoneGroup.put("Работа", new ArrayList<Contact>());
        sut.phoneGroup.put(nameGroop2, new ArrayList<Contact>());
        sut.addContactToGroup(nameGroop2, c2);
        sut.addContactToGroup(nameGroop1, c2);
        sut.addContactToGroup(nameGroop2, c4);
        sut.addContactToGroup("Работа", c3);
    }

    @BeforeEach
    public void initContact() {
        Contact sutContact = new Contact("МАМА", "325-259");
    }

    @Test
    public void testFindContactInGroup() {//не понимаю почему красное при выполнении
        List<String> waitRez = Arrays.asList(nameGroop2, nameGroop1);
        List<String> rez = sut.findContactInGroup(sutContact);
        Assertions.assertLinesMatch(waitRez, rez);
    }

    @Test
    public void hamcrestFindContactInGroup() {//не понимаю почему красное при выполнении
        List<String> rez = sut.findContactInGroup(sutContact);
        assertThat(rez, notNullValue());
        assertThat(rez, allOf(hasItem(nameGroop1), hasItem(nameGroop2)));
    }

    @Test
    public void hamcrestAddContactToGroup() {
        Contact addContact = new Contact("Гудвин", "2128506");
        boolean rez = sut.addContactToGroup(nameGroop2, addContact);
        assertThat(rez, equalTo(Boolean.TRUE));
    }

    @AfterAll
    public static void closeAll() {
        sut.phoneGroup.clear();
    }

}
