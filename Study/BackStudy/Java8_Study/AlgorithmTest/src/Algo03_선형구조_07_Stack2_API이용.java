import java.util.Stack;

public class Algo03_선형구조_07_Stack2_API이용 {

	public static void main(String[] args) {

		// API
		Stack<Integer> x = new Stack<>();
		x.push(5);
		x.push(4);
		x.push(3);
		x.push(2);
		x.push(1);

		System.out.println(x); // [5, 4, 3, 2, 1]

		int n = x.pop();
		System.out.println(n + " " + x); // 1 [5, 4, 3, 2]

//		 Looks at the object at the top of this stack without removing it from the stack
		System.out.println("top값(스택에서 가장 최상위값)" + x.peek());

	}// end main
}// end class
