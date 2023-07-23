package com.example.finalgame.thread;

import com.example.finalgame.HelloApplication;
import com.example.finalgame.hero.Hero;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AttackHeroes extends Thread{
    private ImageView heroView;
    private Hero hero;
    public AttackHeroes(ImageView heroView,Hero hero)
    {
        this.hero = hero;
        this.heroView = heroView;
    }
    @Override
    public void run()
    {
        /*try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        ImageView fireView = new ImageView();
        fireView.setImage(new Image(new HelloApplication().getClass().getResource("blueRay2.png").toString()));
        fireView.setFitWidth(69);
        fireView.setFitHeight(41);
        HelloApplication.root.getChildren().add(fireView);
        fireView.setLayoutY(heroView.getLayoutY()-62);
        fireView.setLayoutX(heroView.getLayoutX()+79);

    }
}
