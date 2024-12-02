package lab8;
class LinkedBinaryTree<E> implements BinaryTree<E> {
    protected Node<E> root;
    protected int size;
    public LinkedBinaryTree() {
        this.root = null;
        this.size = 0;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public Node<E> root() {
        return root;
    }
    public Node<E> parent(Node<E> v) {
        return v.getParent();
    }
    public int numChildren(Node<E> v) {
        int count = 0;
        if (v.getLeft() != null) count++;
        if (v.getRight() != null) count++;
        return count;
    }
    public boolean isInternal(Node<E> v) {
        return numChildren(v) > 0;
    }
    public boolean isExternal(Node<E> v) {
        return numChildren(v) == 0;
    }
    public boolean isRoot(Node<E> v) {
        return v == root;
    }
    public Node<E> left(Node<E> v) {
        return v.getLeft();
    }
    public Node<E> right(Node<E> v) {
        return v.getRight();
    }
    public Node<E> sibling(Node<E> v) {
        Node<E> parent = parent(v);
        if (parent == null) return null; // v is root
        if (v == left(parent)) return right(parent);
        else return left(parent);
    }
    public boolean hasLeft(Node<E> v) {
        return v.getLeft() != null;
    }
    public boolean hasRight(Node<E> v) {
        return v.getRight() != null;
    }
    public Node<E> addRoot(E e) {
        if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
        root = new Node<>(e, null, null, null);
        size = 1;
        return root;
    }
    public Node<E> addLeft(Node<E> v, E e) {
        if (v.getLeft() != null) throw new IllegalArgumentException("Node already has a left child");
        Node<E> leftChild = new Node<>(e, v, null, null);
        v.setLeft(leftChild);
        size++;
        return leftChild;
    }
    public Node<E> addRight(Node<E> v, E e) {
        if (v.getRight() != null) throw new IllegalArgumentException("Node already has a right child");
        Node<E> rightChild = new Node<>(e, v, null, null);
        v.setRight(rightChild);
        size++;
        return rightChild;
    }
    public E set(Node<E> v, E e) {
        E temp = v.getElement();
        v.setElement(e);
        return temp;
    }
    public void setRoot(Node<E> node) {
        this.root = node;
    }
    public E remove(Node<E> v) {
        if (numChildren(v) == 2) throw new IllegalArgumentException("Node has two children");
        Node<E> parent = v.getParent();
        Node<E> child = (v.getLeft() != null ? v.getLeft() : v.getRight());
        if (child != null) child.setParent(parent);
        if (v == root) root = child;
        else {
            if (v == left(parent)) parent.setLeft(child);
            else parent.setRight(child);
        }
        size--;
        E temp = v.getElement();
        v.setElement(null); // help garbage collection
        v.setLeft(null);
        v.setRight(null);
        v.setParent(v); // convention for defunct node
        return temp;
    }
    // Helper methods for tree traversal
    public void preOrder(Node<E> root) {
        if (root != null) {
            System.out.print(root.getElement() + " ");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }
    public void postOrder(Node<E> root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getElement() + " ");
        }
    }
    public void inOrder(Node<E> root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getElement() + " ");
            inOrder(root.getRight());
        }
    }
    public Node<E> search(Node<E> root, E key) {
        if (root == null || root.getElement().equals(key)) return root;
        Node<E> leftResult = search(root.getLeft(), key);
        if (leftResult != null) return leftResult;
        return search(root.getRight(), key);
    }
}