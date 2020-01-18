package myengine;

/**
 * Created by Shashank Mahesh on 05 12, 2017
 *
 * @author Shashank Mahesh
 */
public class LevelFourBalloon extends Balloon {

    /**
     * Allocates a new Balloon object using the given image.
     */
    public LevelFourBalloon() {
        super(ImageFactory.getInstance().newImage(ImageType.LEVEL_4_BALLOON), 4, 3);
    }

}