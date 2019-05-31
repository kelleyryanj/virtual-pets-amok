package virtualPetsAmok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	Map<String, VirtualPet> virtualPetsInShelter = new HashMap<>();

	LitterBox box = new LitterBox();
	
	
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
		box.tick();
//		cage.tick();
	}

	public void emptyLitterBox() {

		box.cleanLitterBox();

	}

	public int getLitterSoil() {
		return box.getLitterStatus();
	}

	
	public void waterAllPets() {
		for (String key : virtualPetsInShelter.keySet()) {
			VirtualOrganicPet value = (VirtualOrganicPet) virtualPetsInShelter.get(key);
			value.water();
		}
	}

	public void feedAllPets() {
		for (String key : virtualPetsInShelter.keySet()) {
			VirtualOrganicPet value = (VirtualOrganicPet) virtualPetsInShelter.get(key);
			value.feedPet();
		}
		
	}

	public void oilAllPets() {
		for (String key : virtualPetsInShelter.keySet()) {
			RoboticVirtualPet value = (RoboticVirtualPet) virtualPetsInShelter.get(key);
			value.oilPet();
		}
		 
	}

	public void walkDog() {
	for(String key : virtualPetsInShelter.keySet()) {
			VirtualPet value = virtualPetsInShelter.get(key);
			if(value instanceof WalkAndCleanDogCage)
			WalkAndCleanDogCage.walkDog();
		}
		
		
		
	}
}
