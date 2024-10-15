package com.test.module.domain;

import lombok.Data;

import java.util.List;

@Data
public class TreeNode {
    private String name;
    private List<ListNode> nodeList;
    private List<TreeNode> children;
}
