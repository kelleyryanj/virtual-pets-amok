package virtualPetsAmok;

public class LitterBox {

	private int litterBox = 50;
	
	public void litterBox(int litterbox) {
		this.litterBox = litterBox;
	}

	public int getLitterStatus() {
		return litterBox;

	}

	public void cleanLitterBox() {
		litterBox -= litterBox;
	}

	public void tick() {
		litterBox += 5;

	}

}
