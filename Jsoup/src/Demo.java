
import java.io.IOException;
//import org.jsoup.helper.Validate;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import java.util.List;
import java.util.Scanner;
import java.util.Scanner;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Demo {
    public static void main(String[] args) throws IOException {
        //Validate.isTrue(args.length == 1, "usage: supply url to fetch");
    	String str;
    	String nv_mid;
    	String subString;
    	String model_Id;
    	int indexOfFirst,indexOfLast;
        String base = "http://shopping.naver.com/search/all.nhn?query=";
        String KEYWORD = "가습기 ";
        String url = base + KEYWORD;
        print("Fetching %s", url);
        String attr;
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");
        Elements mid_id = doc.select("._productLazyImg");
        Elements cat_id = doc.select(".depth");
        
        //._productLazyImg
        //a[href].data-nv-mid
        Elements media = doc.select("[src]");
        Elements imports = doc.select("link[href]");

        print("\nMedia: (%d)", media.size());
        for (Element src : media) {
            if (src.tagName().equals("img"))
                print(" * %s: <%s> %sx%s (%s)",
                        src.tagName(), src.attr("abs:src"), src.attr("width"), src.attr("height"),
                        trim(src.attr("alt"), 20));
            else
                print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
        }

        print("\nImports: (%d)", imports.size());
        for (Element link : imports) {
            print(" * %s <%s> (%s)", link.tagName(),link.attr("abs:href"), link.attr("rel"));
        }

        print("\nLinks: (%d)", links.size());
        for (Element link : links) {
        	
        	print(" %s  (%s)", link.attr("abs:href"), trim(link.text(), 35));
            
            }
        for(Element c : cat_id){
        	//str = c.attr("cat_id");
        	System.out.println("cat_id : " + c.text());
        	
        }
        
        for (Element l : mid_id) {
        	
        	nv_mid = l.attr("data-original");
        	indexOfFirst = nv_mid.indexOf("main_"); 
        	indexOfLast = nv_mid.indexOf('.');
			
			subString = nv_mid.substring(indexOfFirst+13,nv_mid.length());
			
			 
        	indexOfLast = subString.indexOf('.');
        	
        	model_Id = subString.substring(0,indexOfLast);
        	System.out.println("모델 아이디 :"+model_Id);
			
        	//print("%s",l.attr("data-original"));
        }
    }
    
 
    
    

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }
}



