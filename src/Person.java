/**
 * Abstract base class for anyone stored in the system.
 * Abstraction: subclasses must say what their role is.
 * Encapsulation: fields are private and accessed through getters.
 */
public abstract class Person {
    private final String id;
    private final String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String fetchId()   { return id; }
    public String fetchName() { return name; }

    /** Each subclass describes its own role (polymorphism). */
    public abstract String fetchRole();
}