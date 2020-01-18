package myengine;

/**
 * This interface represents a contract between a Controller and a View.
 * The View must implement this interface, and a Controller can use this
 * to gather information from the View.
 *
 * @author Shashank Mahesh
 */

public interface ControllerToView {

    public void placeLevelOneBalloon();

    public void placeLevelTwoBalloon();

    public void placeLevelThreeBalloon();

    public void placeLevelFourBalloon();

    public void placeLevelFiveBalloon();

    public void placeLevelSixBalloon();

    public void placeLevelSevenBalloon();

    public void placeLevelEightBalloon();

    public void placeLevelNineBalloon();

    public void placeLevelTenBalloon();

    public void placeStandardMonkey(double x, double y);

    public void startWorld();

    public void stopWorld();

}