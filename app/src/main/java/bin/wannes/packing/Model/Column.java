/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bin.wannes.packing.Model;

/**
 * Created by Wannes Fransen.
 */
public class Column extends VolumeObject {
    final double SAFETY_MARGIN= 1.05;
    public Column(int length, int width, int height, int pockets) {
        setLength((length));
        setWidth((width));
        setHeight((height));
    }

    public int calculateHeight(int height, int pockets){
        double temp = ((height*0.05) + ((pockets +1)*0.6))*2 + 5;
        return (int)Math.ceil(temp*SAFETY_MARGIN);
    }

    public int calculateLength(int length){
        double temp = length*1.10;
        return (int)Math.ceil(temp*SAFETY_MARGIN);
    }

    public int calculateWidth(int width){
        double temp = width*1.15;
        return (int)Math.ceil(temp*SAFETY_MARGIN);
    }
}
