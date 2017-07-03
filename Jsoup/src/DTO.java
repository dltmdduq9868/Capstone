public class DTO {
String category;
String model;
String url;

public String getCategory(){
	return category;
}

public void setCategory(String category){
	this.category = category;
}
public String getModel() {

 return model;
}
public void setModel(String model) {
//System.out.println("setmodel "+model);	
 this.model = model;
}

public String getUrl() {
 return url;
}

public void setUrl(String url) {
//System.out.println("seturl "+url);
 this.url = url;
}

}

//System.out.println("model "+model);
//System.out.println("url "+url);