package petRegistry.model;

import java.time.LocalDate;
import java.util.Set;

public class Camel extends PackAnimals {

    public Camel(String name, LocalDate birthdate, Set<String> commands) {
        super(name, birthdate, commands);
    }

}
