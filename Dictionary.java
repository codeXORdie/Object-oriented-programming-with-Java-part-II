
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Victoria (Nur) Acar
 */
public class Dictionary {

    private Map<String, String> map;

    public Dictionary() {
        map = new HashMap<String, String>();
    }

    public String translate(String word) {
        if (map.containsKey(word)) {
            return map.get(word);
        }
        return null;
    }

    public void add(String word, String translation) {
        map.put(word, translation);
    }

    public int amountOfWords() {
        int count = 0;
        for (String key : map.keySet()) {
            count++;
        }
        return count;
    }

    public ArrayList<String> translationList() {
        ArrayList<String> translation = new ArrayList<String>();
        for (String key : map.keySet()) {
            translation.add(key + " = " + map.get(key));
        }
        return translation;
    }

}
