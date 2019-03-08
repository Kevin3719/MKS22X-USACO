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
  public static int[][] update(int[][] input) {
    int[][] output = new int[input.length][input[0].length];
    for (int i = 0; i < input.length; i ++) {
      for (int j = 0; j < input[0].length; j++) {
        if (input[i][j] != -1) {
        if (j - 1 >= 0 && input[i][j - 1] != -1){
          output[i][j] += input[i][j - 1];
        }
        if (i - 1 >= 0 && input[i - 1][j] != -1){
          output[i][j] += input[i - 1][j];
        }
        if (i + 1 < input.length && input[i + 1][j] != -1){
          output[i][j] += input[i + 1][j];
        }
        if ( j + 1 < input[0].length && input[i][j + 1] != -1){
          output[i][j] += input[i][j + 1];
        }
      }
      else {
        output[i][j] = -1;
      }
      }
    }
    return output;
  }
  public static int silver(String filename) throws FileNotFoundException {
    int output = 0;
    Scanner s1 = new Scanner(new File(filename));
    int length =  s1.nextInt();
    int width = s1.nextInt();
    int moves = s1.nextInt();
    int[][] pasture = new int[length][width];
    int[][] temporary = new int[length][width];
    String temp = "";
    for (int i = 0; i < length; i ++) {
      temp = s1.next();
      for (int j = 0; j < width; j++) {
        if(temp.charAt(j) == '.') {
          pasture[i][j] = 0;
        }
        if(temp.charAt(j) == '*') {
          pasture[i][j] = -1;
        }
      }
    }
    int startingrow = s1.nextInt();
    int startingcol = s1.nextInt();
    int endingrow = s1.nextInt();
    int endingcol = s1.nextInt();
    pasture[startingrow - 1][startingcol - 1] = 1;
    for(int k = 0; k < moves; k++) {
      pasture = update(pasture);
    }
    return pasture[endingrow - 1][endingcol - 1];

  }
}
