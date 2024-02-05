public class CountCalls {
  public static int calls;
  
  public static int f(int m, int n) {
    calls++;
    if (m == 1 && n == 1) {
      return 1;
    }
    if (m == 0 || n == 0) {
      return 0;
    }
    return f(m - 1, n) + f(m, n - 1);
  }


  public static void main(String[] args) {

    System.out.println(f(4,4));
    System.out.println("Quantité de calls : " + calls);
  }

}
