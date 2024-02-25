package model.persona;

import java.util.Date;

public class Instructor extends Person{

    public Instructor(){};
    
    public Instructor(String name, String phoneNumber, Date bornDate, String address, String email){
        super(name, phoneNumber, bornDate, address, email);
    }

}
