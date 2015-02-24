import Objects.PlayerObj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraTracking {

	OrthographicCamera Camera;
	PlayerObj Player1;

	/*
	 * This class is responsible for changing the camera to track the player.
	 * 
	 * Functions: - CameraTracking: Initial object creation to bring in the
	 * needed objects
	 * 
	 * - UpdateCameraTrakcing: This class is to track the player, and move the
	 * camera according to the players movements
	 * 
	 * - Move (Up, Down, Left, Right): These functions are responsible for
	 * translating the camera a certain direction.
	 */
	
	
	public CameraTracking(OrthographicCamera ImportedCamera,
			PlayerObj ImportedPlayer) {
		Camera = ImportedCamera;
		Player1 = ImportedPlayer;

	}

	public void UpdateCameraTracking() {
		// Camera Tracking Debugging
		// - When the player gets within a certain threshold of the side (Width
		// or Height Divided by 3 or 2.5 in this case) the camera will adjust.
		// Preventing the user from going off screen. This allows for levels
		// larger than just the window size.

		// Up and Down camera movement. If the player gets within 160 pixels of
		// the top or bottom it moves them.
		
		//Top Camera Movements
		if ((Player1.rec.y) > (Camera.position.y + Camera.viewportHeight / 3)) {
			MoveUp(Gdx.graphics.getDeltaTime());
		}
		//Bottom Camera Tracking
		if ((Player1.rec.y) < (Camera.position.y - Camera.viewportHeight / 3)) {
			MoveDown(Gdx.graphics.getDeltaTime());
		}

		// Left Side Camera Tracking
		if (Player1.rec.x > (Camera.position.x + Camera.viewportWidth / 2.5)) {
			MoveLeft(Gdx.graphics.getDeltaTime());
		}

		// Right Side Camera Tracking
		if (Player1.rec.x < (Camera.position.x - Camera.viewportWidth / 2.5)) {
			MoveRight(Gdx.graphics.getDeltaTime());
		}

		// Updates the Camera to the new X and Y values. Without this the camera
		// wont actually move.
		Camera.update();

	}

	/* - Camera Translations
	 * 
	 * These move rates are used to sync correctly with the players movements.
	 * If can be larger or smaller, but this prevents the camera from scrolling
	 * at the wrong pace.
	 */
	
	private void MoveUp(float Delta) {
		Camera.translate(0, Player1.MoveRate * Delta);
	}

	private void MoveDown(float Delta) {
		Camera.translate(0, -Player1.MoveRate * Delta);
	}

	private void MoveRight(float Delta) {
		Camera.translate(Player1.MoveRate * -Delta, 0);
	}

	private void MoveLeft(float Delta) {
		Camera.translate(Player1.MoveRate * Delta, 0);
	}

}
