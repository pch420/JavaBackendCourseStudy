package com.exam;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class SelectTest {
	public static void main(String[] args) {
		// db.collection.find()

		// 1. 몽고 DB 연결 - mongodb://localhost:27017
		MongoClient client = MongoClients.create("mongodb://localhost:27017");

		// 2. tutorial db 연결 - use tutorial
		MongoDatabase db = client.getDatabase("tutorial");

		// 3. 컬렉션 연결
		MongoCollection<Document> collection = db.getCollection("user");

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
