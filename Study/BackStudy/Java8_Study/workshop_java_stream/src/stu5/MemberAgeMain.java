package stu5;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class MemberAgeMain {

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
		
		int sum = members.stream()
						 .mapToInt(t->t.getAge())
						 .sum();
		System.out.println("Sum : " + sum);
		
		double avg = members.stream()
				 			.mapToDouble(t->t.getAge())
				 			.average()
				 			.orElse(0.0);
		System.out.println("Avg : " + avg);
		
		int min = members.stream()
	 					 .mapToInt(t->t.getAge())
	 					 .min()
	 					 .orElse(0);
		System.out.println("Min : " + min);
		
		int max= members.stream()
				 .mapToInt(t->t.getAge())
				 .max()
				 .orElse(0);
		System.out.println("Max : " + max);
		

	}

}
