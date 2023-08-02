import java.util.List;
import java.util.Scanner;

import com.dto.DeptDTO;
import com.service.DeptService;
import com.service.DeptServiceImpl;

public class DeptMain {

	public static void main(String[] args) {

		// 화면처리 추가
		while (true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("1. 전체목록");
			System.out.println("0. 종료");
			System.out.println("---------------");
			String num = scan.nextLine();
			if ("1".equals(num)) {
				// 서비스 연동
				DeptService service = new DeptServiceImpl(); // 다형성
				List<DeptDTO> list = service.findAll();
				System.out.println("부서번호\t 부서명\t 부서위치");
				System.out.println("----------------------");
				for (DeptDTO dto : list) {
					System.out.println(dto); // dto.toString()
				}
			} else if ("0".equals(num)) {
				System.out.println("프로그램 종료");
				System.exit(0);
			}
		} // end while

	}// end main

}// end class
