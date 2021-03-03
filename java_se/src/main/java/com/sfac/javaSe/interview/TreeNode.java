package com.sfac.javaSe.interview;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	private int id;
	private String name;
	private int parentId;
	private List<TreeNode> children = new ArrayList<TreeNode>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return this.getId() + "--" + this.getName() + "--" + this.getParentId();
	}

}
