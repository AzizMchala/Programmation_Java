package tn.esprit.gestionemployes;

import java.util.*;

public class AffectationHashMap {
    private HashMap<Employe, Departement> affectations;

    public AffectationHashMap() {
        affectations = new HashMap<>();
    }
    // ajouter employé à département
    public void ajouterEmployeDepartement(Employe e, Departement d) {
        affectations.put(e, d); 
    }

    // Instruction 3 
    public void afficherEmployesEtDepartements() {
        for (Map.Entry<Employe, Departement> entry : affectations.entrySet()) {
            System.out.println("Employé : " + entry.getKey() + ", Département : " + entry.getValue());
        }
    }

    // Instruction 4 
    public void supprimerEmploye(Employe e) {
        affectations.remove(e);
    }

    // Instruction 5 
    public void supprimerEmployeEtDepartement(Employe e, Departement d) {
        if (affectations.containsKey(e) && affectations.get(e).equals(d)) {
            affectations.remove(e);
        }
    }

    // Instruction 6 
    public void afficherEmployes() {
        for (Employe e : affectations.keySet()) {
            System.out.println(e);
        }
    }

    // Instruction 7 
    public void afficherDepartements() {
        // Pour éviter les doublons
        Set<Departement> depts = new HashSet<>(affectations.values());
        for (Departement d : depts) {
            System.out.println(d);
        }
    }

    // Instruction 8 
    public boolean rechercherEmploye(Employe e) {
        return affectations.containsKey(e);
    }

    // Instruction 9 
    public boolean rechercherDepartement(Departement d) {
        return affectations.containsValue(d);
    }

    // Instruction 10 
    public TreeMap<Employe, Departement> trierMap() {
        TreeMap<Employe, Departement> triee = new TreeMap<>(affectations);
        return triee;
    }
}


