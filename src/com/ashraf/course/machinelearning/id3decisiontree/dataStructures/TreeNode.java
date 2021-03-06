/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ashraf.course.machinelearning.id3decisiontree.dataStructures;

import com.ashraf.course.machinelearning.id3decisiontree.utilities.Defs;
import com.ashraf.course.machinelearning.id3decisiontree.utilities.Defs.Category;
import java.util.ArrayList;
import java.util.List;

/**
 * TreeNode class is used to create the decision tree. Each TreeNode type object
 * represents a node in the decision tree. TreeNode can keep track of the
 * decision tree structure, decision, feature value, and class in the decision
 * tree.
 *
 * @author Ashraf
 * @since version 1.0.0
 */
public class TreeNode {

    // Flag to represent wheather or not it is a leaf node of the tree
    private Boolean leafNode;

    // Child list of current node
    private List<TreeNode> children;

    // Assigned class for this tree node
    private Category category;

    // Breaking attribute for thi node
    private Integer breakingPos;

    // Nitrogen base feature for this node
    private Defs.NitrogenBase nBase;

    public TreeNode() {
        this.leafNode = Boolean.FALSE;
        this.children = new ArrayList<TreeNode>();
        this.category = Category.UNKNOWN;
        this.breakingPos = Integer.MIN_VALUE;
        this.nBase = Defs.NitrogenBase.UNKNOWN;
    }

    /**
     * @return the leafNode
     */
    public Boolean isLeafNode() {
        return leafNode;
    }

    /**
     * @param leafNode the leafNode to set
     */
    public void setLeafNode(Boolean leafNode) {
        this.leafNode = leafNode;
    }

    /**
     * @return the children
     */
    public List<TreeNode> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return the breakingPos
     */
    public Integer getBreakingPos() {
        return breakingPos;
    }

    /**
     * @param breakingPos the breakingPos to set
     */
    public void setBreakingPos(Integer breakingPos) {
        this.breakingPos = breakingPos;
    }

    /**
     * @return the nBase
     */
    public Defs.NitrogenBase getnBase() {
        return nBase;
    }

    /**
     * @param nBase the nBase to set
     */
    public void setnBase(Defs.NitrogenBase nBase) {
        this.nBase = nBase;
    }
}
