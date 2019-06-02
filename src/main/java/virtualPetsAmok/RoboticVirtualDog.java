package virtualPetsAmok;

public class RoboticVirtualDog extends RoboticVirtualPet implements walkDog{

	

	public RoboticVirtualDog(String petName, String description, int boredom, int health, int happiness, int oilNeed) {
		super(petName, description, boredom, health, happiness, oilNeed);
		
	}

	@Override
	public void walkDog() {
		boredom = 0;
		happiness = 100;
		
	}

		




}
