package at.fitosoft.graph;

import at.fitosoft.graph.color.ColorSpace;
import at.fitosoft.graph.formula.FormulaPainter;
import at.fitosoft.graph.raster.Raster;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class FormulaGradients extends JComponent {
    private static final Logger LOG = Logger.getLogger(FormulaGradients.class);

    @Override
    public void paint(Graphics g) {
         crazyCircles1((Graphics2D) g);
//        crazyCircles2((Graphics2D) g);
//         crazyCircles3((Graphics2D) g);
//         crazyCircles4((Graphics2D) g);
    }

    private void crazyCircles1(Graphics2D g2) {

        ColorSpace colorSpace = new ColorSpace(Arrays.asList(
                Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.RED),
                40);

        drawFormula(new FormulaPainter(colorSpace) {
                        public double calculate(double x, double y) {
                            return Math.sin(x) * Math.cos(y) * Math.cos(y);
                        }
                    },
                -4.0,
                -2.,
                4.,
                2.,
                0.001,
                g2);
    }

    private void crazyCircles2(Graphics2D g2) {

        ColorSpace colorSpace = new ColorSpace(Arrays.asList(
                Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.RED),
                80);

        drawFormula(new FormulaPainter(colorSpace) {
                        public double calculate(double x, double y) {
                            return Math.log10(Math.sin(x) + 1) * Math.cos(Math.tan(y * y));
                        }
                    },
                -0.3,
                0.95,
                0.3,
                1.05,
                0.0001,
                g2);
    }

    private void crazyCircles3(Graphics2D g2) {

        ColorSpace colorSpace = new ColorSpace(Arrays.asList(
                Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.RED),
                80);

        drawFormula(new FormulaPainter(colorSpace) {
                        public double calculate(double x, double y) {
                            return Math.sin(x) + Math.sin(y);
                        }
                    },
                -6.0,
                -3.,
                6.,
                3.,
                0.003,
                g2);
    }

    private void crazyCircles4(Graphics2D g2) {

        ColorSpace colorSpace = new ColorSpace(Arrays.asList(
                Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.RED),
                80);

        drawFormula(new FormulaPainter(colorSpace) {
                        public double calculate(double x, double y) {
                            return Math.atan(Math.sin(x) * x) * Math.atan(Math.cos(y * y) * y);
                        }
                    },
                -20.0,
                -9.,
                20.,
                9.,
                0.005,
                g2);
    }

    private void drawFormula(FormulaPainter formulaPainter,
                             double minX,
                             double minY,
                             double maxX,
                             double maxY,
                             double resolution,
                             Graphics2D g2) {
        Raster raster = new Raster(minX, minY, maxX, maxY, resolution, g2);

        formulaPainter.setRaster(raster);
        formulaPainter.paint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Main Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FormulaGradients mainWindow = new FormulaGradients();
        frame.getContentPane().add(mainWindow);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}
