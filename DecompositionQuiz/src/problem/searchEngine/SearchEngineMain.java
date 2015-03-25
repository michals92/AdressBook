package problem.searchEngine;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class implements simple search engine.
 *
 * @author Petr Adamek
 */
class SearchEngine {

    Map<String,Set<String>> strings = new HashMap<String, Set<String>>();
    
    private static <K,V> Set<V> getSetFromMap(Map<K,Set<V>> map, K key) {
        Set<V> result  = map.get(key);
        if (result == null) {
            result = new HashSet<V>();
            map.put(key, result);
        }
        return result;
    }

    public void addText(String text) {
        String[] keywords = text.toLowerCase().split("\\s+"); // \s = any white charactes
        for (String keyword : keywords) {
            getSetFromMap(strings, keyword).add(text);
        }
    }

    private Set<String> getTextSet(String keyword) {
        Set<String> result  = strings.get(keyword);
        if (result == null) {
            return Collections.emptySet();
        } else {
            return result;
        }
    }

    public Set<String> search(String query) {
        String[] keywords = query.toLowerCase().split("\\s+"); // \s = any white charactes
        if (keywords.length <= 0) {
            return Collections.emptySet();
        }
        Set<String> result = new HashSet<String>(strings.get(keywords[0]));
        // Pokud dotaz obsahuje vice slov, aplikuje se operator AND
        for (int i = 1; i < keywords.length; i++) {
            result.retainAll(getTextSet(keywords[i]));
        }
        return result;
    }
}

/**
 * This class extends SearchEngine with ability to log all queries.
 *
 * @author Petr Adamek
 */
class LoggingSearchEngine extends SearchEngine {

    @Override
    public Set<String> search(String query) {
        System.err.println(query);
        return super.search(query);
    }
    
}

public class SearchEngineMain {
    public static void main(String[] args) {
        SearchEngine searchEngine = new LoggingSearchEngine();
        searchEngine.addText("Prvni veta");
        searchEngine.addText("Druha veta");
        searchEngine.addText("Prvni   blbost  ");
        System.out.println(searchEngine.search("Prvni"));
        System.out.println(searchEngine.search("veta"));
        System.out.println(searchEngine.search("veta   druha"));
    }
}