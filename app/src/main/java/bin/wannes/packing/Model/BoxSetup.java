package bin.wannes.packing.Model;

import java.util.Map;

/**
 * Created by wannes on 1/08/2017.
 */

public class BoxSetup {
    Map<Box, Integer> boxAmount;

    public BoxSetup() {
    }

    public Map<Box, Integer> getBoxAmount() {

        return boxAmount;
    }

    public void setBoxAmount(Map<Box, Integer> boxAmount) {
        this.boxAmount = boxAmount;
    }
}
