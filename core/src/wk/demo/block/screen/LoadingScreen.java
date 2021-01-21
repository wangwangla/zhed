package wk.demo.block.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

import wk.demo.block.Zhed;
import wk.demo.block.constant.Constant;
import wk.demo.block.prefab.ButtonActor;
import wk.demo.block.prefab.LevelItem;
import wk.demo.block.screen.base.BaseScreen;
import wk.demo.block.utils.ProGress;

public class LoadingScreen extends BaseScreen {

    public LoadingScreen(Zhed game) {
        super(game);
    }

    @Override
    public void showView() {
        super.showView();
        // ⚪
        Image image = new Image(new Texture("logo.png"));
        addActor(image);
        image.setPosition(Constant.width/2,Constant.height*0.85F, Align.center);
//        ProGress proGress = new ProGress(
//                new TextureRegion(new Texture("pro_cir.png")),
//                new TextureRegion(new Texture("white_cir.png")),
//                        446F);
//        proGress.setColor(Color.BLACK);
//        proGress.setPercentage(100);
//        addActor(proGress);
//        proGress.setPosition(Constant.width/2,Constant.height/2,Align.center);

        Table table = new Table(){{
            for (int i = 0; i < 3; i++) {
                ButtonActor actor = new ButtonActor(i);
                add(actor).pad(30);
            }
            pack();
        }};
        table.setPosition(Constant.width/2,Constant.height*0.15F,Align.center);
        addActor(table);
        initListener();
    }

    public void initListener(){
        findActor("menu").addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                nextScreen(new LevelScreen(game));
            }
        });
        findActor("detail").addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
            }
        });

        findActor("shop").addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
            }
        });
    }
/*

    private ClickListener buttonListener = new ClickListener(){


        @Override
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
            Actor target = event.getTarget();
            if (target.getParent() != null) {
                target = target.parent;
            }
            boolean isTouch = false;
            if ("menu".equals(target.getName())) {
                isTouch = true;
                nextScreen(new LevelScreen(game));
            }else if("detail".equals(target.getName())){
                isTouch = true;
                nextScreen(new LevelScreen(game));
            }else if("shop".equals(target.getName())){
                isTouch = true;
                nextScreen(new LevelScreen(game));
            }
            if (isTouch) return true;
            else return false;
        }
*/

//        @Override
//        public void clicked(InputEvent event, float x, float y) {
//            super.clicked(event, x, y);
//            if (event==null)return;
//            Actor target = event.getTarget();
//            if (target.getParent() != null) {
//                target = target.parent;
//            }
//            if ("menu".equals(target.getName())) {
//                nextScreen(new LevelScreen(game));
//            }else if("detail".equals(target.getName())){
//                nextScreen(new LevelScreen(game));
//            }else if("shop".equals(target.getName())){
//                nextScreen(new LevelScreen(game));
//            }
//        }
//    };



    public interface menuListener {
        public void menuTouch();
    }

    public void showMenu(){

    }
}
