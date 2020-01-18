package myengine;

/**
 * Created by Rishabh on 5/26/17.
 */
public class LevelEightBalloon extends Balloon {

    /**
     * Allocates a new Balloon object using the given image.
     */
    public LevelEightBalloon() {
        super(ImageFactory.getInstance().newImage(ImageType.LEVEL_8_BALLOON), 8, 1);
    }

}
