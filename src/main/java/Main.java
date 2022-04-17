import java.util.ArrayList;
import java.util.List;

public class Main {
    public static PhoneBook phoneBook = new PhoneBook();

    public static void main(String[] args) {
        // заполняем книгу, создаем группы и контакты
        startPhoneBook();

        Contact c2 = new Contact("МАМА", "325-259");
        // демонстрация добавления контакта в несуществующую группу
        String gr = "Туса";
        if (!phoneBook.addContactToGroup(gr, c2)) {
            System.out.printf("Не могу добавить %s в группу %s, нет такой группы\n", c2, gr);
        } else {
            System.out.printf("Добавление выполнено");
        }
// поиск контакта в нескольких группах
        List groups = phoneBook.findContactInGroup(c2);
        if (groups.isEmpty()) {
            System.out.println(c2.getName() + " - не найдено в телефонной книге \n");
        } else {
            System.out.println("Имя " + c2.getName() + " найдено в группах: " + printLst(groups));
        }
// распечатать группу
        phoneBook.printGroup("Родня");
// поиск контакта по номеру
        String n = "325-259";
        List contacts = phoneBook.findPhoneNumberInGroup(n);
        if (contacts.isEmpty()) {
            System.out.println(n + " в телефонной книге не обнаружен");
        } else {
            System.out.println("Номер " + n + " найден: " + printLst(contacts));
        }
        // печать всей телефонной книги
        // System.out.println(phoneBook);
    }


    static String printLst(List<String> lst) {
        StringBuilder res = new StringBuilder();
        while (!lst.isEmpty()) {
            res.append("\"" + lst.remove(0) + "\" ");
        }
        return res.toString();
    }

    static void startPhoneBook() {
        List<Contact> family = new ArrayList();
        family.add(new Contact("Иван", "10-01-01"));
        family.add(new Contact("Катя", "325-259"));

        Contact c1 = new Contact("Варя", "12-568-2");
        Contact c2 = new Contact("МАМА", "325-259");
        Contact c3 = new Contact("Комфорт", "12-568-2");
        Contact c4 = new Contact("МЧС", "112");

        phoneBook.phoneGroup.put("Родня", family);
        phoneBook.phoneGroup.put("Работа", new ArrayList<Contact>());
        phoneBook.phoneGroup.put("МЧС и ЖКХ", new ArrayList<Contact>());

        phoneBook.addContactToGroup("Родня", c2);
        phoneBook.addContactToGroup("МЧС и ЖКХ", c2);
        phoneBook.addContactToGroup("МЧС и ЖКХ", c3);
        phoneBook.addContactToGroup("МЧС и ЖКХ", c4);
        phoneBook.addContactToGroup("Работа", c3);
    }
}

