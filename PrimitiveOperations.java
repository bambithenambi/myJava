public class PrimitiveOperations {
  public static void main(String[] args) {
    int i = 69;
    System.out.println(i);
    double f = 3.141;
    System.out.println(f);
    double p = f*i;
    System.out.println(p);
    float i_f = (float) i;
    System.out.println(i_f);
    int f_i = (int) f;
    System.out.println(f_i);
    char chook = 'A';
    System.out.println(chook);
    chook = (char) ((int) chook + 32);
    System.out.println(chook);
  }
}
