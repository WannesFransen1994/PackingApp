package bin.wannes.packing.Fragments;

import bin.wannes.packing.Model.Box;

/**
 * Created by wannes on 10-8-2017.
 */

public class WrapperObjectBox{
    Box box;
    int amount;

    public WrapperObjectBox(Box box, int amount) {
        this.box = box;
        this.amount = amount;
    }

    public Box getBox() {
        return box;
    }

    public int getAmount() {
        return amount;
    }
}