public class Fly {
  //defaults
  private static final double DEFAULT_MASS = 5;
  private static final double DEFAULT_SPEED = 10;
  //variables
  private double mass;
  private double speed;
  //constructors
  public Fly() {
    this(DEFAULT_MASS);
  }
  public Fly(double mass) {
    this(mass, DEFAULT_SPEED);
  }
  public Fly(double mass, double speed) {
    this.mass = mass;
    this.speed = speed;
  }
  //methods
  public double getSpeed() {
    return speed;
  }
  public double getMass() {
    return mass;
  }
  public void setSpeed(double speed) {
    if (speed>=0) {
      this.speed = speed;
    }
  }
  public void setMass(double mass) {
    if (mass>=0) {
      this.mass = mass;
    }
  }
  public String toString() {
    if (mass==0) {
      return "I’m dead, but I used to be a fly with a speed of "+speed+".";
    }
    else {
      return "I’m a speedy fly with "+speed+" speed and "+mass+" mass.";
    }
  }
  public void grow(int addMass) {
    double start = mass;
    mass += addMass;
    if (start<20) {
      speed+=(20-start);
    }
    else {
      speed-=(addMass)*0.5;
    }
  }
  public boolean isDead() {
    if (mass==0) {
      return true;
    }
    else {
      return false;
    }
  }


}
