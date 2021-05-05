import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;

public class Clinic{
    private File patientFile;
    private int day;

    public Clinic(String fileName){
        this(new File(fileName));
    }
    public Clinic(File file){
        patientFile = file;
        day = 1;
    }

    public String nextDay(String fileName) throws FileNotFoundException{
        File f = new File(fileName);
        return nextDay(f);
    }
    public String nextDay(File f) throws FileNotFoundException{
        Scanner fileScan = new Scanner(f);
        Scanner counter = new Scanner(f);
        Scanner petScan = null;
        int count = 0;
        while(counter.hasNextLine()) {
            counter.nextLine();
            count++;
        }
        String[] names = new String[count];
        String[] types = new String[count];
        double[] data = new double[count];
        int[] times = new int[count];

        int index = 0;
        String line = null;
        while (fileScan.hasNextLine()) {
            line = fileScan.nextLine();
            petScan = new Scanner(line);
            petScan.useDelimiter(",");
            names[index] = petScan.next(); //consume unused rank token
            types[index] = petScan.next();
            data[index] = petScan.nextDouble();
            times[index] = petScan.nextInt();
            index++;
        }
        Scanner input = new Scanner(System.in);
        String[] messages = new String[count];
        for (int i=0; i<count; i++){
            System.out.print("Consultation for "+names[i]+" the "+types[i]+" at "+times[i]+".\n");
            if (!(types[i].equals("Cat") || types[i].equals("Dog"))){
                throw new InvalidPetException();
            }
            boolean success = false;
            double health = 1.0;
            int painLevel = 1;

            while (!success) {
                try {
                    System.out.print("What is the health of "+names[i]+"?\n");
                    health = input.nextDouble();
                    success = true;
                } catch (Exception e) {
                    input.nextLine();
                    System.out.println("Please enter a double");
                }
            }
            success = false;
            while (!success) {
                try {
                    System.out.print("On a scale of 1 to 10, how much pain is "+names[i]+" in right now?\n");
                    painLevel = input.nextInt();
                    success = true;
                } catch (Exception e) {
                    input.nextLine();
                    System.out.println("Please enter a int");
                }
            }
            Pet p;
            if (types[i].equals("Cat")){
                int miceCaught = (int) data[i];
                p = new Cat(names[i], health, painLevel, miceCaught);
            }
            else {
                double droolRate = data[i];
                p = new Dog(names[i], health, painLevel, droolRate);
            }
            p.speak();
            int exitTime = p.treat()+times[i];
            messages[i] = names[i]+","+types[i]+","+data[i]+","+day+","+times[i]+","+exitTime+","+health+","+painLevel;
        }
        day++;
        return String.join("\n", messages);
    }


}
