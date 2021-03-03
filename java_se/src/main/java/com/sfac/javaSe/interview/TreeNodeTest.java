package com.sfac.javaSe.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TreeNodeTest {
	
	public static void main(String[] args) {
		List<TreeNode> oldList = new ArrayList<TreeNode>();
		List<TreeNode> newList = new ArrayList<TreeNode>();
		
		IntStream.range(1, 20).forEach(item -> {
			TreeNode treeNode = new TreeNode();
			treeNode.setId(item);
			treeNode.setName(String.format("%s%s", "node", item));
			if (item % 3 == 0) {
				treeNode.setParentId(item / 3);
			}
			oldList.add(treeNode);
		});
		
		oldList.stream().forEach(System.out :: println);
		System.out.println("===================");
		
		oldList.stream().forEach(item -> {
			boolean rs = addNodeTree(newList, item);
			if (!rs) {
				newList.add(item);
			}
		});
		
		oldList.stream().forEach(System.out :: println);
		
	}
	
	public static boolean addNodeTree(List<TreeNode> newList, TreeNode treeNode) {
		boolean rs = false;
		for (TreeNode item : newList) {
			if (item.getId() == treeNode.getParentId()) {
				item.getChildren().add(treeNode);
				rs = true;
				break;
			}
			
			if (!item.getChildren().isEmpty()) {
				addNodeTree(item.getChildren(), treeNode);
			}
		}
		
		return rs;
	}
}
