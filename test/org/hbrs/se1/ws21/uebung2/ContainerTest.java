package org.hbrs.se1.ws21.uebung2;

import org.hbrs.se1.ws21.uebung2.memberklassen.FirstClassMember;
import org.hbrs.se1.ws21.uebung2.memberklassen.SecondClassMember;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    Container container;
    @BeforeEach
    void setUp() {
        container = Container.getInstance();
        container.deleteAll();
    }

    @AfterEach
    void tearDown() {
        container = null;
    }

    @Test
    void addMember() throws ContainerException {
        container.addMember(new FirstClassMember(1));
        container.addMember(new FirstClassMember(2));
        assertThrows(ContainerException.class, ()-> container.addMember(new SecondClassMember(2)), "Es sollte eine ContainerException geworfen!");
    }

    @Test
    void deleteMember() throws ContainerException {
        container.addMember(new FirstClassMember(1));
        container.addMember(new FirstClassMember(2));
        assertEquals(2, container.size(), "Es sollte 2 sein");
        container.deleteMember(2);
        assertEquals(1, container.size(),"Es sollte 1 sein");
    }

    @Test
    void size() throws ContainerException {
        container.addMember(new FirstClassMember(1));
        container.addMember(new FirstClassMember(2));
        assertEquals(2, container.size(), "Es sollte 2 sein");
        container.deleteMember(2);
        assertEquals(1, container.size(),"Es sollte 1 sein");
    }
}