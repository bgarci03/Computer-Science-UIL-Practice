import java.util.Scanner;
import static java.lang.System.out;

public class Seema
{
  public static void main(String[] args)

  {
    Scanner sc = new Scanner(System.in);

    /* Collects the data from the input and
     * stores it in an array
     */
    String[] data = sc.nextLine().split(",");
    int[] count = new int[data.length];

    /* Sorts the data in the data array based
     * on alphabetical order
     */
    sort(data);

    /* Finds the amount of times a state
     * appears in the data array
     */
    for (int i = 0; i < data.length; i++)
    {
      String state = data[i];
      int repeats = 0;

      for (String other : data)
        if (state.equals(other))
          repeats++;

      count[i] = repeats;
    }

    /* Sorts the data in the count array while
     * also moving the data around in the data
     * array
     */
    sortAndShift(count, data);

    for (int i = 0; i < data.length; i++)
    {
      for (int j = i + 1; j < data.length; j++)
        if (data[j].equals(data[i]))
          data[j] = "";

      if (!data[i].equals(""))
        out.println(data[i] + ": " + count[i]);
    }
  }

  /***
   * Sorts a String array based o ASCII
   * or alphabetical order
   * @param array is a String array
   */
  static void sort(String[] array)
  {
    for (int i = 0; i < array.length; i++)
    {
      int j = i;

      while (j > 0 && array[j - 1].compareTo(array[j]) > 0)
      {
        String temp = array[j];
        array[j] = array[j - 1];
        array[j - 1] = temp;
        j--;
      }
    }
  }

  /***
   * Sorts the data in an integer array while
   * also moving the data around in a String
   * array based on those sorts.
   * @param x is an integer array
   * @param s is a String array
   */
  static void sortAndShift(int[] x, String[] s)
  {
    for (int i = 0; i < x.length; i++)
    {
      int j = i;

      while (j > 0 && x[j - 1] < x[j])
      {
        int temp = x[j];
        x[j] = x[j - 1];
        x[j - 1] = temp;

        String sTemp = s[j];
        s[j] = s[j - 1];
        s[j - 1] = sTemp;

        j--;
      }
    }
  }
}
