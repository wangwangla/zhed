package wk.demo.block.prefab;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import wk.demo.block.screen.GameView;

public class TempBlack extends Group {
    private Image image;
    private int num;
    private GameView.BlackListener listener;
    private int posx;
    private int posy;
    public TempBlack(){
        image = new Image(new Texture("white_10x10.png"));
        addActor(image);
        image.setSize(20,20);
        num = 5;
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                listener.blackOnClick(posx,posy,5);
            }
        });
    }

    public void setPosXY(int x,int y){
        this.posx = x;
        this.posy = y;
        setPosition(x*50,y*50);
    }

    public int getNum() {
        return num;
    }

    public void addBlackListener(GameView.BlackListener listener){
        this.listener = listener;
    }

    public void setPosX() {
    }
}
