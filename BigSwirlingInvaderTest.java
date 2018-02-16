package ca.ubc.cs.cpsc210.spaceinvaders.test;

import ca.ubc.cs.cpsc210.spaceinvaders.model.BigSwirlingInvader;
import ca.ubc.cs.cpsc210.spaceinvaders.model.Invader;
import ca.ubc.cs.cpsc210.spaceinvaders.model.Missile;
import ca.ubc.cs.cpsc210.spaceinvaders.model.SIGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BigSwirlingInvaderTest {

    private static final int XLOC = SIGame.WIDTH / 2;
    private static final int YLOC = 50;
    private BigSwirlingInvader bigSwirlingInvader;

    @BeforeEach
    public void runBefore() {
        bigSwirlingInvader = new BigSwirlingInvader(XLOC, YLOC);
    }

    @Test
    public void testConstructor() {
        assertEquals(XLOC, bigSwirlingInvader.getX());
        assertEquals(YLOC, bigSwirlingInvader.getY());
    }

    @Test
    public void testUpdate() {
        final int NUM_UPDATES = 8;

        bigSwirlingInvader.move();
        // can't test XLOC due to random jiggle behaviour
        assertEquals(YLOC + 2*BigSwirlingInvader.DY, bigSwirlingInvader.getY());

        for(int count = 1; count < NUM_UPDATES; count++) {
            bigSwirlingInvader.move();
        }

        assertEquals(YLOC + 2*NUM_UPDATES * BigSwirlingInvader.DY, bigSwirlingInvader.getY());
    }

    @Test
    public void testCollideWith() {
        Missile m = new Missile(0, 0);
        assertFalse(bigSwirlingInvader.collidedWith(m));

        m = new Missile(bigSwirlingInvader.getX(), bigSwirlingInvader.getY());
        assertTrue(bigSwirlingInvader.collidedWith(m));

        m = new Missile(bigSwirlingInvader.getX() + BigSwirlingInvader.SIZE_X / 2, bigSwirlingInvader.getY());
        assertTrue(bigSwirlingInvader.collidedWith(m));

        m = new Missile(bigSwirlingInvader.getX() + BigSwirlingInvader.SIZE_X / 2 + Missile.SIZE_X / 2, bigSwirlingInvader.getY());
        assertFalse(bigSwirlingInvader.collidedWith(m));

        m = new Missile(bigSwirlingInvader.getX() - BigSwirlingInvader.SIZE_X / 2, bigSwirlingInvader.getY());
        assertTrue(bigSwirlingInvader.collidedWith(m));

        m = new Missile(bigSwirlingInvader.getX() - BigSwirlingInvader.SIZE_X / 2 - Missile.SIZE_X / 2, bigSwirlingInvader.getY());
        assertFalse(bigSwirlingInvader.collidedWith(m));

        m = new Missile(bigSwirlingInvader.getX(), bigSwirlingInvader.getY() + BigSwirlingInvader.SIZE_Y / 2);
        assertTrue(bigSwirlingInvader.collidedWith(m));

        m = new Missile(bigSwirlingInvader.getX(), bigSwirlingInvader.getY() + BigSwirlingInvader.SIZE_Y / 2 + Missile.SIZE_Y / 2);
        assertFalse(bigSwirlingInvader.collidedWith(m));
    }

}
