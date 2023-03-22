import java.util.Scanner;
import static java.lang.System.out;

public class Wojtek
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);

    int cases = sc.nextInt();
    int caseNum = 1;
    sc.nextLine();

    while (cases-- > 0)
    {
      /* Gets the numbers from the terminal
       * and stores it in an array
       */
      int[] nums = {sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
      sc.nextLine();

      /* Finds the amount of steps by computing
       * the sum of a pair and replacing a value
       * in the array
       */
      int steps = 0;
      while (sumNotZero(nums))
      {
        int index0 = nums[0];
        for (int i = 0; i < nums.length; i++)
        {
          if (i >= nums.length - 1)
            nums[i] = Math.abs(nums[i] - index0);
          else
            nums[i] = Math.abs(nums[i] - nums[i + 1]);
        }

        steps++;
      }

      out.println("Case #" + caseNum + ": " + steps);
      caseNum++;
    }
  }

  /***
   * If the sum of an integer is not 0, returns true,
   * but if it does equal 0, returns false
   * @param array is an integer array
   * @return true if sum is not zero, otherwise false
   */
  static boolean sumNotZero(int[] array)
  {
    int sum = 0;
    for (int num : array)
      sum += num;

    return sum != 0;
  }
}
