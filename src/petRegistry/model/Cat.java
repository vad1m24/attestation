package petRegistry.model;

import java.time.LocalDate;
import java.util.Set;

public class Cat extends Pet {
    public Cat(String name, LocalDate birthdate, Set<String> commands) {
        super(name, birthdate, commands);
    }
}
