package myengine;

/**
 * Created by Rishabh on 5/26/17.
 */
public class LevelTenBalloon extends Balloon {

    /**
     * Allocates a new Balloon object using the given image.
     */
    public LevelTenBalloon() {
        super(ImageFactory.getInstance().newImage(ImageType.LEVEL_10_BALLOON), 10, 2);
    }

}