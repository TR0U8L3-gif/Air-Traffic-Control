package airship;

import distance.Path;
import figure.Cylinder;

public class Balloon extends AirShip{
    public Balloon(Cylinder hitbox, Path airPath) {
        super(hitbox, airPath);
        super.name = this.getClass().getSimpleName();
    }
    public Balloon(Cylinder hitbox, Path airPath, int startTime ) {
        super(hitbox, airPath, startTime);
        super.name = this.getClass().getSimpleName();
    }
}
