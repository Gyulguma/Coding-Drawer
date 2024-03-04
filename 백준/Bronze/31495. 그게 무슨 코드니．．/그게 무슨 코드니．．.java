import java.util.Scanner;

public class Main {

    public static void main(String[] arg){
        String result = "";
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if(!input.startsWith("\"")){
            result = "CE";
        }
        else if(!input.endsWith("\"")){
            result = "CE";
        }
        else{
            result = input.replace("\"","");
        }
        if(result == ""){
            result = "CE";
        }
        System.out.println(result);
    }
}