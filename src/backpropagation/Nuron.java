/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backpropagation;

/**
 *
 * @author cst140031
 */
public class Nuron {
    private int i1, i2, i3, i4;
    private double w1, w2, w3, w4;
    private double output;

    
    public Nuron(double w1, double w2, double w3, double w4){
        this.w1=w1;
        this.w2=w2;
        this.w3=w3;
        this.w4=w4;
    }
    
    
    public double getOutput(int i1, int i2, int i3, int i4){
        //setting the inputs
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
        this.i4 = i4;
        
        double x = i1*w1 + i2*w2 + i3*w3 + i4*w4 - 0.43; //-0.43 is the bias value
        output = 1/(1 + Math.exp(-x));
        output=Math.round(output * 100.0) / 100.0; //to reduce to 2 decimal places
        return output;
    }
    

    public void train(int t){ //t -> training value
        double o=output;
        double learnRate=0.2; //epsilon
        
        double dw1=learnRate*(t-o)*(1-o)*o*i1;
        double dw2=learnRate*(t-o)*(1-o)*o*i2;
        double dw3=learnRate*(t-o)*(1-o)*o*i3;
        double dw4=learnRate*(t-o)*(1-o)*o*i4;
        
        //System.out.println(dw);
        w1 = w1+dw1;
        w2 = w2+dw2;
        w3 = w3+dw3;
        w4 = w4+dw4;
    }
}
