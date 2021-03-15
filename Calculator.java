import java.util.Scanner;
public class Calculator {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("List of Operations: add subtract multiply divide alphabetize");
    System.out.println("Enter an operation:");
    String operation = input.next().toLowerCase();
    switch (operation) {
      case "add":
        System.out.println("Enter two integers: ");
        if (!input.hasNextInt()) {
          System.out.println("Invalid input entered. Terminating...");
        }
        else {
          int a = input.nextInt();
          if (!input.hasNextInt()) {
            System.out.println("Invalid input entered. Terminating...");
          }
          else {
            int b = input.nextInt();
            System.out.println("Answer:"+(a+b));
          }
        }
        break;
      case "subtract":
        System.out.println("Enter two integers: ");
        if (!input.hasNextInt()) {
          System.out.println("Invalid input entered. Terminating...");
        }
        else {
          int a = input.nextInt();
          if (!input.hasNextInt()) {
            System.out.println("Invalid input entered. Terminating...");
          }
          else {
            int b = input.nextInt();
            System.out.println("Answer: "+(a-b));
          }
        }
        break;
      case "multiply":
        System.out.println("Enter two doubles: ");
        if (!input.hasNextDouble()) {
          System.out.println("Invalid input entered. Terminating...");
        }
        else {
          Double a = input.nextDouble();
          if (!input.hasNextDouble()) {
            System.out.println("Invalid input entered. Terminating...");
          }
          else {
            Double b = input.nextDouble();
            Double c = a*b;
            System.out.printf("Answer: %.2f%n",c);
          }
        }
        break;
      case "divide":
        System.out.println("Enter two doubles: ");
        if (!input.hasNextDouble()) {
          System.out.println("Invalid input entered. Terminating...");
        }
        else {
          Double a = input.nextDouble();
          if (!input.hasNextDouble()) {
            System.out.println("Invalid input entered. Terminating...");
          }
          else {
            Double b = input.nextDouble();
            if (b==0) {
              System.out.println("Invalid input entered. Terminating...");
            }
            else{
              Double c = a/b;
              System.out.printf("Answer: %.2f%n",c);
            }
          }
        }
        break;
      case "alphabetize":
        System.out.println("Enter two words: ");
        if (!input.hasNext()) {
          System.out.println("Invalid input entered. Terminating...");
        }
        else {
          String a = input.next();
          if (!input.hasNext()) {
            System.out.println("Invalid input entered. Terminating...");
          }
          else {
            String b = input.next();
            if (a.toLowerCase().compareTo(b.toLowerCase())>0) {
              System.out.println("Answer: "+b+" comes before "+a+" alphabetically.");
            }
            else if (a.toLowerCase().compareTo(b.toLowerCase())<0) {
              System.out.println("Answer: "+a+" comes before "+b+" alphabetically.");
            }
            else {
              System.out.println("Answer: Chicken or Egg.");
            }
          }
        }
        break;
      default:
        System.out.println("Invalid input entered. Terminating...");
    }
  }
}
