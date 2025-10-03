package tn.esprit.gestionzoo.main;
import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;
public class Main {
    public static void main(String[] args) {

        Animal lion = new Animal("Félin", "Lion", 5, true);
        Animal lion1 = new Animal("Félin", "lion", 5, true);
        Animal lapin = new Animal("Rongeur", "Lapin", 2, true);
        Animal elephant = new Animal("Éléphantidé", "Éléphant", 10, true);
        Animal girafe = new Animal("Giraffidé", "Girafe", 8, true);
        Zoo z1 = new Zoo("ZooFrance", "Paris");
        z1.addAnimal(lion);
        z1.addAnimal(elephant);
        z1.addAnimal(lapin);

        /*myZoo.displayZoo();*/
        Zoo z2 = new Zoo("ZooTunis", "Paris");
        z2.addAnimal(lion);
        z2.addAnimal(elephant);
        z2.addAnimal(lapin);

        if(Zoo.comparerZoo(z1,z2)== null){
            System.out.println("egale");
        }
        else{
            System.out.println(Zoo.comparerZoo(z1, z2));
        }
        lion.setAge(7);
        System.out.println("setAge(7) : " + lion);


        System.out.println("setAge(-3) : " + lion);
        lion.setAge(-3);


        Zoo zoo2 = new Zoo("aaaa", "Sfax");
        System.out.println("Nom du zoo : " + zoo2.getName());
        zoo2.setName(null);
        System.out.println("Nom après setName : " + zoo2.getName());
        zoo2.setName("");
        System.out.println("Nom après setName : " + zoo2.getName());

        zoo2.addAnimal(lion);
        zoo2.addAnimal(elephant);
        zoo2.addAnimal(lapin);
        System.out.println("Nom du zoo : " + zoo2);
        /*int test=myZoo.searchAnimal(lion);
        System.out.println(test);
        int test1=myZoo.searchAnimal(lion1);
        System.out.println(test1);*/

        //myZoo.removeAnimal(girafe);
        /*z1.isZooFull();*/


    }
}