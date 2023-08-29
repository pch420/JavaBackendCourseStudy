// 자바의 싱글톤 패턴 구현 (singleton design pattern)
// UserService를 단 한번만 생성하게끔 구현

class UserService {

	// 3. static 변수로 지정 , 외부에서 접근 x - private
	private static UserService service;

	// 1. 생성자를 private로 지정 (무분별한 new를 막기위해)
	private UserService() {
	}

	// 2. 자기자신의 메서드에서 생성
	public static UserService getInstance() {
		// 맨 처음 getInstance() 호출하면 null이기 때문에 객체생성이 되고 service 변수에 100번지가 저장됨.
		// 두번째 getInstance() 호출부터는 null이 아니기 때문에 객체생성없이 그냥 service 값인 100번지를 반환함.
		if (service == null) {
			service = new UserService();
		}
		return service;
	}
}

public class TestMain {

	public static void main(String[] args) {

		UserService s1 = UserService.getInstance(); // 100번지
		UserService s2 = UserService.getInstance(); // 100번지
		UserService s3 = UserService.getInstance(); // 100번지

		System.out.println(s1 == s2); // true
		System.out.println(s1 == s2); // true
		System.out.println(s2 == s3); // true
	}

}
