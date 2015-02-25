import java.util.ArrayList;

import Objects.PlayerObj;
import Objects.RectangleObj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MakeLevel {
	ArrayList<RectangleObj> list = new ArrayList<RectangleObj>();

	RectangleObj Waypoint;

	PlayerObj Player1;

	public MakeLevel(ShapeRenderer ShapRend, PlayerObj Player) {
		/*
		 * This class is sets the levels and renders the boundaries, boxes, etc.
		 * 
		 * Functions: - UpdateLevel: Renders each of the objects, and prevents
		 * the user from overlapping them.
		 * 
		 * Incomplete: Needs a way to make multiple levels
		 */

		Player1 = Player;

		// Creates a RectangleObj to represent the Waypoint.
		Waypoint = new RectangleObj(0, 0, 0, 0, Color.GREEN);

		Level1();

	}

	public void ChangeLevel(int NewLevel) {
		list.clear();

		if (NewLevel == 1) {
			Level1();
		}

		if (NewLevel == 2) {
			list.clear();
		}

	}

	public void Level1() {

		// Set the players position on map load.
		Player1.setposition(5, 5);

		// Level Boundaries
		list.add(new RectangleObj(0, 0, 5, 480, Color.BLACK));
		list.add(new RectangleObj(795, 0, 5, 480, Color.BLACK));
		list.add(new RectangleObj(0, 0, 800, 5, Color.BLACK));
		list.add(new RectangleObj(0, 475, 800, 5, Color.BLACK));

		// Set the Waypoints H and W, and defines where the waypoint is.
		Waypoint.SetArea(50, 50);
		Waypoint.setposition(200, 300);

	}

	public void UpdateDetection(ShapeRenderer shap, PlayerObj Player1) {
		// This functions purpose is to update the hitboxes of each of the
		// objects.
		// This includes the inpassible blocks, and the waypoint blocks.

		// Checks if the user touches the waypoint.
		// Advances level if the user does touch it.
		if (Waypoint.rec.overlaps(Player1.rec)) {
			ChangeLevel(2);
		}

		// Checks each of the Rectangles to see if the Player hits them. If the
		// player does hit them, this prevents it going through them.
		// If the player hits them, it moves them in the opposite direction to
		// prevent them from going inside of it.
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

	public void RenderLevel(ShapeRenderer shap) {
		// This functions purpose is to render the blocks and the user.

		// Renders the Waypoint
		Waypoint.DrawRectangle(shap);
		
		// Renders the user on top of the Rectangles
		Player1.RenderPlayer(shap);


		// Renders each of the objects.
		for (RectangleObj ObjRender : list) {
			ObjRender.DrawRectangle(shap);
		}

	}

}
