import java.util.Scanner;
import static java.lang.System.out;

public class Emmanuel
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
      String input = sc.nextLine();
      String[] array = input.substring(1, input.indexOf("}")).split(",");

      int modeIndex = 0;
      int timesAppeared = 0;

      for (int element = 0; element < array.length; element++)
      {
        int count = 0;

        for (int pos = 0; pos < array.length; pos++)
          if (array[element].equals(array[pos]))
            count++;
        
        if (count > timesAppeared)
        {
          timesAppeared = count;
          modeIndex = element;
        }
      }

      output[index] = array[modeIndex] + " appeared " + timesAppeared + " time(s)";
      index++;
    }

    for (String result : output)
      out.println(result);

    sc.close();
  } 
}
