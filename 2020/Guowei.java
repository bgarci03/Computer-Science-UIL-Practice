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
      /* Using a char array can be used,
       * but performance will be slow,
       * so instead this algorithm is
       * used
       */
      int shift = Integer.parseInt(sc.nextLine());
      String phrase = sc.nextLine() + " ";

      String display = "";

      /* While shift is greater than the 
       * length of what is to be displayed,
       * it'll find the difference between
       * shift and the length of what is to
       * be displayed
       */
      while (shift > phrase.length())
        shift -= phrase.length();

      /* Creates a substring starting from shift
       * and then adds the remaining text. If the
       * remaining characters are missing, it will
       * go back to the beginning
       */
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
