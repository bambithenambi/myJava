public class Dog extends Pet {
    private final static double DEFAULT_DROOLRATE = 5.0;
    private double droolRate;

    public Dog(String name, double health, int painLevel){
        this(name, health, painLevel, DEFAULT_DROOLRATE);
    }
    public Dog(String name, double health, int painLevel, double droolRate){
        super(name, health, painLevel);
        if (droolRate<=0) {
            droolRate = 0.5;
        }
        this.droolRate = droolRate;
    }

    public double getDroolRate(){
        return droolRate;
    }
    public int treat(){
        double health = getHealth();
        int painLevel = getPainLevel();
        double m;
        int minutes;
        if (droolRate<3.5) {
            m = ((painLevel*2.0)/health);
        }
        else if (droolRate<=7.5) {
            m = (painLevel*1.0/health);
        }
        else{
            m = (painLevel/(health*2.0));
        }
        heal();
        return roundUp(m);
    }
    public void speak(){
        super.speak();
        String str = "bark ".repeat(getPainLevel()).trim();
        if (getPainLevel()>5){
            System.out.println(str.toUpperCase());
        }
        else {
            System.out.println(str);
        }
    }
    public boolean equals(Object o){
        if (o instanceof Dog && super.equals(o)){
            Dog d = (Dog) o;
            return this.droolRate == d.droolRate;
        }
        return false;
    }
    public int roundUp(double d) {
        if (d%1.0==0.0) {
            return (int) d;
        }
        else {
            return (int) d +1;
        }
    }
}
