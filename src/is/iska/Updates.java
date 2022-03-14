package is.iska;


import java.util.HashMap;

public class Updates {

    private String missed;
    private String correct_no_position;
    private HashMap<Character, Integer> correct_positions;


    public Updates(){
    }

     public void setMissed(String s){
        missed = s;
     }

     public void setCorrect_no_position(String s){
        correct_no_position = s;
     }

     public void setCorrect_positions(String letters, String positions){
        if(letters.length() != positions.length()){
            throw new IllegalArgumentException("The number of letters and positions are not correct!");
        }
        correct_positions = new HashMap<>();
        for(int i = 0 ; i < letters.length(); i++){
            correct_positions.put(letters.charAt(i), Integer.parseInt(String.valueOf(positions.charAt(i))));
        }
     }

     public String getMissed(){
        return missed;
     }

     public String getCorrect_no_position(){
        return correct_no_position;
     }

     public HashMap<Character, Integer> getCorrect_positions(){
        return correct_positions;
     }

}
