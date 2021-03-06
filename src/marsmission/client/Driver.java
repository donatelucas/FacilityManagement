package marsmission.client;

// MarsMission
import marsmission.domain.*;
import marsmission.dataaccess.*;

// Java
import java.awt.*;
import java.util.*;

// Spring
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        System.out.println("***************** Woot, off to Mars, babe! ******************");
        Facility apollo = (Facility) context.getBean("facility");
        FacilityInformation fi = (FacilityInformation) context.getBean("facilityInformation");
        Maintenance maint = (Maintenance) context.getBean("maintenance");
        Management man = (Management) context.getBean("management");
        StatesFaçade sf = (StatesFaçade) context.getBean("statesFaçade");
        VisitorImpl v = (VisitorImpl) context.getBean("visitorImpl");

        System.out.println("\n");
        apollo.setStateWorking(apollo); // Looks weird, but it's not about looks, babe

        System.out.println("**** INJECTION ****");
        apollo.getFacilityInformation().setName("Apollo");
        System.out.println("This facility is called: " + apollo.getFacilityInformation().getName());
        System.out.println("The state was set to: " + apollo.getState());

        System.out.println("\n");

        apollo.startMachines();
        apollo.getOxygenator().setStatus(false);
        apollo.getInnerAirlocks().setStatus(true);
        apollo.getExternalAirlocks().setStatus(true);
        apollo.getNuclearReactor().setStatus(true);
        apollo.getComms().setStatus(true);
        apollo.getWaterExtraction().setStatus(true);
        apollo.startUpdateMap();
        System.out.println("Apollo's Oxygenator is: " + apollo.getOxygenator().status());
        System.out.println("Apollo's Inner Airlock is: " + apollo.getInnerAirlocks().status());
        System.out.println("Apollo's External Airlock is: " + apollo.getExternalAirlocks().status());
        System.out.println("Apollo's Nuclear Reactor is: " + apollo.getNuclearReactor().status());
        System.out.println("Apollo's Comms is: " + apollo.getComms().status());
        System.out.println("Apollo's WaterExtraction is: " + apollo.getWaterExtraction().status());

        System.out.println("\n");
        System.out.println("Testing Visitor");
        apollo.getComms().accept(v);
        apollo.getExternalAirlocks().accept(v);
        apollo.getNuclearReactor().accept(v);
        apollo.getWaterExtraction().accept(v);
        apollo.getOxygenator().accept(v);
        apollo.getInnerAirlocks().accept(v);
        System.out.println("\n");

        Inspection i = maint.getInspection();
        apollo.addObserver(i);
        i.setFacility(apollo);
        i.returnBorkenMachines(apollo.getMap());
        i.update();
        sf.getStateBroken().setStateBroken(apollo);

        apollo.hasChanged();
        apollo.setChanged();
        apollo.notify(i);

        System.out.println("Testing Maintenance");
        maint.setInspection(i);
        maint.setStatesFaçade(sf);
        maint.listMaintenanceRequest(i.returnBorkenMachines(apollo.getMap()));
        System.out.println("\n");

        System.out.println("Fixing the machines:");
        maint.fixMachines(apollo.getMap());
        maint.fixFacility();


        System.out.println("\n");
        System.out.println("Testing Management on Apollo");
        man.actualUsage(1);
        man.problemRateFacility(6, 1);
        man.requestAvailableCapacity(1);

        System.out.println("\n");

        System.out.println("Calculating Apollo's finances");
        Finance f = man.getFinance();
        apollo.addObserver(f);
        f.setRatePerHour(3.05);
        f.setMaintHourlyCost(50);
        f.calcUsage(1, 8);
        f.calcMaintCostFacility(1, 5);
        f.calcDowntimeFacility(6);
        f.update();

        apollo.hasChanged();
        apollo.setChanged();
        apollo.notify(f);

        System.out.println("\n");
        System.out.println("Removing the Observers");
        apollo.deleteObserver(i);
        apollo.deleteObserver(f);

        if (apollo.checkObserver() == false)
            System.out.println("The Observers have been removed");
        else
            System.out.println("The Observers have not been removed");

    }
}

