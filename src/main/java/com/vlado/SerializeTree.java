package com.vlado;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeTree {

//         2
//        / \
//       7   5
//      / \   \
//     3   6   9
//            /
//           4

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);

        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(4);

//        System.out.println(serialize(root));

//        System.out.println(serialize(deserialize(serialize(deserialize("2,7,5,3,6,null,9,4,null")))));
//        System.out.println(serialize(deserialize(serialize(deserialize("null")))));
        System.out.println(serialize(deserialize(serialize(deserialize("3,2,4,1")))));
    }

    public static String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                sb.append("null,");
                continue;
            }
            sb.append(poll.value);
            sb.append(",");

            if (poll.left == null && poll.right == null) {
                continue;
            }

            queue.add(poll.left);
            queue.add(poll.right);
        }

        String commaless = sb.substring(0, sb.length() - 1);

        if (commaless.endsWith(",null")) {
            commaless = commaless.substring(0, commaless.lastIndexOf(",null"));
        }

        return commaless;
    }

    public static TreeNode deserialize(String input) {
        String[] segments = input.split(",");
        TreeNode root = null;
        TreeNode currentNode = null;
        TreeNode tempNode = null;
        for (int i = 0; i < segments.length; i++) {
            String segment = segments[i];
            Integer val = segment.equals("null") ? null : Integer.parseInt(segment);
            if (i == 0) {
                if (val == null) {
                    break;
                }
                currentNode = new TreeNode(val);
                root = currentNode;
                continue;
            }
            if (i % 2 == 0) {
                //right
                if (val == null) {
                    currentNode.right = null;
                } else {
                    currentNode.right = new TreeNode(val);
                }

                if (val == null) {
                    currentNode = tempNode;
                } else {
                    currentNode = currentNode.right;
                }
            } else {
                //left
                if (val == null) {
                    currentNode.left = null;
                } else {
                    currentNode.left = new TreeNode(val);
                }
                tempNode = currentNode.left;
            }
        }
        return root;
    }


    public static class TreeNode {
        private Integer value;

        public TreeNode(Integer value) {
            this.value = value;
        }

        public TreeNode left;
        public TreeNode right;
    }

}
