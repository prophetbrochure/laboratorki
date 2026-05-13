package Laba9_SearchTrees.Laba9_1;

public class BstNode2<T extends Comparable<T>> {
    public T value;
    public BstNode2<T> leftSon;
    public BstNode2<T> rightSon;

    public BstNode2(T value) {
        this.value = value;
    }

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

    /**
     * @return вставилось ли число в дерево
     */
    public boolean insert(T target) {
        int comparisonResult = target.compareTo(this.value);
        if (comparisonResult == 0) {
            return false;
        }
        if (comparisonResult > 0) {                             // Добавляемое значение больше значения этого узла
            if (this.rightSon == null) {
                this.rightSon = new BstNode2<>(target);
            } else {
                return this.rightSon.insert(target);
            }
        } else {                                                // Добавляемое значение меньше значения этого узла
            if (this.leftSon == null) {
                this.leftSon = new BstNode2<>(target);
            } else {
                return this.leftSon.insert(target);
            }
        }
        return true;
    }

    public BstNode2<T> delete(T target) {
        int comparisonResult = target.compareTo(this.value);
        if (comparisonResult > 0) {                             // Удаляемое значение больше значения этого узла
            if (this.rightSon == null) {
                return this;
            }
            this.rightSon = this.rightSon.delete(target);
            return this;
        } else if (comparisonResult < 0) {                      // Удаляемое значение меньше значения этого узла
            if (this.leftSon == null) {
                return this;
            }
            this.leftSon = this.leftSon.delete(target);
            return this;
        } else {                                                    // Нужно удалить текущий узел
            if (this.leftSon == null && this.rightSon == null) {    // Нет детей
                return null;
            } else if (this.rightSon == null ^ this.leftSon == null) { // Есть только 1 ребенок
                return this.leftSon != null ? this.leftSon : this.rightSon;
            } else {                                                   // Есть оба ребенка
                BstNode2<T> tempNode = this.rightSon;
                while (tempNode.leftSon != null) {
                    tempNode = tempNode.leftSon;
                }
                this.value = tempNode.value;
                this.rightSon = this.rightSon.delete(this.value);
                return this;
            }
        }
    }

    public BstNode2<T> next(T target) {
        BstNode2<T> result = null;
        BstNode2<T> node = this;

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

    public BstNode2<T> prev(T target) {
        BstNode2<T> result = null;
        BstNode2<T> node = this;

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
