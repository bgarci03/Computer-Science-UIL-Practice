import java.util.Scanner;

public class Britanny
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);

    String input = sc.nextLine() + " ";

    double sum = 0;
    int count = 0;
    
    while (input.contains(" "))
    {
      double num = Double.parseDouble(input.substring(0, input.indexOf(" ")));

      sum += num;
      count++;

      input = input.substring(input.indexOf(" ") + 1);
    }

    String textSum = (sum + 0.005) + "";
    textSum = textSum.substring(0, textSum.indexOf(".") + 3);

    String textAvg = (sum / count + 0.005) + "";
    textAvg = textAvg.substring(0, textAvg.indexOf(".") + 3);

    System.out.println(textSum + " " + textAvg);
  }
}
