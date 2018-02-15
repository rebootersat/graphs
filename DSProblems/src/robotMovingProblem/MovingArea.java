package robotMovingProblem;

public class MovingArea {

	private int xPosition;
	private int yPosition;

	public void move(char command) {
		Direction direction = null;
		if (command == 'L')
			direction = Direction.LEFT;
		else if (command == 'R')
			direction = Direction.RIGHT;
		else if (command == 'U')
			direction = Direction.UP;
		else if (command == 'D')
			direction = Direction.DOWN;
		xPosition += direction.getX();
		yPosition += direction.getY();
	}

	public int getxPosition() {
		return xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

}
