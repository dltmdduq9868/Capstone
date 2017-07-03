import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
import java.text.*;
//import com.mysql.jdbc.Statement;
import java.sql.Statement;
 
public class insertDAO {
	
  public static boolean create(DTO dto) throws Exception {
   System.out.println("상품명과 URL를 DB에 삽입전");	  
   boolean flag = false;
   Connection con = null;
   Statement stmt = null; // 데이터를 전송하는 객체
   
   String category = dto.getCategory();
   String model = dto.getModel();
   String url = dto.getUrl();
   
   String sql = "INSERT INTO model_url(category, model, url) VALUES";
 
   try {
    /*한글처리를 위해
     * 이클립스와 데이터베이스 설치시 한글처리를 미리 해주면 코드에서 한글처리
     * 안해도 됩니다.
     * */
//    sql += "('" + new String(model.getBytes(), "ISO-8859-1") + "','"  
//      + new String(url.getBytes(), "ISO-8859-1") + "')";
	   
	   
//	sql += "('" + new String(model.getBytes("8859_1"), "KSC5601") + "','"  
//			    + new String(url.getBytes("8859_1"), "KSC5601") + "')";
	
//    int rowNum =stmt.executeUpdate("insert se (feature, sentWord, sentValue, word1, word2, word3, word4) values('" + 
//    feature + "', '" + sentWord + "', '" + sentValue + "', '" + word1 + "', '" + word2 + "', '" + word3 + "', '" + word4 + "');");
//	  sql += "('" + model + "', '"  + url + "')"; 
      sql += "('" + category + "', '" + model + "', '"  + url + "')";
 
    //동적으로 클래스를 생성하는것도 목적이지만 동적으로 생성될때 DriverManager에 해당 클래스를 등록시키는 목적도 있습니다.
    Class.forName("com.mysql.jdbc.Driver");
    

    //String url = "jdbc:mysql://localhost/hoho?useUnicode=true&characterEncoding=utf8";
    //Connection con = DriverManager.getConnection(url, "root", "XXXXX");
    //jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=utf8
    //& useUnicode=true&characterEncoding=euc_kr

    con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/scrapy?useUnicode=true&characterEncoding=euc_kr", "root", "458658");
    System.out.println("connection ok");
    //error
    stmt = (Statement) con.createStatement();
    stmt.executeUpdate(sql);
    
    System.out.print(category+"...카테고리 DB에 저장 완료");
    System.out.println(model+"...모델명 DB에 저장 완료");
    System.out.println(url+"...URL DB에 저장 완료");
 
    flag = true;
   } catch (Exception e) {
    System.out.println(e);
    flag = false;
   } finally {
 
    try {
 
     if (stmt != null)
      stmt.close();
     if (con != null)
      con.close();
    } catch (Exception e) {
     System.out.println(e.getMessage());
    }
   }
 
   return flag;
 
  }
}
