package maze;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HighScores extends Component {

    public HighScores(){
        FlowPane flowBottom = new FlowPane(Orientation.HORIZONTAL);
        flowBottom.setHgap(30);
        flowBottom.setPadding(new Insets(20,20,10,100));
        FlowPane flowTop = new FlowPane(Orientation.HORIZONTAL);
        Label lblHighScores = new Label("High Scores");
        lblHighScores.setFont(Font.font("arial", FontWeight.BOLD, FontPosture.REGULAR,20));
        lblHighScores.setTextFill(Color.WHITE);
        flowTop.getChildren().add(lblHighScores);
        flowTop.setHgap(200);
        flowTop.setPadding(new Insets(20,20,10,20));
        this.setTop(flowTop);
        this.setBackground(new Background(new BackgroundFill(Color.BLACK,null,null)));
        load();
    }
    @Override
    public void load() {
        Label scores = new Label();
        scores.setPadding(new Insets(10,10,10,10));
        scores.setTextFill(Color.WHITE);
        scores.setFont(Font.font("arial", FontWeight.NORMAL, FontPosture.REGULAR,20));
        String scoreText  ="";
        try(Scanner in = new Scanner(new File("scores.txt"))){
            while(in.hasNext()){
                String temp    = in.nextLine();
                scoreText+= temp+"\n";
            }

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        this.setCenter(scores);
        scores.setText(scoreText);
    }
}
