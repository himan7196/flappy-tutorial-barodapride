package com.barodapride.flappy;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/**
 * Created by Mike on 3/20/2015.
 */
public class GameplayScreen extends ScreenAdapter {

    protected OrthographicCamera camera;
    protected FlappyGame game;

    private Stage gameplayStage;

    private Bird bird;
    private Image background;

    public GameplayScreen(FlappyGame game) {
        this.game = game;
        
        camera = new OrthographicCamera(FlappyGame.WIDTH, FlappyGame.HEIGHT);
        gameplayStage = new Stage(new StretchViewport(FlappyGame.WIDTH, FlappyGame.HEIGHT, camera));

        bird = new Bird();
        bird.setPosition(FlappyGame.WIDTH*.25f, FlappyGame.HEIGHT/2, Align.center);

        background = new Image(Assets.background);

        gameplayStage.addActor(background);
        gameplayStage.addActor(bird);

    }

    @Override
    public void render(float delta) {
        gameplayStage.act();
        gameplayStage.draw();
    }

    @Override
    public void resize(int width, int height) {

        camera.setToOrtho(false, width, height);
        Assets.batch.setProjectionMatrix(camera.combined);
        gameplayStage.getViewport().update(width, height, true);

    }

    @Override
    public void dispose() {
        gameplayStage.dispose();
    }
}
