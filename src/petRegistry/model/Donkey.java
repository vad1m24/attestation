package petRegistry.model;

import java.time.LocalDate;
import java.util.Set;

public class Donkey extends PackAnimals {

    public Donkey(String name, LocalDate birthdate, Set<String> commands) {
        super(name, birthdate, commands);
    }

}
