package myengine;

/**
 * Created by Rishabh on 5/26/17.
 */
public class LevelNineBalloon extends Balloon {

    /**
     * Allocates a new Balloon object using the given image.
     */
    public LevelNineBalloon() {
        super(ImageFactory.getInstance().newImage(ImageType.LEVEL_9_BALLOON), 9, 3);
    }

}
