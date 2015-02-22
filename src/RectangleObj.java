
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public class RectangleObj {
	Rectangle rec;

	Rectangle top, bottom, left, right;
	int MoveRate;
	Color ShapColor;

	public RectangleObj(int x, int y, int width, int height, Color color) {
		rec = new Rectangle(x, y, width, height);
		ShapColor = color;
	}

	public void DrawRectangle(ShapeRenderer shap) {
		shap.begin(ShapeType.Filled);
		shap.setColor(ShapColor);
		shap.rect(rec.x, rec.y, rec.width, rec.height);
		shap.end();
	}

	public void setposition(float x, float y) {
		rec.x = x;
		rec.y = y;
	}
}
