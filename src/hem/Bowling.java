package hem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Bowling {
	private static final int STRIKE_VALUE = 10;
	private boolean checkSpare;
	private List<Frame> frames = new ArrayList<>();
	public String playerName;

	private int frameNo;
	private int currentFrameIndex = 0;
	private int score = 0;
	private int sco = 0;
	private int strikeCounter = 0;
	Frame f = new Frame();
	private int firstRoll = 0;
	private int counter = 0;
	private int secondRollScore = 0;
	private List<Integer> frameValues = new ArrayList<>(10);
	private int trackForAllStrikes = 0;

	public int getFrameNo() {
		return frameNo;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void callRoll() {
		for (int i = 0; i < 10; i++) {
			frame();
			currentFrameIndex++;
		}
	}

	public void frame() {

		Frame frame = new Frame();

		Scanner s = new Scanner(System.in);

		System.out.println("Enter the number of balls you knocked down in firstRoll: ");
		int firstRandomNo = s.nextInt();
		frame.setFirstRoll(firstRandomNo);
		int firstRollScore = frame.getFirstRoll();
		firstRoll = firstRollScore + 10;


		if (STRIKE_VALUE == firstRollScore && currentFrameIndex != 9) {
			System.out.println("STRIKE");
			strikeCounter++;
			trackForAllStrikes++;
			frame.setStrikeTrue();
		} else if (currentFrameIndex != 9) {
			System.out.println("Enter the number of balls you knocked down in secondRoll: ");
			int secondRandomNo = s.nextInt();
			frame.setSecondRoll(secondRandomNo);
			secondRollScore = frame.getSecondRoll();
			score = firstRollScore + secondRollScore;
			frame.setStrikeFalse();

		}

		frames.add(frame);

		if (frame.strike != true && STRIKE_VALUE == firstRollScore + secondRollScore || counter == 1) {
			frame.spare();
			System.out.println("SPARE");

			if (counter == 1) {
				int x = frames.get(currentFrameIndex).getFirstRoll();
				frames.get(currentFrameIndex - 1).setBonus(x);
				counter = 0;
				checkSpare = true;
			}
			counter++;
			if (checkSpare && firstRollScore + secondRollScore != 10) {
				counter = 0;
			}

		}

		if (strikeCounter > 0 && frame.strike == false) {

			int sco = setStrikeValue();
			if (strikeCounter == 1) {
				frames.get(currentFrameIndex - 1).setBonus(sco);

			} else if (strikeCounter == 2) {

				frames.get(currentFrameIndex - 2).setBonus(sco);
				frames.get(currentFrameIndex - 1).setBonus(score);
			} else if (strikeCounter == 3) {
				frames.get(currentFrameIndex - 3).setBonus(sco);
				frames.get(currentFrameIndex - 2).setBonus(firstRoll);
				frames.get(currentFrameIndex - 1).setBonus(score);

			} else if (strikeCounter == 4) {

				if (score != 0) {
					frames.get(currentFrameIndex - 4).setBonus(20);
					frames.get(currentFrameIndex - 3).setBonus(20);
					int x = firstRoll;
					frames.get(currentFrameIndex - 2).setBonus(x);
					frames.get(currentFrameIndex - 1).setBonus(score);
				}
			} else if (strikeCounter == 5) {

				if (score != 0) {
					frames.get(currentFrameIndex - 5).setBonus(20);
					frames.get(currentFrameIndex - 4).setBonus(20);
					frames.get(currentFrameIndex - 3).setBonus(20);
					int x = firstRoll;
					frames.get(currentFrameIndex - 2).setBonus(x);
					frames.get(currentFrameIndex - 1).setBonus(score);
				}
			} else if (strikeCounter == 6) {

				if (score != 0) {
					frames.get(currentFrameIndex - 6).setBonus(20);
					frames.get(currentFrameIndex - 5).setBonus(20);
					frames.get(currentFrameIndex - 4).setBonus(20);
					frames.get(currentFrameIndex - 3).setBonus(20);
					int x = 10 + firstRoll;
					frames.get(currentFrameIndex - 2).setBonus(x);
					frames.get(currentFrameIndex - 1).setBonus(score);
				}
			} else if (strikeCounter == 7) {

				if (score != 0) {
					frames.get(currentFrameIndex - 7).setBonus(20);
					frames.get(currentFrameIndex - 6).setBonus(20);
					frames.get(currentFrameIndex - 5).setBonus(20);
					frames.get(currentFrameIndex - 4).setBonus(20);
					frames.get(currentFrameIndex - 3).setBonus(20);
					int x = 10 + firstRoll;
					frames.get(currentFrameIndex - 2).setBonus(x);
					frames.get(currentFrameIndex - 1).setBonus(score);
				}
			} else if (strikeCounter == 8) {

				if (score != 0) {
					frames.get(currentFrameIndex - 8).setBonus(20);
					frames.get(currentFrameIndex - 7).setBonus(20);
					frames.get(currentFrameIndex - 6).setBonus(20);
					frames.get(currentFrameIndex - 5).setBonus(20);
					frames.get(currentFrameIndex - 4).setBonus(20);
					frames.get(currentFrameIndex - 3).setBonus(20);
					int x = 10 + firstRoll;
					frames.get(currentFrameIndex - 2).setBonus(x);
					frames.get(currentFrameIndex - 1).setBonus(score);
				}
			} else if (strikeCounter == 9) {

				if (score != 0) {
					frames.get(currentFrameIndex - 9).setBonus(20);
					frames.get(currentFrameIndex - 8).setBonus(20);
					frames.get(currentFrameIndex - 7).setBonus(20);
					frames.get(currentFrameIndex - 6).setBonus(20);
					frames.get(currentFrameIndex - 5).setBonus(20);
					frames.get(currentFrameIndex - 4).setBonus(20);
					frames.get(currentFrameIndex - 3).setBonus(20);
					int x = 10 + firstRoll;
					frames.get(currentFrameIndex - 2).setBonus(x);
					frames.get(currentFrameIndex - 1).setBonus(score);
				}
			}
			if (currentFrameIndex == 9) {
				int y = frames.get(currentFrameIndex).getFirstRoll();
				int l = frames.get(currentFrameIndex).getSecondRoll();
				int c = y + l;
				frames.get(currentFrameIndex - 1).setBonus(c);
				int p = frames.get(currentFrameIndex).getFirstRoll();
				int z = frames.get(currentFrameIndex - 1).getScoreForTenth();

				int i = p + z;
				frames.get(currentFrameIndex - 2).setBonus(i);

			}

			strikeCounter = 0;

		}

		if (currentFrameIndex == 9) {

			System.out.println("Enter the no of balls you knocked down in secondRoll: ");
			int secondRoll = s.nextInt();
			frame.setSecondRoll(secondRoll);
			int getSecondRoll = frame.getSecondRoll();
			frames.add(frame);

			if (firstRollScore + getSecondRoll == 10 || firstRollScore == 10) {
				System.out.println("Enter the no of balls you knocked down in thirdRoll: ");
				int thirdRoll = s.nextInt();
				frame.setThirdRoll(thirdRoll);
				firstRollScore = frame.getThirdRoll();
				int y = frames.get(currentFrameIndex).getScoreForTenth();
				frames.get(currentFrameIndex).setBonus(y);
			}
			int y = frames.get(currentFrameIndex).getFirstRoll();
			int l = frames.get(currentFrameIndex).getSecondRoll();
			int q = y + l;

			frames.get(currentFrameIndex - 1).setBonus(q);
			int p = frames.get(currentFrameIndex).getFirstRoll();
			int z = frames.get(currentFrameIndex - 1).getScoreForTenth();

			int w = p + z;

			if (frames.get(currentFrameIndex - 2).getScore() == 10) {
				System.out.println(frames.get(currentFrameIndex - 2).getScore());
				frames.get(currentFrameIndex - 2).setBonus(w);
			}

		}

	}

	public int setStrikeValue() {

		if (f.strike == false && strikeCounter == 1) {
			sco = frames.get(currentFrameIndex).getScore();

		} else if (f.strike == false && strikeCounter == 2) {
			sco = 10 + frames.get(currentFrameIndex).getFirstRoll();

		} else if (strikeCounter == 3 || currentFrameIndex == 9) {
			sco = 20;

		}
		if (currentFrameIndex == 9) {
			score = frames.get(currentFrameIndex).getScoreForTenth();
		}

		return sco;

	}

	public void displayFrames() {
		if (trackForAllStrikes != 10) {
			for (int i = 0; i < frames.size(); i++) {
				if (i != 9) {
					System.out.println("Value for " + i + "  is : " + frames.get(i).getScore());
				} else if (i == 9) {
					System.out.println("Value for " + i + "  is : " + frames.get(i).getScoreForTenth());
				}

			}
		}
	}

	public void displayFramesValue() {
		if (trackForAllStrikes != 10) {
			int score = 0;
			for (int i = 0; i < frames.size(); i++) {
				if (i != 9) {
					score += frames.get(i).getScore();
				} else if (i == 9) {
					score += frames.get(i).getScoreForTenth();
				}
				frameValues.add(score);
			}
		}
	}

	public void finalValues() {
		for (int i = 0; i < frameValues.size(); i++) {
			System.out.println("Value for:   " + i + "  is : " + frameValues.get(i));
		}
	}

}

