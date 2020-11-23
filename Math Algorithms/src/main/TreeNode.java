package main;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
    private final List<TreeNode<T>> children = new ArrayList<>();
    private final T data;

    public TreeNode(T data){
        this.data = data;
    }

    public List<TreeNode<T>> getChildren(){
        return children;
    }

    public T getData() {
        return data;
    }

    public void addChild(TreeNode<T> children){
        this.children.add(children);
    }

    public int getHeight(TreeNode<T> node) {
        if(node == null) {
            return 0;
        }

        int height = 0;

        for(TreeNode<T> child : node.getChildren()) {
            height = Math.max(height, getHeight(child));
        }

        return height + 1;
    }
}