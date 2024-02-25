package controller;

import model.Model;

public class Controller {
    
    private Model model;
    
    
    public Controller(){
        model = new Model();
        model.addExample();
    }

}
