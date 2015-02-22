import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public class GameStart implements ApplicationListener {

	SpriteBatch batch;
	OrthographicCamera cam;
	ShapeRenderer shap;
	Rectangle rec;
	PlayerObj Player1;
	ArrayList<RectangleObj> list = new ArrayList<RectangleObj>();

	MakeLevel Levelgen = new MakeLevel();

	Texture BG;
	Sprite BGSprite;

	@Override
	public void create() {
		cam = new OrthographicCamera();
		cam.setToOrtho(false, 800, 480);
		shap = new ShapeRenderer();

		batch = new SpriteBatch();

		Player1 = new PlayerObj();
		
		Levelgen.MakeLevel(shap, Player1);
		
		BG = new Texture(Gdx.files.internal("Assets/DarkOverlay.png"));
		BGSprite = new Sprite(BG, 112 , -250, 1024, 1024);
		
		
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(cam.combined);

		
		shap.begin(ShapeType.Filled);
		batch.begin();
		BGSprite.setPosition(Player1.rec.x - 388, Player1.rec.y - 247 );
		shap.rect(BGSprite.getX() - 1024, 0, 1024, 1024);
		shap.rect(BGSprite.getX() + 1024, 0, 1024, 1024);

		shap.rect(0, BGSprite.getY() + 1024, 1024, 1024);
		shap.rect(0, BGSprite.getY() - 1024, 1024, 1024);
		BGSprite.draw(batch);
		batch.end();
		shap.end();
		
		
		//Draw the Player
		Player1.DrawRectangle(shap);
		
		
		// Moves the player around.
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			Player1.Left(Gdx.graphics.getDeltaTime());
		}
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			Player1.Right(Gdx.graphics.getDeltaTime());
		}
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			Player1.Up(Gdx.graphics.getDeltaTime());
		}
		if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			Player1.Down(Gdx.graphics.getDeltaTime());
		}

		// Updates the hitboxes with the players movement.
		Player1.update();

		// Updates the Level so that the player will register with the hitboxes.
		// Without this the hitboxes wont work.
		// This also renders the entire level. Without it there wwould be no
		// level
		Levelgen.UpdateLevel(shap, Player1, Gdx.graphics.getDeltaTime());

		

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

}
