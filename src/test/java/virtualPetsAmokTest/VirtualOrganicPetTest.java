package virtualPetsAmokTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import virtualPetsAmok.VirtualOrganicPet;

public class VirtualOrganicPetTest {
	VirtualOrganicPet underTest = new VirtualOrganicPet("pet", "description", 10, 10, 10, 10, 10);
	
	@Test
	public void shouldBeAbleToGetHunger() {

		int check = underTest.getHunger();
		assertEquals(10, check);
		
	}
	
	@Test
	public void shouldBeAbleToGetThirst() {
		int check = underTest.getThirst();
		assertEquals(10, check);
		
	}
	
	@Test
	public void shouldBeAbleToFeedPet() {
		underTest.feedPet();
		int check = underTest.getHunger();
		assertEquals(0, check);
	}
	@Test
	public void shouldBeAbleToWaterPet() {
		underTest.water();
		int check = underTest.getThirst();
		assertEquals(0, check);
	}
	
	
	
}
