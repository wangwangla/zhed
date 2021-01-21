package wk.demo.block.prefab;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class ItemTableActor extends Group {
    private Image image;
    public ItemTableActor(int index){
        image = new Image(new Texture("menu_bg.png"));
        addActor(image);
        image.setColor(Color.valueOf("999999FF"));
        image.setSize(100,100);
        setSize(image.getWidth(),image.getHeight());
    }
}
