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



		Scanner reader = new Scanner(System.in);											//The main method starts here

		while (true) {
			System.out.println("Enter a number to test a feature:\n");
			System.out.println(
					"1 = Test Pressing button        \t|\t 2 = Testing Random Sequence\n"
							+	"3 = Test ButtonLights       \\t|\\t 4 = Exit\\n");
			System.out.print("Enter a number: ");
			String ans = reader.next();
			switch (ans) {


			case "1":
				System.out.println("Button testing");
				testButtons();
				break;

			case "2":
				System.out.println("Sequence Testing");
				ArrayList<ArrayList<String>> newSeq = RandomSequenceGenerator(seq);
				seq = newSeq;
				break;

			case "3":
				System.out.println("ButtonLight testing");
				break;

			case "4":
				System.out.println("Bye Bye!!");
				System.exit(5);

			default:
				System.out.println("ERROR: Please enter a valid number.");
				break;
			}
		}
	}																					//Main method ends here


	public static void testButtons() throws InterruptedException {						//Currently using the Testbuttons() method to see how to use it properly
		int[] red = new int[] { 255, 0, 0 };
		int[] blue = new int[] { 0, 0, 255 };
		int[] green = new int[] { 0, 255, 0 };
		int[] yellow = new int[] { 255, 255, 0 };
		ArrayList<ArrayList<String>> playerSeq = new ArrayList<ArrayList<String>>();
		Counter = 0;	
		try {
			long endtime = System.currentTimeMillis() + 8_000;
			swiftBot.setButtonLight(Button.A, true);
			swiftBot.setButtonLight(Button.B, true);
			swiftBot.setButtonLight(Button.X, true);
			swiftBot.setButtonLight(Button.Y, true);

			swiftBot.enableButton(Button.A, () -> {
				System.out.println("Button A Pressed.");
				swiftBot.setButtonLight(Button.A, false);
				swiftBot.setUnderlight(Underlight.MIDDLE_LEFT, red);
				try {																		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!	
					playerSeq.add(new ArrayList<String>());
					String[][] addColour = ConvertChoice(red);
					ArrayList<ArrayList<String>> p1 = AddPlayerChoice(addColour); 
					correct = CompareChoiceToSequence(p1,seq);	
					System.out.println(correct);
					for(ArrayList<String> col1 : playerSeq){
						for(String code : col1){
							System.out.print(code + ",");
						}	
					}
					System.out.println("\r");
					System.out.println("After CompareChoiceToSequence is passed");
					System.out.println("\r gap");
					//
					if(correct == true) {
						for(int x=0;x<3;x++) {
							playerSeq.get(Counter-1).add(p1.get(0).get(x));
						}
						System.out.println("IT IS RED");
					}
					else {
						System.out.println("\r");
						System.out.println("GAME OVER NERD");
						System.out.println("You made it to Round: "+Round);
						
						System.exit(5);
					}
					Thread.sleep(500);															//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.exit(5);
				}
				swiftBot.disableUnderlight(Underlight.MIDDLE_LEFT);
			});

			swiftBot.enableButton(Button.B, () -> {
				System.out.println("Button B Pressed."); 
				swiftBot.setButtonLight(Button.B, false);
				swiftBot.setUnderlight(Underlight.BACK_LEFT, blue);
				try {																		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!	
					playerSeq.add(new ArrayList<String>());
					String[][] addColour = ConvertChoice(blue);                               
					ArrayList<ArrayList<String>> p1 = AddPlayerChoice(addColour); 
					correct = CompareChoiceToSequence(p1,seq);	
					System.out.println(correct);												
					if(correct == true) {
						for(int x=0;x<3;x++) {
							playerSeq.get(Counter-1).add(p1.get(0).get(x));
						}
						System.out.println("IT IS BLUE");
					}
					else {
						System.out.println("\r");
						System.out.println("GAME OVER NERD");
						System.out.println("You made it to Round: "+Round);
						
						System.exit(5);
					}
					//CURRENT WORKING AREA
					Thread.sleep(500);															//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.exit(5);
				}
				swiftBot.disableUnderlight(Underlight.BACK_LEFT);
			});

			swiftBot.enableButton(Button.X, () -> {
				System.out.println("Button X Pressed.");; 
				swiftBot.setButtonLight(Button.X, false);
				swiftBot.setUnderlight(Underlight.MIDDLE_RIGHT, green);
				try {																		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!	
					playerSeq.add(new ArrayList<String>());
					String[][] addColour = ConvertChoice(green);                               
					ArrayList<ArrayList<String>> p1 = AddPlayerChoice(addColour); 
					correct = CompareChoiceToSequence(p1,seq);	
					System.out.println(correct);												
					if(correct == true) {
						for(int x=0;x<3;x++) {
							playerSeq.get(Counter-1).add(p1.get(0).get(x));
						}
						System.out.println("IT IS GREEN");
					}
					else {
						System.out.println("\r");
						System.out.println("GAME OVER NERD");
						System.out.println("You made it to Round: "+Round);
						
						System.exit(5);
					}
					Thread.sleep(500);															//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.exit(5);
				}
				swiftBot.disableUnderlight(Underlight.MIDDLE_RIGHT);
			});

			swiftBot.enableButton(Button.Y, () -> {
				System.out.println("Button Y Pressed.");
				swiftBot.setButtonLight(Button.Y, false);
				swiftBot.setUnderlight(Underlight.BACK_RIGHT, yellow);
				try {																		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!	
					playerSeq.add(new ArrayList<String>());
					String[][] addColour = ConvertChoice(yellow);                               
					ArrayList<ArrayList<String>> p1 = AddPlayerChoice(addColour); 
					correct = CompareChoiceToSequence(p1,seq);	
					System.out.println(correct);												
					if(correct == true) {
						for(int x=0;x<3;x++) {
							playerSeq.get(Counter-1).add(p1.get(0).get(x));
						}
						System.out.println("IT IS YELLOW");
					}
					else {
						System.out.println("\r");
						System.out.println("GAME OVER NERD");
						System.out.println("You made it to Round: "+Round);
						
						System.exit(5);
					}
					Thread.sleep(500);															//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.exit(5);
				}
				swiftBot.disableUnderlight(Underlight.BACK_RIGHT);
			});

			while (System.currentTimeMillis() < endtime) {
				; 
			}
			swiftBot.disableAllButtons(); 
			swiftBot.disableButtonLights(); 
			System.out.println("All buttons are now off.");

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
		try {
			int nextCol = rand.nextInt(4);
			String[][] temp = new String[][]{{"","",""}};
			seq.add(new ArrayList<String>());
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

}


