import java.awt.Point;
import java.util.List;

import javax.swing.SwingUtilities;

public class RayCasting {

    public static void main(String[] args) {
        
        Point testPoint = new Point(50, 50);
        boolean drawResult = true;

        List<Point> polygon = List.of(
            new Point(50, 50),
            new Point(50, 150),
            new Point(150, 200),
            new Point(250, 150),
            new Point(250, 50)
    );

        boolean isInside = isPointInsidePolygon(testPoint, polygon);
        System.out.println("Is the point inside the polygon? " + isInside);

        if (drawResult){
            SwingUtilities.invokeLater(() -> new RayCastingVisualization(polygon, testPoint));
        }
    }

    public static boolean isPointInsidePolygon(Point point, List<Point> polygon) {
        int intersections = 0;
        int numVertices = polygon.size();

        for (int i = 0; i < numVertices; i++) {
            Point vertex1 = polygon.get(i);
            Point vertex2 = polygon.get((i + 1) % numVertices);

            if (rayIntersectsSegment(point, vertex1, vertex2)) {
                intersections++;
            }
        }

        // Inside if the number of intersections is odd
        return intersections % 2 == 1;
    }

    private static boolean rayIntersectsSegment(Point point, Point vertex1, Point vertex2) {
        double x = point.getX();
        double y = point.getY();
        double x1 = vertex1.getX();
        double y1 = vertex1.getY();
        double x2 = vertex2.getX();
        double y2 = vertex2.getY();

        // Check if the point is within the y-bounds of the segment
        if ((y1 <= y && y < y2) || (y2 <= y && y < y1)) {
            
            // Calculate the x-coordinate of the intersection point
            double xIntersection = (y - y1) / (y2 - y1) * (x2 - x1) + x1;

            // Count the intersection if the x-coordinate is greater than the test point's x-coordinate
            if (x < xIntersection) {
                return true;
            }
        }

        return false;
    }
}
