package wk.demo.block;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.CpuSpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import wk.demo.block.constant.Constant;
import wk.demo.block.screen.LoadingScreen;


public class Zhed extends Game {
    private Viewport viewport ;
    private InputMultiplexer inputMultiplexer;
    private Batch batch;
    @Override
    public void create() {
        batch = new CpuSpriteBatch();

        viewport = new ExtendViewport(720,1280);
        resize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        Constant.assetManager = new AssetManager();
        inputMultiplexer = new InputMultiplexer();
        setScreen(new LoadingScreen(this));
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.94F, 0.94F, 0.94F, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        super.render();
    }

    public void pause () {
    }

    @Override
    public void resume () {
    }

    @Override
    public void dispose() {

    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        viewport.update(width,height);
        viewport.apply();
        Constant.width = viewport.getWorldWidth();
        Constant.height = viewport.getWorldHeight();
    }

    public Viewport getViewport() {
        return viewport;
    }

    public Batch getBatch() {
        return batch;
    }

    public void addInputProcessor(InputProcessor processor){
        inputMultiplexer.addProcessor(processor);
    }

    public void clearInputMultiplexer(){
        inputMultiplexer.clear();
    }

    public InputMultiplexer getInputMultiplexer() {
        return inputMultiplexer;
    }
}
