package at.fitosoft.graph;

import at.fitosoft.graph.raster.Raster;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class DemoScreen extends JComponent {
    private static final Logger LOG = Logger.getLogger(DemoScreen.class);

    private Raster raster;

    @Override
    public void paint(Graphics g) {
        // Draw a simple line using the Graphics2D draw() method.
        Graphics2D g2 = (Graphics2D) g;

        LOG.debug(g2.getTransform());
        LOG.debug(g2.getDeviceConfiguration().getBounds());

        raster = new Raster(-8.0, -1.15, 8., 1.04, 0.03, g2);

        raster.drawScales(Color.BLACK);
        raster.drawDemoTrigonometry();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Main Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DemoScreen mainWindow = new DemoScreen();
        frame.getContentPane().add(mainWindow);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}
