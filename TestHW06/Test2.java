public class Test2{
    public static void main(String[] args) {
        double health = 0.399999;
        int painLevel = 3;
        double d = ((painLevel*2.0)/health);
        if (d%1.0==0.0) {
            System.out.println((int)d);
        }
        else {
            System.out.println((int) d+1);
        }
    }
}
