package wk.demo.block.prefab;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;

public class ButtonActor extends Group {
    private String[] names = {"menu","detail","shop"};
    public ButtonActor(int incoIndex){
        Image image = new Image(new Texture("menu_bg.png"));
        addActor(image);
        image.setColor(Color.BLACK);
        String name = names[incoIndex];
        Image icon = new Image(new Texture(name+".png"));
        addActor(icon);
        setSize(image.getWidth(),image.getHeight());
        icon.setPosition(getWidth()/2,getHeight()/2, Align.center);
        setName(name);
    }
}
