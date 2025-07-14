package model;

public class SportRacer extends Racer{
    public SportRacer(String id, String name, int fuel, Type vehicleType, int speed, int durability, double control){
        super(id, name, fuel, vehicleType.SPORT, speed, durability, control);
    }

    @Override
    public void navigateObstacle(Obstacle obstacle, RaceState state){};
    public boolean canNavigate(){
        return fuel > 0;
    }
}
