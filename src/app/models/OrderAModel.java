package app.models;

import app.base.BaseModel;

public class OrderAModel implements BaseModel {

    public double getOrderCost(int quota, ) {
        return quota * price;
    }
}
