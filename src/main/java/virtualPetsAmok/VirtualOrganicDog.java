package virtualPetsAmok;

public class VirtualOrganicDog extends VirtualOrganicPet implements walkDog {

	private int cageSoil;

	public VirtualOrganicDog() {
		super();
	}

	public VirtualOrganicDog(String petName, String description, int boredom, int health, int happiness, int hunger,
			int thirst, int cageSoil) {
		super(petName, description, boredom, health, happiness, hunger, thirst);
		this.cageSoil = cageSoil;
	}

	public int getCageSoil() {

		return cageSoil;
	}

	public void cleanCage() {
		cageSoil -= cageSoil;

	}

	

	@Override
	public void tick() {
		hunger += 1;
		thirst += 1;
		boredom += 1;
		if (happiness < 50) {
			cageSoil += 5;
		} else {
			cageSoil += 1;
		}
	}

	@Override
	public void walkDog() {
		boredom = 0;
		happiness =100;
		
	}
}
