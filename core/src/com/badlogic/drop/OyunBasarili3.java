package com.badlogic.drop;

/**
 * Created by NurullahSamed on 11.5.2016.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
/**
 * Created by NurullahSamed on 11.5.2016.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;


/**
 * Created by NurullahSamed on 11.5.2016.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by NurullahSamed on 6.5.2016.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;

public class OyunBasarili3 implements Screen {

    final Main game;

    OrthographicCamera camera;

    private Texture oyunbasarili;

    private Texture backgroundTexture;
    private Sprite backgroundSprite;

    private static final int        FRAME_COLS = 1;         // #1
    private static final int        FRAME_ROWS = 1;         // #2

    Animation animasyon;          // #3
    Texture                         sheet;              // #4
    TextureRegion[]                 frames;             // #5
    TextureRegion                   currentFrame;           // #7
    float stateTime;

    private Sound clickSound;

    long puan ;
    long puan2 ;
    long puan3 ;


    Rectangle ok;
    Rectangle carpi;
    float toplam ;


    boolean ses ;
    public OyunBasarili3(final Main gam,long veri,long veri2,long veri3,boolean ses) {
        game = gam;
        this.ses = ses;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        backgroundTexture = new Texture("menubackground.png");
        oyunbasarili = new Texture("son.png");

        backgroundSprite =new Sprite(backgroundTexture);

        puan = veri;
        puan2 = veri2;
        puan3 = veri3;

        ok = new Rectangle();
        ok.x = 360;
        ok.y = 220;
        ok.width = 82;
        ok.height = 48;

        carpi = new Rectangle();
        carpi.x = 470;
        carpi.y = 410;
        carpi.width = 40;
        carpi.height = 42;

        toplam = puan+puan2+puan3;


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        backgroundSprite.draw(game.batch);
        game.batch.draw(oyunbasarili, 800 / 2 - 250 / 2, 200);
        String str = puan3+"";
        String str2 = toplam+"";
        game.font.getData().setScale(2, 2);
        game.font.draw(game.batch, str, 375, 335);
        game.font.getData().setScale(2, 2);
        game.font.draw(game.batch, str2, 365, 290);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            if(ok.contains(touchPos.x,touchPos.y) || carpi.contains(touchPos.x,touchPos.y))
            {
                game.setScreen(new MainMenu(game,ses));
            }
        }


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

    @Override
    public void show() {

    }

}

