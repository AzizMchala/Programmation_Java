package tn.esprit.gestionemployes;

import java.util.List;

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

        // ================== TESTS Etudiant et StudentManagement ====================
        System.out.println("\n===== GESTION DES ETUDIANTS =====\n");
        StudentManagement studentGestion = new StudentManagement();
        List<Etudiant> etudiants = new java.util.ArrayList<>();
        etudiants.add(new Etudiant(3, "Ali", 21));
        etudiants.add(new Etudiant(1, "Sara", 22));
        etudiants.add(new Etudiant(2, "Omar", 23));

        // Affichage simple
        System.out.println("-- Tous les étudiants :");
        studentGestion.displayStudents(etudiants, e -> System.out.println(e));

        // Affichage filtré (âge > 21)
        System.out.println("\n-- Étudiants ayant plus de 21 ans :");
        studentGestion.displayStudentsByFilter(etudiants, e -> e.getAge() > 21, e -> System.out.println(e));

        // Récupération des noms
        String noms = studentGestion.returnStudentsNames(etudiants, Etudiant::getNom);
        System.out.println("\nNoms des étudiants : " + noms);

        // Création d'un étudiant via Supplier
        Etudiant nouveau = studentGestion.createStudent(() -> new Etudiant(4, "Amina", 20));
        etudiants.add(nouveau);
        System.out.println("\nAprès ajout d'Amina :");
        studentGestion.displayStudents(etudiants, System.out::println);

        // Tri par id
        List<Etudiant> sorted = studentGestion.sortStudentsById(etudiants, java.util.Comparator.comparingInt(Etudiant::getId));
        System.out.println("\nÉtudiants triés par id :");
        sorted.forEach(System.out::println);

        // Stream :
        System.out.println("\nListe convertie en Stream (toString):");
        studentGestion.convertToStream(etudiants).forEach(System.out::println);

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
