import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
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
	
	
	@Override
	public void create() {
		 cam = new OrthographicCamera();
		cam.setToOrtho(false, 800, 480);
		shap = new ShapeRenderer();
		
		batch = new SpriteBatch();
		
		Player1 = new PlayerObj();
		
		
		//Level Boundaries
		list.add(new RectangleObj(0, 0, 5, 480));
		list.add(new RectangleObj(795, 0, 5, 480));
		list.add(new RectangleObj(0, 0, 800, 5));
		list.add(new RectangleObj(0, 475, 800, 5));
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(cam.combined);
		
		//This is to draw each of the Triangle's / Players
		for(RectangleObj ObjRender : list){
			ObjRender.DrawRectangle(shap);
		}
		
		Player1.DrawRectangle(shap);

		// Moves the player around.
		if(Gdx.input.isKeyPressed(Keys.LEFT)){Player1.Left(Gdx.graphics.getDeltaTime());}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)){Player1.Right(Gdx.graphics.getDeltaTime());}
		if(Gdx.input.isKeyPressed(Keys.UP)){Player1.Up(Gdx.graphics.getDeltaTime());}
		if(Gdx.input.isKeyPressed(Keys.DOWN)){Player1.Down(Gdx.graphics.getDeltaTime());}
		
		//Updates the hitboxes with the players movement.
		Player1.update();

		
		// Checks each of the Rectangles to see if the Player hits them. If the player does hit them, this prevents it going through them.
for(RectangleObj obj : list){
		if(Player1.top.overlaps(obj.rec)){Player1.rec.y -= Player1.MoveRate * Gdx.graphics.getDeltaTime();}
		if(Player1.bottom.overlaps(obj.rec)){Player1.rec.y += Player1.MoveRate * Gdx.graphics.getDeltaTime();}
		if(Player1.right.overlaps(obj.rec)){Player1.rec.x -= Player1.MoveRate * Gdx.graphics.getDeltaTime(); }
		if(Player1.left.overlaps(obj.rec)){Player1.rec.x += Player1.MoveRate * Gdx.graphics.getDeltaTime();}
}


		
		
		
		
		
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
