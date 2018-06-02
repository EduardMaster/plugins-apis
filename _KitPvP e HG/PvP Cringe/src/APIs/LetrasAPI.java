package APIs;

public class LetrasAPI
{
  public static boolean ContemLetra(String s)
  {
    char[] c = s.toCharArray();
    boolean d = false;
    for (int i = 0; i < c.length; i++) {
      if (!Character.isDigit(c[i]))
      {
        d = true;
        break;
      }
    }
    return d;
  }
}
