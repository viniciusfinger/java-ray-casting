import java.awt.geom.Point2D;
import java.util.List;

public class Example {

    public static void main(String[] args) {
        
        Point2D.Double testPoint = new Point2D.Double(-74.005974, 40.712776);

        List<Point2D.Double> testPolygon = List.of(
            new Point2D.Double(-74.006, 40.71),
            new Point2D.Double(-74.006, 40.72),
            new Point2D.Double(-74.002, 40.725),
            new Point2D.Double(-73.997, 40.722),
            new Point2D.Double(-73.994, 40.717)
        );

        boolean isInside = RayCasting.isPointInsidePolygon(testPoint, testPolygon);
        System.out.println("Is the point inside the polygon? " + isInside);
    }
}
