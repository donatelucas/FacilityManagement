import java.util.Map;
import java.util.HashMap;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class WriteFile {

    public String fileName;
    FacilityMachines fm = new FacilityMachines();
    private Map<String, Boolean> m = new HashMap<String, Boolean>();
    PrintWriter oStream = null;

    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    public String getFileName(){
        return fileName;
    }

    // Copies static map from FacilityMachines to WriteFile
    public void copyMap() {
        for (Map.Entry<String, Boolean> i: fm.getMap().entrySet()){
            m.put(i.getKey(), i.getValue());
        }
    }

    public void saveFacilityInfo(Facility fac){

        try {
            oStream = new PrintWriter(getFileName());
        }
        catch (FileNotFoundException e) {
            System.out.println("Error saving the file " + fileName + ". I can't provide more information because I'm a computer. Beep Boop.");
            System.exit(0);
        }

        // This thing can probably be improved with some data structure to get the functions, maybe a loop with a switch statement.
        // Reads getters from Facility
        int i = 0;
        String name = fac.getName();
        oStream.println(i + "Name: " + name + ".");
        i++;
        int refNumber = fac.getRefNumber();
        oStream.println(i + ": " + refNumber + ".");
        i++;
        String address = fac.getAddress();
        oStream.println(i + ": " + address + ".");
        i++;
        String description = fac.getDescription();
        oStream.println(i + ": " + description + ".");
        i++;
        int capacity = fac.getCapacity();
        oStream.println(i + ": " + capacity + ".");
        i++;
        double cost = fac.getCost();
        oStream.println(i + ": " + cost + ".");
        i++;
        int problemRate = fac.getProblemRate();
        oStream.println(i + ": " + problemRate + ".");
        i++;

        copyMap();
        for (Map.Entry<String, Boolean> j: m.entrySet()){
            String s = j.getKey();
            boolean b = j.getValue();
            oStream.println(i + ": " + s + " = " + b + ". ");
            i++;
        }

        oStream.close();
        System.out.println("File has been saved.");
    }
}
