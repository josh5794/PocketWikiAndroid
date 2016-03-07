package com.pocketwiki.pocketwiki;

/**
 * Created by chinmay on 14/1/16.
 */
public class CityCategoryListItemDTO {

    private String itemName;
    private int entityCount;

    public CityCategoryListItemDTO(String itemName, int entityCount) {
        this.entityCount = entityCount;
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getEntityCount() {
        return entityCount;
    }

    public void setEntityCount(int entityCount) {
        this.entityCount = entityCount;
    }
}
