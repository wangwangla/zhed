package wk.demo.block.screen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

import javafx.scene.control.Tab;
import wk.demo.block.Zhed;
import wk.demo.block.constant.Constant;
import wk.demo.block.prefab.ItemTableActor;
import wk.demo.block.prefab.LevelItem;
import wk.demo.block.screen.base.BaseScreen;

public class LevelScreen extends BaseScreen {
    private Group levelItem;
    private Group itemTable;
    public LevelScreen(Zhed game) {
        super(game);
    }

    @Override
    public void showView() {
        super.showView();
        showItem();
    }

    public void showItem(){
        if (findActor("levelItem")!=null){
            findActor("levelItem").setVisible(true);
        }
        levelItem = new Group();
        levelItem.setName("levelItem");
        addActor(levelItem);
        levelItem.setSize(Constant.width,Constant.height);
        levelItem.setTouchable(Touchable.childrenOnly);
        Image image = new Image(new Texture("white_10x10.png"));
        image.setColor(Color.RED);
        image.getColor().a = 0.2F;
        image.setSize(levelItem.getWidth(),levelItem.getHeight());
        levelItem.addActor(image);

        for (int i = 0; i < 4; i++) {
            LevelItem item = new LevelItem(i);
            item.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    showItemtable();
                }
            });
            levelItem.addActor(item);
            item.setY(i*300);
        }
        Image back = new Image(new NinePatch(new Texture("white_squ.png"),20,20,20,20));
        levelItem.addActor(back);
        back.setColor(Color.BLACK);
        back.setSize(300,100);
        back.setPosition(Constant.width/2,Constant.height*0.2F,Align.center);
        back.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

                nextScreen(new LoadingScreen(game));
            }
        });
    }

    private void showItemtable(){
        levelItem.remove();
        levelItem.setVisible(false);
        itemTable = new Group();
        itemTable.setTouchable(Touchable.childrenOnly);
        int pad = 15;
        itemTable.setSize(Constant.width,Constant.height);
        addActor(itemTable);
        Table table = new Table(){{
            for (int i = 1; i <= 20; i++) {
                ItemTableActor itemTable = new ItemTableActor(i);
                add(itemTable).padLeft(pad).padRight(pad).padBottom(pad);
                if (i%4 == 0){
                    row();
                }
            }
            pack();
        }};
        itemTable.addActor(table);
        table.setPosition(Constant.width/2,Constant.height-70,Align.top);
        Image back = new Image(new NinePatch(new Texture("white_squ.png"),20,20,20,20));
        itemTable.addActor(back);
        back.setColor(Color.BLACK);
        back.setSize(300,100);
        back.setPosition(Constant.width/2,Constant.height*0.2F,Align.center);
        back.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                itemTable.remove();
                showItem();
                itemTable.setVisible(false);
            }
        });
    }

    @Override
    public void loadData() {
        super.loadData();
    }
}
