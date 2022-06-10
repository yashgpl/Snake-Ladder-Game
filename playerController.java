//package com.example.demo;
//
//import javafx.animation.TranslateTransition;
//import javafx.util.Duration;
//import com.example.demo.HelloController;
//import com.example.demo.ladder;
//
//
//public class playerController implements snake{
//    public  double token1Xpos = 20;
//    public double token1Ypos = 0;
//
//    public double token1RevXpos = token1Xpos;
//
//    private TranslateTransition translate1;
//
//    public void moveX(){
//        translate1 = new TranslateTransition();
//        translate1.setNode(token1);
//        translate1.setDuration(Duration.seconds(4));
//        translate1.setToX(token1Xpos);
//        translate1.play();
//
//    }
//
//    public void moveRevX(){
//        translate1 = new TranslateTransition();
//        translate1.setNode(token1);
//        translate1.setDuration(Duration.seconds(4));
//        translate1.setToX(token1RevXpos);
//        translate1.play();
//
//    }
//    public void moveY(){
//        translate1 = new TranslateTransition();
//        translate1.setNode(token1);
//        translate1.setDuration(Duration.seconds(4));
//        translate1.setToY(token1Ypos);
//        translate1.setToX(token1Xpos);
//        translate1.play();
//    }
//    public void Player1X(){
//        if(dice == 1){
//            token1Xpos = token1Xpos+60;
//            moveX();
//        }else if(dice == 2){
//            token1Xpos = token1Xpos+120;
//            moveX();
//        }else if(dice == 3){
//            token1Xpos = token1Xpos+180;
//            moveX();
//        }else if(dice == 4){
//            token1Xpos = token1Xpos+240;
//            moveX();
//        }else if(dice == 5){
//            token1Xpos = token1Xpos+300;
//            moveX();
//        }else{
//            token1Xpos = token1Xpos+360;
//            moveX();
//        }
//
//    }
//    public void player1RevX(){
//        if(dice == 1){
//            token1RevXpos = token1RevXpos-60;
//            moveRevX();
//        }else if(dice == 2){
//            token1RevXpos = token1RevXpos-120;
//            moveRevX();
//        }else if(dice == 3){
//            token1RevXpos = token1RevXpos-180;
//            moveRevX();
//        }else if(dice == 4){
//            token1RevXpos = token1RevXpos-240;
//            moveRevX();
//        }else if(dice == 5){
//            token1RevXpos = token1RevXpos-300;
//            moveRevX();
//        }else{
//            token1RevXpos = token1RevXpos-360;
//            moveRevX();
//        }
//
//    }
//
//    public void revTofor(){
//        if(token1RevXpos == 320 && token1Ypos == token1Ypos){
//            if(dice == 6){
//                token1Xpos = 20;
//                token1Ypos = token1Ypos-54;
//                moveY();
//                snakeAndLadder();
//            }else{
//                player1RevX();
//                snakeAndLadder();
//            }
//        }else if(token1RevXpos == 260 && token1Ypos == token1Ypos){
//            if(dice == 6){
//                token1Xpos = 80;
//                token1Ypos = token1Ypos-54;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 5){
//                token1Xpos = 20;
//                token1Ypos = token1Ypos-54;
//                moveY();
//                snakeAndLadder();
//            }else{
//                player1RevX();
//                snakeAndLadder();
//            }
//        }else if(token1RevXpos == 200 && token1Ypos == token1Ypos){
//            if(dice == 6){
//                token1Xpos = 140;
//                token1Ypos = token1Ypos-54;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 5){
//                token1Xpos = 80;
//                token1Ypos = token1Ypos-54;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 4){
//                token1Xpos = 20;
//                token1Ypos = token1Ypos-54;
//                moveY();
//                snakeAndLadder();
//            }else {
//                player1RevX();
//                snakeAndLadder();
//            }
//        }else if(token1RevXpos == 140 && token1Ypos == token1Ypos){
//            if(dice == 6){
//                token1Xpos = 200;
//                token1Ypos = token1Ypos-54;
//                moveY();
//                snakeAndLadder();
//            }else if(dice== 5){
//                token1Xpos = 140;
//                token1Ypos = token1Ypos-54;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 4){
//                token1Xpos = 80;
//                token1Ypos = token1Ypos-54;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 3){
//                token1Xpos = 20;
//                token1Ypos = token1Ypos-54;
//                moveY();
//                snakeAndLadder();
//            }else{
//                player1RevX();
//                snakeAndLadder();
//            }
//        }else if(token1RevXpos == 80 && token1Ypos == token1Ypos){
//            if(dice == 6){
//                token1Xpos = 260;
//                token1Ypos = token1Ypos-54;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 5){
//                token1Xpos = 200;
//                token1Ypos = token1Ypos-54;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 4){
//                token1Xpos = 140;
//                token1Ypos = token1Ypos-54;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 3){
//                token1Xpos = 80;
//                token1Ypos = token1Ypos-54;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 2){
//                token1Xpos = 20;
//                token1Ypos = token1Ypos-54;
//                moveY();
//                snakeAndLadder();
//            }else{
//                player1RevX();
//                snakeAndLadder();
//            }
//        }else if(token1RevXpos == 20 && token1Ypos == token1Ypos){
//            if(dice == 6){
//                token1Xpos = 320;
//                token1Ypos = token1Ypos-54;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 5){
//                token1Xpos = 260;
//                token1Ypos = token1Ypos-54;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 4){
//                token1Xpos = 200;
//                token1Ypos = token1Ypos-54;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 3){
//                token1Xpos = 140;
//                token1Ypos = token1Ypos-54;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 2){
//                token1Xpos = 80;
//                token1Ypos = token1Ypos-54;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 1){
//                token1Xpos = 20;
//                token1Ypos = token1Ypos-54;
//                moveY();
//                snakeAndLadder();
//            }
//        }else{
//            player1RevX();
//            snakeAndLadder();
//        }
//    }
//
//    public void forTorev(){
//        if(token1Xpos == 260 && token1Ypos == token1Ypos){
//            if(dice == 6){
//                token1Xpos = 560;
//                token1Ypos = token1Ypos-54;
//                token1RevXpos = token1Xpos;
//                moveY();
//                snakeAndLadder();
//            }else{
//                Player1X();
//                snakeAndLadder();
//            }
//        }else if(token1Xpos == 320 && token1Ypos == token1Ypos){
//            if(dice == 6){
//                token1Xpos = 500;
//                token1Ypos = token1Ypos-54;
//                token1RevXpos = token1Xpos;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 5){
//                token1Xpos = 560;
//                token1Ypos = token1Ypos-54;
//                token1RevXpos = token1Xpos;
//                moveY();
//                snakeAndLadder();
//            }else{
//                Player1X();
//                snakeAndLadder();
//            }
//        }else if(token1Xpos == 380 && token1Ypos == token1Ypos){
//            if(dice == 6){
//                token1Xpos = 440;
//                token1Ypos = token1Ypos-54;
//                token1RevXpos = token1Xpos;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 5){
//                token1Xpos = 500;
//                token1Ypos = token1Ypos-54;
//                token1RevXpos = token1Xpos;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 4){
//                token1Xpos = 560;
//                token1Ypos = token1Ypos-54;
//                token1RevXpos = token1Xpos;
//                moveY();
//                snakeAndLadder();
//            }else{
//                Player1X();
//                snakeAndLadder();
//            }
//        }else if(token1Xpos == 440 && token1Ypos == token1Ypos){
//            if(dice == 6){
//                token1Xpos = 380;
//                token1Ypos = token1Ypos-54;
//                token1RevXpos = token1Xpos;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 5){
//                token1Xpos = 440;
//                token1Ypos = token1Ypos-54;
//                token1RevXpos = token1Xpos;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 4){
//                token1Xpos = 500;
//                token1Ypos = token1Ypos-54;
//                token1RevXpos = token1Xpos;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 3){
//                token1Xpos = 560;
//                token1Ypos = token1Ypos-54;
//                token1RevXpos = token1Xpos;
//                moveY();
//                snakeAndLadder();
//            }else{
//                Player1X();
//                snakeAndLadder();
//            }
//        }else if(token1Xpos == 500 && token1Ypos == token1Ypos){
//            if(dice == 6){
//                token1Xpos = 320;
//                token1Ypos = token1Ypos-54;
//                token1RevXpos = token1Xpos;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 5){
//                token1Xpos = 380;
//                token1Ypos = token1Ypos-54;
//                token1RevXpos = token1Xpos;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 4){
//                token1Xpos = 440;
//                token1Ypos = token1Ypos-54;
//                token1RevXpos = token1Xpos;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 3){
//                token1Xpos = 500;
//                token1Ypos = token1Ypos-54;
//                token1RevXpos = token1Xpos;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 2){
//                token1Xpos = 560;
//                token1Ypos = token1Ypos-54;
//                token1RevXpos = token1Xpos;
//                moveY();
//                snakeAndLadder();
//            }else {
//                Player1X();
//                snakeAndLadder();
//            }
//        }else if(token1Xpos == 560 && token1Ypos == token1Ypos){
//            if(dice == 6){
//                token1Xpos = 260;
//                token1Ypos = token1Ypos-54;
//                token1RevXpos = token1Xpos;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 5){
//                token1Xpos = 320;
//                token1Ypos = token1Ypos-54;
//                token1RevXpos = token1Xpos;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 4){
//                token1Xpos = 380;
//                token1Ypos = token1Ypos-54;
//                token1RevXpos = token1Xpos;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 3){
//                token1Xpos = 440;
//                token1Ypos = token1Ypos-54;
//                token1RevXpos = token1Xpos;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 2){
//                token1Xpos = 500;
//                token1Ypos = token1Ypos-54;
//                token1RevXpos = token1Xpos;
//                moveY();
//                snakeAndLadder();
//            }else if(dice == 1){
//                token1Xpos = 560;
//                token1Ypos = token1Ypos-54;
//                token1RevXpos = token1Xpos;
//                moveY();
//                snakeAndLadder();
//            }
//        }else {
//            Player1X();
//            snakeAndLadder();
//        }
//
//    }
//
//    public void changePos(){
//        if(token1Xpos == 20 && token2Ypos == -489){
//            player1dice.setDisable(true);
//        }else if(token1Ypos == 0){
//            forTorev();
//        }else if(token1Ypos == -54){
//            revTofor();
//        }else if(token1Ypos == -108){
//            forTorev();
//        }else if(token1Ypos == -162){
//            revTofor();
//        }else if(token1Ypos == -216){
//            forTorev();
//        }else if(token1Ypos == -270){
//            revTofor();
//        }else if(token1Ypos == -324){
//            forTorev();
//        }else if(token1Ypos == -378){
//            revTofor();
//        }else if(token1Ypos == -432){
//            forTorev();
//        }else if(token1Ypos == -486){
//            revTofor();
//        }
//    }
//
//
//}
