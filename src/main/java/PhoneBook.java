import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    Map<String, List<Contact>> phoneGroup = new HashMap();


    public boolean addContactToGroup(String nameGroup, Contact contact) {
        if (phoneGroup.get(nameGroup) == null) {
            //System.out.printf("Группы %s не существует, добавление невозможно", nameGroup);
            return false;
        } else {
            phoneGroup.get(nameGroup).add(contact);
            return true;
        }
    }

    public ArrayList<String> findContactInGroup(Contact contact) {
        List<String> groups = new ArrayList();

        for (Map.Entry<String, List<Contact>> kv : phoneGroup.entrySet()) {

            List<Contact> contactList = kv.getValue();
            if (contactList.indexOf(contact) >= 0) {
                groups.add(kv.getKey());
            }
        }
        return (ArrayList<String>) groups;
    }

    public ArrayList<String> findPhoneNumberInGroup(String numberPhone) {
        List<String> contactRes = new ArrayList();
        StringBuilder res = new StringBuilder();

        for (Map.Entry<String, List<Contact>> kv : phoneGroup.entrySet()) {
            List<Contact> contactList = kv.getValue();
            for (Contact l : contactList) {
                if (l.findNamberPhone(numberPhone) == true) {
                    contactRes.add("Имя " + l.getName() + " в группе " + kv.getKey());
                }
            }
        }
        return (ArrayList<String>) contactRes;
    }

    public void printGroup(String nameGroup) {
        StringBuilder res = new StringBuilder();
        if (phoneGroup.get(nameGroup) == null) {
            System.out.printf("Группы %s не существует, распечатать невозможно", nameGroup);
        } else {
            res.append("В группе " + nameGroup + " состоят:\n");
            List<Contact> contactList = phoneGroup.get(nameGroup);
            for (Contact l : contactList) {
                res.append(l + "\n" + "        ");
            }
            System.out.println(res);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Телефонная книга: \n");
        for (Map.Entry<String, List<Contact>> kv : phoneGroup.entrySet()) {
            res.append("Группа " + kv.getKey() + " состоит из: \n        ");
            List<Contact> contactList = kv.getValue();
            for (Contact l : contactList) {
                res.append(l + "\n" + "        ");

            }
            res.append("\n");
        }
        return res.toString();
    }
}
