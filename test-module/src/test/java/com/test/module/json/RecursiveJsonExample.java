
package com.test.module.json;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.test.common.io.FileUtils;
import com.test.module.domain.TreeNode;

import java.util.List;

public class RecursiveJsonExample {
    public static void main(String[] args) throws Exception {

        String jsonString = FileUtils.fileToString("1.txt");


        // 将 JSON 字符串解析为自定义类 TreeNode
        // List<TreeNode> root = JSON.parseArray(jsonString, TreeNode.class);

        JSONArray jsonArray = JSONUtil.parseArray(jsonString);
        List<TreeNode> root = jsonArray.toList(TreeNode.class);

        // 输出解析结果
        for (TreeNode treeNode : root) {
            System.out.println(treeNode);
        }
        // System.out.println(root);
    }
}
