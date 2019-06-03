package virtualPetsAmok;

public abstract class VirtualOrganicPet extends VirtualPet implements FeedWaterPets {

	protected int thirst;
	protected int hunger;

	public VirtualOrganicPet() {
		super();
	}

	public VirtualOrganicPet(String petName, String description, int boredom, int health, int happiness, int hunger,
			int thirst) {
		super(petName, description, boredom, health, happiness);
		this.thirst = thirst;
		this.hunger = hunger;

	}

	public int getHunger() {

		return hunger;
	}

	public int getThirst() {

		return thirst;
	}

	@Override
	public void feedPet() {
		hunger -= hunger;

	}

	@Override
	public void water() {
		thirst -= thirst;

	}

	@Override
	public void tick() {
		if (thirst > 80) {
			health -= 10;
			happiness -= 10;
			hunger += 1;
			thirst += 1;
			boredom += 1;
		} else {
			hunger += 1;
			thirst += 1;
			boredom += 1;

		}
	}
}
