package model.persona;

import java.util.Date;

public class Monitor extends Person{
    public Monitor(){};
    
    public Monitor(String name, String phoneNumber, Date bornDate, String address, String email){
        super(name, phoneNumber, bornDate, address, email);
    }
}