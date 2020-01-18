package myengine;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

/**
 * The <code>World</code> interface should be used when a background or
 * backdrop is to be attached to a JavaFX application. It is to be used
 * with <code>GamePane</code>. All classes that implement the <code>World</code>
 * interface absolutely must extend <code>Pane</code> or higher.
 *
 * @author Shashank Mahesh
 */
public class World extends Pane {

    private Background background;

    private Controller controller;

    private AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            getObjects(Actor.class).forEach(actor -> actor.act(now));
        }
    };

    public World(Controller controller, Background background) {
        this.background = background;
        this.controller = controller;
        getChildren().add(0, background);
    }

    /**
     * Starts the timer that calls the act method on the world and on each Actor in the world each frame.
     */
    public void start() {
        timer.start();
    }


    /**
     * Stops the timer that calls the act method.
     */
    public void stop() {
        timer.stop();
    }


    /**
     * Getter for the background in this world
     * @return the Background for this World
     */
    public Background getWorldBackground() {
        return background;
    }

    /**
     * Adds the given actor to the world. Remember that since a World is a Pane, all you need to do is get the
     * Children list of the Pane and add the Actor to it.
     *
     * @param actor - the actor to add
     */
    public void add(Actor actor) {
        getChildren().add(actor);
        actor.onWorldAttached();
    }
  

    /**
     * Removes the given actor from the world. The implementation is similar to add() but instead of adding to the
     * existing child list, you are removing from it.
     *
     * @param actor - the actor to remove
     */
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }


    /**
     * Returns a list of all the actors in the world of the given class. Implementation directions: The method header
     * is given to you already so just copy it as is. What you need to do is to first make some kind of List
     * (for example: ArrayList) of type A objects. Then iterate through that list and if all of the following
     * conditions are met, then add the Actor to the list and return the list after the loop is finished.
     *
     * @param cls - The type of actor that will be in the list
     * @param <T> - The type of actors
     * @return - a list of all the actors in the world of the given class.
     */
    public <T extends Actor> java.util.List<T> getObjects(java.lang.Class<T> cls) {
        List<T> objects = new ArrayList<>();
        for (Node child : getChildren()) {
            if (cls.isAssignableFrom(child.getClass())) {
                objects.add((T) child);
            }
        }
        return objects;
    }

    public void onLifeLost() {
        controller.onLifeLost();
    }

}