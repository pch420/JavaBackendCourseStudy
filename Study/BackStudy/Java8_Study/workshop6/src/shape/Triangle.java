package shape;

public class Triangle extends Shape implements Resize {

	public Triangle() {}

	public Triangle(int width, int height, String colors) {
		super(width, height, colors);
	}

	@Override
	public double getArea() {
		// 밑변 * 높이/2
		return (double) getWidth() * getHeight() / 2;
	}

	@Override
	public void setResize(int size) {
		int update = getHeight() + size;
		setHeight(update);
	}

}
