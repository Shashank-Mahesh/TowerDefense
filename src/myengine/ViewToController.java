package myengine;

/**
 * This interface represents a contract between a Controller and a View.
 * The Controller must implement this interface, and a View can use this
 * to gather information from the Controller.
 *
 * @author Shashank Mahesh
 */

public interface ViewToController extends Runnable {

    public void onImageDragged(ImageType imageType);

    public void onImageDropped(double x, double y);

    public World getMyWorld();

    public void start();

    public void onBalloonPassedThrough();

    public void onBalloonHit();

    public double getTotalMoney();

    public int getNumLivesRemaining();

}