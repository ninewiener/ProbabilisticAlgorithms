import java.util.Arrays;
import java.util.Random;

public class ProbabilisticAlgorithms {
  private Random rand = new Random();
  private double squareLength = 10;
  private static final int totalPoints = 100000;

  public static void main(String[] args) {
    ProbabilisticAlgorithms pa = new ProbabilisticAlgorithms();
    double[][] coords = pa.generateRandomPoints(totalPoints);
    int counter = 0;
    for (double[] coord : coords) {
      System.out.print(Arrays.toString(coord));
      if (pa.isInsideCircle(coord)) {
        System.out.println(" inside");
        counter++;
      } else System.out.println(" outside");
    }
    System.out.println(pa.approximatePi(counter));
  }

  private double approximatePi(int counter) {
    System.out.println(counter + " / " + totalPoints);
    return (double) counter * 4 / totalPoints;
  }

  private double[][] generateRandomPoints(int numberOfPoints) {
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