
package algorithms;

import java.util.Comparator;

/**
 *
 * @author kAlex
 */
public class RedBlackTree<Key, Value> implements TreeInterface<Key, Value> {

    private RedBlackBST<Key, Value> tree;
    
    public RedBlackTree() {
        tree = new RedBlackBST(Comparator.naturalOrder());
    }

    @Override
    public Value get(Key k) {
        return tree.get(k);
    }

    @Override
    public void put(Key key, Value value) {
        tree.insert(key, value);
    }

    @Override
    public int size() {
        return tree.getSize();
    }   
} 