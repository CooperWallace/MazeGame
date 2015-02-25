import Objects.PlayerObj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class OverlayShadow {

	Texture BG;
	Sprite BGSprite;

	public OverlayShadow() {
		/*
		 * This class is responsible for the SpotLight effect that follows the
		 * user.
		 * 
		 * Functions: - UpdateOverlay: Update the spotlight's position as the
		 * player moves.
		 */

		// Spotlight overlay texture.
		BG = new Texture(Gdx.files.internal("Assets/DarkOverlay.png"));

		// Sprite
		BGSprite = new Sprite(BG, 0, 0, 256, 256);

	}

	public void UpdateOverlay(ShapeRenderer shap, SpriteBatch batch,
			PlayerObj Player1) {
		// This sub is to update the spotlight as the player moves around

		// Begin the Rendering Sequence
		shap.begin(ShapeType.Filled);
		shap.setColor(Color.BLACK);
		batch.begin();
		
		// The reason there are offsets to the X and Y coordinates is to make
		// sure that the Spotlight is centered on the player
		// Without the offsets the spotlight texture would be rendered in the
		// wrong place
		// It is linked to the Player1 object so it can move with the player.
		// Without this it wouldn't move, and it would sit in one single spot.
		BGSprite.setPosition(Player1.rec.x - 116, Player1.rec.y - 114);
		BGSprite.draw(batch);
		
		// These are to cover the places that are not covered by the Spotlight
		// texture. This prevents there from being holes on all the sides. The
		// offsets are to allow it to appear on all sides.
		// Note: Needs both X and Y to track the movements, otherwise when the
		// camera moves the border wont follow

		// Left Side Black Border - Height changed to prevent overlap of Y
		shap.rect(BGSprite.getX() - 1024, BGSprite.getY(), 1024, 256);
		
		//Right Side Black Border - Height changed to prevent overlap of Y
		shap.rect(BGSprite.getX() + 256, BGSprite.getY(), 1024, 256);
		
		// Top Black Border
		shap.rect(BGSprite.getX() - 1000, BGSprite.getY() + 256, 2000, 1024);
		
		//Bottom Black Border
		shap.rect(BGSprite.getY() - 1000, BGSprite.getY() - 1024, 2000, 1024);

		// End the Rendering Sequence
		batch.end();
		shap.end();
	}

}
