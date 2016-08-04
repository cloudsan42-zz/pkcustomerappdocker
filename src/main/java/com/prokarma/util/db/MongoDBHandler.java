package com.prokarma.util.db;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class MongoDBHandler {
	public static MongoClient mongo = null;
	public static DB db = null;
	public static DBCollection table = null;

	public static String dbHost = null;
	public static String dbPort = null;
	public static String dbUser = null;
	public static String dbPassword = null;
	public static String dbName = null;
	public static String dbOperations = null;

	public static String dbURI = null;

	// @SuppressWarnings("finally")
	@SuppressWarnings("finally")
	public static void getMongoCon(String hostName, String portNo) {
		boolean status = true;
		/**** Connect to MongoDB ****/
		// Since 2.10.0, uses MongoClient
		try {
			System.out.println("Creating Connection Object to MongoDB....");
			mongo = new MongoClient(MongoDBHandler.dbURI);
			/**** Get database ****/
			// if database doesn't exists, MongoDB will create it for you
			db = mongo.getDB(dbName);
			// Authentication
			// boolean auth = db.authenticate(dbUser, dbPassword);
			// System.out.println("Auth Status::::" + auth);
			/**** Get collection / table from 'notes_tab' ****/
			// if collection doesn't exists, MongoDB will create it for you
			table = db.getCollection("notes_tab");
			// return new Object();
		} catch (Exception e) {
			status = false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Creating Connection Object to MongoDB....Status::::" + "Successful::::" + status);
		}
	}

	@SuppressWarnings("finally")
	public static boolean putNote(String owner, String note) {
		boolean status = true;
		try {
			/**** Insert ****/
			System.out.println("/**** Insert ****/");
			// create a document to store key and value
			BasicDBObject document = new BasicDBObject();
			document.put("note_owner", owner);
			document.put("note", note);
			table.insert(document);
		} catch (Exception ex) {
			ex.printStackTrace();
			status = false;
		} finally {
			return status;
		}
	}

	@SuppressWarnings("finally")
	public static void getNote(String owner) {
		try {
			/**** Find and display ****/
			System.out.println("/**** Find and Display ****/");
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("note_owner", owner);
			DBCursor cursor = table.find(searchQuery);
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}
	}

	@SuppressWarnings("finally")
	public static boolean postNote(String oldNote, String newNote) {
		boolean status = true;
		try {
			/**** Update ****/
			System.out.println("/**** Update ****/");
			// search document where note=oldNote and update it with newNote
			BasicDBObject query = new BasicDBObject();
			query.put("note", oldNote);

			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("note", newNote);

			BasicDBObject updateObj = new BasicDBObject();
			updateObj.put("$set", newDocument);

			table.update(query, updateObj);
		} catch (Exception ex) {
			ex.printStackTrace();
			status = false;
		} finally {
			return status;
		}
	}

	@SuppressWarnings("finally")
	public static boolean deleteNote(String noteOwner) {
		boolean status = true;
		try {
			/** Delete **/
			System.out.println("/**** Delete ****/");
			BasicDBObject searchQuery1 = new BasicDBObject();
			searchQuery1.put("note_owner", noteOwner);
			table.remove(searchQuery1);
		} catch (Exception ex) {
			ex.printStackTrace();
			status = false;
		} finally {
			return status;
		}
	}

}
