package StudentSystem.bean;

public class Address {
    public String province;
    public String city;
    public String street;
    public String door;
    public Address()
    {}
    public Address(String province, String city, String street, String door)
    {
        this.province = province;
        this.city = city;
        this.street = street;
        this.door = door;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }
}
