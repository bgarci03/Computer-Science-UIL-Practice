import java.util.Scanner;
import static java.lang.System.out;

public class Kenneth 
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);

    int cases = sc.nextInt();
    sc.nextLine();

    String[] output = new String[cases];
    int index = 0;

    while (cases-- > 0)
    {
      /* Creates the sudoku board as a
       * integer 2D array
       */
      int[][] board = new int[9][9];

      for (int i = 0; i < board.length; i++)
      {
        String[] row = sc.nextLine().split(" ");

        for (int j = 0; j < row.length; j++)
        {
          board[i][j] = Integer.parseInt(row[j]);
        }
      }

      /* Traverses the array in row-major order
       * to check if the number in a certain spot
       * is in the correct position through row-major
       * order, column-major
       */
      int[] rowErrors = new int[board.length];
      int[] colErrors = new int[board[0].length];

      for (int row = 0; row < board.length; row++)
      {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int col = 0; col < board[0].length; col++)
          nums[board[row][col] - 1] = 0;
        
        if (sumNotZero(nums))
          rowErrors[row] = row + 1;
      }

      for (int col = 0; col < board[0].length; col++)
      {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int row = 0; row < board.length; row++)
          nums[board[row][col] - 1] = 0;
        
        if (sumNotZero(nums))
          colErrors[col] = col + 1;
      }

      boolean notSolution = false;

      if (sumNotZero(rowErrors) || sumNotZero(colErrors))
        notSolution = true;

      String out = "GRID #" + (index + 1) + ": ";
      
      if (notSolution)
      {
        out += " NOT A SOLUTION\n>> ROWS WITH ERRORS: ";

        if (sumNotZero(rowErrors))
        {
          for (int row : rowErrors)
            if (row > 0)
              out += row + " ";
        }
        else
          out += "NONE";
        
        out += "\n>> COLUMNS WITH ERRORS: ";

        if (sumNotZero(colErrors))
        {
          for (int col : colErrors)
            if (col > 0)
              out += col + " ";
        }
        else
          out += "NONE";
        out += "\n";
      }
      else
        out += "SOLUTION IS CORRECT\n";
      out += "============";

      output[index] = out;
      index++;
    }

    for (String result : output)
      out.println(result);

    sc.close();
  }

  static boolean sumNotZero(int[] array)
  {
    int sum = 0;

    for (int num : array)
      sum += num;

    if (sum > 0)
      return true;
    return false;
  }
}
