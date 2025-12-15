package cpsc219.strategygame.Model;

public class Knight extends Entity{
    // fields
    String textureName = "knight.png";
    Allegiance ALLEGIANCE = Allegiance.ALLY;

    public Knight(int health, int movementDistance, MovementType movementType, int damage) {
        super(health, movementDistance, movementType, damage);
    }

    // getter
    public Allegiance getALLEGIANCE() { return ALLEGIANCE; }
}
