package arvorebinariabusca;

public class Tree {

    private Item record;
    private Tree left, right;

    //construtores
    public Tree() {
        this.record = null;
        this.left = null;
        this.right = null;
    }

    public Tree(Item record) {
        this.record = record;
        this.left = null;
        this.right = null;
        //   System.out.println("Criei a arvore Inseri o elemento " + record.getValor());
    }

    public Item getRecord() {
        return record;
    }

    public void setRecord(Item record) {
        this.record = record;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    //
    public boolean Empty() {
        return (this.record == null);
    }

    public void insert(Item record) {
        if (Empty()) {
            this.record = record;
        } else {
            Tree newTree = new Tree(record);
            if (record.getValue() < this.record.getValue()) {//inserir na decendencia esquerda
                if (this.left == null) {
                    this.left = newTree;
                    //  System.out.println("Inseri" + record.getValor()+ "a esquerda"+ this.record.getValor());
                } else {
                    this.left.insert(record);// recursao
                }

            } else if (record.getValue() > this.record.getValue()) {
                if (this.right == null) {
                    this.right = newTree;
                    //   System.out.println("Inseri" + record.getValor()+ "a esquerda"+ this.record.getValor());
                } else {
                    this.right.insert(record);//recursao
                }
            }

        }
    }

    public boolean search(int value) {
        if (Empty()) {
            return false;
        }
        if (this.record.getValue() == value) {
            return true;
        } else {
            if (value < this.record.getValue()) {
                if (this.left == null) {
                    return false;
                } else {
                    return this.left.search(value);//repassei a resp para subarvore esquerda
                }
            } else if (value > this.record.getValue()) {
                if (this.right == null) {
                    return false;
                } else {
                    return this.right.search(value);//repassei a resp para subarvore direita
                }
            }
        }
        return false;
    }

    public void printPreOrder() {
        if (!Empty()) {
            System.out.print(this.record.getValue() + " ");
            if (this.left != null) {
                this.left.printPreOrder();
            }
            if (this.right != null) {
                this.right.printPreOrder();
            }
        }
    }

    public void printInOrder() {
        if (this.left != null) {
            this.left.printInOrder();
        }
        System.out.print(this.record.getValue() + " " );
        if (this.right != null) {
            this.right.printInOrder();
        }

    }
    public void printPostOrder(){
        if(!Empty()){
            if(this.right != null){
                this.right.printPostOrder();
            }
            if(this.left!= null){
                this.left.printPostOrder();
            }
            System.out.print(this.record.getValue() + " ");
            
        }
        
    }

}
    
    
    
    
    
    
    