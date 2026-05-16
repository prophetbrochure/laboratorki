package Laba9_SearchTrees.Laba9_2;

public class AvlTreeWrapper<T extends Comparable<T>> {
    private final String skullEmoji = " \uD83D\uDC80\uD83D\uDC80\uD83D\uDC80";
    private AvlNode<T> root;

    public void insert(T target) {
        System.out.print("[INSERT] ");
        if (target == null) {
            System.out.println("Попытка вставить null в дерево" + skullEmoji);
            return;
        }
        if (this.root == null) {
            this.root = new AvlNode<>(target);
        }
            root.insert(target);

        System.out.println("Добавлен объект: " + target);
    }

    public void has(T target) {
        System.out.print("[HAS] ");
        if (target == null) {
            System.out.println("Попытка найти null в дереве" + skullEmoji);
            return;
        }
        boolean result;
        if (root == null) {
            result = false;
        } else {
            result = root.has(target);
        }
        System.out.println(result ? ("Объект " + target + " есть в дереве") : ("Объекта " + target + " нет в дереве"));
    }

    public void delete(T target) {
        System.out.print("[DELETE] ");
        if (target == null) {
            System.out.println("Попытка удалить null из дерева" + skullEmoji);
            return;
        }
        if (root == null || !root.has(target)) {
            System.out.println("Нечего удалять, объекта " + target + " нет в дереве");
        } else {
            root = root.delete(target);
            System.out.println("Объект " + target + " удалён из дерева");
        }
    }

    public void next(T target) {
        System.out.print("[NEXT] ");
        if (target == null) {
            System.out.println("Попытка найти следующий объект для null" + skullEmoji);
            return;
        }
        if (root == null) {
            System.out.println("Попытка найти следующий объект в пустом дереве");
            return;
        }
        AvlNode<T> result = root.next(target);
        if (result == null) {
            System.out.println("В дереве нет объектов, больше заданного");
        } else {
            System.out.println("Следующий объект для объекта " + target + ": " + result.value);
        }
    }

    public void prev(T target) {
        System.out.print("[PREV] ");
        if (target == null) {
            System.out.println("Попытка найти предыдущий объект для null" + skullEmoji);
            return;
        }
        if (root == null) {
            System.out.println("Попытка найти предыдущий объект в пустом дереве");
            return;
        }
        AvlNode<T> result = root.prev(target);
        if (result == null) {
            System.out.println("В дереве нет объектов, меньше заданного");
        } else {
            System.out.println("Следующий объект для объекта " + target + ": " + result.value);
        }
    }


}
