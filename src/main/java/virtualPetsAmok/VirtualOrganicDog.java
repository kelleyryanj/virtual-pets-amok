package virtualPetsAmok;

public class VirtualOrganicDog extends VirtualOrganicPet implements WalkAndCleanDogCage {

	private int cageSoil;

	public VirtualOrganicDog(String petName, String description, int boredom, int health, int happiness, int hunger,
			int thirst, int cageSoil) {
		super(petName, description, boredom, health, happiness, hunger, thirst);
		this.cageSoil = cageSoil;
	}

	public int getcageSoil() {
		
		return cageSoil;
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
