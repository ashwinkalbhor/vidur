package image.control;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logic.events.ProcessImageEvent;


public class CalculateControl extends JPanel {
    private static final long serialVersionUID = 2636247746338890880L;
    private JTextField        count;
    private JButton           process;

    public CalculateControl(ImageHandler imageHandler) {

        setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.setLayout(new GridLayout(2, 1));
        count = new JTextField("Count");
        count.setBounds(100, 30, 350, 40);
        process = new JButton("Process");
        process.setBounds(10, 30, 80, 40);

        ProcessImageEvent processImageEvent =
        new ProcessImageEvent(imageHandler, count);

        process.addMouseListener(processImageEvent);
        add(process);
        add(count);
    }
}
