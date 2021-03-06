
import java.io.IOException;
import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Crawling {
	public static void main(String[] args)throws Exception{
		System.out.println("웹 크롤링 시작.......");
    	String item;
    	
    	ArrayList<String> naverShopURL = new ArrayList<String>();
        String base = "http://shopping.naver.com/search/all.nhn?query=";
        //String KEYWORD = "가습기";
        
        DTO dto = new DTO();
        insertDAO DB = new insertDAO();
        Crawling crawler = new Crawling();
        IDparsing parse = new IDparsing();
        ManipulateUrl manipulateUrl = new ManipulateUrl();
        ParsingKeyword parseKey = new ParsingKeyword();//(JDBC)inputDB에서 상품명을 가져온다.
        
    	
    	//final String query = "http://shopping.naver.com/search/all.nhn?query=가습기";
    	
    	
    	
    	System.out.println("웹상에서 검색된 키워드..."+parseKey.getKeyword());
    	naverShopURL = manipulateUrl.makeUrl("http://shopping.naver.com/detail/detail.nhn?",parseKey.getKeyword(),parse.getModelId(base, parseKey.getKeyword()));
    	//카테고리를 파싱한다. 	
    	crawler.getCategory(base+parseKey.getKeyword());
    	//상품 브랜드 이름과 url를 파싱한다. 
    	for(int i=0;i<naverShopURL.size();i++){
    		//dto로 웹상에서 검색된 카테고리 키워드를 넘겨준다.
    		dto.setCategory(parseKey.getKeyword());
    		//dto로 파싱한 브랜드명을 넘겨준다.
    		dto.setModel(crawler.getBrandName(naverShopURL.get(i)));
    		//파싱한 브랜드명 출력
    		//crawler.getBrandName(naverShopURL.get(i));
    		
    		dto.setUrl(crawler.getUrl(naverShopURL.get(i)));
    		//crawler.getUrl(naverShopURL.get(i));
    		
    		insertDAO.create(dto);
    	}	
			
    	
    	//리뷰 파싱 기능
    	for(int i=0;i<naverShopURL.size();i++){
    		//crawler.getProductReview(naverShopURL.get(i));
    		
    	}
	}
    	
    	
    void getCategory(String url) throws IOException{
		String trim;
		int endIndex;
		Document doc = Jsoup.connect(url).get();
		Elements category = doc.select("ul.goods_list span.depth ");
		trim = category.text();
		endIndex = trim.indexOf('>');
		System.out.println("상품 카테고리... "+trim.substring(0, endIndex));
			
	}
	
	String getBrandName(String url) throws IOException{
		Document doc = Jsoup.connect(url).get();
		Elements brandName = doc.select("div.h_area h2");
//		if(brandName != null)
//			System.out.println("상품없음");
		
		if(brandName.isEmpty()){
			//System.out.println("상품없음");
			return "NULL";
		}	
		
		else{
			//System.out.println(brandName.text());
			return brandName.text();
		}
		
		
	}
	String getUrl(String url){
		//System.out.println(url);
		return url;
		
	}
	
	void getProductReview(String url) throws IOException{
		
    	int cnt1;
    	int cnt2=1;
    	String tmpUrl;
    	
    	
    	for(cnt1 = 1; cnt1<=1 ; cnt1++){
    		tmpUrl = null;
    		tmpUrl = url + "&page="+cnt1;
		Document doc = Jsoup.connect(url).get();
		//Document doc_query = Jsoup.connect(query).get();
		
		Elements scraping = doc.select("div.atc");
		
		for(Element e : scraping){
		System.out.println(cnt2+e.text());
		cnt2++;
		}
		
    	}
	}
	
	
}

