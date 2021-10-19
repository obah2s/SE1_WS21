package org.hbrs.se1.ws21.uebung2;

import java.util.ArrayList;
import java.util.HashMap;

public class Container {
    // ArrayList um die Objekte zu speichern
    private ArrayList<Member> elemente = new ArrayList<>();

    public void addMember(Member member) throws ContainerException {
        for(Member i: elemente) {
            if(i.getID().equals(member.getID())) { // i.getID() == member.getID()
                throw new ContainerException("Das Member-Objekt mit der ID ["+ i.getID() +"] ist be- reits vorhanden!");
            }
        }
        elemente.add(member);
    }

    public String deleteMember(Integer id) {
        int position = 0;
        for(Member i: elemente) {
            if(!i.getID().equals(id)) {
                position++;
            }
            else if(i.getID().equals(id)) {
                elemente.remove(position);
                return "Das Member-Objekt mit der ID ["+ id +"] wurde erfolgreich gelöscht!";
            }
        }
        return "Das Member-Objekt mit der ID ["+ id +"] ist nicht vorhanden!";
    }

    public void dump() {
        for(Member i: elemente) {
            System.out.println(i.toString());
        }
    }

    public int size() {
        return elemente.size();
    }

}
