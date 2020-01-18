package myengine;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class will produce new images on a method call. It is also a singleton class.
 *
 * @author Shashank Mahesh
 */
public class ImageFactory {

    private static ImageFactory imageFactory = new ImageFactory();

    private ImageFactory() {
    }

    /**
     * Get the singleton object for the ImageFactory class
     * @return the singleton
     */
    public static ImageFactory getInstance() {
        return imageFactory;
    }

    /**
     * Creates and returns a new image of the ImageType passed in
     * @param imageType - Enum representation of the image that is to be created
     * @return new Image of imageType
     */
    public Image newImage(ImageType imageType) {
        String path;
        switch (imageType) {
            case LEVEL_1_BALLOON:
                path = "file:balloon_blue.png";
                break;
            case LEVEL_2_BALLOON:
                path = "file:balloon_red.png";
                break;
            case LEVEL_3_BALLOON:
                path = "file:balloon_green.png";
                break;
            case LEVEL_4_BALLOON:
                path = "file:balloon_yellow.png";
                break;
            case LEVEL_5_BALLOON:
                path = "file:balloon_pink.png";
                break;
            case LEVEL_6_BALLOON:
                path = "file:balloon_black.png";
                break;
            case LEVEL_7_BALLOON:
                path = "file:balloon_white.png";
                break;
            case LEVEL_8_BALLOON:
                path = "file:balloon_lead.png";
                break;
            case LEVEL_9_BALLOON:
                path = "file:balloon_rainbow.png";
                break;
            case LEVEL_10_BALLOON:
                path = "file:balloon_ceramic.png";
                break;
            case LEVEL_1_PATH:
                path = "file:BTDPath.png";
                break;
            case LEVEL_2_PATH:
                path = "file:BTDPath2.png";
                break;
            case SIDE_MENU:
                path = "file:SideMenu.png";
                break;
            case STANDARD_MONKEY:
                path = "file:standard_monkey.png";
                break;
            case POPPED:
                path = "file:popped_balloon.png";
                break;
            default:
                return null;
        }

        return new Image(path);
    }

    public ImageView newImageView(ImageType imageType) {
        return new ImageView(newImage(imageType));
    }

}