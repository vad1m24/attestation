package petRegistry.model;

import java.time.LocalDate;
import java.util.Set;

public class Dog extends Pet {
    public Dog(String name, LocalDate birthdate, Set<String> commands) {
        super(name, birthdate, commands);
    }
}
