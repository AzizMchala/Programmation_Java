package tn.esprit.gestionzoo.entities;

public abstract class Aquatic extends Animal implements Carnivore<Food> {
    private String habitat;

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;

    }

    @Override
    public void eatMeat(Food meat) {
        if (meat == null) {
            System.out.println("Food is null and cannot be eaten.");
            return;
        }
        if (meat == Food.MEAT || meat == Food.BOTH) {
            System.out.println(getName() + " (aquatic) eats meat.");
        } else {
            System.out.println(getName() + " (aquatic) cannot eat plants only.");
        }
    }
    
    
    public String toString() {
        return super.toString() + ", Habitat: " + habitat;
    }

    public abstract void swim();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Aquatic other = (Aquatic) obj;
        return this.getName().equals(other.getName()) &&
               this.getAge() == other.getAge() &&
               this.habitat.equals(other.habitat);
    }
}
