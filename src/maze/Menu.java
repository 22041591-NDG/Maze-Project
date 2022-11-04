package maze;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class Menu extends Application {
    public static void main(String[] args){
        launch(args);
    }
    private Stage newStage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane menuPage = new BorderPane();
        primaryStage.setScene(new Scene(menuPage,500,500));
        primaryStage.setTitle("Menu");
        primaryStage.show();
        Button btnStartGame = new Button("Start Game");
        btnStartGame.setPadding(new Insets(70,20,70,20));
        Button btnHighScores = new Button("High Scores");
        btnHighScores.setPadding(new Insets(70,20,70,20));
        Button btnRules = new Button("Rules");
        btnRules.setPadding(new Insets(20,20,20,20));
            Pane flowTop = new Pane();
        Text textMenu = new Text("Menu");
        textMenu.setFont(Font.font("arial", FontWeight.BOLD, FontPosture.REGULAR,40));
        flowTop.getChildren().add(textMenu);
        textMenu.setX(196);
        textMenu.setY(40);
        ((BorderPane) menuPage).setTop(flowTop);
            FlowPane flowButtons = new FlowPane(Orientation.VERTICAL);
        flowButtons.setVgap(5);
        ((BorderPane) menuPage).setRight(flowButtons);
        flowButtons.getChildren().add(btnStartGame);
        flowButtons.getChildren().add(btnHighScores);
            FlowPane flowBottom = new FlowPane(Orientation.HORIZONTAL);
        flowBottom.getChildren().addAll(btnRules);
        flowBottom.setPadding(new Insets(10,10,10,190));
        ((BorderPane) menuPage).setBottom(flowBottom);
            Button btnCloseComponent = new Button("Close");

        Image image = new Image(getClass().getResource("/pic2.jpg").toString());
        ImageView imageview = new ImageView(image);
        imageview.setFitHeight(350);
        imageview.setFitWidth(350);
        menuPage.setBackground(new Background(new BackgroundImage(image,null,null,null,null)));

        btnCloseComponent.setOnAction(event ->{
            newStage.close();
            primaryStage.show();
        });
        btnStartGame.setOnAction(event ->{
            Maze mazePage = new Maze();
            newStage = new Stage();
            newStage.setScene(new Scene(mazePage));
            newStage.setTitle("Maze");
            mazePage.setRight(btnCloseComponent);
            btnCloseComponent.setPadding(new Insets(20,20,20,20));
            primaryStage.close();
            newStage.show();
        });
        btnHighScores.setOnAction(event ->{
            HighScores highScores = new HighScores();
            newStage = new Stage();
            newStage.setScene(new Scene(highScores, 500,500));
            newStage.setTitle("High Scores");
            highScores.setBottom(btnCloseComponent);
            btnCloseComponent.setPadding(new Insets(20,20,20,20));
            newStage.show();
            primaryStage.close();
        });
        btnRules.setOnAction(event ->{
            Rules rules = new Rules();
            newStage = new Stage();
            newStage.setScene(new Scene(rules,500,500));
            newStage.setTitle("Rules");
            newStage.show();
            rules.getChildren().add(btnCloseComponent);
            primaryStage.close();
        });
    }
}
