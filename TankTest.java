package ca.ubc.cs.cpsc210.spaceinvaders.test;

import ca.ubc.cs.cpsc210.spaceinvaders.model.SIGame;
import ca.ubc.cs.cpsc210.spaceinvaders.model.Tank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * Unit tests for the Tank class.
 */
public class TankTest {
	private static final int XLOC = SIGame.WIDTH / 2;
	private Tank tank;
	
	@BeforeEach
	public void runBefore() {
		tank = new Tank(XLOC);
	}
	
	@Test
	public void testGetX() {
		assertEquals(tank.getX(),XLOC);
	}
    @Test
    public void testIsFacingRight() {
        assertTrue(tank.isFacingRight());
        tank.faceLeft();
        assertFalse(tank.isFacingRight());
    }
    @Test
    public void testFaceRight() {
	    tank.faceRight();
        tank.faceLeft();
        tank.faceRight();
        assertTrue(tank.isFacingRight());
    }
    @Test
    public void testFaingLeft() {
        tank.faceRight();
        tank.faceLeft();
        tank.faceLeft();
        tank.faceLeft();
        tank.faceRight();
        tank.faceLeft();
        assertFalse(tank.isFacingRight());
    }

    @Test
    public void testMove() {
	    tank.move();
	    assertEquals(tank.getX(), XLOC+tank.DX);
        tank.faceLeft();
        tank.move();
        tank.move();
        assertEquals(tank.getX(), XLOC-tank.DX);

    }

    @Test
    public void testHandleBoundary() {
	    Tank tankOutOfBoundary = new Tank(SIGame.WIDTH );
	    tankOutOfBoundary.move();
	    assertEquals(tankOutOfBoundary.getX(),SIGame.WIDTH);
        assertEquals(tank.getX(), XLOC);

    }
}
