package wk.demo.block.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.compression.lzma.Base;

import wk.demo.block.Zhed;
import wk.demo.block.screen.base.BaseScreen;

public class GameScreen extends BaseScreen {
    Stage stage;
    public GameScreen(Zhed game) {
        super(game);
    }

    @Override
    public void show() {
        initView();
    }

    public void initView(){
        GameView view = new GameView();
        view.show();
        stage.addActor(view);
    }

    private float time = 0;
    @Override
    public void render(float delta) {
        stage.act();
        stage.draw();
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
