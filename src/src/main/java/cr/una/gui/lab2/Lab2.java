package cr.una.gui.lab2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author mguzmana
 */
public class Lab2 extends JFrame implements ActionListener {

    String[] genders = {"Masculino", "Femenino", "Otro"};

    JTextField firstName = new JTextField(20);
    JTextField lastName = new JTextField(20);
    JTextField phone = new JTextField(20);
    JComboBox gender = new JComboBox(genders);
    JTextArea result = new JTextArea(4, 20);
    JButton ok = new JButton("OK");
    JButton clean = new JButton("Clean");
    JLabel firstNameLabel = new JLabel("Nombre: ");
    JLabel lastNameLabel = new JLabel("Apellido: ");
    JLabel fullNameLabel = new JLabel("Nombre Completo: ");
    JLabel phoneLabel = new JLabel("Phone: ");
    JLabel genderLabel = new JLabel("Gender:                ");
    JLabel resultLabel = new JLabel("Result: ");

    public Lab2() {
        super("Lab2 Information");
        setSize(250, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FlowLayout lm = new FlowLayout(FlowLayout.LEFT);

        JPanel panel = new JPanel();

        //set the name to components
        panel.setName("Form");
        firstNameLabel.setName("lblFirstName");
        lastNameLabel.setName("lblLastName");
        fullNameLabel.setName("lblFullName");
        phoneLabel.setName("lblPhone");
        genderLabel.setName("lblGender");
        resultLabel.setName("lblResult");

        firstName.setName("firstName");
        lastName.setName("lastName");

        phone.setName("phone");
        gender.setName("gender");
        result.setName("comments");
        ok.setName("ok");
        clean.setName("clean");

        result.setLineWrap(true);
        result.setWrapStyleWord(true);
        result.setEnabled(false);

        panel.setName("Form");
        panel.setLayout(lm);
        panel.add(firstNameLabel);
        panel.add(firstName);
        panel.add(lastNameLabel);
        panel.add(lastName);
        panel.add(fullNameLabel);
        panel.add(phoneLabel);
        panel.add(phone);
        panel.add(genderLabel);
        panel.add(gender);
        panel.add(resultLabel);
        panel.add(result);
        panel.add(ok);
        panel.add(clean);

        ok.addActionListener(this);

        add(panel);
        setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static void main(String[] arguments) {
        Lab2.setLookAndFeel();
        Lab2 lab2 = new Lab2();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if (source == ok) {
            fullNameLabel.setText("Nombre Completo: " + firstName.getText() + " " + lastName.getText());
        }
        repaint();
    }
}