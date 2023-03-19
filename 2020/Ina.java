import java.util.Scanner;
import static java.lang.System.out;

// IMPORTS NEEDED FOR ALGORITHM
import java.util.ArrayList;

public class Ina 
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
      /* Separates the given data in a list
       * then converts it into Integers
       */
      String[] data = sc.nextLine().split(" ");

      int amountOfComs = Integer.parseInt(data[0]);
      int comOriginal = Integer.parseInt(data[1]);
      int downloadTime = Integer.parseInt(data[2]);

      int totalTime = 0;

      ArrayList<Integer> pairs = new ArrayList<>();
      ArrayList<Integer> withDownload = new ArrayList<>();
      ArrayList<Integer> getsDownload = new ArrayList<>();
      ArrayList<Integer> hasImpact = new ArrayList<>();
      
      withDownload.add(comOriginal);

      /* Gets the next few inputs that will
       * repeat amountOfComs - 1 times
       */
      while (amountOfComs-- > 1)
      {
        pairs.add(sc.nextInt());
        pairs.add(sc.nextInt());
        sc.nextLine();
      }

      /* Finds the computers that have the most impact and
       * sorts the computers downloading in the right order
       */
      for (int i = 0; i < withDownload.size(); i++)
      {
        int comWithFile = withDownload.get(i);

        int impacts = 0;

        for (int j = 0; j < pairs.size(); j += 2)
        {
          int com1 = pairs.get(j);
          int com2 = pairs.get(j + 1);

          if (withDownload.contains(com1) || withDownload.contains(com2))
          {
            if (withDownload.contains(com1) && withDownload.contains(com2))
              continue;
            
            if (com1 == comWithFile && !withDownload.contains(com2))
            {
              getsDownload.add(com2);
              impacts++;
            }
            else if (!withDownload.contains(com1))
            {
              getsDownload.add(com1);
              impacts++;
            }
          }
        }

        if (impacts > 0)
          hasImpact.add(comWithFile);

        for (int com : getsDownload)
          withDownload.add(com);
        getsDownload.clear();
      }

      /* Removes the pairs that have both numbers
       * which impact others and adds time
       */
      for (int i = 0; i < pairs.size(); i += 2)
      {
        int com1 = pairs.get(i);
        int com2 = pairs.get(i + 1);

        if (hasImpact.contains(com1) && hasImpact.contains(com2))
        {
          totalTime += downloadTime;

          pairs.remove(i);
          pairs.remove(i);

          i -= 2;
        }
      }

      /* Adds the remaining time to totalTime
       * by removing the ones that are in
       * hasImpact and making sure it only
       * shows up once then repeating again
       */
      ArrayList<Integer> used = new ArrayList<>();

      while (pairs.size() > 0)
      {
        used.clear();

        for (int i = 0; i < pairs.size(); i += 2)
        {
          int com1 = pairs.get(i);
          int com2 = pairs.get(i + 1);

          if (!(used.contains(com1) || used.contains(com2)))
          {
            pairs.remove(i);
            pairs.remove(i);

            if (hasImpact.contains(com1))
              used.add(com1);
            else
              used.add(com2);
            
            i -= 2;

            continue;
          }
        }

        totalTime += downloadTime;
      }

      output[index] = "Case #" + (index + 1) + ": " + totalTime;
      index++;
    }

    for (String result : output)
      out.println(result);

    sc.close();
  }
}
