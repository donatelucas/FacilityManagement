package marsmission.domain;
import java.util.*;
import java.lang.Object;

public class Inspection implements InspectionInterface, Observer {

    private static Facility fac;
    private Maintenance m;
    public void update(Object arg) {}

    //setters
    public void setFacility(Facility fac) { this.fac = fac; }
    public void setMaintenance(Maintenance m){
        this.m = m;
    }

    //getters
    public Facility getFacility() {return fac;}
    public Maintenance getMaintenance(){
        return m;
    }
    public boolean isBroken(){

        if (fac.getState().toString().equals("BROKEN"))
            return true;
        else
            return false;
    }

    public boolean makeMaintenanceRequest(){

        if (fac.getState().toString().equals("BROKEN")){
            System.out.println("This facility needs maintenance"); //for testing
            return true;
        }
        else {
            System.out.println("This facility does not need maintenance"); //for testing
            return false;
        }

    }

    public void getFacilityStatus(Map<String, Boolean> map){ // The status of any Facility map
        for (Map.Entry<String, Boolean> i: map.entrySet()){
            System.out.println(i.getKey() + ": " + i.getValue());
        }
    }

    public Map<String, Boolean> returnBrokenMachines(Map<String, Boolean> map){
        Map<String, Boolean> iMap = new HashMap<String, Boolean>();

        for(Map.Entry<String, Boolean> i: map.entrySet()){
            if (!i.getValue()){
                iMap.put(i.getKey(), i.getValue());
            }
        }
        return iMap;
    }
}
