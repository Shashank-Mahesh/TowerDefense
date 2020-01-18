package myengine;

/**
 * Created by Rishabh on 5/26/17.
 */
public class LevelSevenBalloon extends Balloon {

    /**
     * Allocates a new Balloon object using the given image.
     */
    public LevelSevenBalloon() {
        super(ImageFactory.getInstance().newImage(ImageType.LEVEL_7_BALLOON), 7, 1);
    }

}
