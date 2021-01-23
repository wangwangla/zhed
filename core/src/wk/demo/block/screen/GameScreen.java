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
    private int arr[][];
    private TempBlack[][] blacks;
    public GameScreen(Zhed game) {
        super(game);
    }

    public void showView(){
        Group view = new Group();
        addActor(view);
        arr = new int[10][10];
        blacks = new TempBlack[10][10];
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr[0].length; i1++) {
                blacks[i][i1] = new TempBlack();
                addActor(blacks[i][i1]);
            }
        }
        // show

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
