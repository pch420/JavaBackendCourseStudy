package stu3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductSearchMain {

	public static void main(String[] args) {
		
		List<Product> products=new ArrayList<>();
		
		products.add(new Product(1, true, "마우스", 5000));
		products.add(new Product(2, false, "키보드", 15000));
		products.add(new Product(3, true, "포인터", 50000));
		products.add(new Product(4, true, "케이스", 3000));
		products.add(new Product(5, false, "형광펜", 1000));
		products.add(new Product(6, true, "액정필름", 10000));
		products.add(new Product(7, true, "케이블", 8000));
		products.add(new Product(8, false, "지우개", 1000));
		products.add(new Product(9, true, "볼펜", 2500));
		products.add(new Product(10, true, "샤프", 4000));
		
		products.stream()
				.filter(t->t.isSale())
				.filter(t->t.getPrice() <= 100000)
				.sorted(Comparator.comparingInt(t->t.getPrice()))
				.forEach(System.out::println);
	}

}
