import java.util.Scanner;
public class InteractiveConversion {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter degrees in Farenheit: ");
    int farenheit = input.nextInt();
    double celsius = (5.0/9) * (farenheit-32);
    System.out.println("Celcius: "+celsius);
  }
}
