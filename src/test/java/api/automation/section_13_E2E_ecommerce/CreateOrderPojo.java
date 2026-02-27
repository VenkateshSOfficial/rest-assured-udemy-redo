package api.automation.section_13_E2E_ecommerce;

import java.util.List;

public class CreateOrderPojo {
    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    private List<Orders> orders;
}
