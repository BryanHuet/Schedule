package filrouge;
import filrouge.constraints.*;
import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;


public class InteractiveScheduling {
	public static void main (String [] args) {
/*
    Scanner scanner = new Scanner(System.in);
    System.out.println("Entrez le nombre d'activites voulu");
    int nb = scanner.nextInt();
    int duree=0;String desc;
    ArrayList<Activity> activities = new ArrayList();
    for (int i=0;i<nb;i++){
      System.out.println("Description de lactivite");
      desc=scanner.next();
      System.out.println("Duree de lactivite");
      duree = scanner.nextInt();
      Activity act = new Activity(desc,duree);
      activities.add(act);
    }
    scanner.close();

    for(Activity i : activities){
    System.out.println(i.getDescription());
  }*/




	Scanner scanner2 = new Scanner(System.in);
	String rep;
	System.out.println("Souhaitez-vous entrez une liste d'activité et de contraintes? y/n");
	rep=scanner2.next();
	if (! (rep.compareTo("y")==0)){
		  // Some activities
	  Activity cafe = new Activity ("Boire un café", 10);
	  Activity cours = new Activity ("Cours de POO", 30);
	  Activity campus = new Activity ("Aller au campus", 15);
	  Activity lireMail = new Activity ("Lire mon courrier électronique", 5);
	  List<Activity> activities = Arrays.asList (cafe, lireMail, campus,cours);
	  // Definition of constraints
	  PrecedenceConstraint c1 = new PrecedenceConstraint (cafe, campus);
	  PrecedenceConstraint c2 = new PrecedenceConstraint (campus, cours);
	  PrecedenceConstraint c3 = new PrecedenceConstraint (lireMail, cours);
	  List<PrecedenceConstraint> allConstraints = Arrays.asList (c1, c2, c3);
		//user entre les horaires des activités definies, le programme stock l'activité et lheure dans un hashmap
	  Scanner scanner = new Scanner(System.in);
	  int duree;
	  HashMap<Activity, Integer> emploiDuTemps = new HashMap<Activity, Integer> ();
	  for (Activity i: activities){
	    System.out.println("Saisissez l'horaire de l'activite : "+i.getDescription());
	    duree = scanner.nextInt();
	    emploiDuTemps.put(i,duree);
	  }
	  scanner.close();
		// On instancie un verifieur
	  Verifier verifieur = new Verifier();
	  // on ajoute des contraintes au verifieur;
	  verifieur.add(new PrecedenceConstraint(cafe, campus));
	  verifieur.add(new MeetConstraint(lireMail, cours));

	  // Contrainte : activité1, activité2 et activité3 doivent toutes
	  // être exécutées en au plus 90 minutes
	  ArrayList<Activity> ensemble = new ArrayList<> ();
	  ensemble.add(cafe);
	  ensemble.add(campus);
	  ensemble.add(lireMail);
		MaxSpanConstraint contrainteEnsemble = new MaxSpanConstraint(ensemble, 90);
	  verifieur.add(contrainteEnsemble);

		//test final :
	  System.out.println("L'emploi du temps satisfait-il toutes les contraintes ? ");
	  if (! verifieur.verify(emploiDuTemps)) {
	      System.out.println("Non");
	  } else {
	      System.out.println("Oui");
	  }

	}
 }
}