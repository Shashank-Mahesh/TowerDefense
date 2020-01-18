package myengine;

/**
 * Created by Rishabh on 5/26/17.
 */

public class LevelSixBalloon extends Balloon {

    /**
     * Allocates a new Balloon object using the given image.
     */
    public LevelSixBalloon() {
        super(ImageFactory.getInstance().newImage(ImageType.LEVEL_6_BALLOON), 6, 1);
    }

}
