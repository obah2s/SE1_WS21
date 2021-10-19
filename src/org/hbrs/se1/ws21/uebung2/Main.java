package org.hbrs.se1.ws21.uebung2;

import org.hbrs.se1.ws21.uebung2.memberklassen.FirstClassMember;
import org.hbrs.se1.ws21.uebung2.memberklassen.SecondClassMember;

public class Main {

    public static void main(String[] args) {
        Container container = new Container();

        Member member1 = new FirstClassMember(1);
        Member member2 = new SecondClassMember(2);
        Member member3 = new FirstClassMember(3);
        Member member4 = new SecondClassMember(3);

        try {
            container.addMember(member1);
            container.addMember(member2);
            container.addMember(member3);
            //container.addMember(member4);
            System.out.println("Container size: "+ container.size());
        } catch (ContainerException e) {
            e.printStackTrace();
        }
        container.deleteMember(3);
        System.out.println("Container size: "+ container.size());


        container.dump();

    }
}
