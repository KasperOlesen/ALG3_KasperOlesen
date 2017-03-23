/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author Tobias
 */
public class Test {

    public static void main(String[] args) {
        TreeInterface <Integer, String> map = new RedBlackTree<>();
        map.put(0, "Q");
        map.put(1, "A");
        map.put(2, "Z");
        map.put(3, "E");
        map.put(4, "D");
        map.put(5, "C");
        System.out.println("Size: " +map.size());
        System.out.println(map.get(0));
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));
        System.out.println(map.get(4));
        System.out.println(map.get(5));
     
        

       

    }
}
