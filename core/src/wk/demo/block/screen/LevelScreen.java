package wk.demo.block.screen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
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
        levelItem = new Group();
        addActor(levelItem);
        levelItem.setSize(Constant.width,Constant.height);
        Table table = new Table(){{
            for (int i = 0; i < 4; i++) {
                LevelItem item = new LevelItem(i);
                item.addListener(listener);
                add(item);
                row();
            }
            pack();
        }};
        levelItem.addActor(table);
        table.setPosition(Constant.width/2,Constant.height - 70, Align.top);
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
        itemTable = new Group();
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
                itemTable.addListener(levelListener);
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
                itemTable = null;
            }
        });
    }

    @Override
    public void loadData() {
        super.loadData();
    }

    private ClickListener listener = new ClickListener(){
        @Override
        public void clicked(InputEvent event, float x, float y) {
            super.clicked(event, x, y);
            showItemtable();
        }
    };

    private ClickListener levelListener = new ClickListener(){
        @Override
        public void clicked(InputEvent event, float x, float y) {
            super.clicked(event, x, y);
            game.setScreen(new GameScreen(game));
        }
    };
}
