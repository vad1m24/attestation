package petRegistry.repository;

import petRegistry.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    private List<Animal> animals = new ArrayList<>();

    public void showRepository() {
        animals.forEach(System.out::println);
    }

    public void addAnimalToRepository(Animal animal) {
        animals.add(animal);
    }

    public Animal getByName(String name) {
        return animals.stream().filter(animal -> animal.getName().equals(name)).findFirst().orElse(null);
    }

    public void addCommandByAnimalName(String name, String command) {
        Animal byName = getByName(name);
        byName.getCommands().add(command);
    }
}
