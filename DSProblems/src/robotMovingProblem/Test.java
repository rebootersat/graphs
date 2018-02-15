package robotMovingProblem;

public class Test {
	public static void main(String[] args) {
		MovingArea movingArea = new MovingArea();
		Robot robot = new Robot(movingArea);
		robot.move("UDDLLRUUUDUURUDDUULLDRRRR");
		System.out.println(robot.getPosition());
		
	}
}
