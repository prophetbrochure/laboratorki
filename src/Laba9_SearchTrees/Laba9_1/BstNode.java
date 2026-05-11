package Laba9_SearchTrees.Laba9_1;

public class BstNode {
    public int value;
    public BstNode leftSon, rightSon;


    BstNode(int value) {
        this.value = value;
    }

    public void insert(int x) {
        if (x < this.value) {
            if (this.leftSon == null) {
                this.leftSon = new BstNode(x);
            } else {
                this.leftSon.insert(x);
            }
        } else if (x > this.value) {
            if (this.rightSon == null) {
                this.rightSon = new BstNode(x);
            } else {
                this.rightSon.insert(x);
            }
        }
        return; // дублирующие значения не добавляются в дерево
    }

    public boolean has(int target) {
        if (this.value == target) {
            return true;
        } else if (target > this.value) {
            if (this.rightSon == null) {
                return false;
            }
            return this.rightSon.has(target);
        } else {
            if (this.leftSon == null) {
                return false;
            }
            return this.leftSon.has(target);
        }
    }

    public void delete(int target) {
        if (!this.has(target)) {
            return;
        }
        recursiveDelete(target, null);
    }

    public void recursiveDelete(int target, BstNode parent) {
        if (this.value == target) {
            if (parent == null) {
                System.out.println("Ошибка: попытка удалить корень дерева");
                return;
            }
            boolean isLeftSon = (this == parent.leftSon);
            if (this.leftSon == null && this.rightSon == null) {  // Нет детей
                if (isLeftSon) {
                    parent.leftSon = null;
                } else {
                    parent.rightSon = null;
                }
            } else if (this.leftSon != null && this.rightSon == null) {  // Есть только левый
                if (isLeftSon) {
                    parent.leftSon = this.leftSon;
                } else {
                    parent.rightSon = this.leftSon;
                }
            } else if (this.leftSon == null && this.rightSon != null) { //Есть только правый
                if (isLeftSon) {
                    parent.leftSon = this.rightSon;
                } else {
                    parent.rightSon = this.rightSon;
                }
            } else {// 2 ребёнка
                this.value = removeMin(this.rightSon);
            }

        } else if (target > this.value) {
            this.rightSon.recursiveDelete(target, this);
        } else {
            this.leftSon.recursiveDelete(target, this);
        }
    }

    private int removeMin(BstNode startNode) {
        BstNode parent = null;
        BstNode currentNode = startNode.leftSon;

        while (currentNode.leftSon != null) {
            parent = currentNode;
            currentNode = currentNode.leftSon;
        }
        if (parent != null) {
            parent.leftSon = currentNode.rightSon;
        }

        return currentNode.value;
    }
}
