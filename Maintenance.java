import java.util.*;

public class Maintenance  {

  private Machines mach;
  private Inspection ins;
  private Control c;

  //setter
  public void setInspection(Inspection ins) { this.ins = ins; }

  //getter
  public Inspection getInspection() {return ins;}


  public void listMaintenanceRequest(Map<String, Boolean> map){ //shows what needs to be fixed from inspection

    System.out.println("Here are the machines that will be fixed");
    for (Map.Entry<String, Boolean> i : map.entrySet()) {
      System.out.println(i.getKey());
    }
  }

  public void fixMachines(Map<String, Boolean> map){ //changes broken machines to true

    //updates the map
    map.replaceAll((key, value) -> true);

    for (Map.Entry<String, Boolean> i: map.entrySet()){
      System.out.println(i.getKey() + ": " + i.getValue());
    }
    System.out.println("The machines are now all working");
  }

  public Facility fixFacility(){ //changes the faciity state to resting

    if (ins.getFacility().getState().toString().equals("BROKEN"))
    {
      System.out.println("The current state is " + ins.getFacility().getState() + " it will to change to RESTING");
      c.vacateFacility(ins.getFacility());
      System.out.println("The state is now " + ins.getFacility().getState());
      return ins.getFacility();
    }
    else
    {
      return ins.getFacility();
    }
  }
}

