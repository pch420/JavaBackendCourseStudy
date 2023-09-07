package stu4;

import java.util.ArrayList;
import java.util.List;

public class MemberAddressMain {

	public static void main(String[] args) {
		
		List<Member> members=new ArrayList<>();
		
		members.add(new Member("홍길동", "서울특별시", "hong@gmail.com", 25));
		members.add(new Member("김길동", "원주시", "kim@gmail.com", 23));
		members.add(new Member("가길동", "서울특별시", "ka@hotmail.com", 35));
		members.add(new Member("박길동", "대전광역시", "park@hotmail.com", 56));
		members.add(new Member("송길동", "부산광역시", "song@gmail.com", 43));
		members.add(new Member("이길동", "서울특별시", "lee@gmail.com", 32));
		members.add(new Member("조길동", "부산광역시", "cho@naver.com", 30));
		members.add(new Member("손길동", "인천광역시", "son@gmail.com", 48));
		members.add(new Member("한길동", "인천광역시", "han@hotmail.com", 52));
		members.add(new Member("나길동", "서울특별시", "na@naver.com", 29));
		
		members.stream()
			   .filter(t->t.getAddress().contains("광역시"))
			   .forEach(System.out::println);

	}

}
