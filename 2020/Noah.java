import java.util.Scanner;
import static java.lang.System.out;

// IMPORTS NEEDED FOR ALGORITHM
import java.util.HashMap;

public class Noah
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);

    int count = sc.nextInt();
    sc.nextLine();

    String[] brand = new String[count];
    String[] model = new String[count];
    int[] year = new int[count];

    String[] data = new String[count];

    /* Collects the data inputted and stores
     * each line in an array, then splits each
     * line to get the separate data and store
     * those in an array as well
     */
    int index = 0;
    while (count-- > 0)
    {
      String[] input = sc.nextLine().split(",");

      brand[index] = input[0];
      model[index] = input[1];
      year[index] = Integer.parseInt(input[2]);

      data[index] = input[0] + " " + input[1] + " " + input[2];

      index++;
    }

    /* Sorts the array containing each line
     * and then outputs it to the terminal
     */
    stringSort(data);
    out.println("---Data Sorted---");
    for (String line : data)
      out.println(line);

    /* Sorts each make and then outputs
     * it to the terminal along with its
     * count
     */
    stringSort(brand);
    HashMap<String, Integer> makeBreak = new HashMap<>();
    for (String name : brand)
    {
      if (makeBreak.containsKey(name))
        makeBreak.put(name, makeBreak.get(name) + 1);
      else
        makeBreak.put(name, 1);
    }
    out.println("\n---Make Breakdown---");
    for (String make : brand)
    {
      if (makeBreak.containsKey(make))
      {
        out.println(make  + ": " + makeBreak.get(make));
        makeBreak.remove(make);
      }
    }

    /* Sorts each model and then outputs
     * it to the terminal along with its
     * count
     */
    stringSort(model);
    HashMap<String, Integer> modelBreak = new HashMap<>();
    for (String name : model)
    {
      if (modelBreak.containsKey(name))
        modelBreak.put(name, modelBreak.get(name) + 1);
      else
        modelBreak.put(name, 1);
    }
    out.println("\n---Model Breakdown---");
    for (String name : model)
    {
      if (modelBreak.containsKey(name))
      {
        out.println(name + ": " + modelBreak.get(name));
        modelBreak.remove(name);
      }
    }

    /* Sorts each year and then outputs
     * it to the terminal along with its
     * count
     */
    integerSort(year);
    HashMap<Integer, Integer> yearBreak = new HashMap<>();
    for (int y : year)
    {
      if (yearBreak.containsKey(y))
        yearBreak.put(y, yearBreak.get(y) + 1);
      else
        yearBreak.put(y, 1);
    }

    out.println("\n---Year Breakdown---");
    for (int y : year)
    {
      if (yearBreak.containsKey(y))
      {
        out.println(y + ": " + yearBreak.get(y));
        yearBreak.remove(y);
      }
    }

    sc.close();
  }

  /**
   * Sort a String array based on ASCII
   * or alphabetical order
   * @param array is a String array
   */
  static void stringSort(String[] array)
  {
    for (int i = 1; i < array.length; i++)
    {
      int j = i;

      while (j > 0 && array[j - 1].compareTo(array[j]) > 0)
      {
        String tmp = array[j];
        array[j] = array[j - 1];
        array[j - 1] = tmp;
        j--;
      }
    }
  }

  /**
   * Sort an integer array based on
   * lowest to greatest
   * @param array is an integer array
   */
  static void integerSort(int[] array)
  {
    for (int i = 1; i < array.length; i++)
    {
      int j = i;

      while (j > 0 && array[j - 1] > array[j])
      {
        int tmp = array[j];
        array[j] = array[j - 1];
        array[j - 1] = tmp;
        j--;
      }
    }
  }
}
