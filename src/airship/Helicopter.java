package airship;

import distance.Path;
import figure.Cylinder;

public class Helicopter extends AirShip {
    public Helicopter(Cylinder hitbox, Path airPath) {
        super(hitbox, airPath);
        super.name = this.getClass().getSimpleName();
        super.setFlightTime();
        super.move(0);
    }
    public Helicopter(Cylinder hitbox, Path airPath, int startTime ) {
        super(hitbox, airPath, startTime);
        super.name = this.getClass().getSimpleName();
        super.setFlightTime();
        super.move(0);
    }
}