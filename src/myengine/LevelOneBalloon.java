package myengine;

/**
 * Created by Shashank Mahesh on 05 12, 2017
 *
 * @author Shashank Mahesh
 */
public class LevelOneBalloon extends Balloon {

    /**
     * Allocates a new Balloon object using the given image.
     */
    public LevelOneBalloon() {
        super(ImageFactory.getInstance().newImage(ImageType.LEVEL_1_BALLOON), 1, 1);
    }

}