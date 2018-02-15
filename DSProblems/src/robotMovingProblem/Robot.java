package robotMovingProblem;

public class Robot {

	private MovingArea movingArea;

	public Robot(MovingArea movingArea) {
		this.movingArea = movingArea;
	}

	public void move(String command) {
		command = command.toUpperCase();
		char[] directions = command.toCharArray();
		for (int i = 0; i < directions.length; i++) {
			movingArea.move(directions[i]);
		}
	}

	public String getPosition() {
		StringBuilder position = new StringBuilder();
		position.append("(").append(movingArea.getxPosition()).append(",")
				.append(movingArea.getyPosition()).append(")");
		return position.toString();
	}
}
