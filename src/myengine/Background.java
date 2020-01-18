package myengine;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class represents the Background image in the game
 *
 * @author Shashank Mahesh
 */

public abstract class Background extends ImageView {

    public Background(Image image) {
        super(image);
        setFitHeight(500);
        setFitWidth(500);
    }

    public abstract Point getStartingPoint();

    public abstract Point getNextPoint(Point currPoint);

}