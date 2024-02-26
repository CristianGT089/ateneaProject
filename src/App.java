import Vista.Vista;
import controller.Controller;
import model.Model;

public class App {

    public static void main(String[] args) throws Exception {
        
        Model model = new Model();
        Vista frm = new Vista();
        Controller control = new Controller(model,frm);
        control.iniciar();
        frm.setVisible(true);
         
    }

}
