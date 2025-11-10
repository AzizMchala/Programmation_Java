package tn.esprit.gestionzoo.main;
import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;
import tn.esprit.gestionzoo.entities.Aquatic;
import tn.esprit.gestionzoo.entities.Terrestrial;
import tn.esprit.gestionzoo.entities.Dolphin;
import tn.esprit.gestionzoo.entities.Penguin;
import tn.esprit.gestionzoo.entities.ZooFullException;
import tn.esprit.gestionzoo.entities.InvalidAgeException;
public class Main {
    public static void main(String[] args) {

        Animal lion = new Animal("Félin", "Lion", 5, true);
        Animal lion1 = new Animal("Félin", "lion", 5, true);
        Animal lapin = new Animal("Rongeur", "Lapin", 2, true);
        Animal elephant = new Animal("Éléphantidé", "Éléphant", 10, true);
        Animal girafe = new Animal("Giraffidé", "Girafe", 8, true);
        Zoo z1 = new Zoo("ZooFrance", "Paris");
        try {
            z1.addAnimal(lion);
        } catch (ZooFullException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Nombre d'animaux z1: " + z1.compterAnimaux());
        }
        try {
            z1.addAnimal(elephant);
        } catch (ZooFullException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Nombre d'animaux z1: " + z1.compterAnimaux());
        }
        try {
            z1.addAnimal(lapin);
        } catch (ZooFullException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Nombre d'animaux z1: " + z1.compterAnimaux());
        }

        /*myZoo.displayZoo();*/
        Zoo z2 = new Zoo("ZooTunis", "Paris");
        try {
            z2.addAnimal(lion);
        } catch (ZooFullException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Nombre d'animaux z2: " + z2.compterAnimaux());
        }
        try {
            z2.addAnimal(elephant);
        } catch (ZooFullException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Nombre d'animaux z2: " + z2.compterAnimaux());
        }
        try {
            z2.addAnimal(lapin);
        } catch (ZooFullException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Nombre d'animaux z2: " + z2.compterAnimaux());
        }

        if(Zoo.comparerZoo(z1,z2)== null){
            System.out.println("egale");
        }
        else{
            System.out.println(Zoo.comparerZoo(z1, z2));
        }
        lion.setAge(7);
        System.out.println("setAge(7) : " + lion);


        System.out.println("setAge(-3) : " + lion);
        try {
            lion.setAge(-3);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }


        Zoo zoo2 = new Zoo("aaaa", "Sfax");
        System.out.println("Nom du zoo : " + zoo2.getName());
        zoo2.setName(null);
        System.out.println("Nom après setName : " + zoo2.getName());
        zoo2.setName("");
        System.out.println("Nom après setName : " + zoo2.getName());

        try {
            zoo2.addAnimal(lion);
        } catch (ZooFullException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Nombre d'animaux zoo2: " + zoo2.compterAnimaux());
        }
        try {
            zoo2.addAnimal(elephant);
        } catch (ZooFullException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Nombre d'animaux zoo2: " + zoo2.compterAnimaux());
        }
        try {
            zoo2.addAnimal(lapin);
        } catch (ZooFullException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Nombre d'animaux zoo2: " + zoo2.compterAnimaux());
        }

        // Ajout d'animaux aquatiques
        Dolphin dolphin = new Dolphin("Delphinidae", "Flipper", 8, true, "Mer", 25.5f);
        Penguin penguin = new Penguin("Spheniscidae", "Pingouin", 4, false, "Antarctique", 10.0f);
        zoo2.addAquaticAnimal(dolphin);
        zoo2.addAquaticAnimal(penguin);

        // Affichage de la méthode swim() pour tous les animaux aquatiques
        zoo2.displayAquaticAnimalsSwim();

        System.out.println("Nom du zoo : " + zoo2);
        /*int test=myZoo.searchAnimal(lion);
        System.out.println(test);
        int test1=myZoo.searchAnimal(lion1);
        System.out.println(test1);*/

        //myZoo.removeAnimal(girafe);
        /*z1.isZooFull();*/

        Terrestrial terrestrial = new Terrestrial("Canidé", "Chien", 3, true, 4);
        Dolphin dolphin2 = new Dolphin("Delphinidé", "Flipper", 6, true, "Océan", 35.5f);
        Penguin penguin2 = new Penguin("Sphéniscidé", "Pingouin", 4, false, "Banquise", 120.0f);

        System.out.println(terrestrial);
        System.out.println(dolphin2);
        System.out.println(penguin2);

        dolphin2.swim();
        penguin2.swim();

        // Test 1: InvalidAgeException via constructor
        try {
            Animal invalid = new Animal("TestFamily", "BadAge", -1, true);
            System.out.println("Should not print: " + invalid);
        } catch (InvalidAgeException e) {
            System.out.println("[TEST] InvalidAgeException (ctor): " + e.getMessage());
        }

        // Test 2: InvalidAgeException via setter
        try {
            lion.setAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("[TEST] InvalidAgeException (setter): " + e.getMessage());
        }

        // Test 3: ZooFullException when exceeding capacity (3)
        Zoo smallZoo = new Zoo("SmallZoo", "TestCity");
        try {
            smallZoo.addAnimal(new Animal("F1", "A1", 1, true));
        } catch (ZooFullException e) { System.out.println(e.getMessage()); }
        System.out.println("Count smallZoo: " + smallZoo.compterAnimaux());
        try {
            smallZoo.addAnimal(new Animal("F2", "A2", 2, true));
        } catch (ZooFullException e) { System.out.println(e.getMessage()); }
        System.out.println("Count smallZoo: " + smallZoo.compterAnimaux());
        try {
            smallZoo.addAnimal(new Animal("F3", "A3", 3, true));
        } catch (ZooFullException e) { System.out.println(e.getMessage()); }
        System.out.println("Count smallZoo: " + smallZoo.compterAnimaux());
        try {
            smallZoo.addAnimal(new Animal("F4", "A4", 4, true));
        } catch (ZooFullException e) {
            System.out.println("[TEST] ZooFullException: " + e.getMessage());
        }
        System.out.println("Count smallZoo: " + smallZoo.compterAnimaux());

        // Test 4: Duplicate add on a fresh zoo (no exception; log + count unchanged)
        Zoo dupZoo = new Zoo("DupZoo", "TestCity");
        try {
            dupZoo.addAnimal(new Animal("F1", "A1", 1, true));
        } catch (ZooFullException e) { System.out.println(e.getMessage()); }
        System.out.println("Count dupZoo: " + dupZoo.compterAnimaux());
        try {
            dupZoo.addAnimal(new Animal("F1", "A1", 1, true));
        } catch (ZooFullException e) { System.out.println(e.getMessage()); }
        System.out.println("Count dupZoo (dup attempt): " + dupZoo.compterAnimaux());



        System.out.println("Terrestrial tests:");
        terrestrial.eatMeat(tn.esprit.gestionzoo.entities.Food.MEAT);
        terrestrial.eatMeat(tn.esprit.gestionzoo.entities.Food.PLANT);
        terrestrial.eatMeat(tn.esprit.gestionzoo.entities.Food.BOTH);
        terrestrial.eatPlant(tn.esprit.gestionzoo.entities.Food.PLANT);
        terrestrial.eatPlant(tn.esprit.gestionzoo.entities.Food.MEAT);
        terrestrial.eatPlant(tn.esprit.gestionzoo.entities.Food.BOTH);
        terrestrial.eatPlantAndMeet(tn.esprit.gestionzoo.entities.Food.BOTH);
        terrestrial.eatPlantAndMeet(tn.esprit.gestionzoo.entities.Food.MEAT);
        terrestrial.eatPlantAndMeet(tn.esprit.gestionzoo.entities.Food.PLANT);


        System.out.println("\nDolphin tests:");
        dolphin2.eatMeat(tn.esprit.gestionzoo.entities.Food.MEAT);
        dolphin2.eatMeat(tn.esprit.gestionzoo.entities.Food.PLANT);
        dolphin2.eatMeat(tn.esprit.gestionzoo.entities.Food.BOTH);

       
        System.out.println("\nPenguin tests:");
        penguin2.eatMeat(tn.esprit.gestionzoo.entities.Food.MEAT);
        penguin2.eatMeat(tn.esprit.gestionzoo.entities.Food.PLANT);
        penguin2.eatMeat(tn.esprit.gestionzoo.entities.Food.BOTH);

    }
}