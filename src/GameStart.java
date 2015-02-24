import java.util.ArrayList;

import Objects.PlayerObj;
import Objects.RectangleObj;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class GameStart implements ApplicationListener {

	SpriteBatch batch;
	OrthographicCamera cam;
	ShapeRenderer shap;
	Rectangle rec;
	PlayerObj Player1;
	ArrayList<RectangleObj> list = new ArrayList<RectangleObj>();

	MakeLevel Levelgen;
	OverlayShadow ShadowSpotlight;
	CameraTracking Camera;
	
	
	@Override
	public void create() {
		cam = new OrthographicCamera();
		
		//Sets the rendering window.
		cam.setToOrtho(false, 800, 480);
		shap = new ShapeRenderer();

		batch = new SpriteBatch();

		Player1 = new PlayerObj();
		
		Levelgen = new MakeLevel(shap, Player1);
			
		ShadowSpotlight = new OverlayShadow();
		
		Camera = new CameraTracking(cam, Player1);
		
	}	

	@Override
	public void render() {
		
		//Clears the background, and sets a white background.
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// This updates our Rectangles and Sprites with the camera as it moves.
		// This is important because neither of them would move with the camera without this.
		batch.setProjectionMatrix(cam.combined);
		shap.setProjectionMatrix(cam.combined);

		//Draw the Player
		Player1.DrawRectangle(shap);
		
		
		//Updates the Player1's movement with controls.
		// This method controls the players movement and handles inputs
		Player1.UpdateMovementControl(Gdx.graphics.getDeltaTime());
		
		// Updates the hitboxes with the players movement.
		Player1.update();
		
		//Update the Tracking Camera with the players rectangle as it moves around.
		Camera.UpdateCameraTracking();
			
			
		// Updates the Level so that the player will register with the hitboxes.
		// Without this the hitboxes wont work.
		// This also renders the entire level. Without it there wwould be no
		// level
		Levelgen.UpdateLevel(shap, Player1, Gdx.graphics.getDeltaTime());

		// This is last because it needs to put an overlay over everything and not let anything appear over top of it.
		// It's the spotlight effect that follows around the Player
		// Check OverlayShadow for more information
		//ShadowSpotlight.UpdateOverlay(shap, batch, Player1);
		
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
