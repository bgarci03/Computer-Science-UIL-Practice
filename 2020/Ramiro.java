import java.util.Scanner;
import static java.lang.System.out;


public class Ramiro
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);

    int cases = sc.nextInt();
    sc.nextLine();

    int[] output = new int[cases];
    int i = 0;

    while (cases-- > 0)
    {
      /* Gets the hexadecimal string from the
       * input
       */
      String val1 = sc.next();
      String val2 = sc.next();
      sc.nextLine();

      /* Converts the hexadecimal string into
       * a binary string
       */
      String bin1 = hexaToBin(val1);
      String bin2 = hexaToBin(val2);

      int differences = 0;

      for (int index = 0; index < bin1.length(); index++)
        if (!bin1.substring(index, index + 1).equals(bin2.substring(index, index + 1)))
          differences++;
      
      output[i] = differences;
      i++;
    }

    for (int result : output)
      out.println(result);

    sc.close();
  }

  static String hexaToBin(String hexa)
  {
    String digits = "0123456789ABCDEF";
    String binary = "";
    
    long decimal = 0;

    for (int i = 0, power = hexa.length() - 1; i < hexa.length(); i++, power--)
      decimal += digits.indexOf(hexa.substring(i, i + 1)) * Math.pow(16, power);

    int power = 0;

    while (decimal > (long) Math.pow(2, power))
      power++;
    if (power > 0)
      power--;
    
    long place = (long) Math.pow(2, power);

    while (place >= 1)
    {
      int repeats = 0;

      while (decimal >= place)
      {
        repeats++;
        decimal -= place;
      }
      binary += digits.substring(repeats, repeats + 1);

      place /= 2;
    }

    while (binary.length() < 32)
      binary = "0" + binary;

    return binary;

  }
}
