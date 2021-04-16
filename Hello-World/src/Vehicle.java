public class Vehicle {
    int passengers;
    double fuel; //fuel capacity in gallons
    double mpg; //miles per gallon

    Vehicle(int f, int m){ //constructor
        this.passengers = 5; //default 5 passengers
        this.fuel = f;
        this.mpg = m;
    }
    Vehicle(int p, int f, int m){ //constructor
        this.passengers = p;
        this.fuel = f;
        this.mpg = m;
    }
    double fuelNeeded(int miles){
        return (double) miles/ mpg;
    }

    /*EQUIVALENT
    double fuelNeeded(int miles){
        return (double) miles/ this.mpg;
    }*/

}
