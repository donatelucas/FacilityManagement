package marsmission.domain;

public class ExternalAirlocks implements MachinesInterface {
    private Facility fac;
    private boolean status;
    public void setFacility(Facility fac) { this.fac = fac; }

    public Facility getFacility() { return fac; }

    public void machine(){
        System.out.println("External Airlocks");
    }

    public void setStatus(boolean s){
        this.status = s;
    }

    public boolean status(){
        return status;
    }
}
