public class FarenheitToCelsius {
  public static void main(String[] args) {
    int saturdayFarenheit = 78;
    int sundayFarenheit = 81;
    double saturdayCelsius = (5.0/9) * (saturdayFarenheit-32);
    double sundayCelsius = (5.0/9) * (sundayFarenheit-32);
    System.out.println("Weekend Averages");
    System.out.println("Saturday: " + saturdayCelsius);
    System.out.println("Sunday: " + sundayCelsius);


  }
}
