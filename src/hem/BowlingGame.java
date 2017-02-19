package hem;

public class BowlingGame {

	public static void main(String[] args) {
		Bowling bowling = new Bowling();
		bowling.setPlayerName("HemHer");

		System.out.println("Welcome to the Bowling game " + bowling.getPlayerName());
		bowling.callRoll();
		bowling.displayFrames();
		bowling.displayFramesValue();
		bowling.finalValues();

	}
}
