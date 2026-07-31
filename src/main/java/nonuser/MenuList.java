package nonuser;

import java.util.ArrayList;

public class MenuList {

    private final int menuListId;
    private final int productionOrderId;

    public MenuList(int menuListId, int productionOrderId) {
        this.menuListId = menuListId;
        this.productionOrderId = productionOrderId;
    }

    public int getMenuListId() {
        return menuListId;
    }

    public int getProductionOrderId() {
        return productionOrderId;
    }

    @Override
    public String toString() {
        return "MenuList{" +
                "menuListId=" + menuListId +
                ", productionOrderId=" + productionOrderId +
                '}';
    }
}
