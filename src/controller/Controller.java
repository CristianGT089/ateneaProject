package controller;

import Vista.Vista;
import Vista.VistaInstructor;
import Vista.VistaMonitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Model;

public class Controller implements ActionListener{
    
    private Vista vista;
    private Model model;
    
    public Controller(Model model, Vista vista){
        this.model = model;

        this.vista = vista; 
        this.vista.monitor.addActionListener(this);
        this.vista.instructor.addActionListener(this);
    }
    
    public void iniciar(){
        vista.setTitle("Monitor");
        vista.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==vista.monitor){
           
           VistaMonitor frm = new VistaMonitor();
           MonitorController moncon = new MonitorController(model.getMonitorDAO(), frm);
           moncon.iniciar();
           frm.setVisible(true);
           vista.dispose();
        }
        if(e.getSource()==vista.instructor){
            
            VistaInstructor frm = new VistaInstructor();
            InstructorController inscon = new InstructorController(model.getInstructorDAO(), frm);
            inscon.iniciar();
            frm.setVisible(true);
            vista.dispose();
        }
    }

    public Vista getVista() {
        return vista;
    }

    public void setVista(Vista vista) {
        this.vista = vista;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

}
