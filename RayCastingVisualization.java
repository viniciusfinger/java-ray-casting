import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RayCastingVisualization extends JFrame {

    private List<Point> polygon;
    private Point testPoint;

    public RayCastingVisualization(List<Point> polygon, Point testPoint) {
        this.polygon = polygon;
        this.testPoint = testPoint;

        setTitle("Ray Casting Visualization");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        
        graphics.setColor(Color.BLUE);

        int[] xPoints = new int[polygon.size()];
        int[] yPoints = new int[polygon.size()];
        
        for (int i = 0; i < polygon.size(); i++) {
            xPoints[i] = polygon.get(i).x;
            yPoints[i] = polygon.get(i).y;
        }

        int numVertices = polygon.size();

        graphics.drawPolygon(xPoints, yPoints, numVertices);

        graphics.setColor(Color.RED);
        graphics.fillOval(testPoint.x - 3, testPoint.y - 3, 6, 6);
    }

    public static void main(String[] args) {
        
        List<Point> polygon = List.of(
                new Point(50, 50),
                new Point(50, 150),
                new Point(150, 200),
                new Point(150, 210),
                new Point(250, 150),
                new Point(250, 50),
                new Point(150, 100)
        );

        Point testPoint = new Point(150, 150);

        SwingUtilities.invokeLater(() -> new RayCastingVisualization(polygon, testPoint));
    }
}
