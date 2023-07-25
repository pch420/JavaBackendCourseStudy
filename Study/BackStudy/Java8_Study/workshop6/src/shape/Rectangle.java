package shape;

public class Rectangle extends Shape implements Resize {

	public Rectangle() {}

	public Rectangle(int width, int height, String colors) {
		super(width, height, colors);
	}

	@Override
	public double getArea() {
		// 밑변 * 높이
		return (double) getWidth() * getHeight();
	}

	@Override
	public void setResize(int size) {
		int update = getWidth() + size;
		setWidth(update);

	}

}
