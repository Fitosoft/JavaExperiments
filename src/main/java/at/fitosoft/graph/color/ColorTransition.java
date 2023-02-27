package at.fitosoft.graph.color;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Creates color transitions between two colors.
 */
public class ColorTransition {
    private static final Logger LOG = LogManager.getLogger(ColorTransition.class);

    private final List<Color> colors;

    /**
     * Creates a color transition between the given colors creating the specified amount of steps in between.
     *
     * @param start start color
     * @param end end color
     * @param steps number of sample steps in between
     */
    public ColorTransition(Color start, Color end, int steps) {
        double doubleSteps = steps + 1;

        colors = new ArrayList<>();

        double startRed = start.getRed();
        double startGreen = start.getGreen();
        double startBlue = start.getBlue();

        double endRed = end.getRed();
        double endGreen = end.getGreen();
        double endBlue = end.getBlue();

        double stepRed = (endRed - startRed) / doubleSteps;
        double stepGreen = (endGreen - startGreen) / doubleSteps;
        double stepBlue = (endBlue - startBlue) / doubleSteps;

        colors.add(start);

        double currentRed = startRed;
        double currentGreen = startGreen;
        double currentBlue = startBlue;

        for (int i = 1; i <= steps + 1; i++) {
            currentRed += stepRed;
            currentGreen += stepGreen;
            currentBlue += stepBlue;

            LOG.debug("currentRed = " + currentRed);
            LOG.debug("currentGreen = " + currentGreen);
            LOG.debug("currentBlue = " + currentBlue);
            colors.add(new Color((int) Math.round(currentRed), (int) Math.round(currentGreen), (int) Math.round(currentBlue)));
        }
    }

    public Color getColor(int index) {
        return colors.get(index % colors.size());
    }

    public List<Color> colors() {
        return new ArrayList<>(colors);
    }
}
