package virtualPetsAmok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {
	int litterBox = 50;
	Map<String, VirtualPet> virtualPetsInShelter = new HashMap<>();

	public void takeInNewPetToShelter(VirtualPet petInShelter) {
		virtualPetsInShelter.put(petInShelter.getPetName(), petInShelter);

	}

	public VirtualPet findPetInShelter(String name) {
		return virtualPetsInShelter.get(name);
	}

	public void removeAdoptedPet(VirtualPet petInShelter) {
		virtualPetsInShelter.remove(petInShelter.getPetName(), petInShelter);

	}

	public Collection<VirtualPet> getAllPets() {

		return virtualPetsInShelter.values();
	}

	public void playWithPet(String petInShelter) {
		VirtualPet playWithPet = findPetInShelter(petInShelter);
		playWithPet.play();

	}

	public void feedAPet(String findPetInShelter) {
		VirtualPet feedPet = findPetInShelter(findPetInShelter);
		VirtualOrganicPet feed = (VirtualOrganicPet) feedPet;
		feed.feedPet();
	}

	public void waterAPet(String findPetInShelter) {
		VirtualPet feedPet = findPetInShelter(findPetInShelter);
		VirtualOrganicPet feed = (VirtualOrganicPet) feedPet;
		feed.water();
	}

	public void playWithAllPets() {
		for (String key : virtualPetsInShelter.keySet()) {
			VirtualPet value = virtualPetsInShelter.get(key);
			value.play();
		}

	}

	public void tick() {
		for (String key : virtualPetsInShelter.keySet()) {
			VirtualPet value = virtualPetsInShelter.get(key);
			value.tick();

		}

		litterBox += 5;

	}

	public void emptyLitterBox() {

		litterBox = 0;

	}

	public int getLitterSoil() {
		return litterBox;
	}

	public void waterAllPets() {
		for (VirtualPet pets : getAllPets()) {
			if (pets instanceof VirtualOrganicPet) {
				VirtualOrganicPet orgPet = (VirtualOrganicPet) pets;
				orgPet.water();
			
			}
		}
	}

	public void feedAllPets() {
		for (VirtualPet pets : getAllPets()) {
			if (pets instanceof VirtualOrganicPet) {
				VirtualOrganicPet orgPet = (VirtualOrganicPet) pets;
				orgPet.feedPet();
			
			}
		}

	}

	public void oilAllPets() {
		for (VirtualPet pets : getAllPets()) {
			if (pets instanceof RoboticVirtualPet) {
				RoboticVirtualPet roboPet = (RoboticVirtualPet) pets;
				roboPet.oilPet();
			
			}
		}

	}

	public void walkDogs(String petInShelter) {
		VirtualPet walkDog = findPetInShelter(petInShelter);
		if (walkDog instanceof VirtualOrganicDog) {
		VirtualOrganicDog walk = (VirtualOrganicDog) walkDog;
		walk.walkDog();
		} else if (walkDog instanceof RoboticVirtualDog) {
		virtualPetsAmok.walkDog walk = (virtualPetsAmok.walkDog) walkDog;
		walk.walkDog();
	}

	}

	
	public void cleanDogCage(String petInShelter) {
		VirtualPet cleanDogCage = findPetInShelter(petInShelter);
		VirtualOrganicDog orgDog = (VirtualOrganicDog) cleanDogCage;
		orgDog.cleanCage();
	}

	public void cleanAllDogCages() {
		for (String key : virtualPetsInShelter.keySet()) {
			VirtualPet value = virtualPetsInShelter.get(key);
			VirtualOrganicDog orgDog = (VirtualOrganicDog) value;
			orgDog.cleanCage();
		}
	}

	public void showOrganicCats() {
		System.out.println("Organic cats:");
		System.out.println();
		System.out.println("Name\t|Description\t|Boredom|Health\t|Happiness |Thirst |Hunger");
		System.out.println("**********************************************************************************");
		for (VirtualPet pets : getAllPets()) {
			if (pets instanceof VirtualOrganicCat) {
				VirtualOrganicPet orgpet = (VirtualOrganicPet) pets;
				System.out.println(pets.getPetName() + "\t|\t" + pets.getDescription() + "\t| " + pets.getBoredom()
						+ "\t|" + pets.getHealth() + "\t|" + pets.getHappiness() + "\t   |" + orgpet.getThirst()
						+ "\t   |" + orgpet.getHunger());
			}
		}
	}

	public void showOrganicDogs() {
		System.out.println();
		System.out.println("Organic dogs:");
		System.out.println();
		System.out.println("Name\t|Description\t|Boredom|Health\t|Happiness |Thirst |Hunger |Cage Soil");
		System.out.println("**********************************************************************************");
		for (VirtualPet pets : getAllPets()) {
			if (pets instanceof VirtualOrganicDog) {
				VirtualOrganicDog orgDog = (VirtualOrganicDog) pets;
				System.out.println(pets.getPetName() + "\t|\t" + pets.getDescription() + "\t| " + pets.getBoredom()
						+ "\t|" + pets.getHealth() + "\t|" + pets.getHappiness() + "\t   |" + orgDog.getThirst()
						+ "\t   |" + orgDog.getHunger() + "\t  |" + orgDog.getCageSoil());
			}
		}
	}

	public void showRoboPets() {
		System.out.println();
		System.out.println("Robotic Pets:");
		System.out.println();
		System.out.println("Name\t|Description\t|Boredom|Health\t|Happiness |Oil Need");
		System.out.println("**********************************************************************************");
		for (VirtualPet pets : getAllPets()) {
			if (pets instanceof RoboticVirtualPet) {
				RoboticVirtualPet roboPet = (RoboticVirtualPet) pets;
				System.out.println(pets.getPetName() + "\t|\t" + pets.getDescription() + "\t| " + pets.getBoredom()
						+ "\t|" + pets.getHealth() + "\t|" + pets.getHappiness() + "\t   |" + roboPet.getOilNeed());
			}
		}
	}

	public void walkAllOrgDogs() {
		for (VirtualPet pets : getAllPets()) {
			if (pets instanceof VirtualOrganicDog) {
				VirtualOrganicDog orgDog = (VirtualOrganicDog) pets;
				orgDog.walkDog();
			
			}
		}
		
	}

	public void walkAllRoboDogs() {
		for (VirtualPet pets : getAllPets()) {
			if (pets instanceof RoboticVirtualDog) {
				walkDog roboDog = (walkDog) pets;
				roboDog.walkDog();
			
			}
		}
		
	}

	public void oilPet(String findPetInShelter) {
		VirtualPet roboPet = findPetInShelter(findPetInShelter);
		RoboticVirtualPet oil = (RoboticVirtualPet) roboPet;
		oil.oilPet();
	
		
	}
}
