package com.julien.bts_e4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CalculatriceTest {
    @Before
    public void setUp() throws Exception {
        calculatrice calculatrice = new calculatrice();

    }

    @Test
    public void addition() throws Exception {
        //On creer un objet neutre
        calculatrice calculatrice = new calculatrice();
        //Préparation des arguments
        double a = 1.00;
        double b = 2.00;
        //On réalise l'opération souhaitée
        double retour = calculatrice.addition(a, b);
        //On vérifie si le résulat est bon.
        assertEquals(3.00, retour, 0.00);

    }

    @Test
    public void soustraction() throws Exception {
        //On creer un objet neutre
        calculatrice calculatrice = new calculatrice();
        //Préparation des arguments
        double a = 2.00;
        double b = 1.00;
        //On réalise l'opération souhaitée
        double retour = calculatrice.soustraction(a, b);
        //On vérifie si le résulat est bon.
        assertEquals(1.00, retour, 0.00);

    }

    @Test
    public void multiplication() throws Exception {
        //On creer un objet neutre
        calculatrice calculatrice = new calculatrice();
        //Préparation des arguments
        double a = 2.00;
        double b = 1.00;
        //On réalise l'opération souhaitée
        double retour = calculatrice.multiplication(a, b);
        //On vérifie si le résulat est bon.
        assertEquals(2.00, retour, 0.00);

    }

    @Test
    public void division() throws Exception {
        //On creer un objet neutre
        calculatrice calculatrice = new calculatrice();
        //Préparation des arguments
        double a = 2.00;
        double b = 2.00;
        //On réalise l'opération souhaitée
        double retour = calculatrice.division(a,b);
        //On vérifie si le résulat est bon.
        assertEquals(1.00, retour, 0.00);

    }

}
