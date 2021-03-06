package scheduling;

import constraints.Activity;
import constraints.Constraint;

import java.util.ArrayList;
import java.util.HashMap;

public class Verifier {
  protected ArrayList<Constraint> list;

  public Verifier() {
    this.list = new ArrayList<>();
  }

  public void add(Constraint contrainte){
    if ( ! this.list.contains(contrainte)){
      this.list.add(contrainte);
    }
  }

  public boolean verify(HashMap<Activity, Integer> hmap){
    for(Constraint c: this.list){
      if ( ! c.isSatisfiedBySchedule(hmap)){
        System.out.println("Constaint: "+c.getName()+" is not valid");
        return false;
      }
    }
    return true;
  }

}
