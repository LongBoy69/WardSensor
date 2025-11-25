import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main {
    public static void main(String[] args) {
        EnvironmentalSystem system = new EnvironmentalSystem();

        JFrame frame = new JFrame("Ward Sensors");
        frame.setLayout(new GridLayout(4, 1));
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null); // center on screen
        frame.setVisible(true);
        JLabel nWard =new JLabel("Empty");
        JLabel cWard =new JLabel("Empty");
        JLabel sWard =new JLabel("Empty");

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ward0 = Math.round(system.getTempFeed().getTemp(0)) + "°C";
                String ward1 = Math.round(system.getTempFeed().getTemp(1)) + "°C";
                String ward2 = Math.round(system.getTempFeed().getTemp(2)) + "°C";

                //boolean heaterW1 = system.isHeatingOn(0);

                frame.add(nWard);
                frame.add(cWard);
                frame.add(sWard);

                nWard.setText("North Ward- Current Temperature: " + ward0 + " | Ideal Temperature: 23°");
                cWard.setText("Central Ward- Current Temperature: " + ward1 + " | Ideal Temperature: 22°");
                sWard.setText("South Ward- Current Temperature: " + ward2 + " | Ideal Temperature: 20°");

                frame.repaint();
            }
        });
        timer.start();

    }
}

