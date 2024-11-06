package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Fruit {
    private int x;
    private int y;
    private ImageIcon img;
//    private int snake_size;

    public Fruit(){
        //img = new ImageIcon("fruit.jpg");
        img = new ImageIcon(getClass().getResource("SpongeBob.png"));
        this.x = (int) (Math.floor(Math.random() * Main.colum) * Main.CEL_SIZE);
        this.y = (int) (Math.floor(Math.random() * Main.row) * Main.CEL_SIZE);
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    public void drawFruit(Graphics g){
        img.paintIcon(null, g, this.x, this.y);
    }

    public void setNewLocation(Snake s){
//        snake_size = s.getSnakeBody().size();
        int new_x;
        int new_y;
        boolean overlapping;
        do {
            new_x = (int) (Math.floor(Math.random() * Main.colum) * Main.CEL_SIZE);
            new_y = (int) (Math.floor(Math.random() * Main.row) * Main.CEL_SIZE);
            overlapping = check_overlap(new_x, new_y, s);
        } while (overlapping);

        this.x = new_x;
        this.y = new_y;
    }
    private boolean check_overlap(int x, int y, Snake s){
        ArrayList<Node> snake_body = s.getSnakeBody();
        for(int j = 0; j < s.getSnakeBody().size(); j++){
            if (x == snake_body.get(j).x && y == snake_body.get(j).y){
                return true;
            }
        }
        return false;
    }
}