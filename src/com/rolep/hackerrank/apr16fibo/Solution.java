package com.rolep.hackerrank.apr16fibo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by rolep on 29/04/16.
 */
public class Solution {

    //consider input is in right format, no exception hadling
    //we cant affect incoming set
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {

            //reading n and m
            String lineOne = reader.readLine();
            String[] argsOne = lineOne.split(" ");
            int n = Integer.parseInt(argsOne[0]);
            int m = Integer.parseInt(argsOne[1]);

            //our main and only tree
            MyTree<Integer> myTree = new MyTree<Integer>(1);

            //map to store values for nodes, which cant be initialised
            //ie specified parent is not yet present
            //will try to add them later
            //mb parent node will appear
            //(in case input values are not ordered)
            //not implemeting this - in current case it is probably useless
            //we can read all p and then sort them ascending
            HashMap<Integer, Integer> unsetNodes = new HashMap<Integer, Integer>();

            //reading p values and adding nodes to the tree
            for (int i = 1; i < n; i++) {
                int p = Integer.parseInt(reader.readLine());
                if (!myTree.addNode(p, i + 1)) {
                    unsetNodes.put(i + 1, p);
                }
            }

            //reading input actions
            for (int i = 0; i < m; i++) {
                String line = reader.readLine();
                String[] symbols = line.split(" ");
                int x = Integer.parseInt(symbols[1]);
                long kOrY = Integer.parseInt(symbols[2]);
                switch (symbols[0]) {
                    case "Q":
                        List<Node<Integer>> path = new ArrayList<Node<Integer>>();
                        if (x == kOrY) {
                            path.add(myTree.getNodeByLabel(x));
                        } else {
                            Node<Integer> one = myTree.getNodeByLabel(x);
                            Node<Integer> two = myTree.getNodeByLabel((int)kOrY);
                            if (one == null || two == null) break;
                            if (one.getPathToSubNode(two, path)) {
                            } else if (two.getPathToSubNode(one, path)) {
                            } else {
                                List<Node<Integer>> pathA = new ArrayList<Node<Integer>>();
                                List<Node<Integer>> pathB = new ArrayList<Node<Integer>>();
                                myTree.walkUpFromTwoNodesTillMet(one, two, path, pathA, pathB);
                                //BigDecimal sum = new BigDecimal(0);
                                //for (Node<Integer> node : path) {
                                //    sum = sum.add(new BigDecimal(node.getFibo()));
                                //}
                                //System.out.println(sum.remainder(new BigDecimal(1000000007)));
                            }
                        }
                        BigDecimal sum = new BigDecimal(0);
                                for (Node<Integer> node : path) {
                                    sum = sum.add(node.getFibo());
                                }
                                System.out.println(sum.remainder(new BigDecimal(1000000007)));


                        break;

                    case "U":
                        myTree.nodeSubTreeFiboAdd(x, kOrY);
                        break;
                }
            }

        }
        catch (IOException e) {}
    }

    public static class MyTree<Integer> {

        private Node<Integer> root;

        //List of all nodes for easy find
        public ArrayList<Node<Integer>> allNodes = new ArrayList<Node<Integer>>();

        public MyTree(Integer rootLabel) {
            root = new Node<Integer>();
            root.label = rootLabel;
            root.children = new ArrayList<Node<Integer>>();
            allNodes.add(root);
        }

        //adding new node by known label of parent node and this node label
        public boolean addNode(Integer parentLabel, Integer label) {
            //first - searching for parent node = the node with provided parentLabel
            Node<Integer> parentNode = getNodeByLabel(parentLabel);
            //if we cant find parent node to add new node to - we say no
            if (parentNode == null) {
                return false;
            }
            //if we found parent node - create new node
            Node<Integer> newNode = new Node();
            newNode.label = label;
            newNode.parent = parentNode;
            //dont forget to add new node to the parent's list of children
            parentNode.children.add(newNode);
            //and add new node to the list of all nodes
            allNodes.add(newNode);
            //we added new node ok
            return true;
        }


        //getting node by label number
        public Node<Integer> getNodeByLabel(Integer label) {
            //first checking if it is root label
            //and then all root children = all other nodes in this tree
            for (Node<Integer> node : allNodes) {
                if (node.label.equals(label)) {
                    return node;
                }
            }
            //if no node matched provided label
            return null;
        }

        //getting root node for adding
        //getting required started fibo number
        //calling recursive addition for target root node
        public void nodeSubTreeFiboAdd(Integer label, long fiboK) {
            Node<Integer> addingRoot = getNodeByLabel(label);
            BigDecimal[] fibos = getFibonachiNumber(fiboK);
            addingRoot.addFibInSubNodesRecursive(fibos);
        }

        public boolean walkUpFromTwoNodesTillMet(Node<Integer> one, Node<Integer> two, List<Node<Integer>> path,
                                                 List<Node<Integer>> pathA, List<Node<Integer>> pathB) {

            if (pathB.contains(one)) {
                path.addAll(pathA);
                path.addAll(pathB.subList(0, pathB.indexOf(one)+1));
                return true;
            }

            if (pathA.contains(two)) {
                path.addAll(pathB);
                path.addAll(pathA.subList(0, pathA.indexOf(two)+1));
                return true;
            }

            if (one.equals(two)) {
                path.addAll(pathA);
                path.addAll(pathB);
                if (!path.contains(one)) {
                    path.add(one);
                }
                return true;
            }

            if (!one.equals(root)) {
                pathA.add(one);
                one = one.parent;
            }

            if (!two.equals(root)) {
                pathB.add(two);
                two = two.parent;
            }

            return walkUpFromTwoNodesTillMet(one,two, path, pathA, pathB);
        }
    }

    //Node - the single node of the tree
    public static class Node<Integer> {
        //label = N = unique label of node
        private Integer label;

        //fibo - field for carrying value, increased by some fibonachi laws
        private BigDecimal fibo = new BigDecimal(0);

        //reference to parent node
        private Node<Integer> parent;

        public BigDecimal getFibo() {
            return fibo;
        }

        //list of child nodes
        private List<Node<Integer>> children = new ArrayList<Node<Integer>>();

        //recursively adding fibo number to all subnodes
        //incrementing it for each child branch
        public void addFibInSubNodesRecursive(BigDecimal[] fibos) {
            this.fibo = this.fibo.add(fibos[1]);
            BigDecimal[] nextFibos = new BigDecimal[] {fibos[1], fibos[0].add(fibos[1])};
            for (Node<Integer> childNode : this.children) {
                childNode.addFibInSubNodesRecursive(nextFibos);
            }
        }

        public boolean getPathToSubNode(Node<Integer> target, List<Node<Integer>> path) {

            if (this.equals(target)) {
                path.add(this);
                return true;
            }
            else if (this.children.isEmpty()) {
                return false;
            }
            else {
                for (Node<Integer> child : children) {
                    if (child.getPathToSubNode(target, path)) {
                        path.add(this);
                        return true;
                    }
                }
            }
            return false;
        }
    }

    //calculating k-th fibonachi number
    //returning k-th and k-1 (previous) fibo number
    //for easy calculating next k+1 fibo number
    //by the users of this function
    //k-th is second, index 1, k-1 is first, index 0
    public static BigDecimal[] getFibonachiNumber(long k) {
        BigDecimal[] fibos = null;
        if (k == 1) {
            fibos = new BigDecimal[] {new BigDecimal(0), new BigDecimal(1)};
        }
        else if (k == 2) {
            fibos = new BigDecimal[] {new BigDecimal(1), new BigDecimal(1)};
        }
        else {
            BigDecimal prev = new BigDecimal(1);
            BigDecimal next;
            BigDecimal kth = new BigDecimal(1);
            for (int i = 2; i < k+1; i++) {
                next = kth.add(prev);
                prev = kth;
                kth = next;
            }
            fibos = new BigDecimal[] {prev, kth};
        }

        return fibos;
    }

}
