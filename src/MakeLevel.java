import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class MakeLevel {
	

	ArrayList<RectangleObj> list = new ArrayList<RectangleObj>();
	
	public MakeLevel(ShapeRenderer ShapRend, PlayerObj Player1){
		

		// Level Boundaries
		list.add(new RectangleObj(0, 0, 5, 480, Color.BLACK));
		list.add(new RectangleObj(795, 0, 5, 480, Color.BLACK));
		list.add(new RectangleObj(0, 0, 800, 5, Color.BLACK));
		list.add(new RectangleObj(0, 475, 800, 5, Color.BLACK));
	}
	
	
	
	
	
	public void UpdateLevel(ShapeRenderer shap, PlayerObj Player1, float Delta){	
		//Renders each of the objects.
		for (RectangleObj ObjRender : list) {
			ObjRender.DrawRectangle(shap);
		}

		// Checks each of the Rectangles to see if the Player hits them. If the
		// player does hit them, this prevents it going through them.		
		for (RectangleObj obj : list) {
			if (Player1.top.overlaps(obj.rec)) {
				Player1.rec.y -= Player1.MoveRate * Gdx.graphics.getDeltaTime();
			}
			if (Player1.bottom.overlaps(obj.rec)) {
				Player1.rec.y += Player1.MoveRate * Gdx.graphics.getDeltaTime();
			}
			if (Player1.right.overlaps(obj.rec)) {
				Player1.rec.x -= Player1.MoveRate * Gdx.graphics.getDeltaTime();
			}
			if (Player1.left.overlaps(obj.rec)) {
				Player1.rec.x += Player1.MoveRate * Gdx.graphics.getDeltaTime();
			}
		}
	}
	
}
