import java.util.*;
public class USACO {
  public int[][] cowstopper(int[][] input, int row, int col, int level) {
    int max = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j ++) {
        if (input[row + i][col + i] > max) {
          max = input[row + i][col + i];
        }
      }
    }
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j ++) {
        if (max - input[row + i][col + i] <= level) {
          input[row + i][col + i] = max - level;
        }
      }
    }
    return input;
  }
  public static int bronze(String filename) {
    int output = 0;
    Scanner s1 = new Scanner(filename);
    int length = (int) s1.nextDouble();
    int width = (int)s1.nextDouble();
    int water = (int)s1.nextDouble();
    int cows = (int)s1.nextDouble();
    int[][] lake = new int[length][width];
    for (int i = 0; i < length; i ++) {
      for (int j = 0; j < width; j++) {
        lake[i][j] = (int) s1.nextDouble();
      }
    }


    return output * 72 * 72;
  }



}
