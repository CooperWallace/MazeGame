package Objects;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public class RectangleObj {
	public Rectangle rec;
	Color ShapColor;

	public RectangleObj(int x, int y, int width, int height, Color color) {
		/*
		 * Renders the rectangles and sets their position.
		 * 
		 * Functions - DrawRectangle: Renders the Rectangle with the Position
		 * and the Color that is specified.
		 */

		rec = new Rectangle(x, y, width, height);
		ShapColor = color;
	}

	public void DrawRectangle(ShapeRenderer shap) {
		// Renders the Rectangle.
		shap.begin(ShapeType.Filled);
		shap.setColor(ShapColor);
		shap.rect(rec.x, rec.y, rec.width, rec.height);
		shap.end();
	}

	public void setposition(float x, float y) {
		// Sets the position of the block.
		rec.x = x;
		rec.y = y;
	}
}
