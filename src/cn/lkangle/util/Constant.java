package cn.lkangle.util;

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;

public class Constant {
	public static String DB    = "dorm";
	public static String MYSQL = "jdbc:mysql://localhost:3306/dorm?characterEncoding=gbk";
	public static String USER  = "root";
	public static String PASS  = "root";
	public static String JDBC  = "com.mysql.jdbc.Driver";
	
//	public Constant() {
//		String url = null, port = null;
//		File file = new File("config.ini");
//		if(!file.isFile()){
//			System.err.println("没有发现配置文件！");
//			return;
//		}
//		Scanner in = null;
//		try {
//			in = new Scanner(file);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		while (in.hasNextLine()){
//			String string = in.nextLine();
//			if((string.indexOf("MYSQL")) != -1){
//				url = string.substring(string.indexOf('"') + 1, string.lastIndexOf('"'));
//			} else if (string.indexOf("PORT") != -1) {
//				port = string.substring(string.indexOf('"') + 1, string.lastIndexOf('"'));
//			} else if ((string.indexOf("DB")) != -1) {
//				DB = string.substring(string.indexOf('"') + 1, string.lastIndexOf('"'));
//			} else if ((string.indexOf("USER")) != -1) {
//				USER = string.substring(string.indexOf('"') + 1, string.lastIndexOf('"'));
//			} else if ((string.indexOf("PASS")) != -1) {
//				PASS = string.substring(string.indexOf('"') + 1, string.lastIndexOf('"'));
//			}
//		}
//		MYSQL = "jdbc:mysql://" + url + ":" + port + "/" + DB + "?characterEncoding=gbk";
//		in.close();
//	}
}
