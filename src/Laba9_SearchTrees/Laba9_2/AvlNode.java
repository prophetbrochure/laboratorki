package Laba9_SearchTrees.Laba9_2;

public class AvlNode<T extends Comparable<T>> {
    public T value;
    public AvlNode<T> leftSon;
    public AvlNode<T> rightSon;

    public int height;
    /**
     * Фактор балансировки.<br>
     * Если >0, то ЛЕВОЕ поддерево больше
     * Если <0, то ПРАВОЕ  поддерево больше
     */
    public int balanceFactor;


    public AvlNode(T value) {
        this.value = value;
    }


    /**
     * @return Новый корень поддерева
     * <pre>
     * Если
     * </pre>
     */
    public AvlNode<T> insert(T target) {
        int comparisonResult = target.compareTo(this.value);
        if (comparisonResult == 0) {    // Ничего не вставляется, балансировка не нужна.
            return this;
        }
        if (comparisonResult > 0) {                             // Добавляемое значение больше значения этого узла
            if (this.rightSon == null) {
                this.rightSon = new AvlNode<>(target);
            } else {
                this.rightSon = this.rightSon.insert(target);
            }
        } else {                                                // Добавляемое значение меньше значения этого узла
            if (this.leftSon == null) {
                this.leftSon = new AvlNode<>(target);
            } else {
                this.leftSon = this.leftSon.insert(target);
            }
        }
        return balance();
    }

    public AvlNode<T> delete(T target) {
        int cmp = target.compareTo(this.value);

        if (cmp < 0) {
            if (leftSon != null) {
                leftSon = leftSon.delete(target);
            }
        } else if (cmp > 0) {
            if (rightSon != null) {
                rightSon = rightSon.delete(target);
            }
        } else {
            // нашли узел

            // 0 детей
            if (leftSon == null && rightSon == null) {
                return null;
            }

            // 1 ребенок (левый или правый)
            if (leftSon == null) return rightSon;
            if (rightSon == null) return leftSon;

            // 2 ребенка
            AvlNode<T> successor = rightSon;
            while (successor.leftSon != null) {
                successor = successor.leftSon;
            }

            this.value = successor.value;
            rightSon = rightSon.delete(successor.value);
        }

        return balance();
    }


    //              ВЫСОТА, БАЛАНСИРОВКА, ПОВОРОТЫ...

    /**
     *
     * @return Новый, сбалансированный корень
     */
    public AvlNode<T> balance() {
        update(); // сначала обновляем высоту и баланс

        // левый перекос
        if (balanceFactor > 1) {
            if (leftSon != null && leftSon.balanceFactor < 0) {
                // LR случай
                leftSon = leftSon.rotateLeft();
            }
            return rotateRight();
        }

        // правый перекос
        if (balanceFactor < -1) {
            if (rightSon != null && rightSon.balanceFactor > 0) {
                // RL случай
                rightSon = rightSon.rotateRight();
            }
            return rotateLeft();
        }

        return this;
    }


    public void update() {
        int leftSonHeight = this.leftSon == null ? 0 : this.leftSon.height;
        int rightSonHeight = this.rightSon == null ? 0 : this.rightSon.height;
        balanceFactor = leftSonHeight - rightSonHeight;
        height = Math.max(leftSonHeight, rightSonHeight) + 1;
    }


    /**
     * <p><h2>Малое левое вращение.</h1></p>
     *
     * <pre>
     *   10                 20
     *  /  \              /    \
     * A   20     -->    10     30
     *     / \          / \    /  \
     *    C  30        A   C  E    G
     *      /  \
     *     E    G
     * </pre>
     *
     * @return новый корень поддерева
     */
    private AvlNode<T> rotateLeft() {
        AvlNode<T> newRoot = this.rightSon;
        if (newRoot == null) return this; // защита от NPE

        AvlNode<T> movedSubtree = newRoot.leftSon;

        newRoot.leftSon = this;
        this.rightSon = movedSubtree;

        this.update();
        newRoot.update();

        return newRoot;
    }

    /**
     * <p><h2>Малое правое вращение.</h1></p>
     *
     * <pre>
     *       30                20
     *      /  \             /    \
     *    20    G   -->     10     30
     *   /  \              / \    /  \
     *  10   E            A   C  E    G
     * /  \
     * A    C
     * </pre>
     *
     * @return новый корень поддерева
     */
    private AvlNode<T> rotateRight() {
        AvlNode<T> newRoot = this.leftSon;
        if (newRoot == null) return this; // защита от NPE

        AvlNode<T> movedSubtree = newRoot.rightSon;

        newRoot.rightSon = this;
        this.leftSon = movedSubtree;

        this.update();
        newRoot.update();

        return newRoot;
    }


    //              ПОИСК ЗНАЧЕНИЙ
    public boolean has(T target) {
        if (this.value.equals(target)) {
            return true;
        }
        if (target.compareTo(this.value) > 0) {     // Искомое значение больше значения этого узла
            if (this.rightSon == null) {
                return false;
            }
            return this.rightSon.has(target);
        } else {
            if (this.leftSon == null) {             // Искомое значение меньше значения этого узла
                return false;
            }
            return this.leftSon.has(target);
        }
    }

    public AvlNode<T> next(T target) {
        AvlNode<T> result = null;
        AvlNode<T> node = this;

        while (node != null) {
            if (node.value.compareTo(target) > 0) {
                result = node;
                node = node.leftSon;
            } else {
                node = node.rightSon;
            }
        }
        return result;
    }

    public AvlNode<T> prev(T target) {
        AvlNode<T> result = null;
        AvlNode<T> node = this;

        while (node != null) {
            if (node.value.compareTo(target) < 0) {
                result = node;
                node = node.rightSon;
            } else {
                node = node.leftSon;
            }
        }
        return result;
    }
}
