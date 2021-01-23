package wk.demo.block.screen;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.Array;
import wk.demo.block.Zhed;
import wk.demo.block.prefab.TempBlock;
import wk.demo.block.screen.base.BaseScreen;

/**
 * 提示
 *
 * 无论之前的操作是对是错，都销毁，然后重新开始
 *
 * 它是会记住已经提示的步骤，无论后来的是对是错。都保留
 *
 *
 * 点击之后，会判断手指按下的方向，向选中的方向作用。
 */
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
        void blackOnClick(int x,int y,int num);
    }

    private Array<TempBlock> tempBlocks = new Array<>();

    private BlackListener listener = new BlackListener() {
        @Override
        public void blackOnClick(int x,int y,int num) {
            if (tempBlocks.size>0){
                for (TempBlock tempBlock : tempBlocks) {
                    tempBlock.untip();
                }
            }
            tempBlocks.clear();
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
