import java.util.Scanner;
import static java.lang.System.out;

public class Guowei
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);

    int cases = Integer.parseInt(sc.nextLine());

    String[] output = new String[cases];

    int index = 0;

    // MAIN CODE BEGINS HERE
    for (int i = 0; i < cases; i++)
    {
      /**
       * Using a char array can be used,
       * but perfotmance will be slow,
       * so instead this algorithm is
       * used
       */
      int shift = Integer.parseInt(sc.nextLine());
      String phrase = sc.nextLine() + " ";

      String display = "";

      while (shift > phrase.length())
        shift -= phrase.length();

      display = phrase.substring(shift);

      if (display.length() < 40)
      {
        int end = 40 - display.length();
        display += phrase.substring(0, end);
      }
      else
        display = display.substring(0, 40);

      output[index] = display;
      index++;
    }

    for (String result : output)
      out.println(result);

    sc.close();
  }
}
