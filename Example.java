import java.awt.geom.Point2D;
import java.util.List;

public class Example {

    public static void main(String[] args) {
        
        Point2D.Double testPoint = new Point2D.Double(0.439480686923888, 101.89079447127064);

        List<Point2D.Double> testPolygon = List.of(
            new Point2D.Double(0.452, 101.873),
            new Point2D.Double(0.439,101.867),
            new Point2D.Double(0.429, 101.901),
            new Point2D.Double(0.443, 101.905)
        );

        boolean isInside = RayCasting.isPointInsidePolygon(testPoint, testPolygon);
        System.out.println("Is the point inside the polygon? " + isInside);
    }
}
