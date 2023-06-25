package petRegistry.model;

import java.time.LocalDate;
import java.util.Set;

public class Pet extends Animal {

    public Pet(String name, LocalDate birthdate, Set<String> commands) {
        super(name, birthdate, commands);
    }


}
