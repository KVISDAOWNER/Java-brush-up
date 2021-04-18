package units;

class PlayerAlreadySetException extends IllegalArgumentException {
    PlayerAlreadySetException() {
        super("Player.Player all ready set");
    }
}
