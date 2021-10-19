package org.hbrs.se1.ws21.uebung2.memberklassen;

import org.hbrs.se1.ws21.uebung2.Member;

public class SecondClassMember implements Member {
    private Integer id;

    public SecondClassMember(Integer id) {
        this.id = id;
    }
    @Override
    public Integer getID() {
        return id;
    }

    @Override
    public String toString() {
        return "SecondClassMember (ID = " + id + " )";
    }
}
