import java.util.Scanner;
public class InteractiveConversionPrintf {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter degrees in Farenheit and the day of the week: ");
    int farenheit = input.nextInt();
    String day = input.next();
    System.out.print("Enter your preffered Celsius label (Celsius, Centigrade, C): ");
    String lab = input.next();
    double celsius = (5.0/9) * (farenheit-32);
    System.out.printf("%s\'s Fahrenheit: %d\n", day, farenheit);
    System.out.printf("%s\'s %-10s: %.1f\n", day, lab, celsius);
  }
}
