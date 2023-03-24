package ro.tuc;

import ro.tuc.Controller.Controller;
import ro.tuc.Model.Operations;
import ro.tuc.Model.Polynomial;
import ro.tuc.View.View;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class App {
    public static void main(String[] args) {
       View view=new View();
       Operations operations=new Operations();
        Controller controller=new Controller(view,operations);
       Polynomial pol1=new Polynomial();
        Polynomial pol2=new Polynomial();
       Polynomial result=new Polynomial();
        pol1.getMap().put(3,1.0);
        pol1.getMap().put(1,1.0);
        pol1.getMap().put(0,1.0);
        pol2.getMap().put(1,1.0);
        pol2.getMap().put(0,-1.0);
       result=operations.division(pol1,pol2);

        for (Map.Entry<Integer, Double> entry : result.getMap().entrySet())
       {
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
       }



       }
    }
