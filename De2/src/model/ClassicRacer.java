package model;

import java.util.Random;

public class ClassicRacer extends Racer {
    public ClassicRacer(String id, String name, int fuel, Type vehicleType, int speed, int durability, double control){
        super(id, name, fuel, vehicleType.SPORT, speed, durability, control);
    }

    @Override
    public void navigateObstacle(Obstacle obstacle, RaceState state){};
    public boolean canNavigate(){
        return fuel > 0;
    }
}
