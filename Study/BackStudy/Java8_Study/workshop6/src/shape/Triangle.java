package shape;

public class Triangle extends Shape implements Resize {

	public Triangle() {
		// TODO Auto-generated constructor stub
	}

	public Triangle(int width, int height, String colors) {
		super(width, height, colors);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getArea() {
		double area;
		area = getWidth() * getHeight() * 0.5;
		return area;
	}

	@Override
	public void setResize(int size) {
		int resize;
		resize = getHeight() + size;
		setHeight(resize);

	}

}
