class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = process(new_id);
        new_id = new_id.replaceAll("\\.+", ".");
        if(new_id.startsWith(".")) new_id = new_id.substring(1);
        if(new_id.endsWith(".")) new_id = new_id.substring(0, new_id.length()-1);
        if(new_id.isEmpty()) new_id = "a";
        if(new_id.length() >= 16) new_id = new_id.substring(0, 15);
        if(new_id.endsWith(".")) new_id = new_id.substring(0, new_id.length()-1);
        while(new_id.length() <= 2) new_id = new_id + (new_id.charAt(new_id.length()-1)+""); 
        return new_id;
    }
    
    private String process(String new_id) {
        StringBuilder sb = new StringBuilder();
        for(char c : new_id.toCharArray()) {
            if((c>='a' && c<='z') || (c>='0' && c<='9') || c=='-'
              || c=='_' || c=='.')
                sb.append(c+"");   
        }
        return sb.toString().trim();
    }
}