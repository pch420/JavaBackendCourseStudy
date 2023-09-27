package com.exam;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class UpdateTest {
	public static void main(String[] args) {
		// db.collection.find()

		// 1. 몽고 DB 연결 - mongodb://localhost:27017
		MongoClient client = MongoClients.create("mongodb://localhost:27017");

		// 2. tutorial db 연결 - use tutorial
		MongoDatabase db = client.getDatabase("tutorial");

		// 3. 컬렉션 연결
		MongoCollection<Document> collection = db.getCollection("user");

		// ################################
		// 가. 단일 문서 수정 ( updateOne(필터, 업데이트) , $set 표현식)
		// db.user.updateOne({username:'정조'}, {$set:{age:70}} )
		Bson filter = Filters.eq("username", "정조");
		Bson update = Updates.set("age", 70);
		collection.updateOne(filter, update);

		// db.user.updateOne({username:'정조'}, {$set:{age:40, gender:'f'}})
		Bson filter2 = Filters.eq("username", "정조");
		Bson update2 = Updates.combine(Updates.set("age", 40), Updates.set("gender", "f"));
		collection.updateOne(filter2, update2);

		// 나. 멀티 문서 수정 ( updateMany(필터, 업데이트), $set 표현식 )
		// db.user.updateMany({age:{$gt:40}}, {$set:{gender:'f'}})

		collection.updateMany(Filters.gt("age", 40), Updates.set("gender", "m"));
		// ################################

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
