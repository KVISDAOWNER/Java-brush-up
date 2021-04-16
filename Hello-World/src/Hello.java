import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Hello {
    public static void main(String[] args){
        //Hello();
        //DistToMeters();
        //CreateVehicle();
        while(true){
            NumberGame();
        }
    }

    public static void Hello(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name!");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + "!");
    }

    public static void DistToMeters(){
        Scanner scanner = new Scanner(System.in);
        Units units = new Units();
        System.out.println("Enter distance in feet:");
        Double feet = Double.parseDouble(scanner.nextLine());
        System.out.printf("Meters: %f\n", units.feetToMeters(feet)); //Note different from println
    }

    public static void CreateVehicle(){
        Vehicle vehicle = new Vehicle(5, 8, 18);
        System.out.println("Created vehicle!");
        System.out.printf("Passengers: %d ",  vehicle.passengers);
        System.out.printf("Fuel: %f ", vehicle.fuel);
        System.out.printf("Mile per gal: %f\n", vehicle.mpg);
    }

    public static void NumberGame(){
        System.out.println("Guess a random number beween 1 and 10:");

        //+1 because the max bound is exclusive
        int rand = ThreadLocalRandom.current().nextInt(1, 10 + 1);

        Scanner scanner = new Scanner(System.in);
        int guess = Integer.parseInt(scanner.nextLine());
        if(guess == rand)
            System.out.println("Congrats you guessed it! It was: " + rand);
        else
            System.out.println("Sorry! It was: " + rand);
    }
}
