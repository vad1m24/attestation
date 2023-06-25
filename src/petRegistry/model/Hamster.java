package petRegistry.model;

import java.time.LocalDate;
import java.util.Set;

public class Hamster extends Pet {

    public Hamster(String name, LocalDate birthdate, Set<String> commands) {
        super(name, birthdate, commands);
    }

}
