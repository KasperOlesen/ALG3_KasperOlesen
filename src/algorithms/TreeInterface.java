
package algorithms;

/**
 *
 * @author kAlex
 */
public interface TreeInterface <Key, Value> {
    Value get(Key key);
    void put(Key key, Value value);
    int size();        
}
