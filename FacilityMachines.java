import java.util.*;

public class FacilityMachines extends Facility {

    private boolean oxygenator, innerAirlocks, externalAirlocks,
    comms, nuclearReactor, waterMaking;
    private Map<String, Boolean> map = new HashMap<String, Boolean>();
    private final int numberOfMachines = 7;
    // Store a Hashmap with the keys as the variables, and return it.
    // Maybe extending the StateMachine is needed

    FacilityMachines() {
        super(name, refNumber);
    }

    public void Oxygenator(boolean oxygenator){
        this.oxygenator = oxygenator;
    }

    public boolean NuclearReactor(boolean nuclearReactor){
        return this.nuclearReactor = nuclearReactor;
    }

    public boolean InnerAirlocks(boolean innerAirlocks){
        return this.innerAirlocks = innerAirlocks;
    }

    public boolean ExternalAirlocks(boolean externalAirlocks){
        return this.externalAirlocks = externalAirlocks;
    }

    public boolean nuclearReactor(boolean nuclearReactor){
        return this.nuclearReactor = nuclearReactor;
    }

    public boolean Comms(boolean comms){
        return this.comms = comms;
    }

    public boolean WaterMaking(boolean waterMaking){
        return this.waterMaking = waterMaking;
    }

    /*
        Not a great use of SRP (single responsibility principle) here, I know, but we never discussed a way for
        people using the interface to be able to add services, and that being
        streamlined automatically, so here is why it is like this.
    */
    public void getFacilityStatus(){ //parts of a facility, check if they are working
        map.put("Oxygenator", oxygenator);
        map.put("Inner Airlocks", innerAirlocks);
        map.put("External Airlocks", externalAirlocks);
        map.put("Nuclear Reactor", nuclearReactor);
        map.put("Comms", comms);
        map.put("WaterMaking", waterMaking);

        for (Map.Entry<String, Boolean> i: map.entrySet()){
            System.out.println(i.getKey() + ": " + i.getValue());
        }
    }
}
