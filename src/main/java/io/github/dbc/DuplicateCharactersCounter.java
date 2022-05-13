package io.github.dbc;

import java.util.Map;

public class DuplicateCharactersCounter {
    /**
     * Counts the number of duplicate characters in a string.
     *
     * @param string String to count duplicate characters.
     * @return Map with characters and their count.
     */
    public Map<Character, Integer> countDuplicateCharacters(String string) {
        Map<Character,Integer> map = new HashMap<>();
        var len = string.length();
        for(var i = 0;i<len;i++)
        {
            var key = string.charAt(i);
            if(map.containsKey(key))
            {
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }
        }
        return map;
    }
}
