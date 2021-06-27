/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinariabusca;

/**
 *
 * @author gabri
 */
public class teste {
    public static void main(String[] args) {
        Tree one = new Tree(new Item(10));
      
        one.insert(new Item(5));
        one.insert(new Item(1));
        one.insert(new Item(8));
        one.insert(new Item(15));
        one.insert(new Item(12));
        one.insert(new Item(18));
        
        
        one.printPreOrder();
        System.out.println(" ");
        one.printInOrder();
        System.out.println(" ");
        one.printPostOrder();
    }
    
}
