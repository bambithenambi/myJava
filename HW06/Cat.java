public class Cat extends Pet {
    private final static int DEFAULT_MICECAUGHT = 0;
    private int miceCaught;

    public Cat(String name, double health, int painLevel){
        this(name, health, painLevel, DEFAULT_MICECAUGHT);
    }
    public Cat(String name, double health, int painLevel, int miceCaught){
        super(name, health, painLevel);
        if (miceCaught<0){
            miceCaught=0;
        }
        this.miceCaught = miceCaught;
    }

    public int getMiceCaught(){
        return miceCaught;
    }
    public int treat(){
        double health = getHealth();
        int painLevel = getPainLevel();
        int minutes;
        if (miceCaught<4) {
            minutes = (int)((painLevel*2)/health)+1;
        }
        else if (miceCaught<=7) {
            minutes = (int)(painLevel/health)+1;
        }
        else{
            minutes = (int)(painLevel/(health*2))+1;
        }
        heal();
        return minutes;
    }
    public void speak(){
        super.speak();
        String str = "meow ".repeat(getPainLevel());
        if (getPainLevel()>5){
            System.out.println(str.toUpperCase());
        }
        else {
            System.out.println(str);
        }
    }
    public boolean equals(Object o){
        if (o instanceof Cat && super.equals(o)){
            Cat c = (Cat) o;
            return this.miceCaught == c.miceCaught;
        }
        return false;
    }


}
