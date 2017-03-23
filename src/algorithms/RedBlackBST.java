package algorithms;

import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tobias
 */
public class RedBlackBST<K, V> {

    private RedBlackNode<K, V> root;
    private Comparator<K> comp;

    private int size = 0;

    public RedBlackBST(Comparator<K> comp) {
        this.root = null;
        this.comp = comp;
    }

    public int getSize() {
        return size;
    }

    public void insert(K data, V value) {
        if (data == null) {
            throw new NullPointerException("Data should not be null");
        }
        this.root = insert(data, value, root);
        this.root.setIsRed(false);
    }

    public V get(K key) {
        RedBlackNode<K, V> x = root;
        while (x != null) {
            int c = comp.compare(key, x.getData());
            if (c < 0) {
                x = x.getLeft();
            } else if (c > 0) {
                x = x.getRight();
            } else {
                return x.getValue();
            }
        }
        return null;
    }

    private RedBlackNode<K, V> insert(K data, V value, RedBlackNode<K, V> h) {
        if (h == null) {
            size++;
            return new RedBlackNode<>(data, value);
        }
        int c = comp.compare(data, h.getData());
        if (c < 0) {
            h.setLeft(insert(data, value, h.getLeft()));
        } else if (c > 0) {
            h.setRight(insert(data, value, h.getRight()));
        } else {
            h.setData(data);
            h.setValue(value);
            size++;
        }

        if (isRed(h.getRight()) && !isRed(h.getLeft())) {
            h = rotateLeft(h);
        }

        if (isRed(h.getLeft()) && isRed(h.getLeft().getLeft())) {
            h = rotateRight(h);
        }

        if (isRed(h.getLeft()) && isRed(h.getRight())) {
            flipColors(h);
        }
        return h;
    }

    private boolean isRed(RedBlackNode<K, V> node) {
        if (node == null) {
            return false;
        }
        return node.isRed();
    }

    private RedBlackNode<K, V> rotateLeft(RedBlackNode<K, V> h) {
        RedBlackNode<K, V> tmp = h.getRight();
        h.setRight(tmp.getLeft());
        tmp.setLeft(h);
        tmp.setIsRed(h.isRed());
        h.setIsRed(true);
        return tmp;
    }

    private RedBlackNode<K, V> rotateRight(RedBlackNode<K, V> h) {
        RedBlackNode<K, V> tmp = h.getLeft();
        h.setLeft(tmp.getRight());
        tmp.setRight(h);
        tmp.setIsRed(h.isRed());
        h.setIsRed(true);
        return tmp;
    }

    private void flipColors(RedBlackNode<K, V> h) {
        h.getLeft().setIsRed(false);
        h.getRight().setIsRed(false);
        h.setIsRed(true);
    }
}
