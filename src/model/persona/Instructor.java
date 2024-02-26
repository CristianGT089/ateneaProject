package model.persona;

import java.sql.Date;

public class Instructor extends Person{

    public Instructor(){};
    
    public Instructor(String name, String phoneNumber, Date bornDate, String address, String email){
        super(name, phoneNumber, bornDate, address, email);
    }

    public Instructor(int id, String name, String phoneNumber, Date bornDate, String address, String email){
        super(id, name, phoneNumber, bornDate, address, email);
    }

}
