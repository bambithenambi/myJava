public class Gameplay{
    public static void main(String[] args) {
        BlueAstronaut bob = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut heath = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut albert = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut angel = new BlueAstronaut("Angel", 0, 1, 0);
        RedAstronaut liam = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut suspiciousPerson = new RedAstronaut("Suspicious Person", 100, "experienced");

        liam.sabotage(bob);
        System.out.println(bob.toString());
        liam.freeze(suspiciousPerson);
        liam.freeze(albert);
        System.out.println(liam.toString());
        System.out.println(albert.toString());
        albert.emergencyMeeting();
        suspiciousPerson.emergencyMeeting();
        bob.emergencyMeeting();
        System.out.println(suspiciousPerson.toString());
        heath.completeTask();
        System.out.println(heath.toString());
        heath.completeTask();
        System.out.println(heath.toString());
        heath.completeTask();
        liam.freeze(angel);
        System.out.println(angel.toString());
        System.out.println(liam.toString());
        System.out.println(bob.toString());
        liam.sabotage(bob);
        System.out.println(bob.toString());
        liam.sabotage(bob);
        System.out.println(bob.toString());
        liam.freeze(bob);
        System.out.println(bob.toString());
        angel.emergencyMeeting();
        System.out.println(liam.toString());

    }
}
