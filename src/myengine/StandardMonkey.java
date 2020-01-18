package myengine;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.List;

public class StandardMonkey extends Actor {

	private double range = 100;
	
	private Point position;

	private double vertical = 225;
	
	private long startTime;

	private long waitTime =200;
	
	private long shooterTime = 2000;
	
	private Line line;

	private View view;


	public StandardMonkey(double x, double y, View view) {
		this(new Point(x, y), view);
	}

    public StandardMonkey(Point position, View view) {
        super(ImageFactory.getInstance().newImage(ImageType.STANDARD_MONKEY));
        this.position = position;
        this.view = view;

        setX(position.getX());
        setY(position.getY());

        setRotate(vertical);
    }


    @Override
	public void act(long now) {
    	getWorld().getChildren().remove(line);
    	if(startTime != 0 && System.currentTimeMillis() < startTime + shooterTime){
    		getWorld().getChildren().remove(line);
    	}
    	if (startTime != 0 && System.currentTimeMillis() < startTime + waitTime)
		    return;
		startTime = 0;

		List<Balloon> balloons = getWorld().getObjects(Balloon.class);
		for (Balloon balloon : balloons) {
			Point p = balloon.getPosition();
			if (p.distanceFrom(position) < range) {
				turnToTarget(p);
				balloon.hit();
				view.notifyHit();
				shoot(p);
				startTime = System.currentTimeMillis();
				return;
			}
		}
    }
    
    public void turnToTarget(Point target) {
        if(target.getY() < position.getY() && target.getX() < position.getX()){
        	setRotate(315);
        }
        else if(target.getY() > position.getY() && target.getX() < position.getX()){
        	setRotate(225);
        }
        else if(target.getY() > position.getY() && target.getX() > position.getX()){
        	setRotate(495);
        }
        else{
        	setRotate(405);
        }
    }
    
    public void shoot(Point target){
    	line = new Line(target.getX() + 10, target.getY() + 12, position.getX() + 22, position.getY() + 22);
    	line.setStroke(Color.RED);
    	line.setStrokeWidth(10);
    	getWorld().getChildren().add(line);
    }

    public static double getCost() {
        return 150;
    }
}
