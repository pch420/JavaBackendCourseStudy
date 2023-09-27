package com.exam;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class SelectTest2 {
	public static void main(String[] args) {
		// db.collection.find()

		// 1. 몽고 DB 연결 - mongodb://localhost:27017
		MongoClient client = MongoClients.create("mongodb://localhost:27017");

		// 2. tutorial db 연결 - use tutorial
		MongoDatabase db = client.getDatabase("tutorial");

		// 3. 컬렉션 연결
		MongoCollection<Document> collection = db.getCollection("user");

		// 4. 조건 지정 - db.user.find({gender:'f'})

		Bson filter = Filters.eq("gender", "f");

		// 조건 조회 - db.user.find({age:{$gt:60}})
		filter = Filters.gt("age", 60);

		// 조건 조회 - db.user.find({$and:[{gender:'f'},{age:18}]})
		filter = Filters.and(Filters.eq("gender", "f"), Filters.eq("age", 18));

		// 조건 조회 - db.user.find({$or:[{gender:'f'},{age:18}]})
		filter = Filters.or(Filters.eq("gender", "f"), Filters.eq("age", 18));

		MongoCursor<Document> cursor = collection.find(filter).cursor();

		while (cursor.hasNext()) {
			Document doc = cursor.next();
			System.out.println(doc);
			System.out.println(doc.get("_id") + "\t" + doc.getString("username"));
		}

	}// end main
}// end class
