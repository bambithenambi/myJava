public class Frog{
  //defaults
  private static final double DEFAULT_AGE = 0.42;
  private static final double DEFAULT_tongueSpeed = 5;
  //variables
  private String name;
  private int age;
  private double tongueSpeed;
  private boolean isFroglet;
  private static String species = "Rare Pepe";
  //constructors
  public Frog(String name) {
    this(name, DEFAULT_AGE, DEFAULT_tongueSpeed);
  }
  public Frog(String name, double ageInYears, double tongueSpeed) {
    this(name, (int) (ageInYears*12), tongueSpeed);
  }
  public Frog(String name, int age, double tongueSpeed) {
    this.name = name;
    this.age = age;
    this.tongueSpeed = tongueSpeed;
    if (age<7 && age>1) {
      isFroglet=true;
    }
    else {
      isFroglet=false;
    }
  }
  //methods
  public void grow() {
    grow(1);
  }
  public void grow(int months) {
    if (months>=0) {
      double start = age;
      age += months;
      if (start <12) {
        tongueSpeed+= (12-start) < months ? (12-start) : months;
        if (age>=30) {
          tongueSpeed-=(age-30);
        }
      }
      else if (start>=30) {
        tongueSpeed-=months;
      }
      else {
        if (age>=30) {
          tongueSpeed-=(age-30);
        }
      }
      if (tongueSpeed<5){
        tongueSpeed=5;
      }
      if (age<7 && age>1) {
        isFroglet=true;
      }
      else {
        isFroglet=false;
      }
    }
  }
  public void eat(Fly fly) {
    if (fly.isDead()) {
      return;
    }
    if (tongueSpeed>fly.getSpeed()) {
      if (fly.getMass()>=(age*0.5)) {
        grow();
      }
      fly.setMass(0);
    }
    else {
      fly.grow(1);
    }

  }
  public String toString(){
    if (isFroglet) {
      return "My name is "+name+" and I’m a rare froglet! I’m "+age+" months old and my tongue has a speed of "+tongueSpeed+".";
    }
    else {
      return "My name is "+name+" and I’m a rare frog. I’m "+age+" months old and my tongue has a speed of "+tongueSpeed+".";
    }
  }
  public String getSpecies() {
    return species;
  }
  public void setSpecies(String species) {
    this.species = species;
  }
}
