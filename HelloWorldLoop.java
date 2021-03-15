public class HelloWorldLoop {
  public static void main(String[] args) {
    int counter = 0;

    while (counter<10) {
      String appendix;
      if (counter==0){
        appendix="st";
      }
      else if (counter==1) {
        appendix="nd";
      }
      else if (counter==2) {
        appendix="rd";
      }
      else {
        appendix="th";
      }
      System.out.println("Hello world for the "+(counter+1)+appendix+" time");
      counter+=1;
    }
  }
}
