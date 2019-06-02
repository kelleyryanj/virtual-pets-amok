package virtualPetsAmok;

public class RoboticVirtualPet extends VirtualPet {

	private int oilNeed;
	
	public RoboticVirtualPet() {
		super ();
	}
	
	public RoboticVirtualPet(String petName, String description, int boredom, int health, int happiness, int oilNeed) {
		super(petName, description, boredom, health, happiness);
		this.oilNeed = oilNeed;
	}
	
	
	public int getOilNeed() {
		
		return oilNeed;
	}
	public void oilPet() {
		oilNeed -= oilNeed;
		
	}
	
	@Override
	public void tick() {
		boredom += 1;
		oilNeed += 1;
	}
	
	
}
