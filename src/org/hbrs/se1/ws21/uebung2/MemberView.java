package org.hbrs.se1.ws21.uebung2;

import java.util.List;

public class MemberView {

    // dump: nimmt eine List<Member> aus gibt es aus
    public void dump(List<Member> liste) {
        for (Member element: liste) {
            System.out.println(element);
        }
    }
}
