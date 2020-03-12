public class Employee {
    private String title = "";
    private String name = "";
    private String pps = "";
    private String etype = "";
    private long phone = 0;
    private int age = 0;

    public Employee(String title, String name, String pps, long phone, String etype, int age) {
        setTitle(title);
        setName(name);
        setPps(pps);
        setPhone(phone);
        setEtype(etype);
        setAge(age);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == "Mr" || title == "Mrs" || title == "Ms")
            this.title = title;
        else
            throw new IllegalArgumentException("Invalid title (Must be either: |Mr|Mrs|Ms|)");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2)
            this.name = name;
        else
            throw new IllegalArgumentException("Invalid name (Must be >= 2 characters");
    }

    public String getPps() {
        return pps;
    }

    public void setPps(String pps) {
        if (pps.length() >= 8)
            this.pps = pps;
        else
            throw new IllegalArgumentException("Invalid PPS number (Must be >= 8 characters");
    }

    public String getEtype() {
        return etype;
    }

    public void setEtype(String etype) {
        if (etype == "Full-Time" || etype == "Part-Time" || etype == "Contractor")
            this.etype = etype;
        else
            throw new IllegalArgumentException("Invalid Employment Type (Must be either: |Full-Time|Part-Time|Contractor|");
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        if (String.valueOf(phone).length() == 9)
            this.phone = phone;
        else
            throw new IllegalArgumentException("Invalid Phone Number (Must be in a 9 digits format)");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 16)
            this.age = age;
        else
            throw new IllegalArgumentException("Invalid age (Must be >= 16 years old");
    }
}
