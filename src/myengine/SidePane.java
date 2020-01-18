package myengine;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Created by Shashank Mahesh on 05 19, 2017
 *
 * @author Shashank Mahesh
 */
public class SidePane extends StackPane {

    private BorderPane sideStack;

    private GridPane gridPane = new GridPane();

    private final static int IMAGE_DIMENSION = 60;

    private Text text = new Text();

    private int nextX = 0;

    private int nextY = 0;

    private View view;


    public SidePane(View view) {
        this(new ImageView(ImageFactory.getInstance().newImage(ImageType.SIDE_MENU)), view);
    }

    public SidePane(ImageView sidePaneBackground, View view) {
        super(sidePaneBackground);
        this.view = view;

        sideStack = new BorderPane(gridPane);
        updateText();
        sideStack.setTop(text);

        getChildren().add(sideStack);
        gridPane.setAlignment(Pos.CENTER);

        text.setFont(Font.font("Roboto", FontWeight.BOLD, 19));
        text.setFill(Color.WHITE);
        text.setLineSpacing(7);

        BorderPane.setMargin(text, new Insets(20));
    }

    public void updateText() {
        text.setText("Money: " + view.getTotalMoney() + "\nLives: " + view.getNumLivesRemaining());

    }

    public void add(ImageView imageView) {
        imageView.setFitHeight(IMAGE_DIMENSION);
        imageView.setFitWidth(IMAGE_DIMENSION);

        gridPane.add(imageView, nextX, nextY);
        updateNextCoordinates(2);
    }

    private void updateNextCoordinates(int maxX) {
        if (nextX == maxX - 1) {
            nextX = 0;
            nextY++;
        } else {
            nextX++;
        }
    }
}
