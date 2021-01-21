package wk.demo.block.prefab;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import wk.demo.block.constant.Constant;

public class LevelItem extends Group {
    private int num;
    public LevelItem(int num){
        this.num = num;
        Image image = new Image(new NinePatch(new Texture("white_squ.png"),20,20,20,20));
        addActor(image);
        image.setWidth(Constant.width - 20);
        setSize(image.getWidth(),image.getHeight());
        image.setColor(Color.valueOf("CCCCCCFF"));
    }

    public int getNum() {
        return num;
    }
}
