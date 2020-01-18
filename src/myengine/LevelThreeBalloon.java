package myengine;

/**
 * Created by Shashank Mahesh on 05 12, 2017
 *
 * @author Shashank Mahesh
 */
public class LevelThreeBalloon extends Balloon {

    /**
     * Allocates a new Balloon object using the given image.
     */
    public LevelThreeBalloon() {
        super(ImageFactory.getInstance().newImage(ImageType.LEVEL_3_BALLOON), 3, 2);
    }

}