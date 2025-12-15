package cpsc219.strategygame.Model;

public enum MovementType {
    ORTHOGONAL("ortho"),
    DIAGNOAL("diago");

    final String type;
    MovementType(String type) {
        this.type = type;
    }
}
