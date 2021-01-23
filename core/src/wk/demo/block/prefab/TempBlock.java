package wk.demo.block.prefab;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

import wk.demo.block.constant.Constant;
import wk.demo.block.screen.GameScreen;

public class TempBlock extends Group {
    private Image image;
    private int num;
    private GameScreen.BlackListener listener;
    private int posx;
    private int posy;
    private boolean isClick = false;
    public TempBlock(int tempBlock){
        this.num = tempBlock;
        String nameTexture = "";
        if (tempBlock == Constant.BLOCK){
            nameTexture = "";
            isClick = true;
        }else if (tempBlock == Constant.TARGET){
            nameTexture = "";
        }
        image = new Image(new Texture("white_10x10.png"));
        addActor(image);
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                listener.blackOnClick(posx,posy,5);
                //判断方向

            }
        });
    }



    public void setBlockWidth(float width) {
        setSize(width,width);
        image.setWidth(width - 5);
        image.setHeight(width - 5);
        image.setPosition(getWidth()/2,getHeight()/2, Align.center);
    }

    public void setPosXY(int x, int y){
        this.posx = x;
        this.posy = y;
        setPosition(x*getWidth(),y*getWidth());
    }

    public int getNum() {
        return num;
    }

    public void addBlackListener(GameScreen.BlackListener listener){
        this.listener = listener;
    }

    public void setPosX() {
    }

    public void tip() {
    }
}
