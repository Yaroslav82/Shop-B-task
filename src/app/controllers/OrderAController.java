package app.controllers;

import app.base.BaseController;
import app.models.OrderAModel;
import app.utils.Constants;
import app.utils.Rounder;
import app.views.OrderView;

public class OrderAController implements BaseController {

    private OrderAModel model;
    private String[] data;
    private String orderCostRounded;

    @Override
    public void handleData() {

        OrderView view = new OrderView();
        data = view.getData();
        model = new OrderAModel();

        orderCostRounded = Rounder.roundValue(getOrderCost());
        view.getOutput(formOutput());
    }

    private double getOrderCost() {
        return model.getOrderCost(Integer.parseInt(data[1]),
                Double.parseDouble(data[2]));
    }

    private String formOutput() {
        return "\nOrder " + data[0] + " cost is " + Constants.CURRENCY +
                " " + orderCostRounded;
    }
}
