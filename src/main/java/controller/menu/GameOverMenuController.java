package controller.menu;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import util.UserData;

/**
 * The controller class for the game over menu (managed by FXML sheet).
 *
 */
public class GameOverMenuController {

    @FXML
    private BorderPane pane;

    @FXML
    private Label deathSegment;

    @FXML
    private Label playingTime;

    @FXML
    private Label totalPoints;

    /**
     * Sets size of the BorderPane.
     * 
     * @param x
     * @param y
     */
    public void setSize(final double x, final double y) {
        this.pane.setPrefWidth(x);
        this.pane.setPrefHeight(y);
    }

    /**
     * Modifies labels to show points and stopwatch.
     * 
     * @param deathSegment
     * @param totalSegments
     * @param userData
     */
    public void setInfoToDisplay(final int deathSegment, final int totalSegments, final UserData userData) {
        this.deathSegment.setText("Died at segment:" + deathSegment + "/" + totalSegments);
        this.playingTime.setText("Playing time: " + userData.getTime());
        this.totalPoints.setText("Total points: " + userData.getPoints());
    }
}
