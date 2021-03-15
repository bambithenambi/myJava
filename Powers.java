import java.util.Scanner;
public class Powers{
  public static void main(String[] args) {
    Scanner input=new Scanner(System.in);
    System.out.print("Enter max value of power: ");
    int upto = input.nextInt();
    for(int base=2; base<=10; base++) {
      System.out.println("The powers of "+base+" upto " + upto);
      for(int pow=1; pow<=upto; pow*=base) {
        System.out.println(pow);
      }
    }
  }
}
