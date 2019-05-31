package virtualPetsAmok;

public class RoboticVirtualDog extends RoboticVirtualPet implements WalkAndCleanDogCage{

	private int cageSoil;

	public RoboticVirtualDog(String petName, String description, int boredom, int health, int happiness, int oilNeed, int cageSoil) {
		super(petName, description, boredom, health, happiness, oilNeed);
		this.cageSoil = cageSoil;
	}

	
	

	
	@Override
	public void cleanCage(VirtualPet virtualPet) {
		cageSoil -= cageSoil;
		
	}


	@Override
	public void walkDog(VirtualPet virtualPet) {
		boredom -= boredom;
		happiness = 100;
		
	}

}
