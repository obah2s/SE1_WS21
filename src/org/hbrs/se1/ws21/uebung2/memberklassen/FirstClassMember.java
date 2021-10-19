package org.hbrs.se1.ws21.uebung2.memberklassen;

import org.hbrs.se1.ws21.uebung2.Member;

public class FirstClassMember implements Member {
    private Integer id;
    public FirstClassMember(Integer id) {
        this.id = id;
    }
    @Override
    public Integer getID() {
        return id;
    }

    @Override
    public String toString() {
        return "FirstClassMember (ID = " + id + " )";
    }
}
