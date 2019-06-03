package virtualPetsAmokTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import virtualPetsAmok.VirtualOrganicCat;
import virtualPetsAmok.RoboticVirtualCat;
import virtualPetsAmok.RoboticVirtualDog;
import virtualPetsAmok.RoboticVirtualPet;
import virtualPetsAmok.VirtualOrganicDog;
import virtualPetsAmok.VirtualOrganicPet;
import virtualPetsAmok.VirtualPet;
import virtualPetsAmok.VirtualPetShelter;

public class virtualPetShelterTest {
	VirtualPetShelter underTest;
	VirtualPet virtualPet1;
	VirtualPet virtualPet2;
	VirtualPet virtualRoboPet1;
	VirtualPet virtualRoboPet2;
	VirtualPet organicDog1;
	VirtualPet organicDog2;
	VirtualOrganicCat litterBox;
	RoboticVirtualPet virtualPet;
	RoboticVirtualDog virtualRoboDog1;
	RoboticVirtualDog virtualRoboDog2;

	@Before
	public void setup() {
		underTest = new VirtualPetShelter();
		// VirtualPet is (name, description, boredom, health, happiness)
		virtualPet1 = new VirtualOrganicCat("pet1", "description", 10, 10, 10, 10, 10);
		virtualPet2 = new VirtualOrganicCat("pet2", "description", 10, 10, 10, 10, 10);
		// RoboticalVirtualPet is (name, description, boredom, health, happiness,
		// oilNeed)
		virtualRoboPet1 = new RoboticVirtualCat("pet3", "description", 10, 10, 10, 10);
		virtualRoboPet2 = new RoboticVirtualCat("pet4", "description", 10, 10, 10, 10);
		virtualRoboDog1 = new RoboticVirtualDog("roboDog1", "roboDog1", 10, 10, 10, 10);
		virtualRoboDog2 = new RoboticVirtualDog("roboDog2", "roboDog2", 10, 10, 10, 10);
		// VirtualDog is (name, description, boredom, health, happiness, thirst, hunger,
		// cageSoil)
		organicDog1 = new VirtualOrganicDog("orgdog1", "orgdog1", 10, 10, 60, 10, 10, 10);
		organicDog2 = new VirtualOrganicDog("orgdog2", "orgdog2", 10, 10, 10, 10, 10, 10);
	}

	@Test
	
	public void shouldReturnLitterSoil() {
		int check = underTest.getLitterSoil();
		assertEquals(50, check);
		
	}
	@Test
	public void shouldReturnHealth() {
		underTest.takeInNewPetToShelter(virtualPet1);
		VirtualPet testPet1 = underTest.findPetInShelter("pet1");
		int check = testPet1.getHealth();
		assertEquals(10, check);
		
	}
	
	@Test
	public void shouldReturnHappiness() {
		underTest.takeInNewPetToShelter(virtualPet1);
		VirtualPet testPet1 = underTest.findPetInShelter("pet1");
		int check = testPet1.getHappiness();
		assertEquals(10, check);
		
	}
	@Test
	public void ShouldIntakePetToShelter() {
		underTest.takeInNewPetToShelter(virtualPet1);
		VirtualPet check = underTest.findPetInShelter("pet1");
		assertEquals(virtualPet1, check);

	}

	@Test
	public void shouldReturnPetOneandPetTwoInCollection() {
		underTest.takeInNewPetToShelter(virtualPet1);
		underTest.takeInNewPetToShelter(virtualPet2);
		Collection<VirtualPet> allPets = underTest.getAllPets();
		assertThat(allPets, containsInAnyOrder(virtualPet1, virtualPet2));
	}
	
	@Test
	public void shouldEmptyLitterBox() {
		underTest.emptyLitterBox();
		int check = underTest.getLitterSoil();
		assertEquals(0, check);
	}
	@Test
	public void shouldRemovePetWhenAdopted() {
		underTest.takeInNewPetToShelter(virtualPet1);
		underTest.removeAdoptedPet(virtualPet1);
		VirtualPet check = underTest.findPetInShelter(virtualPet1.getPetName());
		assertThat(check, is(nullValue()));
	}


	@Test
	public void shouldDecreaseoredomOfOnePetTOZero() {
		underTest.takeInNewPetToShelter(virtualPet1);
		underTest.playWithPet("pet1");
		VirtualPet testPet = underTest.findPetInShelter("pet1");
		int check = testPet.getBoredom();
		assertEquals(check, 0);

	}
	@Test
	public void shouldDecreaseBoredomOfAllPetsToZero() {
		underTest.takeInNewPetToShelter(virtualPet1);
		underTest.takeInNewPetToShelter(virtualPet2);
		underTest.playWithAllPets();
		VirtualPet testPet1 = underTest.findPetInShelter("pet1");
		VirtualPet testPet2 = underTest.findPetInShelter("pet2");
		int check1 = testPet1.getBoredom();
		int check2 = testPet2.getBoredom();
		assertEquals(check1, 0);
		assertEquals(check2, 0);
		
	}


	@Test
	public void shouldBeAbleToFeedAllOrgPets() {
		
		underTest.takeInNewPetToShelter(virtualPet1);
		underTest.takeInNewPetToShelter(virtualPet2);
		VirtualPet test1 = underTest.findPetInShelter("pet1");
		VirtualPet test2 = underTest.findPetInShelter("pet2");
		underTest.feedAllPets();
		VirtualOrganicPet testPet1 = (VirtualOrganicPet) test1;
		VirtualOrganicPet testPet2 = (VirtualOrganicPet) test2;
		int check1 = testPet1.getHunger();
		int check2 = testPet2.getHunger();
		assertEquals(0, check1);
		assertEquals(0, check2);
		
	}


	@Test
	public void shouldReturnCageSoil() {
		underTest.takeInNewPetToShelter(organicDog1);
		VirtualPet testPet = underTest.findPetInShelter("orgdog1");
		VirtualOrganicDog testpet1 = (VirtualOrganicDog) testPet;
		int check = testpet1.getCageSoil();
		assertEquals(10, check);
	}

	@Test
	public void shouldReduceCageSoilToZeroWhenCleaningCage() {
		underTest.takeInNewPetToShelter(organicDog1);
		underTest.cleanDogCage("orgdog1");
		VirtualPet testPet = underTest.findPetInShelter("orgdog1");		
		VirtualOrganicDog pet1 = (VirtualOrganicDog) testPet;
		int check = pet1.getCageSoil();
		assertEquals(0, check);
	}

	@Test
	public void shouldReduceAllCagesSoilToZeroWhenCleaningCage() {
		underTest.takeInNewPetToShelter(organicDog1);
		underTest.takeInNewPetToShelter(organicDog2);
		underTest.cleanAllDogCages();
		VirtualPet testPet1 = underTest.findPetInShelter("orgdog1");
		VirtualPet testPet2 = underTest.findPetInShelter("orgdog1");
		VirtualOrganicDog pet1 = (VirtualOrganicDog) testPet1;
		VirtualOrganicDog pet2 = (VirtualOrganicDog) testPet2;
		int check1 = pet1.getCageSoil();
		int check2 = pet2.getCageSoil();
		assertEquals(0, check1);
		assertEquals(0, check2);
	}

	@Test
	public void shouldIncreaseLitterBoxSoil() {
		underTest.tick();
		int check = underTest.getLitterSoil();
		assertEquals(55, check);
	}

	@Test
	public void shouldIncreaseCageSoil() {
		underTest.takeInNewPetToShelter(organicDog1);
		underTest.tick();
		VirtualPet testPet1 = underTest.findPetInShelter("orgdog1");
		VirtualOrganicDog pet1 = (VirtualOrganicDog) testPet1;
		int check = pet1.getCageSoil();
		assertEquals(11, check);
	}


	@Test
	public void shouldBeAbleToFeedPet() {
		underTest.takeInNewPetToShelter(organicDog1);
		VirtualPet test1 = underTest.findPetInShelter("orgdog1");
		underTest.feedAPet("orgdog1");
		VirtualOrganicPet petTest = (VirtualOrganicPet) test1;
		int check = petTest.getHunger();
		assertEquals(0, check);
	}

	@Test
	public void shouldBeAbleToWaterPet() {
		underTest.takeInNewPetToShelter(organicDog1);
		VirtualPet test1 = underTest.findPetInShelter("orgdog1");
		underTest.waterAPet("orgdog1");
		VirtualOrganicPet petTest = (VirtualOrganicPet) test1;
		int check = petTest.getThirst();
		assertEquals(0, check);
	}

	@Test
	public void shouldBeAbleToWaterAllOrgPets() {
		underTest.takeInNewPetToShelter(virtualPet1);
		underTest.takeInNewPetToShelter(virtualPet2);
		VirtualPet test1 = underTest.findPetInShelter("pet1");
		VirtualPet test2 = underTest.findPetInShelter("pet2");
		VirtualOrganicPet testPet1 = (VirtualOrganicPet) test1;
		VirtualOrganicPet testPet2 = (VirtualOrganicPet) test2;
		underTest.waterAllPets();
		int check1 = testPet1.getThirst();
		int check2 = testPet2.getThirst();
		assertEquals(0, check1);
		assertEquals(0, check2);
		
	}
	@Test
	public void shouldBeAbleToWalkOrgDogs() {
		underTest.takeInNewPetToShelter(organicDog1);
		VirtualPet test1 = underTest.findPetInShelter("orgdog1");
		underTest.walkDogs("orgdog1");
		int checkBoredom = test1.getBoredom();
		int checkHappiness = test1.getHappiness();
		assertEquals(0, checkBoredom);
		assertEquals(100, checkHappiness);
		
	}
	@Test
	public void shouldBeAbleToWalkAllOrgDogs() {
		underTest.takeInNewPetToShelter(organicDog1);
		underTest.takeInNewPetToShelter(organicDog2);
		VirtualPet test1 = underTest.findPetInShelter("orgdog1");
		VirtualPet test2 = underTest.findPetInShelter("orgdog2");
		underTest.walkAllOrgDogs();
		int checkBoredom1 = test1.getBoredom();
		int checkBoredom2 = test2.getBoredom();
		int checkHappiness1 = test1.getHappiness();
		int checkHappiness2 = test2.getHappiness();
		assertEquals(0, checkBoredom1);
		assertEquals(0, checkBoredom2);
		assertEquals(100, checkHappiness1);
		assertEquals(100, checkHappiness2);
		
	}


	@Test
	public void shouldBeAbleToOilAllRoboPets() {
		underTest.takeInNewPetToShelter(virtualRoboPet1);
		underTest.takeInNewPetToShelter(virtualRoboPet2);
		underTest.oilAllPets();
		VirtualPet test1 = underTest.findPetInShelter("pet3");
		VirtualPet test2 = underTest.findPetInShelter("pet4");
		RoboticVirtualPet pet1 = (RoboticVirtualPet) test1;
		RoboticVirtualPet pet2 = (RoboticVirtualPet) test2;
		int check1 = pet1.getOilNeed();
		int check2 = pet2.getOilNeed();
		assertEquals(0, check1);
		assertEquals(0, check2);
	}



	@Test
	public void shouldBeAbleToWalkAllRoboDogs() {
		underTest.takeInNewPetToShelter(virtualRoboDog1);
		underTest.takeInNewPetToShelter(virtualRoboDog2);
		VirtualPet test1 = underTest.findPetInShelter("roboDog1");
		VirtualPet test2 = underTest.findPetInShelter("roboDog2");
		underTest.walkAllRoboDogs();
		int checkBoredom1 = test1.getBoredom();
		int checkBoredom2 = test2.getBoredom();
		int checkHappiness1 = test1.getHappiness();
		int checkHappiness2 = test2.getHappiness();
		assertEquals(0, checkBoredom1);
		assertEquals(0, checkBoredom2);
		assertEquals(100, checkHappiness1);
		assertEquals(100, checkHappiness2);
	}

	@Test
	public void shouldIncreaseByOneAfterTickRuns() {
		underTest.takeInNewPetToShelter(virtualPet1);
		underTest.tick();
		VirtualPet testedPet = underTest.findPetInShelter("pet1");
		int resultBoredom = testedPet.getBoredom();
		int resultHunger = ((VirtualOrganicPet) testedPet).getHunger();
		assertEquals(11, resultBoredom);
		assertEquals(11, resultHunger);
	}
}
