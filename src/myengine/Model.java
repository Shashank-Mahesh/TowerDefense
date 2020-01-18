package myengine;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * This class is used to transfer and receive game data with a partner program. It will parse the data it receives into 
 * a SpriteData object that can be used by the controller. It will also send information about the sprites in GamePane 
 * to the partner program. 
 * 
 * @author Pranav Atreya
 * @author Shashank Mahesh
 */

public class Model implements ControllerToModel {

	private long numTimes = 0;
	private long maxTimes = 50;
	private double randFactor = 0.004;

	private Set<ModelObservable> observers = new HashSet<>();

	private Scanner scanner = new Scanner(System.in);

	/**
	 * Default constructor for Model
	 */
	public Model(ModelObservable observable) {
		observers.add(observable);
	}

	public void onMessageReceived() {
		//Conditions will go here, such as-
		//if (something) then observers.forEach(o -> o.doSomething());

		observers.forEach(observer -> observer.placeLevelOneBalloon());
		wait(0.5);
		observers.forEach(observer -> observer.placeLevelTwoBalloon());
		wait(0.5);
		observers.forEach(observer -> observer.placeLevelThreeBalloon());
		wait(0.5);
		observers.forEach(observer -> observer.placeLevelFourBalloon());
		wait(0.5);
		observers.forEach(observer -> observer.placeLevelFiveBalloon());
		wait(0.5);
		observers.forEach(observer -> observer.placeLevelSixBalloon());
		wait(0.5);
		observers.forEach(observer -> observer.placeLevelSevenBalloon());
		wait(0.5);
		observers.forEach(observer -> observer.placeLevelEightBalloon());
		wait(0.5);
		observers.forEach(observer -> observer.placeLevelNineBalloon());
		wait(0.5);
		observers.forEach(observer -> observer.placeLevelTenBalloon());
	}

	public void wait (double seconds){
		double time = System.currentTimeMillis();
		while ((System.currentTimeMillis()-time) < seconds){}
	}

	@Override
	public void run() {
		double rand = Math.random();
		if (rand < randFactor){
			onMessageReceived();
			if(Math.random() < 0.1) {
				numTimes++;
				randFactor += 0.003;
			}
		}
	}

}
