import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class OverlayShadow {

	Texture BG;
	Sprite BGSprite;

	public OverlayShadow() {

		// Spotlight overlay texture.
		BG = new Texture(Gdx.files.internal("Assets/DarkOverlay.png"));

		// Sprite
		BGSprite = new Sprite(BG, 112, -250, 1024, 1024);

	}

	public void UpdateOverlay(ShapeRenderer shap, SpriteBatch batch,
			PlayerObj Player1) {
		//This sub is to update the spotlight as the player moves around
		
		
		// Begin the Rendering Sequence
		shap.begin(ShapeType.Filled);
		batch.begin();
		
		// The reason there are offsets to the X and Y coordinates is to make sure that the Spotlight is centered on the player
		// Without the offsets the spotlight texture would be rendered in the wrong place
		// It is linked to the Player1 object so it can move with the player. Without this it wouldn't move, and it would sit in one single spot.
		BGSprite.setPosition(Player1.rec.x - 388, Player1.rec.y - 247);
		BGSprite.draw(batch);
		
		// These are to cover the places that are not covered by the Spotlight texture. This prevents there from being holes on all the sides. The offsets are to allow it to appear on all sides.
		shap.rect(BGSprite.getX() - 1024, 0, 1024, 1024);
		shap.rect(BGSprite.getX() + 1024, 0, 1024, 1024);
		shap.rect(0, BGSprite.getY() + 1024, 1024, 1024);
		shap.rect(0, BGSprite.getY() - 1024, 1024, 1024);
		
		
		// End the Rendering Sequence
		batch.end();
		shap.end();
	}

}