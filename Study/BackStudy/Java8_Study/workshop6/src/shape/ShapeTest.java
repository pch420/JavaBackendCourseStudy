package shape;

public class ShapeTest {

	public static void main(String[] args) {

		// 다형성으로 배열
		Shape shape[] = new Shape[6];
		shape[0] = new Triangle(7, 5, "Blue");
		shape[1] = new Rectangle(4, 6, "Blue");
		shape[2] = new Triangle(6, 7, "Red");
		shape[3] = new Rectangle(8, 3, "Red");
		shape[4] = new Triangle(9, 8, "White");
		shape[5] = new Rectangle(5, 7, "White");

		System.out.println("기본정보");

		for (Shape s : shape) {
			String shapeName = "";
			if (s instanceof Triangle) {
				shapeName = "Triangle";
			} else {
				shapeName = "Rectangle";
			}
			System.out.println(shapeName + " \t " + s.getArea() + " \t " + s.getColors());
		}

		System.out.println();
		System.out.println("사이즈를 변경 후 정보");

		for (Shape s : shape) {
			// Triangle --> Resize 변경 가능
			// Rectangle --> Resize 변경 가능
			Resize r = (Resize) s;
			r.setResize(5);
		}

		for (Shape s : shape) {
			String shapeName = "";
			if (s instanceof Triangle) {
				shapeName = "Triangle";
			} else {
				shapeName = "Rectangle";
			}

			System.out.println(shapeName + " \t " + s.getArea() + " \t " + s.getColors());
		}

	}

}
