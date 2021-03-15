public class StringOperations {
  public static void main (String[] args) {
    String name = "Abhijit";
    System.out.println(name);
    System.out.println("A"+name.substring(1, 6)+"Z");
    String url = "www.github.com";
    System.out.println(url);
    int dex1 = url.indexOf('.');
    int dex2 = dex1+url.substring(dex1+1).indexOf('.');
    System.out.println(url.substring(dex1+1, dex2+1)+"1331");
  }

}
