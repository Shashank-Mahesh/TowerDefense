package myengine;

/**
 * This interface represents a contract between a Controller and a Model.
 * The Model must implement this interface, and a Controller can use this
 * to gather information from the Model.
 *
 * TODO- More methods will be added as soon as the Model is finalized
 *
 * @author Shashank Mahesh & Pranav Atreya
 */
public interface ControllerToModel extends Runnable {

	/**
	 * Builds and returns a SpriteData object based on information passed in from the opponent's program
	 * 
	 * @return - the SpriteData object used for creating Sprites and displaying the opponent's ongoing game
	 */
//    public SpriteData getOpponentData();
    
    
    /**
     * Sends information about the current state of the game to the opponent program
     * 
     * @param gameData - The SpriteData object containing information about the current game state
     */
//    public void sendGameData(SpriteData gameData);

}