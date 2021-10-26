package org.hbrs.se1.ws21.uebung2;

import org.hbrs.se1.ws21.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws21.uebung3.persistence.PersistenceStrategy;
import org.hbrs.se1.ws21.uebung3.persistence.PresistenceStrategyImpl;

import java.util.ArrayList;
import java.util.List;

public class Container {
    // Verwendung des Design Pattern Singleton aus Übung 3
    // Damit lässt sich nur ein Objekt einer Klasse erzeugen
    /*
        Schritte:
         1- Erzeugung ein Objekt (static)
         2- Constructor der Klasse auf private setzen
         3- Implementierung einer statische Methode, die das erzeugte Objekt (1) zurückgibt.
     */

    private static Container myObject;

    private Container() {};

    public static Container getInstance() {
        if(myObject == null) {
            myObject = new Container();
            return myObject;
        }
        return myObject;
    }

    // ArrayList um die Objekte zu speichern
    private List<Member> elemente = new ArrayList<>();

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

    /* Methode würde in die Klasse MemberView verlegt.
    public void dump() {
        for(Member i: elemente) {
            System.out.println(i.toString());
        }
    }

     */

    public int size() {
        return elemente.size();
    }

    // Übung 3:

    // Die Methode store speichert Member-Objekte persistent auf einen Datenspeicher

    public void store() throws PersistenceException {
        PresistenceStrategyImpl presistenceStrategy = new PresistenceStrategyImpl();
        presistenceStrategy.openConnection();
        presistenceStrategy.save(elemente);
        presistenceStrategy.closeConnection();
    }

    // Die Methode load ladet Member-Objekte aus einem Datenspeicher

    public void load() throws PersistenceException {
        PresistenceStrategyImpl presistenceStrategy = new PresistenceStrategyImpl();
        presistenceStrategy.openConnection();
        elemente = presistenceStrategy.load();
        presistenceStrategy.closeConnection();
    }

    // Die Methode getCurrentList liefert die Liste mit den aktuellen Member-Objekte

    public List<Member> getCurrentList() {
        return elemente;
    }

    // Löscht alles zum Test Zweck

    public void deleteAll() {
        boolean b = elemente.removeAll(elemente);
    }


}
