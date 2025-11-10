package tn.esprit.gestionzoo.entities;

public class Terrestrial extends Animal implements Omnivore<Food> {
    private int nbrLegs;

    public Terrestrial(String family, String name, int age, boolean isMammal, int nbrLegs) {
        super(family, name, age, isMammal);
        this.nbrLegs = nbrLegs;
    }

    @Override
    public void eatMeat(Food meat) {
        if (meat == null) {
            System.out.println("Food is null and cannot be eaten.");
            return;
        }
        if (meat == Food.MEAT || meat == Food.BOTH) {
            System.out.println(getName() + " (terrestrial) eats meat.");
        } else {
            System.out.println(getName() + " (terrestrial) cannot eat plants only for meat.");
        }
    }

    @Override
    public void eatPlant(Food plant) {
        if (plant == null) {
            System.out.println("Food is null and cannot be eaten.");
            return;
        }
        if (plant == Food.PLANT || plant == Food.BOTH) {
            System.out.println(getName() + " (terrestrial) eats plants.");
        } else {
            System.out.println(getName() + " (terrestrial) cannot eat meat only for plants.");
        }
    }

    @Override
    public void eatPlantAndMeet(Food food) {
        if (food == null) {
            System.out.println("Food is null and cannot be eaten.");
            return;
        }
        if (food == Food.BOTH) {
            System.out.println(getName() + " (terrestrial) eats both meat and plants.");
        } else if (food == Food.MEAT) {
            System.out.println(getName() + " (terrestrial) eats meat now and will eat plants later.");
        } else {
            System.out.println(getName() + " (terrestrial) eats plants now and will eat meat later.");
        }
    }
}


