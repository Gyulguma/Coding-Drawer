import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<String, Integer> type = new HashMap<String, Integer>();
        type.put("R", 0);
        type.put("T", 0);
        type.put("C", 0);
        type.put("F", 0);
        type.put("J", 0);
        type.put("M", 0);
        type.put("A", 0);
        type.put("N", 0);
        
        for(int i=0; i<survey.length; i++){
            String[] result = check(survey[i], choices[i]);
            type.put(result[0], type.get(result[0])+Integer.parseInt(result[1]));
        }
        
        String answer = printResult(type);
        return answer;
    }
    
    private String[] check(String survey, int choice){
        String[] result = new String[2];
        String type =  "";
        int score = 0;
        switch(choice){
            case 1: 
                score = 3;
                type = survey.charAt(0)+"";
                break;
            case 2:
                score = 2;
                type = survey.charAt(0)+"";
                break;
            case 3:
                score = 1;
                type = survey.charAt(0)+"";
                break;
            case 5: 
                score = 1;
                type = survey.charAt(1)+"";
                break;
            case 6:
                score = 2;
                type = survey.charAt(1)+"";
                break;
            case 7:
                score = 3;
                type = survey.charAt(1)+"";
                break;
            default:
                score = 0;
                type = survey.charAt(1)+"";
                break;
        }
        result[0] = type;
        result[1] = score+"";
        return result;
    }
    
    private String printResult(HashMap<String, Integer> type){
        String result = "";
        if(type.get("R") >= type.get("T")) result += "R";
        else if(type.get("R") < type.get("T")) result += "T";
        
        if(type.get("C") >= type.get("F")) result += "C";
        else if(type.get("C") < type.get("F")) result += "F";
        
        if(type.get("J") >= type.get("M")) result += "J";
        else if(type.get("J") < type.get("M")) result += "M";
        
        if(type.get("A") >= type.get("N")) result += "A";
        else if(type.get("A") < type.get("N")) result += "N";
        
        return result;
    }
}