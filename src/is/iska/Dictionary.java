package is.iska;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class Dictionary {

    private List<String> dict;
    final int len = 5;

    public Dictionary() throws FileNotFoundException {
        dict = new ArrayList<>();
        InputStream is = getClass().getClassLoader().getResourceAsStream("words.txt");
        Scanner sc = new Scanner(is);
        while(sc.hasNext()){
            String tmp = sc.next();
            if(tmp.length() == len){
                dict.add(tmp);
            }
        }
    }

    public String getNextGuess(){
        int r = (int) (Math.random() * dict.size());
        return dict.get(r);
    }

    public int updateAll(Updates updates){
        int totalRemoved = 0;
        totalRemoved += updateMissed(updates.getMissed());
        totalRemoved += updateCorrectNoPositions(updates.getCorrect_no_position());
        totalRemoved += updateCorrectPositions(updates.getCorrect_positions());
        return totalRemoved;
    }

    private int updateCorrectPositions(HashMap<Character, Integer> correct_positions) {
        List<String> toRemove = new ArrayList<>();
        for(String s : dict){
            for(Character c : correct_positions.keySet()){
                if(s.charAt(correct_positions.get(c)) != c){
                    toRemove.add(s);
                }
            }
        }
        dict.removeAll(toRemove);
        return toRemove.size();
    }

    private int updateMissed(String missed){
        List<String> toRemove = new ArrayList<>();
        for(String s : dict){
            for(int i = 0; i < missed.length(); i++){
                if(s.contains(String.valueOf(missed.charAt(i)))){
                    toRemove.add(s);
                }
            }
        }

        dict.removeAll(toRemove);
        return toRemove.size();
    }

    private int updateCorrectNoPositions(String correct_no_positions){
        List<String> toRemove = new ArrayList<>();
        for(String s : dict){
            for(int i = 0; i < correct_no_positions.length(); i++){
                if(!s.contains(String.valueOf(correct_no_positions.charAt(i)))){
                    toRemove.add(s);
                }
            }
        }
        dict.removeAll(toRemove);
        return toRemove.size();
    }
}
