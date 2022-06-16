package team.service;

public class TeamException extends Exception {
    static final long serialVersionUID = -338712393124229948L;

    public TeamException() {
    }

    public TeamException(String message) {
        super(message);
    }
}
