package cpsc219.strategygame.Model;

public abstract class Entity {
    // field
    int health;
    int movementDistance;
    int damage;
    MovementType movementType;
    TurnState turnState = TurnState.IDLE; // basic

    public Entity(int health, int movementDistance, MovementType movementType) {
        this.health = health;
        this.movementDistance = movementDistance;
        this.movementType = movementType;
        damage = 0; // if not declared
    }
    public Entity(int health, int movementDistance, MovementType movementType, int damage) {
        this.health = health;
        this.movementDistance = movementDistance;
        this.movementType = movementType;
        this.damage = damage;
    }

    // getters
    public int getHealth() { return health; }
    public int getMovementDistance() { return movementDistance; }
    public int getDamage() { return damage; }
    public MovementType getMovementType() { return movementType; }
    public TurnState getTurnState() { return turnState; }

    // setters
    public void setHealth(int health) { this.health = health; }
    public void setMovementDistance(int movementDistance) { this.movementDistance= movementDistance; }
    public void setDamage(int damage) { this.damage = damage; }
    public void setMovementType(MovementType movementType) { this.movementType = movementType; }
    public void setTurnState(TurnState turnState) { this.turnState= turnState; }


}
