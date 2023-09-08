import java.util.Arrays;

class MyStack {

	int top; // 스택 가장 최상단
	int size;
	int[] stack;

	public MyStack(int size) {
		this.size = size;
		stack = new int[size];
		top = -1;
	}

	// 저장 : top 증가하고 값 저장
	public void push(int n) {
		++top;
		stack[top] = n;
		System.out.println(stack[top] + " Push~");
	}

	// 삭제: 값 제거하고 top 감소
	public void pop() {
		if (top >= 0) {
			System.out.println(stack[top] + " pop~");
		}
		stack[top--] = 0;
	}

	// 현재 top에 있는 값 반환 (스택의 가장 최상단)
	public int peek() {
		return stack[top];
	}

}// end class

public class Algo03_선형구조_07_Stack1_직접생성 {

	public static void main(String[] args) {

		MyStack x = new MyStack(5);
		x.push(5);
		x.push(4);
		x.push(3);
		x.push(2);
		x.push(1);

		System.out.println(Arrays.toString(x.stack));
		System.out.println(x.peek());
		System.out.println();

		for (int i = 0; i < x.size; i++) {
			x.pop();
		}

	}// end main
}// end class
