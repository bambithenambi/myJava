public abstract class Pet {
    private String name;
    private double health;
    private int painLevel;

    public Pet(String name, double health, int painLevel) {
        if (health>1.0) {
            health = 1.0;
        }
        else if (health<0.0) {
            health = 0.0;
        }
        if (painLevel > 10) {
            painLevel = 10;
        }
        else if (painLevel < 1) {
            painLevel = 1;
        }
        this.name = name;
        this.health = health;
        this.painLevel = painLevel;
    }
    public double getHealth(){
        return health;
    }
    public String getName(){
        return name;
    }
    public int getPainLevel(){
        return painLevel;
    }
    public abstract int treat();

    public void speak(){
        String str = "Hello! My name is "+name;
        if (painLevel>5) {
            System.out.println(str.toUpperCase());
        }
        else {
            System.out.println(str);
        }
    }
    public boolean equals(Object o) {
        if (o instanceof Pet) {
            Pet p = (Pet) o;
            return this.name.equals(p.name);
        }
        return false;
    }
    protected void heal(){
        health = 1.0;
        painLevel = 1;
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
