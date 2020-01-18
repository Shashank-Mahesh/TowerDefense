package myengine;

/**
 * This is the Controller component of the MVC design pattern
 *
 * @author Shashank Mahesh
 */

public class Controller
        implements ViewToController, ModelObservable {

    private ControllerToView view;

    private ImageType imageHighlighted = null;

    private World myWorld = new World(this, new LevelOnePath());

    private int totalMoney = 500;

    private boolean gameOver = false;

    private int numLives = 200;

    private ControllerToModel model = new Model(this);


    public Controller(ControllerToView callingInstance) {
        this.view = callingInstance;
    }

    @Override
    public void start() {
        view.startWorld();
    }

    @Override
    public void onBalloonPassedThrough() {
        numLives--;
        if (numLives <= 0)
            onGameOver();
    }

    @Override
    public void onBalloonHit() {
        totalMoney += 1;
    }

    @Override
    public double getTotalMoney() {
        return totalMoney;
    }

    @Override
    public int getNumLivesRemaining() {
        return numLives;
    }

    private void onGameOver() {
        view.stopWorld();
    }

    @Override
    public void onImageDragged(ImageType imageType) {
        imageHighlighted = imageType;
    }

    @Override
    public void onImageDropped(double x, double y) {
        switch (imageHighlighted) {
            case STANDARD_MONKEY:
                if (StandardMonkey.getCost() > totalMoney) {
                    System.out.println("Not enough Money. Money Right now = " + totalMoney);
                } else {
                    view.placeStandardMonkey(x, y);
                    totalMoney -= StandardMonkey.getCost();
                }
                break;
        }
        imageHighlighted = null;
    }

    @Override
    public World getMyWorld() {
        return myWorld;
    }

    @Override
    public void run() {
        model.run();
    }

    public void onLifeLost() {
        numLives --;

        if (numLives <= 0) {
            gameOver = true;
            onGameOver();
        }
    }

    @Override
    public void placeLevelOneBalloon() {
        view.placeLevelOneBalloon();
    }

    @Override
    public void placeLevelTwoBalloon() {
        view.placeLevelTwoBalloon();
    }

    @Override
    public void placeLevelThreeBalloon() {
        view.placeLevelThreeBalloon();
    }

    @Override
    public void placeLevelFourBalloon() {
        view.placeLevelFourBalloon();
    }

    @Override
    public void placeLevelFiveBalloon() {
        view.placeLevelFiveBalloon();
    }

    @Override
    public void placeLevelSixBalloon() {
        view.placeLevelSixBalloon();
    }

    @Override
    public void placeLevelSevenBalloon() {
        view.placeLevelSevenBalloon();
    }

    @Override
    public void placeLevelEightBalloon() {
        view.placeLevelEightBalloon();
    }

    @Override
    public void placeLevelNineBalloon() {
        view.placeLevelNineBalloon();
    }

    @Override
    public void placeLevelTenBalloon() {
        view.placeLevelTenBalloon();
    }

}
