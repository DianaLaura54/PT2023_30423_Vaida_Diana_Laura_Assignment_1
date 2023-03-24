package ro.tuc.Controller;

import ro.tuc.Model.Operations;
import ro.tuc.Model.Polynomial;
import ro.tuc.View.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private View view;
    private Polynomial polynomial;
    private Operations operations;

    public Controller(View view,Operations operations) {
        this.view = view;
        this.operations=operations;
        this.view.addCreateListener(new CreateListener());
        this.view.addCreateListener2(new CreateListener2());
        this.view.addCreateListener3(new CreateListener3());
        this.view.addCreateListener4(new CreateListener4());
        this.view.addCreateListener5(new CreateListener5());
        this.view.addCreateListener6(new CreateListener6());
    }


    class CreateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {

                String first = view.getpolynomial1();
                String second = view.getpolynomial2();
                Polynomial polynomial1 =new Polynomial();
                Polynomial polynomial2 =new Polynomial();
                Polynomial result;
                polynomial1.StringtoPol(first);
               polynomial2.StringtoPol(second);
               result=operations.add(polynomial1,polynomial2);
               String x="";
                for (Map.Entry<Integer, Double> entry : result.getMap().entrySet()) {
                    if(entry.getKey()==0)
                    {
                        x = Double.toString(entry.getValue())  +x;
                    }
                    else if(entry.getValue()<0)
                    {
                        x = Double.toString(entry.getValue()) + "x^" + Integer.toString(entry.getKey()) +"+" + x;
                    }
                    else
                    {
                        x =  Double.toString(entry.getValue()) + "x^" + Integer.toString(entry.getKey()) +x;
                    }

                }
                view.settextAreaResult(x);

            } catch (Exception ex) {
                view.showMessage("Something went wrong!");
                ex.printStackTrace();
            }
        }
    }
    class CreateListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {

                String first = view.getpolynomial1();
                String second = view.getpolynomial2();
                Polynomial polynomial1 =new Polynomial();
                Polynomial polynomial2 =new Polynomial();
                Polynomial result;
                polynomial1.StringtoPol(first);
                polynomial2.StringtoPol(second);
                result=operations.substraction(polynomial1,polynomial2);
                String x="";
                for (Map.Entry<Integer, Double> entry : result.getMap().entrySet()) {
                    if(entry.getKey()==0)
                    {
                        x = Double.toString(entry.getValue())  +x;
                    }
                    else if(entry.getValue()<0)
                    {
                        x = Double.toString(entry.getValue()) + "x^" + Integer.toString(entry.getKey()) +"+" + x;
                    }
                    else
                    {
                        x =  Double.toString(entry.getValue()) + "x^" + Integer.toString(entry.getKey()) +x;
                    }
                }
                view.settextAreaResult(x);
            } catch (Exception ex) {
                view.showMessage("Something went wrong!");
                ex.printStackTrace();
            }
        }
    }
    class CreateListener3 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String first = view.getpolynomial1();
                String second = view.getpolynomial2();
                Polynomial polynomial1 =new Polynomial();
                Polynomial polynomial2 =new Polynomial();
                Polynomial result;
                polynomial1.StringtoPol(first);
                polynomial2.StringtoPol(second);
                result=operations.multiplication(polynomial1,polynomial2);
                String x="";
                for (Map.Entry<Integer, Double> entry : result.getMap().entrySet()) {
                    if(entry.getKey()==0)
                    {
                        x = Double.toString(entry.getValue())  +x;
                    }
                    else if(entry.getValue()<0)
                    {
                        x = Double.toString(entry.getValue()) + "x^" + Integer.toString(entry.getKey()) +"+" + x;
                    }
                    else
                    {
                        x =  Double.toString(entry.getValue()) + "x^" + Integer.toString(entry.getKey()) +x;
                    }
                }
                view.settextAreaResult(x);

            } catch (Exception ex) {
                view.showMessage("Something went wrong!");
                ex.printStackTrace();
            }
        }
    }
    class CreateListener4 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String first = view.getpolynomial1();
                String second = view.getpolynomial2();
                Polynomial polynomial1 =new Polynomial();
                Polynomial polynomial2 =new Polynomial();
                Polynomial result;
                polynomial1.StringtoPol(first);
                polynomial2.StringtoPol(second);
                result=operations.division(polynomial1,polynomial2);
                String x="";
                for (Map.Entry<Integer, Double> entry : result.getMap().entrySet()) {
                    if(entry.getKey()==0)
                    {
                        x = Double.toString(entry.getValue())  +x;
                    }
                    else if(entry.getValue()<0)
                    {
                        x = Double.toString(entry.getValue()) + "x^" + Integer.toString(entry.getKey()) +"+" + x;
                    }
                    else
                    {
                        x =  Double.toString(entry.getValue()) + "x^" + Integer.toString(entry.getKey()) +x;
                    }
                }
                view.settextAreaResult(x);
            } catch (Exception ex) {
                view.showMessage("Something went wrong!");
                ex.printStackTrace();
            }
        }
    }
    class CreateListener5 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {

                String first = view.getpolynomial1();
                Polynomial polynomial1 =new Polynomial();
                Polynomial result;
                polynomial1.StringtoPol(first);
                result=operations.integrative(polynomial1);
                String x="";
                for (Map.Entry<Integer, Double> entry : result.getMap().entrySet()) {
                    if(entry.getKey()==0)
                    {
                        x = Double.toString(entry.getValue())  +x;
                    }
                    else if(entry.getValue()<0)
                    {
                        x = Double.toString(entry.getValue()) + "x^" + Integer.toString(entry.getKey()) +"+" + x;
                    }
                    else
                    {
                        x =  Double.toString(entry.getValue()) + "x^" + Integer.toString(entry.getKey()) +x;
                    }

                }
                view.settextAreaResult(x);
            } catch (Exception ex) {
                view.showMessage("Something went wrong!");
                ex.printStackTrace();
            }
        }
    }
    class CreateListener6 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {

                String first = view.getpolynomial1();
                Polynomial polynomial1 =new Polynomial();
                Polynomial result;
                polynomial1.StringtoPol(first);
                result=operations.derivative(polynomial1);
                String x="";
                for (Map.Entry<Integer, Double> entry : result.getMap().entrySet()) {
                    if(entry.getKey()==0)
                    {
                        x = Double.toString(entry.getValue())  +x;
                    }
                    else if(entry.getValue()<0)
                    {
                        x = Double.toString(entry.getValue()) + "x^" + Integer.toString(entry.getKey()) +"+" + x;
                    }
                    else
                    {
                        x =  Double.toString(entry.getValue()) + "x^" + Integer.toString(entry.getKey()) +x;
                    }
                }
                view.settextAreaResult(x);

            } catch (Exception ex) {
                view.showMessage("Something went wrong!");
                ex.printStackTrace();
            }
        }
    }
}