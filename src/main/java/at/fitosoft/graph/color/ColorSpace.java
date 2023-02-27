package at.fitosoft.graph.color;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Creates a color space that consists of several colors and transitions in between.
 */
public class ColorSpace {
    private static final Logger LOG = LogManager.getLogger(ColorSpace.class);

    private final List<Color> colors;

    public ColorSpace(List<Color> sourceColors, int stepsPerColor) {
        colors = new ArrayList<>();

        Color previousColor = sourceColors.get(0);
        colors.add(previousColor);

        for (Color color : sourceColors.subList(1, sourceColors.size())) {
            ColorTransition transition = new ColorTransition(previousColor, color, stepsPerColor);
            colors.addAll(transition.colors().subList(1, transition.colors().size()));
            previousColor = color;
        }

        LOG.info("Number of source colors: " + sourceColors.size());
        LOG.info("Steps per color: " + stepsPerColor);
        LOG.info("Size of color list: " + colors.size());
    }

    public Color getColor(int index) {
        return colors.get(index % colors.size());
    }

    public List<Color> colors() {
        return new ArrayList<>(colors);
    }
}
