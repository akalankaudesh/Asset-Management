package lk.ijse.dep.AssetManagement.view.effects;

import javafx.animation.ScaleTransition;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import javafx.util.Duration;


public class Image_Effect {

    public void start(MouseEvent mouseEvent){
        if (mouseEvent.getSource() instanceof javafx.scene.image.ImageView){
            javafx.scene.image.ImageView icon = (ImageView) mouseEvent.getSource();

//            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), icon);
//            scaleT.setToX(1.2);
//            scaleT.setToY(1.2);
//            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);
        }
    }

    public void end(MouseEvent mouseEvent){
        if (mouseEvent.getSource() instanceof ImageView){
            ImageView icon = (ImageView) mouseEvent.getSource();
            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            icon.setEffect(null);

        }
    }


    public void start1(MouseEvent mouseEvent){
        if (mouseEvent.getSource() instanceof javafx.scene.image.ImageView){
            javafx.scene.image.ImageView icon = (ImageView) mouseEvent.getSource();

            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.1);
            scaleT.setToY(1.1);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);
        }
    }

    public void end1(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) mouseEvent.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            icon.setEffect(null);
        }
    }
}