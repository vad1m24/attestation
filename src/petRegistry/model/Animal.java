package petRegistry.model;

import java.time.LocalDate;
import java.util.Set;

public abstract class Animal {

    private String name;
    private LocalDate birthdate;
    private Set<String> commands;

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public Set<String> getCommands() {
        return commands;
    }

    public Animal(String name, LocalDate birthdate, Set<String> commands) {

        this.name = name;
        this.birthdate = birthdate;
        this.commands = commands;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", commands=" + commands +
                '}';
    }
}
