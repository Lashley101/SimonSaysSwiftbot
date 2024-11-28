package DoesMySwiftbotWork.DoesMySwiftbotWorkTest;

import swiftbot.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.lang.*; 

public class Swiftbot_Project {
	static SwiftBotAPI swiftBot;
	public ArrayList<ArrayList<String>> seq = new ArrayList<ArrayList<String>>();
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
		ArrayList<ArrayList<String>> seq = new ArrayList(); 

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
		
		try {
			long endtime = System.currentTimeMillis() + 20_000;
			swiftBot.setButtonLight(Button.A, true);
			swiftBot.setButtonLight(Button.B, true);
			swiftBot.setButtonLight(Button.X, true);
			swiftBot.setButtonLight(Button.Y, true);
			
			swiftBot.enableButton(Button.A, () -> {
				System.out.println("Button A Pressed.");
				swiftBot.disableButton(Button.A);
				swiftBot.setButtonLight(Button.A, false);
				swiftBot.setUnderlight(Underlight.MIDDLE_RIGHT, red);;
				

			});

			swiftBot.enableButton(Button.B, () -> {
				System.out.println("Button B Pressed."); 
				swiftBot.disableButton(Button.B);
				swiftBot.setButtonLight(Button.B, false);
				
			});

			swiftBot.enableButton(Button.X, () -> {
				System.out.println("Button X Pressed.");; 
				swiftBot.disableButton(Button.X);
				swiftBot.setButtonLight(Button.X, false);
			});

			swiftBot.enableButton(Button.Y, () -> {
				System.out.println("Button Y Pressed.");
				swiftBot.disableButton(Button.Y);
				swiftBot.setButtonLight(Button.Y, false);
			});

			while (System.currentTimeMillis() < endtime) {
				; 
			}
			swiftBot.disableAllButtons(); 
			System.out.println("All buttons are now off.");

		} catch (Exception e) {
			System.out.println("Something went wrong with the buttons");
			e.printStackTrace();
			System.exit(5);
		}

	}

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
			for(int[] colour : compseq){
				for(int code : colour){
					System.out.println(code +",");
				}


			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: failed to set all under lights");
			System.exit(5);
		}

		return seq;
	}
}
