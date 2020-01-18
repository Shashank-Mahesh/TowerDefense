package myengine;

import javafx.scene.image.Image;

/**
 * Created by Shashank Mahesh on 05 20, 2017
 *
 * @author Shashank Mahesh
 */
public class Balloon extends Actor {

    private Point position;

    private Background background;

    private int hitPoints;

    private int level;

    private int speed;


    public Balloon(Image image, int level, int speed) {
        super(image);
        this.hitPoints = level;
        this.level = level;
        this.speed = speed;
    }

    public int getNumHitPoints() {
        return hitPoints;
    }


    private long hitTime = -1;

    public void hit() {
        hitPoints--;
        level--;
        this.setImage(new Image ("file:popped_balloon.png"));

        if (hitPoints < 1) {
            hitTime = System.currentTimeMillis();
            setImage(ImageFactory.getInstance().newImage(ImageType.POPPED));
        } else {
            switch (hitPoints) {
                case 1:
                    this.setImage(ImageFactory.getInstance().newImage(ImageType.LEVEL_1_BALLOON));
                    break;
                case 2:
                    this.setImage(ImageFactory.getInstance().newImage(ImageType.LEVEL_2_BALLOON));
                    break;
                case 3:
                    this.setImage(ImageFactory.getInstance().newImage(ImageType.LEVEL_3_BALLOON));
                    break;
                case 4:
                    this.setImage(ImageFactory.getInstance().newImage(ImageType.LEVEL_4_BALLOON));
                    break;
                case 5:
                    this.setImage(ImageFactory.getInstance().newImage(ImageType.LEVEL_5_BALLOON));
                    break;
                case 6:
                    this.setImage(ImageFactory.getInstance().newImage(ImageType.LEVEL_6_BALLOON));
                    break;
                case 7:
                    this.setImage(ImageFactory.getInstance().newImage(ImageType.LEVEL_7_BALLOON));
                    break;
                case 8:
                    this.setImage(ImageFactory.getInstance().newImage(ImageType.LEVEL_8_BALLOON));
                    break;
                case 9:
                    this.setImage(ImageFactory.getInstance().newImage(ImageType.LEVEL_9_BALLOON));
                    break;
            }
        }
    }


    @Override
    public void act(long now) {
        updatePosition();
        if (hitTime == -1) {
            for (int i=0; i<speed; i++) {
                position = background.getNextPoint(position);
                if (position == null) {
                    getWorld().onLifeLost();
                    getWorld().remove(this);
                    return;
                }
            }
        }
        else {
            if (System.currentTimeMillis() - hitTime > 50)
                getWorld().remove(this);
        }
    }

    @Override
    public void onWorldAttached() {
        background = getWorld().getWorldBackground();
        position = background.getStartingPoint();
        updatePosition();
    }

    public Point getPosition(){
        return position;
    }

    private void updatePosition() {
        setX(position.getX() - getWidth()/2);
        setY(position.getY() - getHeight()/2);
    }

}
