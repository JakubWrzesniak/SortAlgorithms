package List;

public interface Iterator {
    void first();
    void last();
    void previous();
    void next();
    boolean isDone();
    Object current();
}
