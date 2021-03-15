import java.util.Scanner;
public class InteractiveConversion3 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter degrees in Farenheit and the day of the week: ");
    int farenheit = input.nextInt();
    String day = input.next();
    double celsius = (5.0/9) * (farenheit-32);
    System.out.println(day + "\'s Farenheit: "+farenheit);
    System.out.println(day + "\'s Celcius: "+celsius);
  }
}
