package com.boss.cuncis.jadwalsholatretrofit.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ItemResponse {

	@SerializedName("items")
	private List<Item> items;

	public void setItems(List<Item> items){
		this.items = items;
	}

	public List<Item> getItems(){
		return items;
	}
}