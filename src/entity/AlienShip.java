package entity;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
*  The <code>AlienShip</code> class is used to create objects that move,
*  can increase in speed detect collisions with other objects, fire <code>Missile</code>'s to destroy
*  <code>Ship</code>'s, and be destroyed by <code>Missile</code>s fired by
*  <code>Ship</code>s.
*/ 
public class AlienShip extends Ship {
	
	/**
	 * Multiply's the speed of the <code>AlienShip</code>s as more are destroyed
	 */
	private static int speedMultiplier = 1,
					   velocityX = 1,
					   velocityY = 5;
	
	/**
	 * Is alien moving down?
	 */
	private static boolean verticalMovement = false;
	
	/**
	 * Default constructor for a <code>AlienShip</code>
	 */
	public AlienShip() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Sets all of the properties of <code>AlienShip</code>.
	 * @param x the x location
	 * @param y the y location
	 * @param width of the <code>Entity</code>
	 * @param height of the <code>Entity</code>
	 */
	public AlienShip(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	/**
	 * Sets speed of all <code>AlienShip</code>s.
	 */
	public static void setSpeedMultiplier(int speedMultiplier) {
		AlienShip.speedMultiplier = speedMultiplier;
	}
	
	/**
	 * Returns the speed of all Alien Ships
	 */

	public static int getSpeed() {
		return velocityX*speedMultiplier;
	}
	
	/**
	 * Change Direction of all Alien Ships
	 */
	public static void changeDirection() {
		velocityX = - velocityX;
	}
	
	/**
	 * Change Direction of all Alien Ships
	 */
	public static void setVerticalMovement(boolean verticalMovement) {
		AlienShip.verticalMovement = verticalMovement;
	}
	
	/**
	 * Fires a <code>Missile</code> from the <code>AlienShip</code> in the
	 * downward direction
	 */
	@Override
	public Missile fire() {
		int speed = 15; 
		Missile missile = new Missile(x + width/2, y, speed);
		return missile;
	}

	/**
	 * Destroys the <code>AlienShip</code>.
	 */
	public void destroy(){
		
	}

	/**
	 * Moves the <code>AlienShip</code> along its trajectory
	 */
	@Override
	public void move(){
		x =  x + velocityX*speedMultiplier;
		if(verticalMovement){
			y = y + velocityY*speedMultiplier;
		}
		setShape();
	}
	
	/**
	 * Paints the <code>AlienShip</code>
	 */
	@Override
	public void paint(Graphics pane) {
		pane.setColor(color.black);
		pane.fillRect(x, y, width, height);
	}
	
	/**
	 * Sets the shape of the <code>AlienShip</code>.
	 */
	@Override
	public void setShape() {
		shape = new Rectangle(x, y, width, height);
	}
	
}
