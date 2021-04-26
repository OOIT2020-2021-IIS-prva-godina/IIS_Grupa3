package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape{

	private Point upperLeftPoint;
	private int width;
	private int height;

	public Rectangle() {
	}

	public Rectangle(Point upperLeftPoint, int width, int height) {
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
	}

	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected) {
		this(upperLeftPoint, width, height);// prva naredba
		setSelected(selected);
		//dolazi do promene nakon uvodjenja Shape
		//this.selected = selected;
	}

	public int area() {
		return this.height * this.width;
	}

	public int circumference() {
		return this.height * 2 + 2 * this.width;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {

			Rectangle pomocna = (Rectangle) obj;
			if (this.upperLeftPoint.equals(pomocna.upperLeftPoint) && this.width == pomocna.width
					&& this.height == pomocna.height) {
				return true;
			}
			return false;
		} else
			return false;
	}
	
	public boolean contains(int x, int y) {
		if(x>=upperLeftPoint.getX() && x<=upperLeftPoint.getX()+width
				&& y>=upperLeftPoint.getY() && y<=upperLeftPoint.getY()+height)
			return true;
		return false;
	}
	
	public boolean contains(Point p) {
		if(p.getX()>=upperLeftPoint.getX() && p.getX()<=upperLeftPoint.getX()+width
				&& p.getY()>=upperLeftPoint.getY() && p.getY()<=upperLeftPoint.getY()+height)
			return true;
		return false;
	}

	
	@Override
	public void draw(Graphics g) {
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
		
		if (selected) {
			g.setColor(Color.blue);
			g.drawRect(upperLeftPoint.getX() - 2, upperLeftPoint.getY() - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() + width - 2, upperLeftPoint.getY() - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() - 2, upperLeftPoint.getY() + height - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() + width  - 2, upperLeftPoint.getY() + height - 2, 4, 4);
		}
		
	}
	
	

	@Override
	public void moveTo(int x, int y) {
		upperLeftPoint.moveTo(x, y);
		
	}

	@Override
	public void moveBy(int byX, int byY) {
		upperLeftPoint.moveBy(byX, byY);
	}
	
	@Override
	public int compareTo(Object o) {

		if(o instanceof Rectangle) {
			return this.area()-((Rectangle)o).area();
		}
		return 0;
	}

	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String toString() {
		return "Upper left point:" + upperLeftPoint + ", width = " + width + ", height =" + height;
	}

}
