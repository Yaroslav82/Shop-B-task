package app.controllers;

import app.base.BaseController;
import app.models.OrderBModel;
import app.utils.Constants;
import app.utils.Rounder;
import app.views.OrderView;

public class OrderBController implements BaseController {

    private OrderBModel model;
    private String[] data;
    private String orderCostRounded;
    private String deliveryCostRounded;

    @Override
    public void handleData() {

        OrderView view = new OrderView();
        data = view.getData();
        model = new OrderBModel();

        double orderCost = getOrderCost();
        orderCostRounded = Rounder.roundValue(orderCost);

        double deliveryCost = getDeliveryCost();
        deliveryCostRounded = Rounder.roundValue(deliveryCost);

        view.getOutput(formOutput());
    }

    private double getOrderCost() {
        return model.getOrderCost(Integer.parseInt(data[1]),
                Double.parseDouble(data[2]));
    }

    private double getDeliveryCost() {
        return model.getDeliveryCost(Integer.parseInt(data[1]),
                Double.parseDouble(data[2]));
    }

    private String formOutput() {
        return "\nOrder " + data[0] + " cost is " +  +
                " " + orderCost + "\nDelivery cost is " + Constants.CURRENCY +
                " " + deliveryCostRounded;
    }
}
