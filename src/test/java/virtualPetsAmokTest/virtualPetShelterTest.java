package virtualPetsAmokTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import virtualPetsAmok.LitterBox;
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
	LitterBox litterBox;

	@Before
	public void setup() {
		underTest = new VirtualPetShelter();
		virtualPet1 = new VirtualOrganicPet("pet1", "description", 10, 10, 10, 10, 10);
		virtualPet2 = new VirtualOrganicPet("pet2", "description", 10, 10, 10, 10, 10);
		virtualRoboPet1 = new RoboticVirtualPet("pet3", "description", 10, 10, 10, 10);
		virtualRoboPet2 = new RoboticVirtualPet("pet4", "description", 10, 10, 10, 10);
		organicDog1 = new VirtualOrganicDog("orgdog1", "orgdog", 10, 10, 10, 10, 10, 10);
		organicDog2 = new VirtualOrganicDog("orgdog2", "orgdog", 10, 10, 10, 10, 10, 10);
	}

	@Test
	public void ShouldIntakePetToShelter() {
		underTest.takeInNewPetToShelter(virtualPet1);
		VirtualPet result = underTest.findPetInShelter("pet1");
		assertEquals(virtualPet1, result);

	}

	@Test
	public void shouldRemovePetWhenAdopted() {
		underTest.takeInNewPetToShelter(virtualPet1);
		underTest.removeAdoptedPet(virtualPet1);
		VirtualPet result = underTest.findPetInShelter(virtualPet1.getPetName());
		assertThat(result, is(nullValue()));
	}

	@Test
	public void shouldReturnPetOneandPetTwoInCollection() {
		underTest.takeInNewPetToShelter(virtualPet1);
		underTest.takeInNewPetToShelter(virtualPet2);
		Collection<VirtualPet> allPets = underTest.getAllPets();
		assertThat(allPets, containsInAnyOrder(virtualPet1, virtualPet2));
	}

	
	@Test
	public void shouldDecreaseoredomOfOnePetTOZero() {
		underTest.takeInNewPetToShelter(virtualPet1);
		underTest.playWithPet("pet1");
		VirtualPet testedPet = underTest.findPetInShelter("pet1");
		int result = testedPet.getBoredom();
		assertEquals(result, 0);

	}

	@Test
	public void shouldDecreaseBoredomOfAllPetsToZero() {
		underTest.takeInNewPetToShelter(virtualPet1);
		underTest.takeInNewPetToShelter(virtualPet2);
		underTest.playWithAllPets();
		VirtualPet testedPet1 = underTest.findPetInShelter("pet1");
		VirtualPet testedPet2 = underTest.findPetInShelter("pet2");
		int result1 = testedPet1.getBoredom();
		int result2 = testedPet2.getBoredom();
		assertEquals(result1, 0);
		assertEquals(result2, 0);

	}

	

	@Test
	public void shouldIncreaseByOneAfterTickRuns() {
		underTest.takeInNewPetToShelter(virtualPet1);
		underTest.tick();
		VirtualPet testedPet = underTest.findPetInShelter("pet1");
		int resultBoredom = testedPet.getBoredom();
		assertEquals(11, resultBoredom);
		}

	@Test

	public void shouldReturnLitterSoil() {
		int check = underTest.getLitterSoil();
		assertEquals(50, check);

	}

	@Test
	public void shouldEmptyLitterBox() {
		underTest.emptyLitterBox();
		int check = underTest.getLitterSoil();
		assertEquals(0, check);
	}

//	@Test
//	public void shouldReturnCageSoil() {
//		int check = underTest.getCageSoil();
//		assertEquals(50, check);
//	}
//
//	@Test
//	public void shouldCleanAllCages() {
//		underTest.cleanAllDogCages();
//		int check = underTest.getCageSoil();
//		assertEquals(0, check);
//	}

	@Test
	public void shouldIncreaseLitterBoxSoil() {
		underTest.tick();
		int check = underTest.getLitterSoil();
		assertEquals(55, check);
	}

//	@Test
//	public void shouldIncreaseCageSoil() {
//		underTest.tick();
//		int check = underTest.getCageSoil();
//		assertEquals(55, check);
//	}

	@Test
	public void shouldReturnHealth() {
		underTest.takeInNewPetToShelter(virtualPet1);
		VirtualPet testedPet1 = underTest.findPetInShelter("pet1");
		int result1 = testedPet1.getHealth();
		assertEquals(10, result1);

	}
	@Test
	public void shouldReturnHappiness() {
		underTest.takeInNewPetToShelter(virtualPet1);
		VirtualPet testedPet1 = underTest.findPetInShelter("pet1");
		int result1 = testedPet1.getHappiness();
		assertEquals(10, result1);

	}
	
	@Test
	public void shouldBeAbleToWaterAllOrgPets() {
		underTest.takeInNewPetToShelter(virtualPet1);
		underTest.takeInNewPetToShelter(virtualPet2);
		VirtualPet test1 = underTest.findPetInShelter("pet1");
		VirtualPet test2 = underTest.findPetInShelter("pet2");
		underTest.waterAllPets();
		int check1 = ((VirtualOrganicPet) test1).getThirst();
		int check2 = ((VirtualOrganicPet) test2).getThirst();
		assertEquals(0, check1);
		assertEquals(0, check2);
		
	}
	@Test
	public void shouldBeAbleToFeedAllOrgPets() {
		underTest.takeInNewPetToShelter(virtualPet1);
		underTest.takeInNewPetToShelter(virtualPet2);
		VirtualPet test1 = underTest.findPetInShelter("pet1");
		VirtualPet test2 = underTest.findPetInShelter("pet2");
		underTest.feedAllPets();
		int check1 = ((VirtualOrganicPet) test1).getHunger();
		int check2 = ((VirtualOrganicPet) test2).getHunger();
		assertEquals(0, check1);
		assertEquals(0, check2);
		
	}
	
	@Test
	public void shouldBeAbleToOilAllRoboPets() {
		underTest.takeInNewPetToShelter(virtualRoboPet1);
		underTest.takeInNewPetToShelter(virtualRoboPet2);
		VirtualPet test1 = underTest.findPetInShelter("pet3");
		VirtualPet test2 = underTest.findPetInShelter("pet4");
		underTest.oilAllPets();
		int check1 = ((RoboticVirtualPet) test1).getOilNeed();
		int check2 = ((RoboticVirtualPet) test2).getOilNeed();
		assertEquals(0, check1);
		assertEquals(0, check2);
	}
	
	@Test
	public void shouldBeAbleToWalkOrgDog() {
		underTest.takeInNewPetToShelter(organicDog1);
		VirtualPet test1 = underTest.findPetInShelter("orgdog1");
		underTest.walkDog();
		int checkBoredom = test1.getBoredom();
		int checkHappiness = test1.getHappiness();
		assertEquals(0, checkBoredom);
		assertEquals(100, checkHappiness);
		
	}
	
	@Test
	public void shouldBeAbleToWalkRoboDog() {
		underTest.takeInNewPetToShelter(virtualRoboPet1);
		VirtualPet test1 = underTest.findPetInShelter("pet3");
		underTest.walkDog();
		int checkBoredom = test1.getBoredom();
		int checkHappiness = test1.getHappiness();
		assertEquals(0, checkBoredom);
		assertEquals(100, checkHappiness);
	}
		
		
		
	
}
