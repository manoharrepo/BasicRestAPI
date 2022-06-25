package files;

import static org.testng.Assert.assertEquals;

import java.io.Console;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class ComplexParseJson {
  public static void main(String args[]) {
	  System.out.println(payload.course());
	  JsonPath js = new JsonPath(payload.course());
	  
     int noofcource =  js.getInt("courses.size()");
     System.out.println("No of Courses: "+noofcource);
     
   int purchaseAmount=   js.getInt("dashboard.purchaseAmount");
   System.out.println("Total purchase Amount: "+purchaseAmount);
   String title = js.getString("courses[0].title");
   System.out.println(title);
   int total = 0 ;
   for (int i =0;i<noofcource;i++) {
	   
	 String cor =   js.getString("courses["+i+"].title");
	int pp =    js.getInt("courses["+i+"].price");
	int cop =    js.getInt("courses["+i+"].copies");
	 System.out.println("Course Name :"+cor+" and Course Price : "+pp+" Copies: "+cop);
	 
	 int pay = pp*cop;
	 total = total+pay;
	 
	 if (js.getString("courses["+i+"].title").equals("RPA")) {
		
		 int copies = js.getInt("courses["+i+"].copies");
		 System.out.println(copies);
		 
	 }
	   
   }
   
   System.out.println("Total : "+total);
   Assert.assertEquals(total,purchaseAmount);
  }
}
