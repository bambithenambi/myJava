import java.util.Scanner;
public class InteractiveConversion2 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter degrees in Farenheit: ");
    int farenheit = input.nextInt();
    System.out.print("Enter day of the week: ");
    String day = input.next();
    double celsius = (5.0/9) * (farenheit-32);
    System.out.println(day + "\'s Farenheit: "+farenheit);
    System.out.println(day + "\'s Celcius: "+celsius);
  }
}
