package lesson06My;

public abstract class Vehicle {
    String name;
    String driverName;
    String releaseYear;
    Engine engine;


    public Vehicle(String name, String driverName, String releaseYear, Engine engine) {
        this.name = name;
        this.driverName = driverName;
        this.releaseYear = releaseYear;
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public abstract void moveForward ();
    public abstract void moveBackward ();
    public abstract void turnRight ();
    public abstract void turnLeft ();

    public void playHorn (){
        System.out.println("Beep! Beep!");
    }




}
