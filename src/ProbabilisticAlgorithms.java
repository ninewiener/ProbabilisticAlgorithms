import java.util.Arrays;
import java.util.Random;

public class ProbabilisticAlgorithms {
  private Random rand = new Random();
  private double squareLength = 10;

  public static void main(String[] args) {
    ProbabilisticAlgorithms pa = new ProbabilisticAlgorithms();
    double[][] coords = pa.computePi(10);
    for (double[] coord : coords) {
      System.out.print(Arrays.toString(coord));
      if (pa.isInsideCircle(coord)) System.out.println(" inside");
      else System.out.println(" outside");
    }
  }

  private double[][] computePi(int numberOfPoints) {
    double[][] coords = new double[numberOfPoints][2];
    for (int i = 0; i < numberOfPoints; i++) {
      double x = rand.nextDouble() * squareLength;
      double y = rand.nextDouble() * squareLength;
      coords[i][0] = x;
      coords[i][1] = y;
    }
    return coords;
  }

  private boolean isInsideCircle(double[] coord) {
    double r = squareLength / 2; // circle radius
    double x = coord[0];
    double y = coord[1];
    double x_center = r; // circle center
    double y_center = r;
    double distanceSquare = (x - x_center) * (x - x_center) + (y - y_center) * (y - y_center);
    return distanceSquare < r * r; // returns true if podouble is within circle
  }
}