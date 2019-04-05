package marsmission.client;

// MarsMission
import marsmission.domain.*;
import marsmission.dataaccess.*;

// Java
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
        Finance f = (Finance) context.getBean("finance");
        Control c = (Control) context.getBean("control");

        apollo.setName("Apollo");
        System.out.println("\n");
        apollo.setStateWorking(apollo); // Looks weird, but it's not about looks, babe
        System.out.println("This facility is called: " + apollo.getName());
        System.out.println("The state was set to: " + apollo.getState());

        System.out.println("\n");
        System.out.println("**** INJECTION ****");
        apollo.getOxygenator().setStatus(true);
        apollo.getInnerAirlocks().setStatus(true);
        apollo.getExternalAirlocks().setStatus(true);
        apollo.getNuclearReactor().setStatus(true);
        apollo.getComms().setStatus(true);
        apollo.getWaterExtraction().setStatus(true);
        apollo.getOxygenator().setFacility(apollo);
        System.out.println("This Machinery belongs to: " + apollo.getOxygenator().getFacility().getName()); // Apollo is set through injection and then name is checked through injection, take that, Inception!
        System.out.println("Apollo's Oxygenator is: " + apollo.getOxygenator().status());
        System.out.println("Apollo's Inner Airlock is: " + apollo.getInnerAirlocks().status());
        System.out.println("Apollo's External Airlock is: " + apollo.getExternalAirlocks().status());
        System.out.println("Apollo's Nuclear Reactor is: " + apollo.getNuclearReactor().status());
        System.out.println("Apollo's Comms is: " + apollo.getComms().status());
        System.out.println("Apollo's WaterExtraction is: " + apollo.getWaterExtraction().status());

        // State Change
        System.out.println("\n");
        apollo.addObserver(f);
        System.out.println("Has the state changed in Facility? " + apollo.hasChanged());
        apollo.getOxygenator().setStatus(false);
        c.setStateBroken(apollo);
        apollo.setChanged();
        System.out.println("Apollo is now: " + apollo.getState());
        System.out.println("Apollo's oxygenator is: " + apollo.getOxygenator().status());
        System.out.println("Has the state changed? " + apollo.hasChanged());

        // Finance check
        apollo.notify(f);
        f.update(apollo);


    }
}
