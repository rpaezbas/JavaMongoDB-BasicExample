

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class Service {
	
	public void saveUser(String body) {
		
		try {
			MongoClient mongo = new MongoClient( "localhost" , 27017 );
			DB db = mongo.getDB("testDb");
			DBCollection users = db.getCollection("users"); //A collection is a table-like structure, a given set of key-value pairs.
			DBObject dbObject = (DBObject) JSON.parse(body);
			users.insert(dbObject);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public void updateUser(String body, String email) {
		
		try {	
			MongoClient mongo = new MongoClient( "localhost" , 27017 );
			DB db = mongo.getDB("testDb");
			DBCollection gymUsers = db.getCollection("users");
			DBObject user = (DBObject) JSON.parse(body);
			BasicDBObject deprecatedUser = new BasicDBObject().append("email", email); //It looks for the user with the field email == email
			gymUsers.update(deprecatedUser, user);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
