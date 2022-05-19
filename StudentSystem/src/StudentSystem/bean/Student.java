package StudentSystem.bean;

public class Student {
    private int id;
    private String name;
    private int age;
    private int classS;
    private String major;
    private Address address;
    public Student()
    {}
    public Student(int id,String name,int age,int classS,String major,Address address)
    {
        this.id = id ;
        this.name = name;
        this.classS = classS;
        this.major = major;
        this.age = age;
//        this.address.setProvince(address.getProvince());
//        this.address.setCity(address.getCity());
//        this.address.setStreet(address.getStreet());
//        this.address.setDoor(address.getDoor());
        this.setAddress(address);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getClassS() {
        return classS;
    }

    public void setClassS(int classS) {
        this.classS = classS;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
