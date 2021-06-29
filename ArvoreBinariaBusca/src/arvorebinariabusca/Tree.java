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
    public Tree remove(Item record) {
        // primeiro caso - achei o elemento
        if (this.record.getValue() == record.getValue()) {
            // caso mais simples - o elemento está em um nó folha
            if (this.right == null && this.left == null) {
                return null;
            } else {
                // caso 2 - eu tenho filhos à esquerda, porém não tenho à direita
                if (this.left != null && this.right == null) {
                    return this.left;
                } // caso 3 - eu tenho filhos à direita, porém não tenho à esquerda
                else if (this.right != null && this.left == null) {
                    return this.right;
                } // caso 4 - tenho filhos dos dois lados (esquerda e direita)
                else {
                    // vamos adotar a estratégia do maior dentre os menores?
                    Tree aux = this.left;
                    while (aux.right != null) { // enquanto houver filhos à direita
                        aux = aux.right;
                    }
                    // troco os elementos da árvore
                    this.record = aux.getRecord();  // o nó atual recebe o elemento do aux
                    // o maior dentre os menores
                    aux.setRecord(record);         // insiro no nó folha (lá embaixão) o elmento a ser eliminado
                    this.left = left.remove(record);
                }
            }
        } else if (record.getValue() < this.record.getValue()) {
            // delegar a responsabilidade à sub-arvore da esquerda
            this.left = this.left.remove(record);
        } else if (record.getValue() > this.record.getValue()) {
            // delegar a responsabilidade à sub-arvore da direita
            this.right = this.right.remove(record);
        }
        return this;
    }

}
    
    
    
    
    
    