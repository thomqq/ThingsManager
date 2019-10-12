package com.tq.thingsmanager.view.model.purchase;

import java.util.Date;

public class PurchaseView {

    private int purchacseId;
    private String categoryName;
    private Date purchaseDate;
    private Date operationDate;
    private int price;

    public PurchaseView(int purchacseId, String name, Date purchaseDate, Date operationDate, int price) {

        this.purchacseId = purchacseId;
        this.categoryName = name;
        this.purchaseDate = purchaseDate;
        this.operationDate = operationDate;
        this.price = price;
    }

    public int getPurchacseId() {
        return purchacseId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public int getPrice() {
        return price;
    }


}
