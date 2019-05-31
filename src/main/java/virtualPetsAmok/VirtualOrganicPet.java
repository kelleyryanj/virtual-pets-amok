package virtualPetsAmok;

public class VirtualOrganicPet extends VirtualPet implements FeedWaterPets {

	private int thirst;
	private int hunger;

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
		hunger += 1;
		thirst += 1;

	}
}

