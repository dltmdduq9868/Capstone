import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
import java.text.*;
//import com.mysql.jdbc.Statement;
import java.sql.Statement;
import java.sql.ResultSet; 
public class ParsingKeyword {
  public static void main(String[] sargs){
	  
  }
	
  public String getKeyword() throws Exception {
//   System.out.println("ParsingKeyword start.....");	  
   boolean flag = false;
   Connection con = null;
   Statement stmt = null; // 데이터를 전송하는 객체
   ResultSet rs = null;
   
   String keyword=null;
   
   

   //select keyword from input order by keyword limit 1;
   //select SEQ from table_name order by SEQ desc limit 1:
   //String sql = "SELECT keyword FROM input order by keyword desc limit 1";
//   String sql = "select * from input order by keyword limit 1;";
   String sql = "select * from input;";
   //input 테이블에서 마지막 행만 가져온다.
   
   try {

 
    //동적으로 클래스를 생성하는것도 목적이지만 동적으로 생성될때 DriverManager에 해당 클래스를 등록시키는 목적도 있습니다.
    Class.forName("com.mysql.jdbc.Driver");


    con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/scrapy?useUnicode=true&characterEncoding=euc_kr", "root", "458658");
    System.out.println("connection ok");
    stmt = (Statement) con.createStatement();
    rs = stmt.executeQuery(sql);
    
    
    while (rs.next()) {
      keyword = rs.getString("keyword");
    
    System.out.println("inputDB에서 마지막 행 : "+keyword);
    }
    flag = true;
   } catch (Exception e) {
    System.out.println(e);
    flag = false;
   } finally {
 
    try {
     if(rs != null)
      rs.close();
     if (stmt != null)
      stmt.close();
     if (con != null)
      con.close();
    } catch (Exception e) {
     System.out.println(e.getMessage());
    }
   }
 
   return keyword;
 
  }
}
