package airship;

import distance.Path;
import figure.Cylinder;

public class Plane extends AirShip{
    public Plane(Cylinder hitbox, Path airPath) {
        super(hitbox, airPath);
        super.name = this.getClass().getSimpleName();
    }
    public Plane(Cylinder hitbox, Path airPath, int startTime ) {
        super(hitbox, airPath, startTime);
        super.name = this.getClass().getSimpleName();
    }
}