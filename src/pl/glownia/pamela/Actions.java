package pl.glownia.pamela;

public enum Actions {
    BUY, FILL, CHECK_STATUS, TAKE, EXIT;

    boolean equals(String decision) {
        return this.name().equalsIgnoreCase(decision);
    }
}