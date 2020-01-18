package myengine;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The View component of the MVC design pattern
 *
 * This class is responsible for all the GUI elements
 *
 * @author Rishabh Shah
 * @author Shashank Mahesh
 */

public class View extends Application implements ControllerToView {

	private ViewToController controller = new Controller(this);

	private World world;

	private SidePane sidePane = new SidePane(this);

	private BorderPane root = new BorderPane();


	public View() {
		world = controller.getMyWorld();
	}


	@Override
	public void start(Stage stage) throws InterruptedException {
		stage.setTitle("Balloon Tower Defense: The Monkey's Last Stand");
		stage.setScene(new Scene(root, 650, 500));
		stage.setResizable(false);

		root.setCenter(world);
		root.setRight(sidePane);


        AnimationTimer controllerRunner = new AnimationTimer() {
            @Override
            public void handle(long now) {
                controller.run();
                sidePane.updateText();
            }
        };
        controllerRunner.start();

		createSidePane();

		world.start();
		stage.show();
	}

	private void createSidePane() {
		ImageView monkey = ImageFactory.getInstance().newImageView(ImageType.STANDARD_MONKEY);
		sidePane.add(monkey);
		monkey.setOnDragDetected(e -> controller.onImageDragged(ImageType.STANDARD_MONKEY));
		monkey.setOnMouseReleased(e -> controller.onImageDropped(e.getSceneX() - monkey.getFitWidth()/2,
				e.getSceneY() - monkey.getFitHeight()/2));
	}

	

	@Override
	public void placeLevelOneBalloon() {
		world.add(new LevelOneBalloon());
	}

	@Override
	public void placeLevelTwoBalloon() {
		world.add(new LevelTwoBalloon());
	}

	@Override
	public void placeLevelThreeBalloon() {
		world.add(new LevelThreeBalloon());
	}

	@Override
	public void placeLevelFourBalloon() {
		world.add(new LevelFourBalloon());
	}

	@Override
	public void placeLevelFiveBalloon() {
		world.add(new LevelFiveBalloon());
	}
	@Override
	public void placeLevelSixBalloon() {
		world.add(new LevelSixBalloon());
	}

	@Override
	public void placeLevelSevenBalloon() {
		world.add(new LevelSevenBalloon());
	}

	@Override
	public void placeLevelEightBalloon() {
		world.add(new LevelEightBalloon());
	}

	@Override
	public void placeLevelNineBalloon() {
		world.add(new LevelNineBalloon());
	}

	@Override
	public void placeLevelTenBalloon() {
		world.add(new LevelTenBalloon());
	}

	@Override
	public void placeStandardMonkey(double x, double y) {
		world.add(new StandardMonkey(new Point(x, y), this));
	}

	@Override
	public void startWorld() {
		world.start();
	}

	@Override
	public void stopWorld() {
		world.stop();
	}


	public static void main(String[] args) {
		launch(args);
	}

	public void notifyHit() {
		controller.onBalloonHit();
	}

	public double getTotalMoney() {
	    return controller.getTotalMoney();
    }

    public int getNumLivesRemaining() {
        return controller.getNumLivesRemaining();
    }
}