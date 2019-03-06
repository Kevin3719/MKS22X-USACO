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





    return output * 72 * 72;
  }



}
