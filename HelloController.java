package com.example.demo;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {

    @FXML
    private ImageView diceIndicatorImage;

    @FXML
    private Button player1dice;

    @FXML
    private Button player2dice;

    @FXML
    private ImageView token1;

    @FXML
    private ImageView token2;

    @FXML
    private TextField lose;

    @FXML
    private TextField win;

    private Stage stage;
    private Scene scene;
    private Parent root;


    public int dice;

    private boolean player1Turn = true;
    private boolean player2Turn = true;

    public  double token1Xpos = 20;
    public double token1Ypos = 0;

    public double token1RevXpos = token1Xpos;

    public double token2Xpos = 20;
    public double token2Ypos = 0;

    public double token2RevXpos = token2Xpos;

    private int rand;

    Image img1 = new Image(getClass().getResourceAsStream("images/dice1.png"));
    Image img2 = new Image(getClass().getResourceAsStream("images/dice2.png"));
    Image img3 = new Image(getClass().getResourceAsStream("images/dice3.png"));
    Image img4 = new Image(getClass().getResourceAsStream("images/dice4.png"));
    Image img5 = new Image(getClass().getResourceAsStream("images/dice5.png"));
    Image img6 = new Image(getClass().getResourceAsStream("images/dice6.png"));

    public void winnerWind() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("winnner.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 331, 233);
        stage.setScene(scene);
        stage.show();
    }

    public void displayImage(){
        dice = (int)(Math.random()*6+1);
        switch (dice){
            case 1:
                diceIndicatorImage.setImage(img1);
                rand = dice;
                break;
            case 2:
                diceIndicatorImage.setImage(img2);
                rand = dice;
                break;
            case 3:
                diceIndicatorImage.setImage(img3);
                rand = dice;
                break;
            case 4:
                diceIndicatorImage.setImage(img4);
                rand = dice;
                break;
            case 5:
                diceIndicatorImage.setImage(img5);
                rand =dice;
                break;
            case 6:
                diceIndicatorImage.setImage(img6);
                rand = dice;
                break;
        }
    }


    public void setTurn(ActionEvent e){
        player1dice.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(player1Turn){
                    displayImage();
                    player1Turn = false;
                    player2Turn = true;
                    player2dice.setDisable(true);
                    try {
                        changePos();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }else{
                    player2dice.setDisable(false);
                    player1dice.setDisable(true);

                }
            }
        });

        player2dice.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(player2Turn){
                    displayImage();
                    player2Turn = false;
                    player1Turn = true;
                    player1dice.setDisable(true);
                    try {
                        changePos2();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }else{
                    player1dice.setDisable(false);
                    player2dice.setDisable(true);

                }
            }
        });
    }
    private TranslateTransition translate1;
    private TranslateTransition translate2;
    public void moveX(){
        translate1 = new TranslateTransition();
        translate1.setNode(token1);
        translate1.setDuration(Duration.seconds(4));
        translate1.setToX(token1Xpos);
        translate1.play();

    }
    public void moveRevX(){
        translate1 = new TranslateTransition();
        translate1.setNode(token1);
        translate1.setDuration(Duration.seconds(4));
        translate1.setToX(token1RevXpos);
        translate1.play();

    }
    public void moveY(){
        translate1 = new TranslateTransition();
        translate1.setNode(token1);
        translate1.setDuration(Duration.seconds(4));
        translate1.setToY(token1Ypos);
        translate1.setToX(token1Xpos);
        translate1.play();
    }

    public void Player1X(){
        if(dice == 1){
            token1Xpos = token1Xpos+60;
            moveX();
        }else if(dice == 2){
            token1Xpos = token1Xpos+120;
            moveX();
        }else if(dice == 3){
            token1Xpos = token1Xpos+180;
            moveX();
        }else if(dice == 4){
            token1Xpos = token1Xpos+240;
            moveX();
        }else if(dice == 5){
            token1Xpos = token1Xpos+300;
            moveX();
        }else{
            token1Xpos = token1Xpos+360;
            moveX();
        }

    }
    public void player1RevX(){
        if(dice == 1){
            token1RevXpos = token1RevXpos-60;
            moveRevX();
        }else if(dice == 2){
            token1RevXpos = token1RevXpos-120;
            moveRevX();
        }else if(dice == 3){
            token1RevXpos = token1RevXpos-180;
            moveRevX();
        }else if(dice == 4){
            token1RevXpos = token1RevXpos-240;
            moveRevX();
        }else if(dice == 5){
            token1RevXpos = token1RevXpos-300;
            moveRevX();
        }else{
            token1RevXpos = token1RevXpos-360;
            moveRevX();
        }

    }
    public void revTofor(){
        if(token1RevXpos == 320 && token1Ypos == token1Ypos){
            if(dice == 6){
                token1Xpos = 20;
                token1Ypos = token1Ypos-54;
                moveY();
                snakeAndLadder();
            }else{
                player1RevX();
                snakeAndLadder();
            }
        }else if(token1RevXpos == 260 && token1Ypos == token1Ypos){
            if(dice == 6){
                token1Xpos = 80;
                token1Ypos = token1Ypos-54;
                moveY();
                snakeAndLadder();
            }else if(dice == 5){
                token1Xpos = 20;
                token1Ypos = token1Ypos-54;
                moveY();
                snakeAndLadder();
            }else{
                player1RevX();
                snakeAndLadder();
            }
        }else if(token1RevXpos == 200 && token1Ypos == token1Ypos){
            if(dice == 6){
                token1Xpos = 140;
                token1Ypos = token1Ypos-54;
                moveY();
                snakeAndLadder();
            }else if(dice == 5){
                token1Xpos = 80;
                token1Ypos = token1Ypos-54;
                moveY();
                snakeAndLadder();
            }else if(dice == 4){
                token1Xpos = 20;
                token1Ypos = token1Ypos-54;
                moveY();
                snakeAndLadder();
            }else {
                player1RevX();
                snakeAndLadder();
            }
        }else if(token1RevXpos == 140 && token1Ypos == token1Ypos){
            if(dice == 6){
                token1Xpos = 200;
                token1Ypos = token1Ypos-54;
                moveY();
                snakeAndLadder();
            }else if(dice== 5){
                token1Xpos = 140;
                token1Ypos = token1Ypos-54;
                moveY();
                snakeAndLadder();
            }else if(dice == 4){
                token1Xpos = 80;
                token1Ypos = token1Ypos-54;
                moveY();
                snakeAndLadder();
            }else if(dice == 3){
                token1Xpos = 20;
                token1Ypos = token1Ypos-54;
                moveY();
                snakeAndLadder();
            }else{
                player1RevX();
                snakeAndLadder();
            }
        }else if(token1RevXpos == 80 && token1Ypos == token1Ypos){
            if(dice == 6){
                token1Xpos = 260;
                token1Ypos = token1Ypos-54;
                moveY();
                snakeAndLadder();
            }else if(dice == 5){
                token1Xpos = 200;
                token1Ypos = token1Ypos-54;
                moveY();
                snakeAndLadder();
            }else if(dice == 4){
                token1Xpos = 140;
                token1Ypos = token1Ypos-54;
                moveY();
                snakeAndLadder();
            }else if(dice == 3){
                token1Xpos = 80;
                token1Ypos = token1Ypos-54;
                moveY();
                snakeAndLadder();
            }else if(dice == 2){
                token1Xpos = 20;
                token1Ypos = token1Ypos-54;
                moveY();
                snakeAndLadder();
            }else{
                player1RevX();
                snakeAndLadder();
            }
        }else if(token1RevXpos == 20 && token1Ypos == token1Ypos){
            if(dice == 6){
                token1Xpos = 320;
                token1Ypos = token1Ypos-54;
                moveY();
                snakeAndLadder();
            }else if(dice == 5){
                token1Xpos = 260;
                token1Ypos = token1Ypos-54;
                moveY();
                snakeAndLadder();
            }else if(dice == 4){
                token1Xpos = 200;
                token1Ypos = token1Ypos-54;
                moveY();
                snakeAndLadder();
            }else if(dice == 3){
                token1Xpos = 140;
                token1Ypos = token1Ypos-54;
                moveY();
                snakeAndLadder();
            }else if(dice == 2){
                token1Xpos = 80;
                token1Ypos = token1Ypos-54;
                moveY();
                snakeAndLadder();
            }else if(dice == 1){
                token1Xpos = 20;
                token1Ypos = token1Ypos-54;
                moveY();
                snakeAndLadder();
            }
        }else{
            player1RevX();
            snakeAndLadder();
        }
    }

    public void forTorev(){
        if(token1Xpos == 260 && token1Ypos == token1Ypos){
            if(dice == 6){
                token1Xpos = 560;
                token1Ypos = token1Ypos-54;
                token1RevXpos = token1Xpos;
                moveY();
                snakeAndLadder();
            }else{
                Player1X();
                snakeAndLadder();
            }
        }else if(token1Xpos == 320 && token1Ypos == token1Ypos){
            if(dice == 6){
                token1Xpos = 500;
                token1Ypos = token1Ypos-54;
                token1RevXpos = token1Xpos;
                moveY();
                snakeAndLadder();
            }else if(dice == 5){
                token1Xpos = 560;
                token1Ypos = token1Ypos-54;
                token1RevXpos = token1Xpos;
                moveY();
                snakeAndLadder();
            }else{
                Player1X();
                snakeAndLadder();
            }
        }else if(token1Xpos == 380 && token1Ypos == token1Ypos){
            if(dice == 6){
                token1Xpos = 440;
                token1Ypos = token1Ypos-54;
                token1RevXpos = token1Xpos;
                moveY();
                snakeAndLadder();
            }else if(dice == 5){
                token1Xpos = 500;
                token1Ypos = token1Ypos-54;
                token1RevXpos = token1Xpos;
                moveY();
                snakeAndLadder();
            }else if(dice == 4){
                token1Xpos = 560;
                token1Ypos = token1Ypos-54;
                token1RevXpos = token1Xpos;
                moveY();
                snakeAndLadder();
            }else{
                Player1X();
                snakeAndLadder();
            }
        }else if(token1Xpos == 440 && token1Ypos == token1Ypos){
            if(dice == 6){
                token1Xpos = 380;
                token1Ypos = token1Ypos-54;
                token1RevXpos = token1Xpos;
                moveY();
                snakeAndLadder();
            }else if(dice == 5){
                token1Xpos = 440;
                token1Ypos = token1Ypos-54;
                token1RevXpos = token1Xpos;
                moveY();
                snakeAndLadder();
            }else if(dice == 4){
                token1Xpos = 500;
                token1Ypos = token1Ypos-54;
                token1RevXpos = token1Xpos;
                moveY();
                snakeAndLadder();
            }else if(dice == 3){
                token1Xpos = 560;
                token1Ypos = token1Ypos-54;
                token1RevXpos = token1Xpos;
                moveY();
                snakeAndLadder();
            }else{
                Player1X();
                snakeAndLadder();
            }
        }else if(token1Xpos == 500 && token1Ypos == token1Ypos){
            if(dice == 6){
                token1Xpos = 320;
                token1Ypos = token1Ypos-54;
                token1RevXpos = token1Xpos;
                moveY();
                snakeAndLadder();
            }else if(dice == 5){
                token1Xpos = 380;
                token1Ypos = token1Ypos-54;
                token1RevXpos = token1Xpos;
                moveY();
                snakeAndLadder();
            }else if(dice == 4){
                token1Xpos = 440;
                token1Ypos = token1Ypos-54;
                token1RevXpos = token1Xpos;
                moveY();
                snakeAndLadder();
            }else if(dice == 3){
                token1Xpos = 500;
                token1Ypos = token1Ypos-54;
                token1RevXpos = token1Xpos;
                moveY();
                snakeAndLadder();
            }else if(dice == 2){
                token1Xpos = 560;
                token1Ypos = token1Ypos-54;
                token1RevXpos = token1Xpos;
                moveY();
                snakeAndLadder();
            }else {
                Player1X();
                snakeAndLadder();
            }
        }else if(token1Xpos == 560 && token1Ypos == token1Ypos){
            if(dice == 6){
                token1Xpos = 260;
                token1Ypos = token1Ypos-54;
                token1RevXpos = token1Xpos;
                moveY();
                snakeAndLadder();
            }else if(dice == 5){
                token1Xpos = 320;
                token1Ypos = token1Ypos-54;
                token1RevXpos = token1Xpos;
                moveY();
                snakeAndLadder();
            }else if(dice == 4){
                token1Xpos = 380;
                token1Ypos = token1Ypos-54;
                token1RevXpos = token1Xpos;
                moveY();
                snakeAndLadder();
            }else if(dice == 3){
                token1Xpos = 440;
                token1Ypos = token1Ypos-54;
                token1RevXpos = token1Xpos;
                moveY();
                snakeAndLadder();
            }else if(dice == 2){
                token1Xpos = 500;
                token1Ypos = token1Ypos-54;
                token1RevXpos = token1Xpos;
                moveY();
                snakeAndLadder();
            }else if(dice == 1){
                token1Xpos = 560;
                token1Ypos = token1Ypos-54;
                token1RevXpos = token1Xpos;
                moveY();
                snakeAndLadder();
            }
        }else {
            Player1X();
            snakeAndLadder();
        }

    }

    public void changePos() throws IOException {
        if(token1Xpos == 380 && token2Ypos == -489){
            if(dice == 6){
                forTorev();
                player1dice.setDisable(true);
                player2dice.setDisable(true);
                win.setText("Player 1");
                lose.setText("Player 2");
                winnerWind();
            }else{
                translate1.stop();
            }
        }else if(token1Xpos == 320 && token2Ypos == -489){
            if(dice == 5){
                forTorev();
                player1dice.setDisable(true);
                player2dice.setDisable(true);
                win.setText("Player 1");
                lose.setText("Player 2");
                winnerWind();
            }else{
                translate1.stop();
            }
        }else if(token1Xpos == 260 && token1Ypos == -489){
            if(dice == 4){
                forTorev();
                player1dice.setDisable(true);
                player2dice.setDisable(true);
                win.setText("Player 1");
                lose.setText("Player 2");
                winnerWind();
            }else{
                translate1.stop();
            }
        }else if(token1Xpos == 200 && token1Ypos == -489){
            if(dice == 3){
                forTorev();
                player1dice.setDisable(true);
                player2dice.setDisable(true);
                win.setText("Player 1");
                lose.setText("Player 2");
                winnerWind();
            }else{
                translate1.stop();
            }
        }else if(token1Xpos == 140 && token1Ypos == -489){
            if(dice == 2){
                forTorev2();
                player1dice.setDisable(true);
                player2dice.setDisable(true);
                win.setText("Player 1");
                lose.setText("Player 2");
                winnerWind();
            }else{
                translate1.stop();
            }
        }else if(token1Xpos == 80 && token1Ypos == -489){
            if(dice == 1){
                forTorev();
                player1dice.setDisable(true);
                player2dice.setDisable(true);
                win.setText("Player 1");
                lose.setText("Player 2");
                winnerWind();
            }else{
                translate1.stop();
            }
        } else if(token1Ypos == 0){
            forTorev();
        }else if(token1Ypos == -54){
            revTofor();
        }else if(token1Ypos == -108){
            forTorev();
        }else if(token1Ypos == -162){
            revTofor();
        }else if(token1Ypos == -216){
            forTorev();
        }else if(token1Ypos == -270){
            revTofor();
        }else if(token1Ypos == -324){
            forTorev();
        }else if(token1Ypos == -378){
            revTofor();
        }else if(token1Ypos == -432){
            forTorev();
        }else if(token1Ypos == -486){
            revTofor();
        }
    }

    public void moveX1(){
        translate2 = new TranslateTransition();
        translate2.setNode(token2);
        translate2.setDuration(Duration.seconds(4));
        translate2.setToX(token2Xpos);
        translate2.play();

    }
    public void moveRevX1(){
        translate2 = new TranslateTransition();
        translate2.setNode(token2);
        translate2.setDuration(Duration.seconds(4));
        translate2.setToX(token2RevXpos);
        translate2.play();

    }

    public void moveY1(){
        translate2 = new TranslateTransition();
        translate2.setNode(token2);
        translate2.setDuration(Duration.seconds(4));
        translate2.setToY(token2Ypos);
        translate2.setToX(token2Xpos);
        translate2.play();
    }
    public void Player2X(){
        if(dice == 1){
            token2Xpos = token2Xpos +60;
            moveX1();
        }else if(dice == 2){
            token2Xpos = token2Xpos +120;
            moveX1();
        }else if(dice == 3){
            token2Xpos = token2Xpos +180;
            moveX1();
        }else if(dice == 4){
            token2Xpos = token2Xpos +240;
            moveX1();
        }else if(dice == 5){
            token2Xpos = token2Xpos +300;
            moveX1();
        }else{
            token2Xpos = token2Xpos +360;
            moveX1();
        }

    }
    public void player2RevX(){
        if(dice == 1){
            token2RevXpos = token2RevXpos -60;
            moveRevX1();
        }else if(dice == 2){
            token2RevXpos = token2RevXpos -120;
            moveRevX1();
        }else if(dice == 3){
            token2RevXpos = token2RevXpos -180;
            moveRevX1();
        }else if(dice == 4){
            token2RevXpos = token2RevXpos -240;
            moveRevX1();
        }else if(dice == 5){
            token2RevXpos = token2RevXpos -300;
            moveRevX1();
        }else{
            token2RevXpos = token2RevXpos -360;
            moveRevX1();
        }

    }

    public void revTofor2(){
        if(token2RevXpos == 320 && token2Ypos == token2Ypos){
            if(dice == 6){
                token2Xpos = 20;
                token2Ypos = token2Ypos -54;
                moveY1();
                snakeAndLadder2();
            }else{
                player2RevX();
                snakeAndLadder2();
            }
        }else if(token2RevXpos == 260 && token2Ypos == token2Ypos){
            if(dice == 6){
                token2Xpos = 80;
                token2Ypos = token2Ypos -54;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 5){
                token2Xpos = 20;
                token2Ypos = token2Ypos -54;
                moveY1();
                snakeAndLadder2();
            }else{
                player2RevX();
                snakeAndLadder2();
            }
        }else if(token2RevXpos == 200 && token2Ypos == token2Ypos){
            if(dice == 6){
                token2Xpos = 140;
                token2Ypos = token2Ypos -54;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 5){
                token2Xpos = 80;
                token2Ypos = token2Ypos -54;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 4){
                token2Xpos = 20;
                token2Ypos = token2Ypos -54;
                moveY1();
                snakeAndLadder2();
            }else {
                player2RevX();
                snakeAndLadder2();
            }
        }else if(token2RevXpos == 140 && token2Ypos == token2Ypos){
            if(dice == 6){
                token2Xpos = 200;
                token2Ypos = token2Ypos -54;
                moveY1();
                snakeAndLadder2();
            }else if(dice== 5){
                token2Xpos = 140;
                token2Ypos = token2Ypos -54;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 4){
                token2Xpos = 80;
                token2Ypos = token2Ypos -54;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 3){
                token2Xpos = 20;
                token2Ypos = token2Ypos -54;
                moveY1();
                snakeAndLadder2();
            }else{
                player2RevX();
                snakeAndLadder2();
            }
        }else if(token2RevXpos == 80 && token2Ypos == token2Ypos){
            if(dice == 6){
                token2Xpos = 260;
                token2Ypos = token2Ypos -54;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 5){
                token2Xpos = 200;
                token2Ypos = token2Ypos -54;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 4){
                token2Xpos = 140;
                token2Ypos = token2Ypos -54;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 3){
                token2Xpos = 80;
                token2Ypos = token2Ypos -54;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 2){
                token2Xpos = 20;
                token2Ypos = token2Ypos -54;
                moveY1();
                snakeAndLadder2();
            }else{
                player2RevX();
                snakeAndLadder2();
            }
        }else if(token2RevXpos == 20 && token2Ypos == token2Ypos){
            if(dice == 6){
                token2Xpos = 320;
                token2Ypos = token2Ypos -54;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 5){
                token2Xpos = 260;
                token2Ypos = token2Ypos -54;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 4){
                token2Xpos = 200;
                token2Ypos = token2Ypos -54;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 3){
                token2Xpos = 140;
                token2Ypos = token2Ypos -54;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 2){
                token2Xpos = 80;
                token2Ypos = token2Ypos -54;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 1){
                token2Xpos = 20;
                token2Ypos = token2Ypos -54;
                moveY1();
                snakeAndLadder2();
            }
        }else{
            player2RevX();
            snakeAndLadder2();
        }
    }

    public void forTorev2(){
        if(token2Xpos == 260 && token2Ypos == token2Ypos){
            if(dice == 6){
                token2Xpos = 560;
                token2Ypos = token2Ypos -54;
                token2RevXpos = token2Xpos;
                moveY1();
                snakeAndLadder2();
            }else{
                Player2X();
                snakeAndLadder2();
            }
        }else if(token2Xpos == 320 && token2Ypos == token2Ypos){
            if(dice == 6){
                token2Xpos = 500;
                token2Ypos = token2Ypos -54;
                token2RevXpos = token2Xpos;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 5){
                token2Xpos = 560;
                token2Ypos = token2Ypos -54;
                token2RevXpos = token2Xpos;
                moveY1();
                snakeAndLadder2();
            }else{
                Player2X();
                snakeAndLadder2();
            }
        }else if(token2Xpos == 380 && token2Ypos == token2Ypos){
            if(dice == 6){
                token2Xpos = 440;
                token2Ypos = token2Ypos -54;
                token2RevXpos = token2Xpos;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 5){
                token2Xpos = 500;
                token2Ypos = token2Ypos -54;
                token2RevXpos = token2Xpos;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 4){
                token2Xpos = 560;
                token2Ypos = token2Ypos -54;
                token2RevXpos = token2Xpos;
                moveY1();
                snakeAndLadder2();
            }else{
                Player2X();
                snakeAndLadder2();
            }
        }else if(token2Xpos == 440 && token2Ypos == token2Ypos){
            if(dice == 6){
                token2Xpos = 380;
                token2Ypos = token2Ypos -54;
                token2RevXpos = token2Xpos;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 5){
                token2Xpos = 440;
                token2Ypos = token2Ypos -54;
                token2RevXpos = token2Xpos;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 4){
                token2Xpos = 500;
                token2Ypos = token2Ypos -54;
                token2RevXpos = token2Xpos;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 3){
                token2Xpos = 560;
                token2Ypos = token2Ypos -54;
                token2RevXpos = token2Xpos;
                moveY1();
                snakeAndLadder2();
            }else{
                Player2X();
                snakeAndLadder2();
            }
        }else if(token2Xpos == 500 && token2Ypos == token2Ypos){
            if(dice == 6){
                token2Xpos = 320;
                token2Ypos = token2Ypos -54;
                token2RevXpos = token2Xpos;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 5){
                token2Xpos = 380;
                token2Ypos = token2Ypos -54;
                token2RevXpos = token2Xpos;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 4){
                token2Xpos = 440;
                token2Ypos = token2Ypos -54;
                token2RevXpos = token2Xpos;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 3){
                token2Xpos = 500;
                token2Ypos = token2Ypos -54;
                token2RevXpos = token2Xpos;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 2){
                token2Xpos = 560;
                token2Ypos = token2Ypos -54;
                token2RevXpos = token2Xpos;
                moveY1();
                snakeAndLadder2();
            }else {
                Player2X();
                snakeAndLadder2();
            }
        }else if(token2Xpos == 560 && token2Ypos == token2Ypos){
            if(dice == 6){
                token2Xpos = 260;
                token2Ypos = token2Ypos -54;
                token2RevXpos = token2Xpos;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 5){
                token2Xpos = 320;
                token2Ypos = token2Ypos -54;
                token2RevXpos = token2Xpos;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 4){
                token2Xpos = 380;
                token2Ypos = token2Ypos -54;
                token2RevXpos = token2Xpos;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 3){
                token2Xpos = 440;
                token2Ypos = token2Ypos -54;
                token2RevXpos = token2Xpos;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 2){
                token2Xpos = 500;
                token2Ypos = token2Ypos -54;
                token2RevXpos = token2Xpos;
                moveY1();
                snakeAndLadder2();
            }else if(dice == 1){
                token2Xpos = 560;
                token2Ypos = token2Ypos -54;
                token2RevXpos = token2Xpos;
                moveY1();
                snakeAndLadder2();
            }
        }else {
            Player2X();
            snakeAndLadder2();
        }

    }

    public void changePos2() throws IOException {
        if(token1Xpos == 380 && token2Ypos == -489){
            if(dice == 6){
                forTorev2();
                player1dice.setDisable(true);
                player2dice.setDisable(true);
                win.setText("Player 2");
                lose.setText("Player 1");
                winnerWind();
            }else{
                translate2.stop();
            }
        }else if(token1Xpos == 320 && token2Ypos == -489){
            if(dice == 5){
                forTorev2();
                player1dice.setDisable(true);
                player2dice.setDisable(true);
                win.setText("Player 2");
                lose.setText("Player 1");
                winnerWind();
            }else{
                translate2.stop();
            }
        }else if(token1Xpos == 260 && token1Ypos == -489){
            if(dice == 4){
                forTorev2();
                player1dice.setDisable(true);
                player2dice.setDisable(true);
                win.setText("Player 2");
                lose.setText("Player 1");
                winnerWind();
            }else{
                translate2.stop();
            }
        }else if(token1Xpos == 200 && token1Ypos == -489){
            if(dice == 3){
                forTorev2();
                player1dice.setDisable(true);
                player2dice.setDisable(true);
                win.setText("Player 2");
                lose.setText("Player 1");
                winnerWind();
            }else{
                translate2.stop();
            }
        }else if(token1Xpos == 140 && token1Ypos == -489){
            if(dice == 2){
                forTorev2();
                player1dice.setDisable(true);
                player2dice.setDisable(true);
                win.setText("Player 2");
                lose.setText("Player 1");
                winnerWind();
            }else{
                translate2.stop();
            }
        }else if(token1Xpos == 80 && token1Ypos == -489) {
            if (dice == 1) {
                forTorev2();
                player1dice.setDisable(true);
                player2dice.setDisable(true);
                win.setText("Player 2");
                lose.setText("Player 1");
                winnerWind();
            }else{
                translate2.stop();
            }
        }else if(token1Xpos == 20 && token2Ypos == -486){
            player2dice.setDisable(true);
        }else if(token2Ypos == 0){
            forTorev2();
        }else if(token2Ypos == -54){
            revTofor2();
        }else if(token2Ypos == -108){
            forTorev2();
        }else if(token2Ypos == -162){
            revTofor2();
        }else if(token2Ypos == -216){
            forTorev2();
        }else if(token2Ypos == -270){
            revTofor2();
        }else if(token2Ypos == -324){
            forTorev2();
        }else if(token2Ypos == -378){
            revTofor2();
        }else if(token2Ypos == -432){
            forTorev2();
        }else if(token2Ypos == -486){
            revTofor2();
        }
    }

    public void snakeAndLadder(){
        if(token1Xpos == 260 && token1Ypos == 0){
            token1Xpos = 200;
            token1Ypos = -108;
            moveY();
        }else if(token1Xpos == 20 && token1Ypos == -108){
            token1Xpos = 140;
            token1Ypos = -270;
            moveY();
        }else if(token1Xpos == 560 && token1Ypos == -108){
            token1Xpos = 560;
            token1Ypos = -270;
            moveY();
        }else if(token1Xpos == 380 && token1Ypos == -162){
            token1Xpos = 320;
            token1Ypos = -270;
            moveY();
        }else if(token1Xpos == 500 && token1Ypos == -324){
            token1Xpos = 380;
            token1Ypos = -486;
            moveY();
        }else if(token1Xpos == 440 && token1Ypos == -108){
            token1Xpos = 380;
            token1Ypos = 0;
            moveY();
        }else if(token1Xpos == 200 && token1Ypos == -216){
            token1Xpos = 260;
            token1Ypos = -108;
            moveY();
        }else if(token1Xpos == 140 && token1Ypos == -378){
            token1Xpos = 20;
            token1Ypos = -324;
            moveY();
        }else if(token1Xpos == 380 && token1Ypos == -432){
            token1Xpos = 320;
            token1Ypos = -324;
            moveY();
        }else if(token1Xpos == 140 && token1Ypos == -486){
            token1Xpos = 560;
            token1Ypos = 0;
            moveY();
        }
    }

    public void snakeAndLadder2(){
        if(token2Xpos == 260 && token2Ypos == 0){
            token2Xpos = 200;
            token2Ypos = -108;
            moveY1();
        }else if(token2Xpos == 20 && token2Ypos == -108){
            token2Xpos = 140;
            token2Ypos = -270;
            moveY1();
        }else if(token2Xpos == 560 && token2Ypos == -108){
            token2Xpos = 560;
            token2Ypos = -270;
            moveY1();
        }else if(token2Xpos == 380 && token2Ypos == -162){
            token2Xpos = 320;
            token2Ypos = -270;
            moveY1();
        }else if(token2Xpos == 500 && token2Ypos == -324){
            token2Xpos = 380;
            token2Ypos = -486;
            moveY1();
        }else if(token2Xpos == 440 && token2Ypos == -108){
            token2Xpos = 380;
            token2Ypos = 0;
            moveY1();
        }else if(token2Xpos == 200 && token2Ypos == -216){
            token2Xpos = 260;
            token2Ypos = -108;
            moveY1();
        }else if(token2Xpos == 140 && token2Ypos == -378){
            token2Xpos = 20;
            token2Ypos = -324;
            moveY1();
        }else if(token2Xpos == 380 && token2Ypos == -432){
            token2Xpos = 320;
            token2Ypos = -324;
            moveY1();
        }else if(token2Xpos == 140 && token2Ypos == -486){
            token2Xpos = 560;
            token2Ypos = 0;
            moveY1();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }






}
