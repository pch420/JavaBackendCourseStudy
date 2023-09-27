package com.exam;

import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class InsertTest {
	public static void main(String[] args) {
		// db.collection.find()

		// 1. 몽고 DB 연결 - mongodb://localhost:27017
		MongoClient client = MongoClients.create("mongodb://localhost:27017");

		// 2. tutorial db 연결 - use tutorial
		MongoDatabase db = client.getDatabase("tutorial");

		// 3. 컬렉션 연결
		MongoCollection<Document> collection = db.getCollection("user");

		// ###########################
		// 가. 단일 문서 저장 (insertOne(문서))
		// db.user.insertOne(문서)
		Document d1 = new Document();
		d1.append("_id", 8);
		d1.append("username", "홍범도");
		d1.append("age", 68);
		d1.append("gender", "M");

//		collection.insertOne(d1);
		// 나. 멀티 문서 저장 (insertMany([문서1, 문서2, ...]))

		Document x = new Document();
		x.append("username", "홍범도1");
		x.append("age", 68);
		x.append("gender", "m");

		Document x2 = new Document();
		x2.append("username", "홍범도2");
		x2.append("age", 4);
		x2.append("gender", "f");

		List<Document> list = Arrays.asList(x, x2);

		collection.insertMany(list);
		// ###########################

		// 4. 전체 조회 - db.user.find()
		// MongoCursor가 JDBC의 ResultSet 기능
		MongoCursor<Document> cursor = collection.find().cursor();

		while (cursor.hasNext()) {
			Document doc = cursor.next();
			System.out.println(doc);
			System.out.println(doc.get("_id") + "\t" + doc.getString("username"));
		}

	}// end main
}// end class
