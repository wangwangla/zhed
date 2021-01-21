package wk.demo.block.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.compression.lzma.Base;

import wk.demo.block.Zhed;
import wk.demo.block.constant.Constant;
import wk.demo.block.prefab.TempBlack;
import wk.demo.block.screen.base.BaseScreen;

public class GameScreen extends BaseScreen {

    public GameScreen(Zhed game) {
        super(game);
    }
    int arr[][];
    public void showView(){
        float blackWidth = 1;
        Group g = new Group();
        addActor(g);


//
//        Table table = new Table(){{
//            for (int i = 0; i < 10; i++) {
//                for (int j = 0; j < 10; j++) {
//                    Image image = new Image(new Texture("shop.png"));
//                    image.setScale(0.5F,0.5F);
//                    image.setSize(10,10);
//                    add(image).pad(2);
//                }
//                row();
//            }pack();
//        }};
//        table.setPosition(Constant.width/2,Constant.height/2, Align.center);
//        addActor(table);

//
//        int srcx = 4;
//        int srcy = 4;
//        int targetX = 5;
//        int targetY = 4;
//        arr = new int[10][10];
//        arr[srcx][srcy] = 1;
//        arr[targetX][targetY] = 2;
//        TempBlack tempBlack = new TempBlack();
//        addActor(tempBlack);
//        tempBlack.addBlackListener(listener);
//        tempBlack.setPosXY(4,5);
//
//
//        addListener(new ClickListener(){
//            @Override
//            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                System.out.println("=======>>>>>>>>>>>>touchDown");
//                return super.touchDown(event, x, y, pointer, button);
//            }
//
//            @Override
//            public void touchDragged(InputEvent event, float x, float y, int pointer) {
//                System.out.println("================>>>>>>>>>>>>>>>touchDragged");
//                super.touchDragged(event, x, y, pointer);
//            }
//
//            @Override
//            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                super.touchUp(event, x, y, pointer, button);
//                System.out.println("=========>>>>>>>>>>>>>>>touUp");
//            }
//        });
    }

    public interface BlackListener{
        public void blackOnClick(int x,int y,int num);
    }

    private GameView.BlackListener listener = new GameView.BlackListener() {
        @Override
        public void blackOnClick(int x,int y,int num) {
            //找到上下左右可以走的位置
            //上
            int count = 0;
            for (int i = x;i<10;i++){
                if (arr[i][y] == 0) {
                    count++;
                    show(i,y);
                }
                if (count >= num)break;
            }
            count = 0;
            for (int i = x;i>=0;i--){
                if (arr[i][y] == 0) {
                    count++;
                    show(i,y);
                }
                if (count >= num)break;
            }
            count = 0;
            for (int i = x;i>=0;i--){
                if (arr[x][i] == 0) {
                    count++;
                    show(x,i);
                }
                if (count >= num)break;
            }

            count = 0;
            for (int i = x;i<10;i++){
                if (arr[x][i] == 0) {
                    count++;
                    show(x,i);
                }
                if (count >= num)break;
            }
        }
    };

    public void show(int x,int y){
        Image image = new Image(new Texture("white_10x10.png"));
        addActor(image);
        image.setPosition(x*50,y*50);
        image.setSize(10,10);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
