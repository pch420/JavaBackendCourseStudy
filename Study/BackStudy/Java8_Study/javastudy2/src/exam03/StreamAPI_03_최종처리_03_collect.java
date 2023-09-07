package exam03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Stu {
	String username;
	int grade;
	boolean isMale; // 남자냐?
	int age;

	public Stu() {
	}

	public Stu(String username, int grade, boolean isMale, int age) {
		this.username = username;
		this.grade = grade;
		this.isMale = isMale;
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Stu [username=" + username + ", grade=" + grade + ", isMale=" + isMale + ", age=" + age + "]";
	}

}

public class StreamAPI_03_최종처리_03_collect {

	public static void main(String[] args) {

		/*-
		 	collect(Collector<? super T, A, R> collector)
		 	- 파라미터인 Collector 인터페이스 대신에
		 	  Collectors 클래스를 사용한다.
		 	- Collectors 클래스의 메서드는 static 메서드이기 때문에
		 	  Collectors.메서드 형식으로 사용한다.	
		*/

		Stu[] stuArr = { new Stu("홍길동", 3, true, 25), 
						 new Stu("이순신", 1, true, 55), 
						 new Stu("유관순", 2, false, 18),
						 new Stu("안중근", 3, true, 31), 
						 new Stu("홍범도", 1, true, 58), 
						 new Stu("강감찬", 3, true, 44) };
		
		// 1. 이름만 출력
		Arrays.stream(stuArr)
			  .map(Stu::getUsername)
			  .forEach(System.out::println);
		System.out.println();
		
		// 2. 이름만 List에 저장
		List<String> list = Stream.of(stuArr)
							.map(Stu::getUsername)
							.collect(Collectors.toList());
		System.out.println("2. 이름만 List에 저장 : " + list);
		System.out.println();
		
		// 3. Map으로 저장 Map<이름, Stu>
		Function<Stu, String> keyMapper = new Function<Stu, String>() {
			
			@Override
			public String apply(Stu t) {
				return t.getUsername();
			}
		};
		// 익명클래스
		Function<Stu, Stu> valueMapper = new Function<Stu, Stu>() {
			@Override
			public Stu apply(Stu t) {
				return t;
			}
		};
		
		Map<String, Stu> m = Stream.of(stuArr)
								   .collect(Collectors.toMap(keyMapper, valueMapper));
		Set<String> keys = m.keySet();
		for (String key : keys) {
			System.out.println(key + " = " + m.get(key));
		}
		System.out.println();

		// 람다표현식
		Map<String, Stu> m2 = Stream.of(stuArr)
								   .collect(Collectors.toMap(t->t.getUsername(),t->t));
		keys = m2.keySet();
		for (String key : keys) {
			System.out.println(key + " = " + m.get(key));
		}
		System.out.println();
		
		// method reference
		Map<String, Stu> m3 = Stream.of(stuArr)
									.collect(Collectors.toMap(Stu::getUsername,t->t));
		keys = m3.keySet();
		for (String key : keys) {
			System.out.println(key + " = " + m.get(key));
		}
		System.out.println();
		
		// 4. 갯수
		long count = Stream.of(stuArr)
						   .collect(Collectors.counting());
		System.out.println("4. 갯수: " + count);
		System.out.println();
		
		// 5. age 합계
		int sum = Stream.of(stuArr)
						.collect(Collectors.summingInt(Stu::getAge));
		System.out.println("5. age 합계 : " + sum);
		System.out.println();
		
		// 6. age 최댓값
		Optional<Stu> max = Stream.of(stuArr)
								  .collect(Collectors.maxBy(Comparator.comparing(Stu::getAge)));
		System.out.println("6. age 최댓값 : " + max.get());
		System.out.println("6. age 최댓값 : " + max.orElse(null));
		System.out.println();
		
		// 7. age 최소값
		Stu min = Stream.of(stuArr)
				  		.collect(Collectors.minBy(Comparator.comparing(Stu::getAge))).orElse(null);
		System.out.println("7. age 최소값 : " + min);
		System.out.println();
		
		/*
			collect(Collectors.partitioningBy(Predicate))
			==> true 값과 false로 나눠서 반환
			
			collect(Collectors.groupingBy(Function))
			==> Function에서 리턴값으로 그룹핑해서 반환
		*/
		
		// 8. 성별 분류
		// 익명클래스
		Predicate<Stu> predicate = new Predicate<Stu>() {
			
			@Override
			public boolean test(Stu t) {
				return t.isMale;
			}
		}; 
		
		Map<Boolean, List<Stu>> xxx = Stream.of(stuArr).collect(Collectors.partitioningBy(predicate));
		List<Stu> male = xxx.get(true);
		List<Stu> female = xxx.get(false);

		System.out.println("male : " + male);
		System.out.println("female : " + female);
		System.out.println();
		
		// 람다표현식
		Map<Boolean, List<Stu>> xxx2 = Stream.of(stuArr)
											 .collect(Collectors.partitioningBy(t->t.isMale));
		male = xxx2.get(true);
		female = xxx2.get(false);
		System.out.println("male : " + male);
		System.out.println("female : " + female);
		System.out.println();
		
		// method reference
		Map<Boolean, List<Stu>> xxx3 = Stream.of(stuArr)
				.collect(Collectors.partitioningBy(Stu::isMale));
		male = xxx3.get(true);
		female = xxx3.get(false);
		System.out.println("male : " + male);
		System.out.println("female : " + female);
		System.out.println();
		
		// 9. grade 그룹핑
		// 익명클래스
		Function<Stu, Integer> classifier = new Function<Stu, Integer>() {
			
			@Override
			public Integer apply(Stu t) {
				return t.getGrade();
			}
		};
		
		Map<Integer, List<Stu>> yyy = Stream.of(stuArr)
											.collect(Collectors.groupingBy(classifier));
		Set<Integer> keys2 = yyy.keySet();
		for (Integer key : keys2) {
			System.out.println(key + "=" + yyy.get(key));
		}
		System.out.println();
		
		// grade 그룹핑 갯수 구하기 
		Map<Integer, Long> yyy2 = Stream.of(stuArr)
										.collect(Collectors.groupingBy(classifier, Collectors.counting()));
		keys2 = yyy2.keySet();
		for (Integer key : keys2) {
			System.out.println(key + "=" + yyy2.get(key));
		}
		System.out.println();
		
		
	} // end main
} // end class
