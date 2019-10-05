package com.tq.thingsmanager.view.model.tile;

import java.io.Serializable;

public class CategoryViewModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long purchaceCategotyId;
    private String name;

    public CategoryViewModel(Long purchaceCategotyId, String name) {
        this.purchaceCategotyId = purchaceCategotyId;
        this.name = name;
    }

    public Long getPurchaceCategotyId() {
        return purchaceCategotyId;
    }

    public String getName() {
        return name;
    }
}
