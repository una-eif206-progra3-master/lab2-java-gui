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

    // Constant of the project
    static final int WIDTH = 250;
    static final int HEIGHT = 350;
    static final String MSG_NOMBRE_COMPLETO = "Nombre Completo: ";

    // Array of genders
    final String[] genders = {"Masculino", "Femenino", "Otro"};

    // UI Components
    final JTextField firstName = new JTextField(20);
    final JTextField lastName = new JTextField(20);
    final JTextField phone = new JTextField(20);
    final JComboBox<String> gender = new JComboBox<>(genders);
    final JTextArea result = new JTextArea(4, 20);
    final JButton ok = new JButton("OK");
    final JButton clean = new JButton("Clean");
    final JLabel firstNameLabel = new JLabel("Nombre: ");
    final JLabel lastNameLabel = new JLabel("Apellido: ");
    final JLabel fullNameLabel = new JLabel(MSG_NOMBRE_COMPLETO);
    final JLabel phoneLabel = new JLabel("Phone: ");
    final JLabel genderLabel = new JLabel("Gender:                ");
    final JLabel resultLabel = new JLabel("Result: ");

    public Lab2() {
        super("Lab2 General Information");

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout and Panel definition
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
        new Lab2();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if (source == ok) {
            fullNameLabel.setText(MSG_NOMBRE_COMPLETO + firstName.getText() + " " + lastName.getText());
        }
        repaint();
    }
}