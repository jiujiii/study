package com.data_structure.leetcode.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TreeNodeTest {

    com.data_structure.leetcode.tree.TreeNode tree = null;

    @Before
    public void init() {
        final int[] ints = { 1, 2, 3, 4, 5, 6, 7 };
        tree = com.data_structure.leetcode.tree.TreeNode.createTree(ints);
    }

    @Test
    public void testCreateTree() {
        assert tree != null;
        Assert.assertEquals(new Integer(4),tree.val);
    }

    @Test
    public void testLog() {
        Assert.assertEquals("4 2 1 3 6 5 7 ",tree.log());
    }

    @Test
    public void maxDepth() {
        Assert.assertEquals(3,tree.maxDepth());;
    }
}