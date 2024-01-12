import java.awt.geom.Point2D;
import java.util.List;

public class ExampleSquare {

    public static void main(String[] args) {
        
        Point2D.Double testPoint = new Point2D.Double(0.4421937591102556, 101.88766462185495);

        List<Point2D.Double> testPolygon = List.of(
            new Point2D.Double(0.430, 101.881),
            new Point2D.Double(0.451, 101.872),
            new Point2D.Double(0.444, 101.885),
            new Point2D.Double(0.448, 101.896)
        );

        boolean isInside = RayCasting.isPointInsidePolygon(testPoint, testPolygon);
        System.out.println("Is the point inside the polygon? " + isInside);
    }
}
