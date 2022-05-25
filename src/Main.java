import java.util.regex.Pattern;

public  class Main {
    public static void main(String[] args) {
        System.out.println(Pattern.compile("(\\(\\s*[a-zA-Z0-9]*(\\s*[,]\\s*[a-zA-Z0-9]*)*\\s*\\))$").matcher("method").find());
       // System.out.println(Pattern.compile("((\\.jpg) | (\\.png) |(\\.jpeg) |(\\.gif))$").matcher("method.jpeg").find());
      String imgReference = "pic.jpeg";
       /* System.out.println((imgReference.endsWith(".jpg")|| imgReference.endsWith(".png") || imgReference.endsWith(".jpeg")
        || imgReference.endsWith(".gif")));*/
        for(int a=0;a<10;a=a+1){

        }


    }
}
