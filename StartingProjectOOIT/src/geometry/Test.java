package geometry;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p = new Point();
		// x je promenljiva definisana kao private
		// System.out.println(p.x);

		// metoda instance i mora biti pozvana nad objektom
		// Point.getX();
		System.out.println(p.getX() + " " + p.getY() + " " + p.isSelected());

		p.setX(10);
		p.setY(10);
		p.setSelected(true);
		
		System.out.println(p.getX() + " " + p.getY() + " " + p.isSelected());
		
		System.out.println(p.distance(40, 50));
	}

}
