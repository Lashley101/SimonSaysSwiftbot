package DoesMySwiftbotWork.DoesMySwiftbotWorkTest;

import swiftbot.*;
import java.awt.image.BufferedImage;
import java.util.Random;


//Explain what the project is here <<<<<<<<<<<<

//REMEMBER TO COMMENT ALL LINES OF CODE (EXPLAIN WHAT IT DOES AND WHY YOU HAVE IT THERE)
//CONSIDER USING INHERITENCE WHEN IMPLEMENTING THE ROAMING/MOVEMENT OF SWIFTBOT
//QR.IO

public class Detect_Object_Project {

	static SwiftBotAPI swiftBot;
	static boolean QRValidation = false;
	static String Mode = "";
	static int leftWheelVelocity = 0;
	static int rightWheelVelocity = 0;
	static int[][] colours = {
			{ 255, 0, 0 }, // Red
			{ 0, 255, 0 }, // Green
			{ 0, 0, 255 }, // Blue
	};

	public static void main(String[] args) throws InterruptedException {

		swiftBot = new SwiftBotAPI();
		System.out.println("Detect Object program");
		System.out.println("");
		System.out.println("");
		System.out.println("Please select the following modes using a QR code as an input:");
		System.out.println("");
		System.out.println("Curious");
		System.out.println("Scaredy");
		System.out.println("Dubious");
		System.out.println("");
		System.out.println("Press the 'X' button to exit the program");

		swiftBot.enableButton(Button.X, () -> {
			System.out.println("Bye Bye!!");
			leftWheelVelocity = 0;
			rightWheelVelocity = 0;
			swiftBot.disableUnderlights();
			System.exit(5);
		});


		while(QRValidation == false){
			BufferedImage img = swiftBot.getQRImage();
			String decodedMessage = swiftBot.decodeQRImage(img);


			if (!decodedMessage.isEmpty()) {
				System.out.println("");
				System.out.println("");
				System.out.println("SUCCESS: QR code found");
				System.out.println("Decoded message: " + decodedMessage);
				System.out.println("");
				QRValidation = InputValidation(decodedMessage);
				if (QRValidation != true) {
					System.out.println("The inputted QR code is invalid.");
					System.out.println("Please select the following modes using a QR code as an input:");
					System.out.println("");
					System.out.println("Curious");
					System.out.println("Scaredy");
					System.out.println("Dubious");
					System.out.println("");
				}
				else {
					Thread.sleep(2000);
					String LCDM = decodedMessage.toLowerCase();
					LCDM = LCDM.trim();
					switch(LCDM) {
					case "curious":
						Mode = LCDM;
						CuriousSwiftBot();
						break;
					case "scaredy":
						Mode = LCDM;
						ScaredySwiftBot();
						break;
					case "dubious":
						Mode = LCDM;
						DubiousSwiftBot();
						break;

					}
				}
			}
		}
	}


	private static boolean InputValidation(String msg) {
		String lmsg = msg.toLowerCase();
		lmsg = lmsg.trim();
		switch(lmsg) {
		case "curious":
			System.out.println("Curious has been inputted");
			System.out.println("Curious mode has been selected");
			System.out.println("");
			return true;
		case "scaredy":
			System.out.println("Scaredy has been inputted");
			System.out.println("Scaredy mode has been selected");
			System.out.println("");
			return true;
		case "dubious":
			System.out.println("Dubious has been inputted");
			System.out.println("Dubious mode has been selected");
			System.out.println("");
			return true;
		default:
			return false;
		}
	}

	//This Method is the behaviour of the SwiftBot while it is roaming and searching for an object
	private static void Roaming() throws InterruptedException {
		Random rotation = new Random();

		//Roaming Thread
		Thread RoamingThread = new Thread(() -> {
			while(!Thread.currentThread().isInterrupted()){
				try {
					swiftBot.fillUnderlights(colours[2]);
					int mode = rotation.nextInt(25,50);
					int direction = rotation.nextInt(1,3);
					if(direction == 1) {
						leftWheelVelocity = mode;
						rightWheelVelocity = 0;
					}
					else {
						leftWheelVelocity = 0;
						rightWheelVelocity = mode;
					}
					//SwiftBot changing roaming direction
					swiftBot.move(leftWheelVelocity, rightWheelVelocity, 1500);
					//SwiftBot Roaming settings
					leftWheelVelocity = 30;
					rightWheelVelocity = 30;
					//SwiftBot moving for 5 seconds
					swiftBot.move(leftWheelVelocity, rightWheelVelocity, 5000);
					Thread.sleep(500);



					Thread.sleep(250);

				} catch (Exception e) {
					System.out.println("");
					System.out.println("Roaming thread interrupted, stopping...");
					System.out.println("");
					leftWheelVelocity = 0;
					rightWheelVelocity = 0;
					swiftBot.move(leftWheelVelocity, rightWheelVelocity, 50);
					return;
				}
			}
		});

		//End of Roaming Thread
		//Distance Checker Thread
		Thread ObjectChecker = new Thread(() -> {
			while(true) {
				try {
					double distance = swiftBot.useUltrasound();
					System.out.print(distance);
					System.out.println("");
					if(distance < 50 && distance != 0) {
						RoamingThread.interrupt();
						System.out.println("");
						System.out.println("Object Detected!!!");
						System.out.println("");
						swiftBot.disableUnderlights();
						Thread.sleep(500);
						return;
					}
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		});
		//End of Distance Checker Thread
		//Runs the Roaming Thread and the Object detector simultaneously 
		RoamingThread.start();
		Thread.sleep(1500);
		ObjectChecker.start();

		while (ObjectChecker.isAlive()) {
			;
		}
	}






	//Method for the Curious SwiftBot
	private static void CuriousSwiftBot() throws InterruptedException{
		double TravelDistance = 0;
		double distance = swiftBot.useUltrasound();
		while(true) {
			Roaming();
			distance = swiftBot.useUltrasound();
			System.out.println("ATTEMPTING TO RUN CURIOUS SWIFTBOT!!!");
			System.out.println(distance);

			while(distance <= 29.5 || distance >= 30.5) {
				System.out.println(distance);
				swiftBot.fillUnderlights(colours[1]);
				while(distance <= 29.5) {
					
					if(distance != 0) {
						leftWheelVelocity = -50;
						rightWheelVelocity = -50;
						TravelDistance = (30 - distance)/18;
						TravelDistance = TravelDistance*1000;
						System.out.println(TravelDistance+" MilliSeconds");
						swiftBot.move(leftWheelVelocity, rightWheelVelocity, ((int) TravelDistance)+50);

					}
					distance = swiftBot.useUltrasound();
				}

				while(distance >= 30.5 && distance < 50) {
					System.out.println(distance);
					if(distance != 0) {
						leftWheelVelocity = 50;
						rightWheelVelocity = 50;
						TravelDistance = (distance - 30)/18;
						TravelDistance = TravelDistance*1000;
						System.out.println(TravelDistance+" MilliSeconds");
						swiftBot.move(leftWheelVelocity, rightWheelVelocity, ((int) TravelDistance)+50);
					}
					distance = swiftBot.useUltrasound();
				}

				if(distance > 50) {
					System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
					System.out.println("Warning! Object has moved further away than the detection range!");
					System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
					long startTime = System.currentTimeMillis();
					long endTime = startTime + 7000; // 7 seconds 
					do{
						distance = swiftBot.useUltrasound();
						swiftBot.disableUnderlights();
						Thread.sleep(150);
						distance = swiftBot.useUltrasound();
						swiftBot.fillUnderlights(colours[0]);
						Thread.sleep(150);

					}while((distance > 50 || distance == 0) && System.currentTimeMillis() < endTime);
					if(distance >50 || distance == 0) {
						System.out.println("Object has not been found. Returning to roaming...");
						break;
					}
				}
			}
			if(distance >= 29.5 && distance <= 30.5) {
				swiftBot.disableUnderlights();
				Thread.sleep(150);
				swiftBot.fillUnderlights(colours[1]);
				Thread.sleep(150);
				swiftBot.disableUnderlights();
				System.out.println("REACHED TARGET DISTANCE!!!!!");
				Thread.sleep(5000);
				System.out.println("Resuming Roaming");
			}
		}
	}






	//Method for the Scaredy SwiftBot
	private static void ScaredySwiftBot() throws InterruptedException{
		Roaming();

	}



	//Method for the Dubious SwiftBot
	private static void DubiousSwiftBot() {
		try {
			//Creates a new instance of Random called 'Rand'
			Random rand = new Random();
			//Sets the integer 'mode' to an integer between 1(inclusive) and 3(exclusive)
			int mode = rand.nextInt(1,3);
			//UI output explaining what is happening above
			System.out.println("");
			System.out.println("Dubious SwiftBot randomly selects one of the other modes to run.");
			System.out.println("A random mode has been selected");
			System.out.println("");
			//Waits a 2 seconds to not overwhelm the user
			Thread.sleep(2000);
			//The Switch dictates which method will be selected based on the integer generated
			switch(mode) {
			case 1:
				//If it is the number '1' then CuriousSwiftBot will be ran
				System.out.println("Curious mode has been selected!");
				CuriousSwiftBot();
				break;
			case 2:
				//If it is the number '2' then ScaredySwiftBot will be ran
				System.out.println("Scaredy mode has been selected!");
				ScaredySwiftBot();
				break;
				//It is ran in case there is an error selecting the number
			default:
				System.out.println("SOMETHING HAS GONE WRONG WITH DUBIOUS RANDOMISER");
				break;
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(5);
		}

	}


}






