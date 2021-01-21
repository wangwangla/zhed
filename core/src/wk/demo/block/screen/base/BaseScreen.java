package wk.demo.block.screen.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

import wk.demo.block.Zhed;
import wk.demo.block.constant.Constant;

public class BaseScreen implements Screen {
    private Stage stage ;
    protected Zhed game;
    public BaseScreen(Zhed game){
        this.game = game;
    }

    @Override
    public void show() {
        game.clearInputMultiplexer();
        stage = new Stage(game.getViewport(),game.getBatch());
        game.addInputProcessor(stage);
        Gdx.input.setInputProcessor(game.getInputMultiplexer());
        loadData();
        showView();
    }

    public void loadData(){

    }

    public void showView(){

    }

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

    public void addActor(Actor actor){
        stage.addActor(actor);
    }

    public <T extends Actor> T findActor(String name){
        Actor actor = null;
        if (stage!=null)
            actor = stage.getRoot().findActor(name);
        return actor == null ? null : (T)actor;
    }

    protected void nextScreen(BaseScreen screen){
        game.setScreen(screen);
    }

    protected void addListener(EventListener listener){
        stage.addListener(listener);
    }
}
