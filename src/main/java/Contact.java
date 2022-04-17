public class Contact {
    private String name;
    private String namberPhone;

    public Contact(String name, String namberPhone) {
        this.name = name;
        this.namberPhone = namberPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamberPhone() {
        return namberPhone;
    }

    public void setNamberPhone(String namberPhone) {
        this.namberPhone = namberPhone;
    }

    public boolean findNamberPhone(String namberPhone) {
        if (this.namberPhone.equals(namberPhone)) {
            return true;
        } else {
            return false;
        }
    }

    //   this.namberPhone = namberPhone; }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Contact contact = (Contact) obj;
        return name == contact.name || (name != null && name.equals(contact.getName())) && (namberPhone == contact.namberPhone
                || (namberPhone != null && namberPhone.equals(contact.getNamberPhone())));
    }

    @Override
    public String toString() {
        //return super.toString();
        return "Имя: " + name + ", телефон: " + namberPhone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((namberPhone == null) ? 0 : namberPhone.hashCode());
        return result;
    }
}
