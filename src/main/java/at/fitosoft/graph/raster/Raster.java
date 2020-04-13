package at.fitosoft.graph.raster;

import at.fitosoft.graph.color.ColorSpace;
import at.fitosoft.graph.color.ColorTransition;
import com.sun.istack.internal.NotNull;
import org.apache.log4j.Logger;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Arrays;

public class Raster {
    private static final Logger LOG = Logger.getLogger(Raster.class);

    private final Double minX;
    private final Double minY;
    private final Double maxX;
    private final Double maxY;
    private final Double resolution;
    private final Graphics2D g;
    private final Double width;
    private final Double height;

    public Raster(@NotNull Double minX, @NotNull Double minY,
                  @NotNull Double maxX, @NotNull Double maxY,
                  @NotNull Double resolution, @NotNull Graphics2D g) {

        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
        this.width = maxX - minX;
        this.height = maxY - minY;
        this.resolution = resolution;
        this.g = g;

        init();

        LOG.info("Raster set up!");
    }

    private void init() {
        Rectangle windowBounds = g.getDeviceConfiguration().getBounds();

        LOG.debug(windowBounds);
        LOG.debug(width);
        LOG.debug(height);
        double scaleX = windowBounds.width / width;
        double scaleY = -windowBounds.height / height;
        AffineTransform transform =
                new AffineTransform(scaleX, 0., 0, scaleY, -minX * scaleX, -maxY * scaleY);
        LOG.debug(transform);
        g.setTransform(transform);

//        drawDemoRectangle();
//        drawDemoSinus();
//        drawScales(Color.BLACK);
    }

    public void drawDemoTrigonometry() {
        ColorSpace transition = new ColorSpace(Arrays.asList(
                Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.RED),
                10);

        int step = 0;
        for (double x = minX; x <= maxX; x += resolution) {
            double y = Math.sin(x);
            drawPoint(x, y, transition.getColor(step));
            step++;
        }

        step = 0;
        for (double x = minX; x <= maxX; x += resolution) {
            double y = Math.cos(x);
            drawPoint(x, y, transition.getColor(step));
            step++;
        }

        step = 0;
        for (double x = minX; x <= maxX; x += resolution / 2) {
            double y = Math.tan(x);
            drawPoint(x, y, transition.getColor(step));
            step++;
        }
    }

    public void drawScales(Color color) {
        g.setStroke(new BasicStroke(resolution.floatValue() / 4));
        g.setColor(color);
        g.draw(new Line2D.Double(0., minY, 0., maxY));
        g.draw(new Line2D.Double(minX, 0., maxX, 0.));
    }

    public void drawDemoRectangle() {
        g.setStroke(new BasicStroke(resolution.floatValue()));
        g.setColor(Color.RED);
        g.draw(new Rectangle2D.Double(minX, minY, width, height));
        g.setColor(Color.GREEN);
        g.draw(new Rectangle2D.Double(minX + resolution * 20, minY + resolution * 20, width - resolution * 40, height - resolution * 40));
    }

    public void drawPoint(Double x, Double y, Color color) {
        g.setStroke(new BasicStroke(resolution.floatValue()));
        g.setColor(color);
        g.fill(new Rectangle2D.Double(x - resolution / 2, y - resolution / 2, resolution, resolution));
    }

    public Double getMinX() {
        return minX;
    }

    public Double getMinY() {
        return minY;
    }

    public Double getMaxX() {
        return maxX;
    }

    public Double getMaxY() {
        return maxY;
    }

    public Double getResolution() {
        return resolution;
    }

    public Double getWidth() {
        return width;
    }

    public Double getHeight() {
        return height;
    }
}
