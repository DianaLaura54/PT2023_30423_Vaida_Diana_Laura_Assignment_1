package ro.tuc;

import ro.tuc.Controller.Controller;
import ro.tuc.Model.Operations;
import ro.tuc.View.View;


public class App {
    public static void main(String[] args) {
       View view=new View();
       Operations operations=new Operations();
        Controller controller=new Controller(view,operations);

    }
}

