//�ʿ��� ��Ű�� �ٿ�ε��ϴ� ��
//Jsoup���̺귯�� ->http://rhkdvy1200.tistory.com/entry/Jsoup%EB%A1%9C-%ED%8C%8C%EC%8B%B1%ED%95%98%EA%B8%B0
//komoran���̺귯�� -> http://shineware.tistory.com/entry/KOMORAN-ver-20-beta-%EC%9E%90%EB%B0%94-%ED%95%9C%EA%B5%AD%EC%96%B4-%ED%98%95%ED%83%9C%EC%86%8C-%EB%B6%84%EC%84%9D%EA%B8%B0

//import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import java.util.List;
import java.util.Scanner;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//import kr.co.shineware.nlp.komoran.*;
//import kr.co.shineware.nlp.komoran.core.analyzer.Komoran;
//import kr.co.shineware.util.common.model.Pair;

public class Main {
	public static void main(String[] args)throws IOException{
		
    	String item;
    	final String naverURL = "http://shopping.naver.com/search/all.nhn?where=all&frm=NVSCTAB&query=";
    	Scanner scan = new Scanner(System.in);
    	System.out.print("���ϴ� ������ �Է�");
    	item = scan.nextLine();
    	String queryURL = naverURL+item;
    	
//		//���̹� ���� ���� ��ǰ�� ����
//		FileWriter fw1 = new FileWriter("C:\\Users\\lee\\jsoup\\out1.txt");
//		//���̹� ���� ���� ��ǰ���� ���¼ҷ� ����� ����
//		FileWriter fw2 = new FileWriter("C:\\Users\\lee\\jsoup\\out2.txt");
		//connet�� url�� �Ľ��ؿ´�.
		Document doc = Jsoup.connect(queryURL).get();
		//������ url���� select�Ͽ� ���ϴ� �����͸� �����Ѵ�. ����� div.atc��
		Elements titles = doc.select("div.title");
		
		//Elements titles = doc.select("div.atc");
		//�ǹ̻��� ���� ������ �ѱ� ���¼� �м��� komoran�� �����Ѵ�.
		//Komoran komoran = new Komoran("C:\\Users\\lee\\Desktop\\model\\models-full");//
		

//		komoran.setFWDic("user_data/fwd.user");
//		komoran.setUserDic("user_data/dic.user");
		
		//��� Ȯ�� �׽�Ʈ�� ���ؼ� ��Ŭ���� �ܼ�â��  �Ľ��� ���� ���
//		for(Element e: titles){
//			System.out.println("review: " + e.text());
//		}
		//��� Ȯ�� �׽�Ʈ�� ���ؼ� ��Ŭ���� �ܼ�â��  ������ ���¼� �м� ��� ���
//		for(Element e: titles){
//		List<List<Pair<String,String>>> result = komoran.analyze(e.text());//�Էµ� sentence�� �м� ����� ��ȯ
//		for (List<Pair<String, String>> eojeolResult : result) {
//			for (Pair<String, String> wordMorph : eojeolResult) {
//				System.out.println(wordMorph);
//			}
//			System.out.println();
//			}
//		}
//		//���Ͽ�  �Ľ��� ���� ����
//		int i=1;
//		for(Element e: titles){
//			String data = i++ +" ��° ����\r\n";
//	        fw1.write(data);
//            fw1.write(e.text());
//            fw1.write("\r\n\r\n");
//		}
//		//���Ͽ� ���� ���¼� �м� ��� ���� 
//		//���� ���� ���� [�ܾ�][tab][ǰ��]
//		int j=1;
//		for(Element e: titles){
//			List<List<Pair<String,String>>> result = komoran.analyze(e.text());//�Էµ� sentence�� �м� ����� ��ȯ
//			for (List<Pair<String, String>> eojeolResult : result) {
//				for (Pair<String, String> wordMorph : eojeolResult) {
//					String data = j++ +" ��°  ���¼� ���\r\n";
//					fw2.write(data);
//					fw2.write(wordMorph.toString());
//					fw2.write("\r\n\r\n");
//					
////					System.out.println(wordMorph);
//				}
//				System.out.println();
//				}
//			}
//		
//	
//		
//		fw2.close();
//		fw1.close();
		}
}



