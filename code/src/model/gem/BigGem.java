package model.gem;

import javafx.scene.image.Image;

public class BigGem extends Gem {
    private final int value = 5;
    

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public Image getGemImage() {
        return new Image("/view/images/stone.png");
    }
}
