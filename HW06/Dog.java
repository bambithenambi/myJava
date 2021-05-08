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
        int minutes;
        if (droolRate<3.5) {
            minutes = roundUp(((painLevel*2)/health));
        }
        else if (droolRate<=7.5) {
            minutes = roundUp((painLevel/health));
        }
        else{
            minutes = roundUp((painLevel/(health*2)));
        }
        heal();
        return minutes;
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
}
