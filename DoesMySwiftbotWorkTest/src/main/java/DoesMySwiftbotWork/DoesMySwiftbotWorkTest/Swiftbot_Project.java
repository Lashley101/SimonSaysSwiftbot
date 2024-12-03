
package DoesMySwiftbotWork.DoesMySwiftbotWorkTest;

import swiftbot.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.lang.*; 

public class Swiftbot_Project {
	static SwiftBotAPI swiftBot;
	public static ArrayList<ArrayList<String>> seq = new ArrayList<ArrayList<String>>();
	static int[][] colours = {
			{ 255, 0, 0 }, // Red
			{ 0, 255, 0 }, // Green
			{ 0, 0, 255 }, // Blue
			{ 255, 255, 0 } // Yellow
	};
	static Underlight[] underlights = new Underlight[] { Underlight.BACK_LEFT, Underlight.BACK_RIGHT,  //Initialised Variables
			Underlight.MIDDLE_LEFT,
			Underlight.MIDDLE_RIGHT, Underlight.FRONT_LEFT, Underlight.FRONT_RIGHT };
	static int Round = 0;
	static int Counter = 0;
	static boolean correct = true;
	

	public static void main(String[] args) throws InterruptedException {
		try {
			swiftBot = new SwiftBotAPI();
		} catch (Exception e) {

			System.out.println("\nI2C disabled!");
			System.out.println("Run the following command:");
			System.out.println("sudo raspi-config nonint do_i2c 0\n");
			System.exit(5);
		}

		// F40 Graphic


		System.out.println("\n*****************************************************************");
		System.out.println("*****************************************************************");
		System.out.println("@#=*==*######++###############=+##%%%%%%%%%%%##%%####%%%%%%#*--=###########%%%%#%%%%%%%%%%%%%%%%%%%%");
		System.out.println("@*=*==**#####*+######%%#%%%%%#=+##%%%%%%%%%#%%%%%%%%%%%%%%%%+--=######%%#%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("@#=*=+**#####*+############%%#=+##########%###%######%%%%%##+--=############%%%%%%%%%%%%%%%%%%%%%%@%");
		System.out.println("@#=*=+**#####**##########%%###+*####%%########%%%%#####%%%%%+==+############%%%#####%%#%%%%%%%%%%%@%");
		System.out.println("@#+*++#*#####**###############+*###############%#%%%%%%%%%%%+==+###########%%%%%%%%%%%%%%%%%%%%%%%@%");
		System.out.println("@#=*++#######**%%%###%%%######=*#####%%%%%%%%%%%%%%%%%%%%%%#+==+######%##%%%%%%%%%%%%%%%%%%%%%%%%%@%");
		System.out.println("%*+#+*#######**%@@%%%%%%######+*####%%%%%%%%%%%%%%%%%%%%%%%%+==*###############%######%%###%%%%%%%%%");
		System.out.println("+++#+*#%#####+*#@@%%%****************************#****##%###+==*#########%%%%%%%#%#%%%%%%%%%%%%%%%%%");
		System.out.println("*###+*#######+*%@@%**%@@@@@@@%%%%%%%%%%###########%%%%%%%%#*++=*#########%#%%%%%%%%%%%%%%%%%%%%%%%@%");
		System.out.println("******++++++++#%@%++%%%%######+==-:..:===+++++++*+******++++++++*#################%%%%%%%%%%%%%%%%%%");
		System.out.println("************+*#%%*=#%%%%%%%#+=+:...-+%*##*=+*+*#+#*###%#***##*%##@@#######%%%%%%%%%%%%%%%#%%%%%%%%%%");
		System.out.println("+++++++++*****##*-+**+++++++*+:..:--=*%%%%%####%%%###########%%@@%%@@%###########%%%%%%%%%%%%%%%%%%%");
		System.out.println("****+++++++++***:-=====--=@#+...=::+-=%%%%#%###%%@%#**##########@@%#%@@##%#%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("+++++++***+++++-....:::--+#++--=.:=---+%%%%%%####@@%##########@@@@@@+*%@%#####%####%%%%%%%%%%%%%%%@%");
		System.out.println("**************+:...====-:--=**=..:-:-**%%%%@@%%%%%%%%#*##%#####%%%%%%**+%@%####=---=%%%%%%%%%%%%%%%%");
		System.out.println("***************===-:=*#**====-:.::--------------=+=***==+==+=++++++====-=++**#+=*###%%#%%%%%%%%%%%@@");
		System.out.println("***=-=+++++++#%+====+*##+=-::-----=====-:-----------------------------------=========+####%%%%%%%%%%");
		System.out.println("*************%@*====+++++#=:..--++=--====-:-::------------:-------------:--:--====++==-=#%%%%%%%%%%%");
		System.out.println("*************@@##*==++++++%*=.:---------------::----------------------------.------------*#%%%%%%%%%");
		System.out.println("************#@@#+++=++*++#@%*=-.-------------=-------+=#+*=**-+++*+++=-------.:-----------**********");
		System.out.println("*****##******@%#++*@*++++#@@#==-::-++++++++++=--------------------------------:=#####***#+**********");
		System.out.println("#**###******#%%%+++@+++++#@@#====-=--+=+%*++%#=---------------*%%--------------:+==#*-=:=*+****+++++");
		System.out.println("#########*#**#%@*=====--=%@@#+++==--===**+**=*==--------------------------------:+##*+###*+*++++++**");
		System.out.println("##############@@%%%#++--+%@@%*+#+===-==+******=-----------------=+----------------*%%+*##+***++=++++");
		System.out.println("-=############%@@@@%#*++=#%%%*++=+**+++======-----====================+++++++++++++*******##%%###***");
		System.out.println("---=*#########*####%%@@%*%%%@%#++=======+**+++++==+++++***************###########++*%%@@%**%@@%#####");
		System.out.println("*----+#########*#*#####%@%#%@%#@@*+====*@@@@%+==#+%@@@@@@@@@@@@@@#@@@@@@@@@@@@@%+=**%@@@#**%@@%#####");
		System.out.println("##*----+########*##########@@#**#%%*====+++++===*==+****##############********++++**+**++*#@@@%%%%%%");
		System.out.println("####+----+#################@@###**#%%%%#**+=====+====+++++++*#######*###++++++++++***#%%%#%%@@@%%%%%");
		System.out.println("#####*=----+##################%@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%");
		System.out.println("#######*=----+#####################%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("#########*-----+####################################################################################");
		System.out.println("###########+-----+##################################################################################");
		System.out.println("#############+-----*################################################################################");
		System.out.println("##############*=-----+##############################################################################");
		System.out.println("################*=-----*############################################################################");
		System.out.println("");
		System.out.println("");
		System.out.println("Simon Says Testing");
		System.out.println("");
		System.out.println("*****************************************************************");
		System.out.println("*****************************************************************\n");




		Menu();
	}																					

	public static void Menu() throws InterruptedException {
		boolean menu = true;
		while(menu == true) {
			Scanner reader = new Scanner(System.in);	
			System.out.println("/////////////////////////////////////////////////////////////");
			System.out.println("/////////////////////////////////////////////////////////////");
			System.out.println("");
			System.out.println("Welcome to Simon:\n");
			System.out.println("");
			if(Round>0) {
				System.out.println("Your Highscore is: "+Round);
			}
			System.out.println("");
			System.out.println(
					"1 = Start Game        \t|\t 2 = Exit Game\n");
			System.out.print("Enter a number: ");
			String ans = reader.next();
			switch (ans) {

			case "1":
				System.out.println("Running new game");
				Round = 0;
				seq.clear();
				menu = false;
				Game();
				break;

			case "2":
				System.out.println("Bye Bye!!");
				System.exit(5);
			default:
				System.out.println("ERROR: Please enter a valid number.");
				break;
			}
		}
	}



	public static void buttonsActive() throws InterruptedException {						//Currently using the Testbuttons() method to see how to use it properly
		int[] red = new int[] { 255, 0, 0 };
		int[] blue = new int[] { 0, 0, 255 };
		int[] green = new int[] { 0, 255, 0 };
		int[] yellow = new int[] { 255, 255, 0 };
		ArrayList<ArrayList<String>> playerSeq = new ArrayList<ArrayList<String>>();
		swiftBot.disableAllButtons();
		swiftBot.disableButtonLights();
		swiftBot.disableUnderlights();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("");
		System.out.println("Round:"+Round);
		System.out.println("");
		System.out.println("Button A: Red");
		System.out.println("Button B: Blue");
		System.out.println("Button X: Green");
		System.out.println("Button Y: Yellow");
		System.out.println("");

		try {
			swiftBot.setButtonLight(Button.A, true);
			swiftBot.setButtonLight(Button.B, true);
			swiftBot.setButtonLight(Button.X, true);
			swiftBot.setButtonLight(Button.Y, true);

			swiftBot.enableButton(Button.A, () -> {
				swiftBot.setUnderlight(Underlight.MIDDLE_LEFT, red);
				try {																			
					playerSeq.add(new ArrayList<String>());
					String[][] addColour = ConvertChoice(red);
					ArrayList<ArrayList<String>> p1 = AddPlayerChoice(addColour); 
					correct = CompareChoiceToSequence(p1,seq);	
					if(correct == true) {
						for(int x=0;x<3;x++) {
							playerSeq.get(Counter-1).add(p1.get(0).get(x));
						}
						System.out.println("Colours Inputted: "+Counter);
						if(Counter == Round) {
							swiftBot.disableAllButtons();
							swiftBot.disableButtonLights();
							Thread.sleep(300);
							swiftBot.disableUnderlight(Underlight.MIDDLE_LEFT);
							Game();
						}
					}
					else {
						swiftBot.disableAllButtons();
						swiftBot.disableButtonLights();
						swiftBot.disableUnderlights();
						System.out.println("\r");
						System.out.println("GAME OVER NERD");
						System.out.println("You made it to Round: "+Round);
						System.out.println("\r");
						System.out.println("\r");
						Thread.sleep(7000);
						if(Round>=5){
							VictoryDance();
						}
						Menu();
					}
					Thread.sleep(500);															//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.exit(5);
				}
				swiftBot.disableUnderlight(Underlight.MIDDLE_LEFT);
			});

			swiftBot.enableButton(Button.B, () -> {
				swiftBot.setUnderlight(Underlight.BACK_LEFT, blue);
				try {																		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!	
					playerSeq.add(new ArrayList<String>());
					String[][] addColour = ConvertChoice(blue);                               
					ArrayList<ArrayList<String>> p1 = AddPlayerChoice(addColour); 
					correct = CompareChoiceToSequence(p1,seq);													
					if(correct == true) {
						for(int x=0;x<3;x++) {
							playerSeq.get(Counter-1).add(p1.get(0).get(x));
						}
						System.out.println("Colours Inputted: "+Counter);
						if(Counter == Round) {
							swiftBot.disableAllButtons();
							swiftBot.disableButtonLights();
							Thread.sleep(300);
							swiftBot.disableUnderlight(Underlight.BACK_LEFT);
							Game();
						}
					}
					else {
						swiftBot.disableAllButtons();
						swiftBot.disableButtonLights();
						swiftBot.disableUnderlights();
						System.out.println("\r");
						System.out.println("GAME OVER NERD");
						System.out.println("You made it to Round: "+Round);
						System.out.println("\r");
						System.out.println("\r");
						if(Round>=5){
							VictoryDance();
						}
						Thread.sleep(7000);
						Menu();
					}
					Thread.sleep(500);															
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.exit(5);
				}
				swiftBot.disableUnderlight(Underlight.BACK_LEFT);
			});

			swiftBot.enableButton(Button.X, () -> {
				swiftBot.setUnderlight(Underlight.MIDDLE_RIGHT, green);
				try {																		
					playerSeq.add(new ArrayList<String>());
					String[][] addColour = ConvertChoice(green);                               
					ArrayList<ArrayList<String>> p1 = AddPlayerChoice(addColour); 
					correct = CompareChoiceToSequence(p1,seq);												
					if(correct == true) {
						for(int x=0;x<3;x++) {
							playerSeq.get(Counter-1).add(p1.get(0).get(x));
						}
						System.out.println("Colours Inputted: "+Counter);
						if(Counter == Round) {
							swiftBot.disableAllButtons();
							swiftBot.disableButtonLights();
							Thread.sleep(300);
							swiftBot.disableUnderlight(Underlight.MIDDLE_RIGHT);
							Game();
						}
					}
					else {
						swiftBot.disableAllButtons();
						swiftBot.disableButtonLights();
						swiftBot.disableUnderlights();
						System.out.println("\r");
						System.out.println("GAME OVER NERD");
						System.out.println("You made it to Round: "+Round);
						System.out.println("\r");
						System.out.println("\r");
						Thread.sleep(7000);
						if(Round>=5){
							VictoryDance();
						}
						Menu();
					}
					Thread.sleep(500);															
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.exit(5);
				}
				swiftBot.disableUnderlight(Underlight.MIDDLE_RIGHT);
			});

			swiftBot.enableButton(Button.Y, () -> {
				swiftBot.setUnderlight(Underlight.BACK_RIGHT, yellow);
				try {																			
					playerSeq.add(new ArrayList<String>());
					String[][] addColour = ConvertChoice(yellow);                               
					ArrayList<ArrayList<String>> p1 = AddPlayerChoice(addColour); 
					correct = CompareChoiceToSequence(p1,seq);													
					if(correct == true) {
						for(int x=0;x<3;x++) {
							playerSeq.get(Counter-1).add(p1.get(0).get(x));
						}
						System.out.println("Colours Inputted: "+Counter);
						if(Counter == Round) {
							swiftBot.disableAllButtons();
							swiftBot.disableButtonLights();
							Thread.sleep(300);
							swiftBot.disableUnderlight(Underlight.BACK_RIGHT);
							Game();
						}
					}
					else {
						swiftBot.disableAllButtons();
						swiftBot.disableButtonLights();
						swiftBot.disableUnderlights();
						System.out.println("\r");
						System.out.println("GAME OVER NERD");
						System.out.println("You made it to Round: "+Round);
						System.out.println("\r");
						System.out.println("\r");
						Thread.sleep(7000);
						if(Round>=5){
							VictoryDance();
						}
						Menu();
					}
					Thread.sleep(500);															
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.exit(5);
				}
				swiftBot.disableUnderlight(Underlight.BACK_RIGHT);
			});
		} catch (Exception e) {
			System.out.println("Something went wrong with the buttons");
			e.printStackTrace();
			System.exit(5);
		}

	}

	//The method below creates a random adding sequences of colours that are outputted on the Underlights of the SwiftBot

	public static ArrayList<ArrayList<String>> RandomSequenceGenerator(ArrayList<ArrayList<String>> seq) throws InterruptedException {

		Random rand = new Random();
		Round+=1;
		Counter = 0;
		try {
			int nextCol = rand.nextInt(4);
			String[][] temp = new String[][]{{"","",""}};
			if(seq.size() < Round) {
			seq.add(new ArrayList<String>());
			}
			for(int x=0;x<3;x++) {
				temp[0][x] = String.valueOf(colours[nextCol][x]);
				seq.get(Round-1).add(temp[0][x]);
			}


			int[][] compseq = new int[seq.size()][3];
			int x = 0;
			do{
				for(int a =0;a<3;a++) {
					compseq[x][a] = Integer.parseInt(seq.get(x).get(a));	
				}
				x+=1;
			}while(x!=seq.size());


			for (int[] rgb : compseq){
				swiftBot.fillUnderlights(rgb);
				Thread.sleep(500);
				swiftBot.disableUnderlights();

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: failed to set all under lights");
			System.exit(5);
		}
		return seq;
	}


	//Adds the pressed button's assigned colour to a 2D String list

	public static String[][] ConvertChoice(int[] colour) throws InterruptedException{
		String[][] temp = new String[][]{{"","",""}};
		try {
			for(int x=0;x<3;x++) {
				temp[0][x] = String.valueOf(colour[x]);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("CheckCorrectColour Method go boom");
			System.exit(5);
		}

		Counter+=1;
		return temp;
	}

	private static ArrayList<ArrayList<String>> AddPlayerChoice(String[][] addColour) {
		ArrayList<ArrayList<String>> p1Seq = new ArrayList<ArrayList<String>>();
		p1Seq.add(new ArrayList<String>());
		try {			
			for(int x=0;x<3;x++) {
				p1Seq.get(0).add(addColour[0][x]);
			}

		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("AddPlayerChoice Method go big boom!!!");
			System.exit(5);
		}
		return p1Seq;
	}

	public static boolean CompareChoiceToSequence(ArrayList<ArrayList<String>> p2, ArrayList<ArrayList<String>> RealSeq) {
		boolean isCorrect = true;
		try {
			for(int x=0;x<p2.get(0).size();x++){
				if(Integer.parseInt(p2.get(0).get(x)) != Integer.parseInt(RealSeq.get(Counter-1).get(x))) {
					isCorrect = false;
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("ComparingChoiceToSequence somehow failed you dumb dumb");
			System.exit(5);
		}

		return isCorrect;
	}

	public static void Game() throws InterruptedException {
	    // After each round, generate the sequence
		

	    // Only ask if the player wants to continue after the 5th round
	    if (Round > 1 && (Round  % 5 == 0)) {
	        Scanner reader = new Scanner(System.in);  
	        System.out.println("--------------------------------------------------------------------------");
	        System.out.println("You have completed " + Round + " rounds!");
	        System.out.println("Would you like to continue or quit?");
	        System.out.println("Enter 1 to continue or 2 to quit:");

	        // Pause the game and wait for user input
	        String ans = reader.next();

	        switch (ans) {
	            case "1":
	                System.out.println("Continuing the game!");
	                break;
	            case "2":
	                System.out.println("Game Over! You made it to Round: " + Round);
			VictoryDance();
	                Menu();  // Exit the game
	                break;
	            default:
	                System.out.println("Invalid input, continuing the game.");
	                break;
	        }
	        
	    }
	    Thread.sleep(1500);
		    ArrayList<ArrayList<String>> newSeq = RandomSequenceGenerator(seq);
		    seq = newSeq;
		    Thread.sleep(500);
		    buttonsActive();
	}
	public static void VictoryDance() {
	int leftWheelVelocity = 0;
	int rightWheelVelocity = 0;
	try {
	Thread.sleep(800);
	System.out.println("You have completed at least Round 5!!!");
	Thread.sleep(800);
	System.out.println("The robot will proceed to do a victory lap! Please put it in an open area");
	Thread.sleep(2500);
	leftWheelVelocity = 50;
	rightWheelVelocity = 50;
	swiftBot.move(leftWheelVelocity, rightWheelVelocity, 1500);
	leftWheelVelocity = 100;
	rightWheelVelocity = 0;
	swiftBot.move(leftWheelVelocity, rightWheelVelocity, 750);
	leftWheelVelocity = 50;
	rightWheelVelocity = 50;
	swiftBot.move(leftWheelVelocity, rightWheelVelocity, 1500);
	Menu();
	
	}catch(Exception e) {
		e.printStackTrace();
		System.out.println("ComparingChoiceToSequence somehow failed you dumb dumb");
		System.exit(5);
	}

}
	       
	
}
