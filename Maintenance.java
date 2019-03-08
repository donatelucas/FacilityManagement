import java.util.*;

public class Maintenance  {

  private Machines mach;
  private Inspection ins;
  private Control c;

  //setter
  public void setInspection(Inspection ins) { this.ins = ins; }

  public void setMach(Machines mach) { this.mach = mach; }

  public void setControl(Control c) {this.c = c;}

  //getter
  public Inspection getInspection() {return ins;}

  public Machines getMach() {return mach;}

  public Control getControl(){return c;}

  public void listMaintenanceRequest(Map<String, Boolean> map){ //shows what needs to be fixed from inspection

    System.out.println("Here are the machines that will be fixed");
    for (Map.Entry<String, Boolean> i : map.entrySet()) {
      System.out.println(i.getKey());
    }
  }

  public boolean[] fixMachines(boolean[] machines){ //changes broken machines to true

    System.out.println("The machines are now all working");

    for (int i = 0; i < machines.length; i++) {
      if (machines[i] == false){
        machines[i] = true;
        System.out.println(i + " " + machines[i]);
      }
    }
    return machines;
    //mach.update();
    //mach.getFacilityStatus();
    }

  public Facility fixFacility(){ //changes the faciity state to resting

    if (ins.getFacility().getState().toString().equals("BROKEN"))
    {
      System.out.println("This state is broken, it is going to change to RESTING");
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

