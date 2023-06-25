package petRegistry.model;

import java.time.LocalDate;
import java.util.Set;

public class PackAnimals extends Animal {

    public PackAnimals(String name, LocalDate birthdate, Set<String> commands) {
        super(name, birthdate, commands);
    }

}
