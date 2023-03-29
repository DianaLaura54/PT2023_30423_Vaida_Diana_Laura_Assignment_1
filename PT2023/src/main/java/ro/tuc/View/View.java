package ro.tuc.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JTextField polynomial1;
    private JTextField polynomial2;
    private JTextArea textAreaResult;
    private  JButton btnAdd;
    private  JButton btnSubstract;
    private JButton btnMultiplication;
    private JButton btnDivision;
    private JButton btnIntegration;
   private JButton btnDerivative;
   private JLabel first;
   private JLabel second;
    public View(){

        this.setResizable(false);
        this.setBounds(100, 100, 917, 698);
        this.getContentPane().setBackground(SystemColor.activeCaption);
        this.getContentPane().setForeground(SystemColor.text);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getContentPane().setLayout(null);

        polynomial1 = new JTextField();
        polynomial1.setFont(new Font("Georgia", Font.PLAIN, 22));
        polynomial1.setBounds(63, 134, 382, 42);
        getContentPane().add(polynomial1);
        polynomial1.setColumns(10);

        polynomial2 = new JTextField();
        polynomial2.setFont(new Font("Georgia", Font.PLAIN, 22));
        polynomial2.setColumns(10);
        polynomial2.setBounds(63, 245, 382, 42);
        getContentPane().add(polynomial2);

        textAreaResult = new JTextArea();
        textAreaResult.setFont(new Font("Georgia", Font.PLAIN, 22));
        textAreaResult.setBounds(46, 421, 650, 117);
        getContentPane().add(textAreaResult);

        btnAdd = new JButton("add");
        btnAdd.setFont(new Font("Georgia", Font.PLAIN, 15));
        btnAdd.setBounds(581, 97, 138, 27);
        getContentPane().add(btnAdd);

        btnSubstract = new JButton("substract");
        btnSubstract.setFont(new Font("Georgia", Font.PLAIN, 15));
        btnSubstract.setBounds(581, 145, 138, 27);
        getContentPane().add(btnSubstract);

        btnMultiplication = new JButton("multiplication");
        btnMultiplication.setFont(new Font("Georgia", Font.PLAIN, 15));
        btnMultiplication.setBounds(581, 186, 138, 27);
        getContentPane().add(btnMultiplication);

        btnDivision = new JButton("division");
        btnDivision.setFont(new Font("Georgia", Font.PLAIN, 15));
        btnDivision.setBounds(581, 233, 138, 27);
        getContentPane().add(btnDivision);

         btnIntegration = new JButton("integration");
        btnIntegration.setFont(new Font("Georgia", Font.PLAIN, 15));
        btnIntegration.setBounds(581, 280, 138, 27);
        getContentPane().add(btnIntegration);

        btnDerivative = new JButton("derivative");
        btnDerivative.setFont(new Font("Georgia", Font.PLAIN, 15));
        btnDerivative.setBounds(581, 324, 138, 27);
        getContentPane().add(btnDerivative);

        first = new JLabel("First polynomial");
        first.setFont(new Font("Georgia", Font.PLAIN, 30));
        first.setBounds(81, 63, 287, 42);
        getContentPane().add(first);

         second = new JLabel("Second polynomial");
        second.setFont(new Font("Georgia", Font.PLAIN, 30));
        second.setBounds(81, 186, 287, 42);
        getContentPane().add(second);
        this.setVisible(true);

}
    public String getpolynomial1() {
        return polynomial1.getText();
    }

    public void setpolynomial1(String polynomial1) {
        this.polynomial1.setText(polynomial1);
    }
    public String getpolynomial2() {
        return polynomial2.getText();
    }

    public void setpolynomial2(String polynomial2) {
        this.polynomial2.setText(polynomial2);
    }

    public String gettextAreaResult() {
        return textAreaResult.getText();
    }

    public void settextAreaResult(String textAreaResult) {
        this.textAreaResult.setText(textAreaResult);
    }
    public void addCreateListener(ActionListener action)
    {
        btnAdd.addActionListener(action);
    }
    public void addCreateListener2(ActionListener action)
    {
        btnSubstract.addActionListener(action);
    }
    public void addCreateListener3(ActionListener action)
    {
        btnMultiplication.addActionListener(action);
    }
    public void addCreateListener4(ActionListener action)
    {
        btnDivision.addActionListener(action);
    }
    public void addCreateListener5(ActionListener action)
    {
        btnIntegration.addActionListener(action);
    }
    public void addCreateListener6(ActionListener action)
    {
        btnDerivative.addActionListener(action);
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

}
