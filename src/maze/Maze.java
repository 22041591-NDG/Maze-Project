package maze;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Maze extends Component {
    public Label levelNumber;
    public Canvas canvas;
    private int levelCounter = 1;
    private int col,row,endRow,endCol,curCol,curRow;
    protected final int w = 70;
    protected final int h = 70;
    private String[][] maze = new String[10][10];

    public Maze(){
        this.setMinSize(750,750);
        canvas = new Canvas(770,770);
        this.setCenter(canvas);
        writeToFile();
        load();
        Image image = new Image(getClass().getResource("/pic1.png").toString());
        ImageView imageview = new ImageView(image);
        imageview.setFitHeight(350);
        imageview.setFitWidth(350);
        this.setBackground(new Background(new BackgroundImage(image,null,null,null,null)));
    }
    @Override
    public void load(){
        levelNumber = new Label();
        levelNumber.setMaxHeight(30);
        levelNumber.setMaxWidth(800);
        levelNumber.setText("Level : " +String.valueOf(levelCounter)+"\t\t\t(You are the Purple. Get to the White using buttons provide.)");
        levelNumber.setFont(Font.font("arial", FontWeight.BOLD, FontPosture.REGULAR,20));
        this.setTop(levelNumber);
        int i ;
        Button moveUp,moveDown,moveRight,moveLeft;
        moveRight = new Button("Right");
        moveLeft  = new Button("Left");
        moveDown  = new Button("Down");
        moveUp    = new Button("Up");
        moveRight.setPadding(new Insets(20,30,10,30));
        moveLeft.setPadding(new Insets(20,30,10,30));
        moveUp.setPadding(new Insets(20,30,10,30));
        moveDown.setPadding(new Insets(20,30,10,30));
        FlowPane flowBottom = new FlowPane();
        flowBottom.getChildren().addAll(moveLeft,moveRight,moveDown,moveUp);
        this.setBottom(flowBottom);
        String e = "",e1 = "",e2 = "",e3 = "",e4 = "",e5 = "",e6 = "",e7 = "",e8 = "",e9 = "";
        String[] mazeArray = new String[0];
            try (Scanner in = new Scanner(new File("file.txt"))){
                while(in.hasNextLine()){
                    String temp = in.nextLine();
                    String[] ar= temp.split(",");
                    e  += ar[0] + ",";
                    e1 += ar[1] + ",";
                    e2 += ar[2] + ",";
                    e3 += ar[3] + ",";
                    e4 += ar[4] + ",";
                    e5 += ar[5] + ",";
                    e6 += ar[6] + ",";
                    e7 += ar[7] + ",";
                    e8 += ar[8] + ",";
                    e9 += ar[9] + ",";
                }
            } catch (FileNotFoundException e10) {
                e10.printStackTrace();
            }
        for(i=0; i<=9 ; i++){ mazeArray = e.split(",");
            drawMaze(canvas.getGraphicsContext2D(),mazeArray[i],0,i*70);
            maze[0][i] = mazeArray[i];
        }
        for(i=0; i<=9 ; i++){ mazeArray = e1.split(",");
            drawMaze(canvas.getGraphicsContext2D(),mazeArray[i],70,i*70);
            maze[1][i] = mazeArray[i];
        }
        for(i=0; i<=9 ; i++){ mazeArray = e2.split(",");
            drawMaze(canvas.getGraphicsContext2D(),mazeArray[i],140,i*70);
            maze[2][i] = mazeArray[i];
        }
        for(i=0; i<=9 ; i++){ mazeArray = e3.split(",");
            drawMaze(canvas.getGraphicsContext2D(),mazeArray[i],210,i*70);
            maze[3][i] = mazeArray[i];
        }
        for(i=0; i<=9; i++){  mazeArray = e4.split(",");
            drawMaze(canvas.getGraphicsContext2D(),mazeArray[i],280,i*70);
            maze[4][i] = mazeArray[i];
        }
        for(i=0; i<=9; i++){  mazeArray = e5.split(",");
            drawMaze(canvas.getGraphicsContext2D(),mazeArray[i],350,i*70);
            maze[5][i] = mazeArray[i];
        }
        for(i=0; i<=9; i++){  mazeArray = e6.split(",");
            drawMaze(canvas.getGraphicsContext2D(),mazeArray[i],420,i*70);
            maze[6][i] = mazeArray[i];
        }
        for(i=0; i<=9; i++){  mazeArray = e7.split(",");
            drawMaze(canvas.getGraphicsContext2D(),mazeArray[i],490,i*70);
            maze[7][i] = mazeArray[i];
        }
        for(i=0; i<=9; i++){  mazeArray = e8.split(",");
            drawMaze(canvas.getGraphicsContext2D(),mazeArray[i],560,i*70);
            maze[8][i] = mazeArray[i];
        }
        for(i=0; i<=9; i++){  mazeArray = e9.split(",");
            drawMaze(canvas.getGraphicsContext2D(),mazeArray[i],630,i*70);
            maze[9][i] = mazeArray[i];
        }
        moveRight.setOnAction(event ->{
            if((maze[curCol+1][curRow]) != "." ){
                moveInMaze(canvas.getGraphicsContext2D(), Color.LIME, col, row);
                col += 70;
                moveInMaze(canvas.getGraphicsContext2D(), Color.PURPLE, col, row);
                curCol++;
                    if (col == endCol && row == endRow) {
                    System.out.println("You have completed the level.");
                    levelCounter++;
                    writeToFile();
                    load();
                        highScoresUpdate();
                }
            }
            else{System.out.println("This is an illegal move");}
        });
        moveLeft.setOnAction(event ->{
                if ((maze[curCol-1][curRow]) != "." && curCol >0){
                moveInMaze(canvas.getGraphicsContext2D(), Color.LIME, col, row);
                col -= 70;
                moveInMaze(canvas.getGraphicsContext2D(), Color.PURPLE, col, row);
                curCol--;
                if (col == endCol && row == endRow) {
                    System.out.println("You have completed the level.");
                    levelCounter++;
                    writeToFile();
                    load();
                    highScoresUpdate();
                }
            }else{System.out.println("This is an illegal move");}
        });
        moveUp.setOnAction(event ->{
            if(maze[curCol][curRow-1] != "." && curCol > 0){
                moveInMaze(canvas.getGraphicsContext2D(), Color.LIME, col, row);
                row -= 70;
                moveInMaze(canvas.getGraphicsContext2D(), Color.PURPLE, col, row);
                curRow--;
                if (col == endCol && row == endRow) {
                    System.out.println("You have completed the level.");
                    levelCounter++;
                    writeToFile();
                    load();
                    highScoresUpdate();
                }
            }else{System.out.println("This is an illegal move");}
        });
        moveDown.setOnAction(event -> {
            if (maze[curCol][curRow+1] != "." && curCol < 9){
                moveInMaze(canvas.getGraphicsContext2D(), Color.LIME, col, row);
                row += 70;
                moveInMaze(canvas.getGraphicsContext2D(), Color.PURPLE, col, row);
                curRow++;
                if (col == endCol && row == endRow) {
                    System.out.println("You have completed the level.");
                    levelCounter++;
                    writeToFile();
                    load();
                    highScoresUpdate();
                }
            }else{System.out.println("This is an illegal move");}
        });
    }
    private void drawMaze(GraphicsContext g, String mazeValue, Integer startX, Integer startY){
        g.setLineWidth(5);
        switch(mazeValue){
            case "*": g.setFill(Color.BLACK);
                g.fillRect(startX,startY,w,h);
                break;
            case ".": g.setFill(Color.LIME);
                g.fillRect(startX,startY,w,h);
                break;
            case "S":g.setFill(Color.PURPLE);
                g.fillRect(startX,startY,w,h);
                col = startX;
                row = startY;
                curCol = startX / 70;
                curRow = startY / 70;
                break;
            case "E":g.setFill(Color.WHITE);
                g.fillRect(startX,startY,w,h);
                endCol = startX;
                endRow = startY;
                break;
            default : System.out.println("Something is wrong");
                break;
        }
    }
    protected void moveInMaze(GraphicsContext g, Color color, Integer startX,Integer startY){
        g.setLineWidth(5);
        g.setFill(color);
        g.fillRect(startX,startY,w,h);
    }
    private void writeToFile(){
        int r = 10, c = 10;

        // build maze and initialize with only walls
        StringBuilder s = new StringBuilder(c);
        for(
                int x = 0;
                x<c;x++)
            s.append('*');
        char[][] maz = new char[r][c];
        for(
                int x = 0;
                x<r;x++)maz[x]=s.toString().

                toCharArray();

        // select random point and open as start node
        Point st = new Point((int) (Math.random() * r), (int) (Math.random() * c), null);
        maz[st.r][st.c]='S';

        // iterate through direct neighbors of node
        ArrayList<Point> frontier = new ArrayList<Point>();
        for(
                int x = -1;
                x <=1;x++)
            for(
                    int y = -1;
                    y <=1;y++)

            {
                if (x == 0 && y == 0 || x != 0 && y != 0)
                    continue;
                try {
                    if (maz[st.r + x][st.c + y] == '.') continue;
                } catch (Exception e) { // ignore ArrayIndexOutOfBounds
                    continue;
                }
                // add eligible points to frontier
                frontier.add(new Point(st.r + x, st.c + y, st));
            }

        Point last = null;
        while(!frontier.isEmpty())

        {

            // pick current node at random
            Point cu = frontier.remove((int) (Math.random() * frontier.size()));
            Point op = cu.opposite();
            try {
                // if both node and its opposite are walls
                if (maz[cu.r][cu.c] == '*') {
                    if (maz[op.r][op.c] == '*') {

                        // open path between the nodes
                        maz[cu.r][cu.c] = '.';
                        maz[op.r][op.c] = '.';

                        // store last node in order to mark it later
                        last = op;

                        // iterate through direct neighbors of node, same as earlier
                        for (int x = -1; x <= 1; x++)
                            for (int y = -1; y <= 1; y++) {
                                if (x == 0 && y == 0 || x != 0 && y != 0)
                                    continue;
                                try {
                                    if (maz[op.r + x][op.c + y] == '.') continue;
                                } catch (Exception e) {
                                    continue;
                                }
                                frontier.add(new Point(op.r + x, op.c + y, op));
                            }
                    }
                }
            } catch (Exception e) { // ignore NullPointer and ArrayIndexOutOfBounds
            }

            // if algorithm has resolved, mark end node
            if (frontier.isEmpty())
                maz[last.r][last.c] = 'E';
        }

        // print final maze
        String mazeString = "";
        PrintWriter pw = null;
        try{
            pw = new PrintWriter("file.txt");

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    pw.write(String.valueOf(maz[i][j]));
                    pw.write(",");
                }
                pw.write("\n");
            }
            pw.flush();
            pw.close();
        }catch(
                FileNotFoundException e){
            e.printStackTrace();
        }
    }
    class Point {
        Integer r;
        Integer c;
        Point parent;
        public Point(int x, int y, Point p) {
            r = x;
            c = y;
            parent = p;
        }
        // compute opposite node given that it is in the other direction from the parent
        public Point opposite() {
            if (this.r.compareTo(parent.r) != 0)
                return new Point(this.r + this.r.compareTo(parent.r), this.c, this);
            if (this.c.compareTo(parent.c) != 0)
                return new Point(this.r, this.c + this.c.compareTo(parent.c), this);
            return null;
        }
    }
    private void highScoresUpdate(){
        String lowest = null;
        String scores = "";
        String l1="",l2="",l3="",l4="",l5="";
        try(Scanner in = new Scanner(new File("scores.txt"))){
            while(in.hasNext()){
                l1 = in.nextLine();
                l2 = in.nextLine();
                l3 = in.nextLine();
                l4 = in.nextLine();
                l5 = in.nextLine();
            }
            String[] lastLine = l5.split("\t");
            lowest = lastLine[2];
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("Old lowest" + lowest);
        System.out.println("New lowest" + levelCounter);

        if(levelCounter > Integer.parseInt(lowest)){
        scores = scores +l1+"\n"+l2+"\n"+l3+"\n"+l4+"\n";
        PrintWriter pw = null;
            try{
             pw = new PrintWriter("scores.txt");
             scores+= "5\tPlayer1\t"+levelCounter;
             pw.write(scores);
             pw.flush();
             pw.close();
            }catch (FileNotFoundException e){
            e.printStackTrace();
            }
        }
    }
}
