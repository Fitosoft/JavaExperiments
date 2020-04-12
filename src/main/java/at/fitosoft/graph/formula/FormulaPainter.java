package at.fitosoft.graph.formula;

import at.fitosoft.graph.color.ColorSpace;
import at.fitosoft.graph.raster.Raster;
import at.fitosoft.math.Exponents;

public abstract class FormulaPainter {
    private Raster raster;
    private final ColorSpace colorSpace;
    private final int nrOfColors;

    public FormulaPainter(ColorSpace colorspace) {
        this.colorSpace = colorspace;
        nrOfColors = colorSpace.colors().size();
    }

    public FormulaPainter(Raster raster, ColorSpace colorspace) {
        this(colorspace);
        this.raster = raster;
    }

    public void paint() {
        for (double x = raster.getMinX(); x <= raster.getMaxX(); x += raster.getResolution()) {
            for (double y = raster.getMinY(); y <= raster.getMaxY(); y += raster.getResolution()) {
                double z = calculate(x, y);
                draw(x, y, z);
            }
        }
    }

    private void draw(double x, double y, double z) {
        final double sig = Exponents.significant(z);
        final int sigIndex = (int) Math.floor(sig * nrOfColors);
        raster.drawPoint(x, y, colorSpace.getColor(sigIndex));
    }

    public abstract double calculate(double x, double y);

    public void setRaster(Raster raster) {
        this.raster = raster;
    }

}
