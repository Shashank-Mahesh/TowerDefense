package myengine;

/**
 * Created by Shashank Mahesh on 05 12, 2017
 *
 * @author Shashank Mahesh
 */
public class LevelTwoBalloon extends Balloon {

    /**
     * Allocates a new Balloon object using the given image.
     */
    public LevelTwoBalloon() {
        super(ImageFactory.getInstance().newImage(ImageType.LEVEL_2_BALLOON), 2, 2);
    }

}