package myengine;

/**
 * Created by Rishabh on 5/26/17.
 */
public class LevelFiveBalloon extends Balloon {

    public LevelFiveBalloon() {
        super(ImageFactory.getInstance().newImage(ImageType.LEVEL_5_BALLOON), 5, 3);
    }

}
