package tn.esprit.gestionzoo.entities;

public class Zoo {
    private Animal[] animals;
    private Aquatic[] aquaticAnimals = new Aquatic[10];
    private String name;
    private String city;
    private static final int nbrCages = 25;
    int nbrAnimals;
    private int nbrAquaticAnimals = 0;

    public Zoo(String name, String city) {
        animals = new Animal[nbrCages];
        setName(name);
        this.city = city;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("ne doit pas etre vide");
        } else {
            this.name = name;
        }
    }
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void displayZoo() {
        System.out.println("tn.esprit.gestionzoo.entities.Zoo Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Number of cages: " + nbrCages);
        System.out.println("Animals in the zoo:");
        for (Animal a : animals) {
            if (a != null) {
                System.out.println("name " + a.getName() + ", Family: " + a.getFamily() + ", Age: " + a.getAge() + ", Mammal: " + a.isMammal());
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("tn.esprit.gestionzoo.entities.Zoo Name: ").append(name)
                .append(", City: ").append(city)
                .append(", Number of cages: ").append(nbrCages)
                .append("\nAnimals:\n");
        for (Animal a : animals) {
            if (a != null) {
                sb.append(a).append("\n");
            }
        }
        return sb.toString();
    }

    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("zoo est plein !");
            return false;
        }
        if (searchAnimal(animal) != -1) {
            System.out.println("tn.esprit.gestionzoo.entities.Animal present : " + animal.getName());
            return false;
        }
        animals[nbrAnimals] = animal;
        nbrAnimals++;

        return true;
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null && animals[i].getName().equals(animal.getName())) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index != -1) {
            animals[index] = null;
            System.out.println("tn.esprit.gestionzoo.entities.Animal supprimer : " + animal.getName());
            return true;
        }
        return false;
    }

    public boolean isZooFull() {
        int nombreAnimaux = 0;
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null) {
                nombreAnimaux++;
            }
        }
        if (nombreAnimaux == nbrCages) {
            System.out.println("tn.esprit.gestionzoo.entities.Zoo is full");
            return true;
        } else {
            System.out.println("tn.esprit.gestionzoo.entities.Zoo is not full");
            return false;
        }
    }

    public int compterAnimaux() {
        int nombreAnimaux = 0;
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null) {
                nombreAnimaux++;
            }
        }
        return nombreAnimaux;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        int animauxZ1 = z1.compterAnimaux();
        int animauxZ2 = z2.compterAnimaux();

        if (animauxZ1 > animauxZ2) {
            return z1;
        } else if (animauxZ2 > animauxZ1) {
            return z2;
        } else {
            return null;
        }
    }

    public void addAquaticAnimal(Aquatic aquatic) {
        if (nbrAquaticAnimals >= aquaticAnimals.length) {
            System.out.println("Le tableau des animaux aquatiques est plein !");
            return;
        }
        aquaticAnimals[nbrAquaticAnimals] = aquatic;
        nbrAquaticAnimals++;
        System.out.println("Animal aquatique ajouté : " + aquatic.getName());
    }

    public void displayAquaticAnimalsSwim() {
        System.out.println("Appel de swim() pour tous les animaux aquatiques du zoo :");
        for (int i = 0; i < nbrAquaticAnimals; i++) {
            if (aquaticAnimals[i] != null) {
                System.out.print(aquaticAnimals[i].getName() + " : ");
                aquaticAnimals[i].swim();
            }
        }
    }

    public float maxPenguinSwimmingDepth() {
        float maxDepth = -1;
        for (int i = 0; i < nbrAquaticAnimals; i++) {
            if (aquaticAnimals[i] instanceof Penguin) {
                Penguin penguin = (Penguin) aquaticAnimals[i];
                if (penguin.getSwimmingDepth() > maxDepth) {
                    maxDepth = penguin.getSwimmingDepth();
                }
            }
        }
        return maxDepth;
    }

    public void displayNumberOfAquaticsByType() {
        int dolphinCount = 0;
        int penguinCount = 0;
        for (int i = 0; i < nbrAquaticAnimals; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) {
                dolphinCount++;
            } else if (aquaticAnimals[i] instanceof Penguin) {
                penguinCount++;
            }
        }
        System.out.println("Nombre de dauphins : " + dolphinCount);
        System.out.println("Nombre de pingouins : " + penguinCount);
    }
}
