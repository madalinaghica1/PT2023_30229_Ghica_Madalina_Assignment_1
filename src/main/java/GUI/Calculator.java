package GUI;

import Business_Logic.Operations;
import Data_Models.Polynomial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    private JPanel inputPanel;
    private JPanel buttonPanel;
    private JPanel resultPanel;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton derivButton;
    private JButton integrareButton;
    private JButton divisonButton;
    private JTextField inputFieldA;
    private JTextField inputFieldB;
    private JTextField resultField;

    private Operations operatii;

    public Calculator() {
        super("Calculator");

        operatii = new Operations();

        // Crearea panoului de intrare
        inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Polinom 1: "));
        inputFieldA = new JTextField(30);
        inputPanel.add(inputFieldA);
        inputPanel.add(new JLabel("Polinom 2: "));
        inputFieldB = new JTextField(30);
        inputPanel.add(inputFieldB);

        // Crearea panoului de butoane
       buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2));

        addButton = new JButton("Adunare");
        subtractButton = new JButton("Scadere");
        multiplyButton = new JButton("Inmultire");
        derivButton = new JButton("Derivare");
        integrareButton = new JButton("Integrare");
        divisonButton = new JButton("Impartire");
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divisonButton);
        buttonPanel.add(derivButton);
        buttonPanel.add(integrareButton);
        addButton.setBackground(Color.magenta);
        subtractButton.setBackground(Color.pink);
        multiplyButton.setBackground(Color.magenta);
        derivButton.setBackground(Color.magenta);
        divisonButton.setBackground(Color.pink);
        integrareButton.setBackground(Color.pink);
        // Crearea panoului de rezultat
        resultPanel = new JPanel(new FlowLayout());
        resultPanel.add(new JLabel("Rezultat: "));
        resultField = new JTextField(30);
        resultField.setEditable(false);
        resultPanel.add(resultField);


        // Adaugarea listenerului de evenimente la butonul de calculare
        integrareButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String a = inputFieldA.getText();
                String b = inputFieldB.getText();
                Polynomial p1=Operations.verifP(a);
                Polynomial p2=Operations.verifP(b);
                Polynomial result = operatii.integrareP(p1);
                resultField.setText(result.toString()+"+c");
            }
        });

        // Adaugarea listenerilor de evenimente la butoanele de operatii
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String a = inputFieldA.getText();
                String b = inputFieldB.getText();
                Polynomial p1=Operations.verifP(a);
                Polynomial p2=Operations.verifP(b);
                Polynomial result = operatii.addP(p1, p2);
                resultField.setText(result.toString());
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String a = inputFieldA.getText();
                String b = inputFieldB.getText();
                Polynomial p1=Operations.verifP(a);
                Polynomial p2=Operations.verifP(b);
                Polynomial result = operatii.subP(p1, p2);
                resultField.setText(result.toString());
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String a = inputFieldA.getText();
                String b = inputFieldB.getText();
                Polynomial p1 = Operations.verifP(a);
                Polynomial p2 = Operations.verifP(b);
                Polynomial result = operatii.multP(p1, p2);
                resultField.setText(result.toString());
            }
        });

        derivButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String a = inputFieldA.getText();
                String b = inputFieldB.getText();
                Polynomial p1=Operations.verifP(a);
                Polynomial p2=Operations.verifP(b);
                Polynomial result = operatii.derivP(p1);
                resultField.setText(result.toString());
            }
        });

        // Adaugarea componentelor la fereastra principala
        this.setLayout(new BorderLayout());
        this.add(inputPanel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);
        this.add(resultPanel, BorderLayout.SOUTH);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setVisible(true);
    }
}