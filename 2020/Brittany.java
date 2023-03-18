import java.util.Scanner;
import static java.lang.System.out;

public class Brittany
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);

    // MAIN CODE BEGINS HERE
    String[] nums = sc.nextLine().split(" ");

    double sum = 0;
    int count = 0;

    for (String num : nums)
    {
      double actual = Double.parseDouble(num);

      sum += actual;
      count++;
    }

    String textSum = (sum + 0.005) + "";
    textSum = textSum.substring(0, textSum.indexOf(".") + 3);

    String textAvg = (sum / count + 0.005) + "";
    textAvg = textAvg.substring(0, textAvg.indexOf(".") + 3);

    out.println(textSum + " " + textAvg);

    sc.close();
  }
}
