package ro.tuc;

import ro.tuc.Controller.Controller;
import ro.tuc.Model.Operations;
import ro.tuc.Model.Polynomial;
import ro.tuc.View.View;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.sql.Types.NULL;


public class App {
    public static void main(String[] args) {
       View view=new View();
       Operations operations=new Operations();
        Controller controller=new Controller(view,operations);

    }
}

