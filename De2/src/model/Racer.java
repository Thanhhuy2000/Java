package model;

public class Racer {
    protected String id;
    protected String name;
    protected int fuel;
    protected Type vehicleType;
    protected int speed;
    protected int durability;
    protected double control;

    public Racer(String id, String name, int fuel, Type vehicleType, int speed, int durability, double control) {
        this.id = id;
        this.name = name;
        this.fuel = fuel;
        this.vehicleType = vehicleType;
        this.speed = speed;
        this.durability = durability;
        this.control = control;
    }

    public String getId() {return id;}
    public String getName() {return name;}
    public int getFuel() {return fuel;}
    public void setFuel(int fuel) {this.fuel = fuel;}
    public Type getVehicleType() {return vehicleType;}
    public int getSpeed() {return speed;}
    public int getDurability() {return durability;}
    public double getControl() {return control;}

    public abstract void naviagateObstacle(Obstacle obstacle, RaceState state);
    public abstract boolean canNavigate();
    public void refuel(){
        this.fuel = Math.min(100, this.fuel + 10);
    }
}
