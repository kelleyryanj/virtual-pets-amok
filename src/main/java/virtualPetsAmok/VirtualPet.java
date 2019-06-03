package virtualPetsAmok;

public abstract class VirtualPet {

	protected String petName;
	protected String description;

	protected int boredom;

	protected int health;
	protected int happiness;

	public VirtualPet() {
		
	}
	
	public VirtualPet(String petName, String description, int boredom, int health, int happiness) {
		this.petName = petName;
		this.description = description;
		this.boredom = boredom;
		this.health = health;
		this.happiness = happiness;
	}

	public String getPetName() {

		return petName;
	}

	public String getDescription() {
		return description;
	}

	public int getBoredom() {

		return boredom;

	}

	public int getHealth() {

		return health;
	}

	public int getHappiness() {

		return happiness;
	}

	public void play() {
		boredom -= 10;
		if (boredom < 0) {
			boredom = 0;

		}
	}

	public void tick() {
		

	}

	
	

}
