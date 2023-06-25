package petRegistry.model;

import java.time.LocalDate;
import java.util.Set;

public class Horse extends PackAnimals {

    public Horse(String name, LocalDate birthdate, Set<String> commands) {
        super(name, birthdate, commands);
    }

}
