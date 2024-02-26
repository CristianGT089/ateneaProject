package model.persona;

import java.sql.Date;

public class Monitor extends Person{
    
    public Monitor(){};
    
    public Monitor(String name, String phoneNumber, Date bornDate, String address, String email){
        super(name, phoneNumber, bornDate, address, email);
    }

    public Monitor(int id, String name, String phoneNumber, Date bornDate, String address, String email){
        super(id, name, phoneNumber, bornDate, address, email);
    }
}
