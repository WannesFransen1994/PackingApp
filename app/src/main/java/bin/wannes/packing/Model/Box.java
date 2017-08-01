/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bin.wannes.packing.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wannes Fransen.
 */
public class Box extends VolumeObject {
    private final Map<Coordinate, Column> items;

    public Box(int length, int width, int height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
        this.items = new HashMap<>();
    }

    public Box(Box box) {
        setLength(box.getLength());
        setWidth(box.getWidth());
        setHeight(box.getHeight());
        this.items = box.getItems();
    }

    public Box(Box box, int amount) {
        setLength(box.getLength());
        setWidth(box.getWidth());
        setHeight(box.getHeight());
        int i = amount;
        this.items = new HashMap<>();
        for (Coordinate c : box.getItems().keySet()) {
            if (i > 0) {
                this.items.put(c, box.getItems().get(c));
                i--;
            }
        }
    }

    public Map<Coordinate, Column> getItems() {
        return items;
    }

    public int getAmountOfItems() {
        return items.size();
    }
}
