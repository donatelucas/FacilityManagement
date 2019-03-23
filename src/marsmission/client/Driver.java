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
        Machines m = (Machines) context.getBean("machines");
        m.setName("Apollo");
        System.out.println("\n");
        System.out.println("**** Injection **** ");
        m.setStateWorking(m);
        System.out.println("This facility is called: " + m.getName());
        System.out.println("The state was set to: " + m.getState());

        System.out.println("Apollo's machines just broke");
        m.breakMachines();
        Control c = m.getControl();
        c.shitIsBroken(m);
        System.out.println("The state is now: " + m.getState());

        System.out.println("---------------------------");

        System.out.println("Time to run an inspection");
        Inspection ins = (Inspection) context.getBean("inspection");
        ins.setFacility(m);
        //ins.isBroken();
        ins.makeMaintenanceRequest();
        //ins.checkMachines(m.getMap());
        ins.returnBrokenMachines(m.getMap(), m.getMachines());

        System.out.println("---------------------------");

        System.out.println("Maintenance will fix any broken machines");
        Maintenance maint = ins.getMaintenance();
        maint.setInspection(ins);
        maint.setControl(c);
        //ins.listMaintenanceRequest();



    }
}
