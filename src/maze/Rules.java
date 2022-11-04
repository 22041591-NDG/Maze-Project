package maze;

import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Rules extends FlowPane implements Interface {
    private Label topLabel;

    public Rules(){
    this.setOrientation(Orientation.VERTICAL);
    this.setVgap(25);
    topLabel = new Label("RULES");
    topLabel.setFont(Font.font("arial", FontWeight.BOLD, FontPosture.REGULAR,40));
    FlowPane flowTop = new FlowPane(Orientation.HORIZONTAL);
    flowTop.getChildren().add(topLabel);
    this.getChildren().add(flowTop);
    Image image = new Image(getClass().getResource("/pic3.png").toString());
    ImageView imageview = new ImageView(image);
    imageview.setFitHeight(300);
    imageview.setFitWidth(400);
    this.setBackground(new Background(new BackgroundImage(image,null,null,null,null)));
    loadRules();
    }
    @Override
    public void loadRules() {
        Label label = new Label();
        label.setText("You find yourself in a maze. Will you find your way \nout?" +
                      "\nYou are the purple avatar. Get to the goal (white block).\nProgress through different mazes to add your name \nto the maze wall of fame, if you can...");
        label.setFont(Font.font("arial", FontWeight.NORMAL, FontPosture.REGULAR,20));
        this.getChildren().add(label);
    }
}
