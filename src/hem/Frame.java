package hem;

public class Frame {

	private  int firstRoll;
	private  int secondRoll;
	private int thirdRoll;
	private int score;
	public  boolean strike;
	private boolean spare;
	private  int bonus;
	
	

	public void setFirstRoll(int firstRoll) {
		this.firstRoll = firstRoll;
	}

	public void setSecondRoll(int secondRoll) {
		this.secondRoll = secondRoll;
	}

	public void setThirdRoll(int thirdRoll) {
		this.thirdRoll = thirdRoll;
	}

	
	public int getFirstRoll() {
		return firstRoll;
	}

	public int getSecondRoll() {
		return secondRoll;
	}

	public int getThirdRoll() {
		return thirdRoll;
	}
	public void setStrikeTrue() {
		strike = true;
	}
	
	public void setStrikeFalse() {
		strike = false;
	}

	public void spare() {
		spare = true;
	}
	
	
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	public  int getScore() {
		return firstRoll + secondRoll + bonus;
	}
	public int getScoreForTenth() {
		return firstRoll + secondRoll + thirdRoll;
	}

	public void setScore(int score) {
		this.score = score;
	
	}
	
	
	
	
}
