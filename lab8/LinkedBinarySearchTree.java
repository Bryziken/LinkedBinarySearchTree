package lab8;
public class LinkedBinarySearchTree<E extends Comparable<E>> extends LinkedBinaryTree<E> {
    // Insert a new node with the given element
	public Node<E> insert(E element) {
        if (isEmpty()) {
            return addRoot(element);
        } else {
            return insertHelper(root(), element);
        }
    }
    // Helper method for insertion
	private Node<E> insertHelper(Node<E> node, E element) {
        if (element.compareTo(node.getElement()) < 0) {
            if (hasLeft(node)) {
                return insertHelper(left(node), element);
            } else {
                return addLeft(node, element);
            }
        } else if (element.compareTo(node.getElement()) > 0) {
            if (hasRight(node)) {
                return insertHelper(right(node), element);
            } else {
                return addRight(node, element);
            }
        }
        return node; // Duplicate element, do nothing
    }
    // Delete the node containing the given element
	public Node<E> delete(E element) {
        Node<E> node = search(root(), element);
        if (node != null) {
            return deleteNode(node);
        }
        return null; // Element not found
    }
    // Helper method for node deletion
	private Node<E> deleteNode(Node<E> node) {
        if (numChildren(node) == 2) {
            throw new IllegalArgumentException("Node has two children");
        }
        Node<E> parent = parent(node);
        Node<E> child = (node.getLeft() != null) ? node.getLeft() : node.getRight();
        if (child != null) {
            child.setParent(parent);
        }
        if (node == root()) {
            setRoot(child);
        } else {
            if (node == left(parent)) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }
        node.setParent(null);
        node.setLeft(null);
        node.setRight(null);
        size--;
        return node;
    }
    // Find and return the minimum node in the tree
	public Node<E> minNode() {
        return findMin(root());
    }
    // Helper method to find the minimum node
	private Node<E> findMin(Node<E> node) {
        if (node == null) {
            return null;
        }
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }
    // Override search method to return Node instead of boolean
    @Override
    public Node<E> search(Node<E> root, E key) {
        if (root == null || root.getElement().equals(key)) {
            return root;
        }
        int cmp = key.compareTo(root.getElement());
        if (cmp < 0) {
            return search(root.getLeft(), key);
        } else {
            return search(root.getRight(), key);
        }
    }
    // Override remove method to return Node instead of element
    @SuppressWarnings("unchecked")
	@Override
    public E remove(Node<E> v) {
        return ((Node<E>) super.remove(v)).getElement();
    }
}