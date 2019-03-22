package mmtest.domain;
import java.util.*;

public interface FacilityInterface {

    // Setters
    public void setName(String name);

    public void setAddress(String address);

    public void setDescription(String description);

    public void setRefNumber(int refNumber);

    public void setCapacity(int capacity);

    public void setCost(double cost);

    public void setProblemRate(int problemRate);

    // Getters
    public String getName();

    public String getAddress();

    public String getDescription();

    public int getRefNumber();

    public int getCapacity();

    public double getCost();

    public int getProblemRate();

    public State getState();
}