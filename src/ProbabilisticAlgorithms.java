import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ProbabilisticAlgorithms {
  private Random rand = new Random();
  private int squareLength = 10;

  public static void main(String[] args) {
    ProbabilisticAlgorithms pa = new ProbabilisticAlgorithms();
    int[][] coords = pa.computePi(10);
    for (int[] coord : coords) {
      System.out.println(Arrays.toString(coord));
    }
  }

  private int[][] computePi(int numberOfPoints) {
    int[][] coords = new int[numberOfPoints][2];
    for (int i = 0; i < numberOfPoints; i++) {
      int x = rand.nextInt(squareLength);
      int y = rand.nextInt(squareLength);
      coords[i][0] = x;
      coords[i][1] = y;
    }
    return coords;
  }
}