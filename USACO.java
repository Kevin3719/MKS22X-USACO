import java.util.*;
import java.io.*;
public class USACO {
  public static int[][] cowstopper(int[][] input, int row, int col, int level) {
    int max = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j ++) {
        if (input[row + i][col + j] > max) {
          max = input[row + i][col + j];
        }
      }
    }
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j ++) {
        if (max - input[row + i][col + j] <= level) {
          input[row + i][col + j] = max - level;
        }
      }
    }
    return input;
  }
  public static int bronze(String filename) throws FileNotFoundException {
    int output = 0;
    Scanner s1 = new Scanner(new File(filename));
    int length = s1.nextInt();
    int width = s1.nextInt();
    int water = s1.nextInt();
    int cows = s1.nextInt();
    int[][] lake = new int[length][width];
    for (int i = 0; i < length; i ++) {
      for (int j = 0; j < width; j++) {
        lake[i][j] = s1.nextInt();
      }
    }
    for (int i = 0; i < cows; i++) {
      cowstopper(lake,s1.nextInt() - 1, s1.nextInt() - 1,s1.nextInt());
    }
  for (int i = 0; i < length; i ++) {
    for (int j = 0; j < width; j++) {
      if (lake[i][j] < water) {
        output += water - lake[i][j];
      }
    }
  }
    return output * 72 * 72;
  }



}
