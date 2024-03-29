package model.persona;

import java.sql.Date;

public abstract class Person {
    private int id;
    private String name;
    private String phoneNumber;
    private Date bornDate;
    private String address;
    private String email;
 
    public Person() {}

    public Person(String name, String phoneNumber, Date bornDate, String address, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.bornDate = bornDate;
        this.address = address;
        this.email = email;
    }

    public Person(int id, String name, String phoneNumber, Date bornDate, String address, String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.bornDate = bornDate;
        this.address = address;
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
