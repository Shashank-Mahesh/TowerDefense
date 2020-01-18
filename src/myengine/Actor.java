package myengine;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public abstract class Actor
        extends ImageView
        implements Serializable {

    /**
     * Allocates a new ImageView object using the given image.
     *
     * @param image Image that this ImageView uses
     */
    public Actor(Image image) {
        super(image);
    }

    /**
     * This method is called every frame once start has been called on the world.
     *
     * @param now - the current time in nanoseconds.
     */
    public abstract void act(long now);

    /**
     * Called by the World a world is attached to this Actor
     */
    public void onWorldAttached() {
    }

    /**
     * Moves this actor by the given dx and dy.
     *
     * @param dx - the amount to move vertically (change in x)
     * @param dy - the amount to move vertically (change in y)
     */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
     * Returns the myengine.World this actor is in, or null if it is not in a world. Remember that myengine.World is a
     * subclass of Pane and in JavaFX, a Pane keeps track of all its child Nodes for you. Therefore, to get the
     * myengine.World an myengine.Actor is in, use the Pane method getParent() and cast it into a myengine.World.
     *
     * @return the myengine.World this actor is in, or null if it is not in a world
     */
    public World getWorld() {
        return (getParent() instanceof World) ? (World) getParent() : null;
    }

    /**
     * Returns The width of the current image of this actor. Doing this will take two steps. First you have to get the
     * Bounds of the ImageView (myengine.Actor) and then you have to ask the Bounds object for its width.
     *
     * @return the width of the current image of this actor, taking into account any transformations.
     */
    public double getWidth() {
        return getBoundsInLocal().getWidth();
    }

    /**
     * Returns The height of the current image of this actor. Doing this will take two steps. First you have to get the
     * Bounds of the ImageView (myengine.Actor) and then you have to ask the Bounds object for its height.
     *
     * @return the height of the current image of this actor, taking into account any transformations.
     */
    public double getHeight() {
        return getBoundsInLocal().getHeight();
    }

    /**
     * Returns a list of the actors of a given type intersecting this actor. Implementation directions: The method
     * header is given to you already so just copy it as is. What you need to do is to first make some kind of List
     * (for example: ArrayList) of type T objects. Then iterate through that list and if all of the following conditions
     * are met, then add the myengine.Actor to the list and return the list after the loop is finished.
     *
     * Conditions for being added to the list:
     * - The object isn't yourself ('this' object)
     * - The object's Class type matches the method parameter's Class type
     * - The object intersects you ('this' object)
     *
     * Note: An myengine.Actor is a Node and Node already has intersection handling via its intersects() method.
     * Look it up in the Node API.
     *
     *
     * @param cls -The type of intersecting actors that should be in the list
     * @param <T> - the class of intersecting actors that will be in the returned list
     *
     * @return a list of all actors of the given type intersecting this actor
     */
    public <T extends Actor> java.util.List<T> getIntersectingObjects(java.lang.Class<T> cls) {
        List<T> intersectors = new ArrayList<>();
        List<T> siblingNodes = getWorld().getObjects(cls);
        for (T actor : siblingNodes) {
            if (actor.intersects(getBoundsInLocal()) && actor != this) {
                intersectors.add(actor);
            }

        }

        return intersectors;
    }

}
