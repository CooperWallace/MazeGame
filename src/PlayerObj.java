import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;


public class PlayerObj {
	Rectangle rec;
	Rectangle top, bottom, left, right;
	int MoveRate;
	
	public PlayerObj(){
		rec = new Rectangle(0, 0, 25,25);
		setposition(350, 100);

		
		//These are the hit boxes for each side of the Player's box. The reason that the X and Y is set to 0 is because they are changed by the Update Function, setting them would be redundant
		//The reason that the X or Y is set to 2 less than 40 is to leave a pixel on each side to prevent overlapping of each of the sides.
		//Rectangle X, Y, W, H
		top = new Rectangle(rec.x, rec.y, rec.width - 2 , 1);
		bottom = new Rectangle(0 , 0, rec.width - 2, 1);
		left = new Rectangle(0,0, 1, rec.height -2);
		right = new Rectangle(0,0, 1, rec.height -2);
		
		MoveRate = 150;
	}
	
	public void update(){
		//This function is to update each of the side's position with the movements of the original rectangle.
		
		
		top.x = rec.x + 1;
		top.y = (rec.y - 1) + rec.height;
		
		bottom.x = rec.x + 1;
		bottom.y = rec.y;
		
		left.x = rec.x;
		left.y = rec.y+1;
		
		right.x = rec.x + rec.width;
		right.y = rec.y + 1;
	}
	
	public void DrawRectangle(ShapeRenderer shap){
		
		
		
		shap.begin(ShapeType.Filled);
		shap.setColor(Color.BLUE);
		shap.rect(rec.x, rec.y, rec.width, rec.height);
		shap.end();
		
		shap.begin(ShapeType.Filled);
		shap.setColor(Color.RED);
		shap.rect(top.x, top.y, top.width, top.height);
		shap.rect(bottom.x, bottom.y, bottom.width, bottom.height);


		shap.rect(right.x, right.y, right.width, right.height);
		shap.rect(left.x, left.y, left.width, left.height);
		shap.end();
	}
	public void setposition(float x, float y){
		rec.x = x;
		rec.y = y;	
		
	}
	
	
	
	
	public void Right(float Delta){
		rec.x += MoveRate * Delta;
	}
	
	public void Left(float Delta){
		rec.x -= MoveRate * Delta;
	}
	
	public void Up(float Delta){
		rec.y += MoveRate * Delta;
	}
	
	public void Down(float Delta){
		rec.y -= MoveRate * Delta;
	}
	
	
	
	
}
