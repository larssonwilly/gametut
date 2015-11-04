package gametut;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject	{

	Handler handler;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
	}
	
	public Rectangle getBounds()	{
		return new Rectangle(x, y, 32, 32);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 37);
		y = Game.clamp(y, 0, Game.HEIGHT - 60);
		
		collision();
		
	}
	
	private void collision()	{
		for(int i = 0; i < handler.object.size(); i++)	{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy)	{
				if(getBounds().intersects(tempObject.getBounds()))	{
					HUD.HEALTH -= 2;
				}
			}
			
			
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
		
	}
	
	
	
}
