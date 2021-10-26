package org.hbrs.se1.ws21.uebung2;

import org.hbrs.se1.ws21.uebung2.memberklassen.FirstClassMember;
import org.hbrs.se1.ws21.uebung2.memberklassen.SecondClassMember;
import org.hbrs.se1.ws21.uebung3.persistence.PersistenceException;

import java.util.List;

public class Main {
    // Diverse Member-Objekte erzeugen,
    // in den Conatainer hinzufügen,
    // Diese wieder auslesen,
    // In MemberView zur Ausgabe übergeben

    public static void main(String[] args) {

        Container container = Container.getInstance();
        container.deleteAll();

        try {
            container.addMember(new FirstClassMember(1));
            container.addMember(new SecondClassMember(2));
            container.addMember(new FirstClassMember(3));
        } catch (ContainerException e) {
            e.printStackTrace();
        }

        MemberView mV = new MemberView();
        mV.dump(container.getCurrentList());


    }
}
