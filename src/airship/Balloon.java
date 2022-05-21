package airship;

import distance.Path;
import figure.Cylinder;

public class Balloon extends AirShip{
    public Balloon(Cylinder hitbox, Path airPath) {
        super(hitbox, airPath);
        super.name = this.getClass().getSimpleName();
        super.setFlightTime();
        super.move(0);
    }
    public Balloon(Cylinder hitbox, Path airPath, double startTime ) {
        super(hitbox, airPath, startTime);
        super.name = this.getClass().getSimpleName();
        super.setFlightTime();
        super.move(0);
    }
}
