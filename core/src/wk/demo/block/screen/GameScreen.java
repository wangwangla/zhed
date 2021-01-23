package wk.demo.block.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import wk.demo.block.Zhed;
import wk.demo.block.prefab.TempBlock;
import wk.demo.block.screen.base.BaseScreen;

public class GameScreen extends BaseScreen {
    private int arr[][];
    private TempBlock[][] bloacks;
    public GameScreen(Zhed game) {
        super(game);
    }

    public void showView(){
        Group view = new Group();
        addActor(view);
        arr = new int[10][10];
        bloacks = new TempBlock[10][10];
        final float widthTemp = 720.0F / arr.length;
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr[0].length; i1++) {
                TempBlock tempBlock = new TempBlock(arr[i][i1]);
                bloacks[i][i1] = tempBlock;
                tempBlock.setBlockWidth(widthTemp);
                view.addActor(tempBlock);
                tempBlock.setPosXY(i,i1);
                tempBlock.addBlackListener(listener);
            }
        }
    }

    public interface BlackListener{
        public void blackOnClick(int x,int y,int num);
    }

    private BlackListener listener = new BlackListener() {
        @Override
        public void blackOnClick(int x,int y,int num) {
            //找到上下左右可以走的位置
            TempBlock block;
            //上
            int count = 0;
            for (int i = x;i<10;i++){
                block = bloacks[i][y];
                if (block.getNum() == 0) {
                    count++;

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
        bloacks[x][y].tip();
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
