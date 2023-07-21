package shape;

public class Rectangle extends Shape implements Resize {

	public Rectangle() {
		// TODO Auto-generated constructor stub
	}

	public Rectangle(int width, int height, String colors) {
		super(width, height, colors);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getArea() {
		double area;
		area = getWidth() * getHeight();
		return area;
	}

	@Override
	public void setResize(int size) {
		int resize;
		resize = getWidth() + size;
		setWidth(resize);

	}

}
