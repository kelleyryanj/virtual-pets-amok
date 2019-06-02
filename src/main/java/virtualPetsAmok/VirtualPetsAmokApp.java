package virtualPetsAmok;

import java.util.Scanner;

public class VirtualPetsAmokApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		VirtualPetShelter shelter = new VirtualPetShelter();
		VirtualOrganicCat pet1 = new VirtualOrganicCat("lucky", "cat", 10, 10, 10, 10, 10);
		VirtualOrganicDog pet2 = new VirtualOrganicDog("hollie", "dog", 10, 10, 10, 10, 10, 0);
		RoboticVirtualPet pet3 = new RoboticVirtualPet("dash", "cat", 10, 10, 10, 10);
		RoboticVirtualDog pet4 = new RoboticVirtualDog("mike", "dog", 10, 10, 10, 10);

		shelter.takeInNewPetToShelter(pet1);
		shelter.takeInNewPetToShelter(pet2);
		shelter.takeInNewPetToShelter(pet3);
		shelter.takeInNewPetToShelter(pet4);

		System.out.println("Welcome to the Scarlet and Grey Pet Shelter");

		boolean gameLoop = true;
		while (gameLoop == true)

		{
			System.out.println("What do you want to do?");
			System.out.println("1: Admit a pet");
			System.out.println("2: Adopt a pet");
			System.out.println("3: Feed a pet");
			System.out.println("4: Play with pets");
			System.out.println("5: Water pets");
			System.out.println("6: Walk dogs");
			System.out.println("7: Oil robotic pets");
			System.out.println("8: Clean communial litter box");
			System.out.println("9: see status of pets in shelter");
			System.out.println("0: quit");
			System.out.println();
			String userInput = input.next();
			input.nextLine();
			
			if (userInput.equals("1")) {
				System.out.println("What type of pet are you admitting?");
				System.out.println("1: Organic Cat");
				System.out.println("2: Organic Dog");
				System.out.println("3: Robotic Cat");
				System.out.println("4: Robotic Dog");
				userInput = input.next();
				input.nextLine();
				if (userInput.equals("1")) {
					System.out.println("What is the cat's name?");
					String name = input.nextLine();
					System.out.println("What is their boredom?");
					int boredom = input.nextInt();
					System.out.println("What is their health?");
					int health = input.nextInt();
					System.out.println("What is their happiness?");
					int happiness = input.nextInt();
					System.out.println("What is their thirst?");
					int thirst = input.nextInt();
					System.out.println("What is it's hunger?");
					int hunger = input.nextInt();
					VirtualOrganicCat newPet = new VirtualOrganicCat(name, "cat", boredom, health, happiness, thirst,
							hunger);
					shelter.takeInNewPetToShelter(newPet);
					shelter.tick();
				} else if (userInput.equals("2")) {
					System.out.println("What is the dog's name?");
					String name = input.nextLine();
					System.out.println("What is their boredom?");
					int boredom = input.nextInt();
					System.out.println("What is their health?");
					int health = input.nextInt();
					System.out.println("What is their happiness?");
					int happiness = input.nextInt();
					System.out.println("What is their thirst?");
					int thirst = input.nextInt();
					System.out.println("What is it's hunger?");
					int hunger = input.nextInt();
					VirtualOrganicDog newPet = new VirtualOrganicDog(name, "dog", boredom, health, happiness, thirst,
							hunger, 0);
					shelter.takeInNewPetToShelter(newPet);
					shelter.tick();
				} else if (userInput.equals("3")) {
					System.out.println("What is the pet's name?");
					String name = input.nextLine();
					System.out.println("What type of pet is it?");
					String description = input.nextLine();
					System.out.println("What is their boredom?");
					int boredom = input.nextInt();
					System.out.println("What is their health?");
					int health = input.nextInt();
					System.out.println("What is their happiness?");
					int happiness = input.nextInt();
					System.out.println("What is their oil need?");
					int oilNeed = input.nextInt();
					RoboticVirtualPet newPet = new RoboticVirtualPet(name, description, boredom, health, happiness,
							oilNeed);
					shelter.takeInNewPetToShelter(newPet);
					shelter.tick();
				} else if (userInput.equals("4")) {
					System.out.println("What is the pet's name?");
					String name = input.nextLine();
					System.out.println("What type of pet is it?");
					String description = input.nextLine();
					System.out.println("What is their boredom?");
					int boredom = input.nextInt();
					System.out.println("What is their health?");
					int health = input.nextInt();
					System.out.println("What is their happiness?");
					int happiness = input.nextInt();
					System.out.println("What is their oil need?");
					int oilNeed = input.nextInt();
					RoboticVirtualDog newPet = new RoboticVirtualDog(name, description, boredom, health, happiness,
							oilNeed);
					shelter.takeInNewPetToShelter(newPet);
					shelter.tick();
				}
			} else if (userInput.equals("2")) {
				System.out.println("What pet do you wish to adopt?");
				userInput = input.next();
				input.nextLine();
				shelter.removeAdoptedPet(shelter.findPetInShelter(userInput));
				System.out.println("Thanks for adopting!!");

			} else if (userInput.equals("3")) {
				System.out.println("Please choose an option");
				System.out.println("1: Feed a single pet");
				System.out.println("2: Feed all pets");
				userInput = input.next();
				input.nextLine();
				if (userInput.equals("1")) {
					System.out.println("Please enter name of Pet you wish to feed.");
					System.out.println();
					for (VirtualPet pets : shelter.getAllPets()) {
						System.out.println(pets.getPetName() + " is a " + pets.getDescription());
					}
					String newPet = input.next().toLowerCase();
					input.nextLine();

					while (shelter.findPetInShelter(newPet) == null) {
						System.out
								.println("Sorry, there is no pet in the shelter by that name. Please retype the name.");
						newPet = input.next();
					}
					shelter.feedAPet(newPet);
					System.out.println(newPet.toUpperCase() + " is full now.");
					System.out.println();
				} else if (userInput.equals("2")) {
					shelter.feedAllPets();
					System.out.println("Thanks! They really love to eat as a group");
					System.out.println();

					shelter.tick();
				}

				shelter.tick();

			} else if (userInput.equals("4")) {
				System.out.println("Please choose an option");
				System.out.println("1: Play with a single pet");
				System.out.println("2: PLay with all pets");
				userInput = input.next();
				input.nextLine();
				if (userInput.equals("1")) {
					System.out.println("Please enter name of Pet you wish to play with.");
					System.out.println();
					String newPet = input.next().toLowerCase();
					input.nextLine();
					while (shelter.findPetInShelter(newPet) == null) {
						System.out
								.println("Sorry, there is no pet in the shelter by that name. Please retype the name.");
						newPet = input.next();

					}
					shelter.playWithPet(newPet);
					System.out.println(newPet.toUpperCase() + " is happy now.");
					System.out.println();
					shelter.tick();
				} else if (userInput.equals("2")) {
					System.out.println("They love playing together as a group.");
					System.out.println();
					shelter.playWithAllPets();

					shelter.tick();

				}

			} else if (userInput.equals("5")) {
				System.out.println("Please choose an option");
				System.out.println("1: Water a single pet");
				System.out.println("2: Water all pets");
				userInput = input.next();
				input.nextLine();
				if (userInput.equals("1")) {
					System.out.println("Please enter name of Pet you wish to water.");
					System.out.println();
					String newPet = input.next().toLowerCase();
					input.nextLine();
					while (shelter.findPetInShelter(newPet) == null) {
						System.out
								.println("Sorry, there is no pet in the shelter by that name. Please retype the name.");
						newPet = input.next();
					}

					shelter.waterAPet(newPet);
					System.out.println(newPet.toUpperCase() + " is better now.");
					System.out.println();
					shelter.tick();

				} else if (userInput.equals("2")) {
					System.out.println("Thanks! It's a big help that you are making sure they all have water.");
					shelter.waterAllPets();

					shelter.tick();
				}
			} else if (userInput.equals("6")) {

				System.out.println("Please choose an option");
				System.out.println("1: Walk a single dog");
				System.out.println("2: Walk all dogs");
				userInput = input.next();
				input.nextLine();
				if (userInput.equals("1")) {
					System.out.println("Please enter name of dog you wish to walk.");
					System.out.println();
					String newPet = input.next().toLowerCase();
					input.nextLine();
					if (shelter.findPetInShelter(newPet) instanceof walkDog) {
						shelter.walkDogs(newPet);
						System.out.println(newPet.toUpperCase() + " is better now.");
						System.out.println();
						shelter.tick();

					} else {

						System.out.println("Sorry, you can only walk dogs.");

					}

				} else if (userInput.equals("2")) {
					System.out.println("Thanks! They love to take a walk together.");
					shelter.walkAllOrgDogs();
					shelter.walkAllRoboDogs();

					shelter.tick();
				}
			} else if (userInput.equals("7")) {
				System.out.println("Please choose an option");
				System.out.println("1: Oil a single pet");
				System.out.println("2: Oil all pets");
				userInput = input.next();
				input.nextLine();
				if (userInput.equals("1")) {
					System.out.println("Please enter name of pet you wish to oil.");
					System.out.println();
					String newPet = input.next().toLowerCase();
					input.nextLine();
					if (shelter.findPetInShelter(newPet) instanceof RoboticVirtualPet) {
						shelter.oilPet(newPet);
						System.out.println(newPet.toUpperCase() + " is better now.");
						System.out.println();
						shelter.tick();

					} else {

						System.out.println("Sorry, you can only oil robotic pets.");
						System.out.println();

					}

				} else if (userInput.equals("2")) {
					System.out.println("Thanksfor oiling all of them for us!!!.");
					shelter.oilAllPets();

					shelter.tick();
				}

			} else if (userInput.equals("8")) {
				System.out.println("Thanks for taking acre of the liiter box!!");
				shelter.emptyLitterBox();
				

			} else if (userInput.equals("9")) {
				System.out.println("Here are the status of the pets");
				shelter.showOrganicCats();
				shelter.showOrganicDogs();
				shelter.showRoboPets();
				System.out.println();
				System.out.println("Litter box soil: " + shelter.getLitterSoil());
				shelter.tick();

			} else if (userInput.equals("0")) {
				gameLoop = false;
			}
		}
		System.out.println("Thanks for volunteering!!!");
		input.close();
		System.exit(0);
	}
}
