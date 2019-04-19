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
        apollo.getComms().setStatus(false);
        apollo.getWaterExtraction().setStatus(true);
        apollo.getOxygenator().setFacility(apollo);
        apollo.startUpdateMap();
        /*System.out.println("Apollo's Oxygenator is: " + apollo.getOxygenator().status());
        System.out.println("Apollo's Inner Airlock is: " + apollo.getInnerAirlocks().status());
        System.out.println("Apollo's External Airlock is: " + apollo.getExternalAirlocks().status());
        System.out.println("Apollo's Nuclear Reactor is: " + apollo.getNuclearReactor().status());
        System.out.println("Apollo's Comms is: " + apollo.getComms().status());
        System.out.println("Apollo's WaterExtraction is: " + apollo.getWaterExtraction().status()); */



















    }
}