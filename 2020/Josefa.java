import java.util.Scanner;
import static java.lang.System.out;

public class Josefa
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);

    int cases = sc.nextInt();
    sc.nextLine();

    String[] output = new String[cases];
    int index = 0;

    // MAIN CODE BEGINS HERE
    while (cases-- > 0)
    {
      int num = sc.nextInt();
      int copy = num;
      sc.nextLine();

      int[] binary = {0, 0, 0, 0, 0, 0, 0, 0};

      /* If the number is negative it adds 128
       * because in two's complement, the negative bit
       * is the first bit, so -128. This will give us
       * what the number is without two's complement
       */
      if (Math.abs(num) != num)
      {
        num += 128;
        binary[0] = 1;
      }

      int value = 64;
      for (int i = 1; i < binary.length; i++)
      {
        if (num >= value)
        {
          binary[i] = 1;
          num -= value;
        }

        value /= 2;
      }

      String toPrint = copy + " = ";
      for (int bin : binary)
        toPrint += bin;
      
      output[index] = toPrint;
      index++;
    }

    for (String result : output)
      out.println(result);
    
    sc.close();
  }
}
