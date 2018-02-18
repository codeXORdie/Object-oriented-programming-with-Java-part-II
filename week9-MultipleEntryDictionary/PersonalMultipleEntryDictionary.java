
package dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Victoria (Nur) Acar
 */
public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary{
    
    private Map<String, Set<String>> map;
    
    public PersonalMultipleEntryDictionary() {
        map = new HashMap<String, Set<String>>();
    }

    @Override
    public void add(String word, String entry) {
        if(!map.containsKey(word)){
            map.put(word, new HashSet<String>());
        }
        map.get(word).add(entry);
    }

    @Override
    public Set<String> translate(String word) {
        if(map.containsKey(word)) {
            return map.get(word);
        }
        return null;
    }

    @Override
    public void remove(String word) {
        if(map.containsKey(word)) {
            map.remove(word);
        }
    }
       
    
}
