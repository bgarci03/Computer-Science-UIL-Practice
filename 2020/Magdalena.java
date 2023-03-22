import java.util.Scanner;
import static java.lang.System.out;

public class Magdalena
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
    /* Using logic, the digit with the greatest
     * digit sum is a digit with all of its
     * digit places being maxed out while still
     * being <= the input.
     * 
     * e.g.
     * INPUT: 100 (99 has the greatest digit sum)
     * OUTPUT: 18
     */
    int base = sc.nextInt();
    String value = sc.next();
    sc.nextLine();

    String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    String newDigit = "";

    long sum = 0;
    String digitSum = "";

    if (value.length() == 1)
      newDigit = value;
    else if (value.substring(1, 2).equals(digits.substring(base - 1, base)))
      newDigit = value;
    else if (value.substring(0, 1).equals("1"))
    {
      for (int i = 1; i < value.length(); i++)
      {
        newDigit += digits.substring(base - 1, base);
      }
    }
    else
    {
      newDigit += digits.substring(digits.indexOf(value.substring(0, 1)) - 1, digits.indexOf(value.substring(0, 1)));

      for (int i = 1; i < value.length(); i++)
      {
        newDigit += digits.substring(base - 1, base);
      }
    }

    /* Find the digit sum in decimal by getting
     * the index of digit in newDigit 
     */
    for (int i = 0; i < newDigit.length(); i++)
      sum += digits.indexOf(newDigit.substring(i, i + 1));

    /* Converts the sum into the base that was
     * inputted
     */
    int power = 0;

    while (sum > Math.pow(base, power))
      power++;
    if (power > 0)
      power--;

    long place = (long) Math.pow(base, power);

    while (place >= 1)
    {
      int repeats = 0;

      while (sum >= place)
      {
        repeats++;
        sum -= place;
      }

      digitSum += digits.substring(repeats, repeats + 1);

      place /= base;
    }
    
    output[index] = "Case #" + (index + 1) + ": " + digitSum;
    index++;    
  }

  for (String result : output)
    out.println(result);

  sc.close();
 }
}
