import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public class PlayerObj {
	Rectangle rec;
	Rectangle top, bottom, left, right;
	int MoveRate;

	/*
	 * This class renders, updates, and controls the movements of the Player.
	 * 
	 * Functions: - PlayerObj: Defines the Rectangles to be used for the Player.
	 * - Update: Updates the hitboxes with the player's coordinates. -
	 * - UpdateMovementControl: Translates input to move the Player around. -
	 * - DrawRectangle: Draws the player on screen.
	 * - setposition: Set the Player's coordinates. Useful for when changing levels.
	 * 
	 * Notes: Remember offsets and hitboxes.
	 */

	public PlayerObj() {
		rec = new Rectangle(0, 0, 25, 25);
		setposition(350, 100);

		// These are the hit boxes for each side of the Player's box. The reason
		// that the X and Y is set to 0 is because they are changed by the
		// Update Function, setting them would be redundant
		// The reason that the X or Y is set to 2 less than the Height and Width
		// is to leave a
		// pixel on each side to prevent overlapping of each of the sides.
		//
		// Note: Overlapping causes the problem of two different sides touching
		// at
		// once. This is bad because it will not let the player through an
		// object, but also move them in a random direction as it detects hits
		// on the other sides.

		// Rectangle X, Y, W, H
		top = new Rectangle(rec.x, rec.y, rec.width - 2, 1);
		bottom = new Rectangle(0, 0, rec.width - 2, 1);
		left = new Rectangle(0, 0, 1, rec.height - 2);
		right = new Rectangle(0, 0, 1, rec.height - 2);

		MoveRate = 150;
	}

	public void update() {
		// This method is to update each of the sides position with the
		// movements of the original rectangle.
		// This method is important to make the hitboxes work with the player.
		// Without these the player would be able to pass through anything.

		top.x = rec.x + 1;
		top.y = (rec.y - 1) + rec.height;

		bottom.x = rec.x + 1;
		bottom.y = rec.y;

		left.x = rec.x;
		left.y = rec.y + 1;

		right.x = rec.x + rec.width;
		right.y = rec.y + 1;
	}

	public void UpdateMovementControl(float Delta) {
		// This method is responsible for moving the player around
		// The MoveRate is responsible for how fast the player is moving.
		// The "Delta" pass through is to move the player according to the FPS.

		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			rec.x -= MoveRate * Delta;
		}
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			rec.x += MoveRate * Delta;
		}

		if (Gdx.input.isKeyPressed(Keys.UP)) {

			rec.y += MoveRate * Delta;
		}
		if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			rec.y -= MoveRate * Delta;
		}
	}

	public void DrawRectangle(ShapeRenderer shap) {
		// This method is responsible for rendering the Player, and for
		// Rendering the Hitboxes around the player.
		// The hitboxes are a simple debug feature to make sure that they are
		// working correctly.

		// Render the Player's Rectangle
		shap.begin(ShapeType.Filled);
		shap.setColor(Color.BLUE);
		shap.rect(rec.x, rec.y, rec.width, rec.height);
		shap.end();

		// Render the hitboxes around the player - Debug Feature
		shap.begin(ShapeType.Filled);
		shap.setColor(Color.RED);
		shap.rect(top.x, top.y, top.width, top.height);
		shap.rect(bottom.x, bottom.y, bottom.width, bottom.height);
		shap.rect(right.x, right.y, right.width, right.height);
		shap.rect(left.x, left.y, left.width, left.height);
		shap.end();
	}

	public void setposition(float x, float y) {
		// Sets the Player's position when called.
		rec.x = x;
		rec.y = y;

	}
}
