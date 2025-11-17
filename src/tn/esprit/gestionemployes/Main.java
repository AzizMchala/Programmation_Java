package tn.esprit.gestionemployes;

public class Main {
    public static void main(String[] args) {
        DepartementHashSet gestion = new DepartementHashSet();

        Departement d1 = new Departement(1, "Informatique", 10);
        Departement d2 = new Departement(2, "RH", 5);
        Departement d3 = new Departement(3, "Comptabilité", 8);
        Departement d4 = new Departement(2, "RH", 5); // pour tester l'égalité

        // Ajout
        gestion.ajouterDepartement(d1);
        gestion.ajouterDepartement(d2);
        gestion.ajouterDepartement(d3);
        gestion.ajouterDepartement(d4); // doublon, ne doit pas s'ajouter

        System.out.println("-- Liste après ajouts --");
        gestion.displayDepartement();

        // Recherche par nom
        System.out.println("\nRecherche nom 'RH' : " + gestion.rechercherDepartement("RH"));
        System.out.println("Recherche nom 'Finance' : " + gestion.rechercherDepartement("Finance"));

        // Recherche par objet
        System.out.println("\nRecherche d2 : " + gestion.rechercherDepartement(d2));
        System.out.println("Recherche departement inexistant : " + gestion.rechercherDepartement(new Departement(99, "Test", 0)));

        // Suppression
        gestion.supprimerDepartement(d2);
        System.out.println("\n-- Liste après suppression RH --");
        gestion.displayDepartement();

        // Tri par id
        System.out.println("\n-- Tri par id --");
        for (Departement d : gestion.trierDepartementById()) {
            System.out.println(d);
        }
    }
}
