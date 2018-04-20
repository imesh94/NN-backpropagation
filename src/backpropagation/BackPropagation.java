/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backpropagation;

import static java.lang.Math.abs;
import java.util.Arrays;

/**
 *
 * @author cst140031
 */
public class BackPropagation {

    public static void main(String[] args) {
        NuralNet nn = new NuralNet();
        double o1, o2, o3;
        int t1, t2, t3;
        double err;
        int errRate=0;
        
        boolean train=true;
        int iter=0;
        
        while(train==true){ 
            iter++;
            train=false;
            
            System.out.println("\nIteration No:"+iter+"\n");
            System.out.println("Expected Output   | Actual Output   | Error");
            
            for(int j=0; j<16; j++){
                
                t1=nn.trainData[j][0];
                t2=nn.trainData[j][1];
                t3=nn.trainData[j][2];
                
                o1=nn.n1.getOutput(nn.inputs[j][0], nn.inputs[j][1], nn.inputs[j][2], nn.inputs[j][3]);
                o2=nn.n2.getOutput(nn.inputs[j][0], nn.inputs[j][1], nn.inputs[j][2], nn.inputs[j][3]);
                o3=nn.n3.getOutput(nn.inputs[j][0], nn.inputs[j][1], nn.inputs[j][2], nn.inputs[j][3]);
                
                
                err=abs((t1+t2+t3)-(o1+o2+o3));
                
                System.out.println(Arrays.toString(nn.trainData[j])+":         "+o1+","+o2+","+o3 +"      "+err);
                

                nn.n1.train(t1);
                nn.n2.train(t2);
                nn.n3.train(t3);
                
                
                
                if (err>0.18){
                    train=true;
                }
                
                //System.out.println(err);
            }
            
            System.out.println("-------------------------------------------------------------");
        }
        
        System.out.println("\nFinal Result (rounded off)\n");
        for(int j=0; j<16; j++){
            o1=Math.round(nn.n1.getOutput(nn.inputs[j][0], nn.inputs[j][1], nn.inputs[j][2], nn.inputs[j][3]));
            o2=Math.round(nn.n2.getOutput(nn.inputs[j][0], nn.inputs[j][1], nn.inputs[j][2], nn.inputs[j][3]));
            o3=Math.round(nn.n3.getOutput(nn.inputs[j][0], nn.inputs[j][1], nn.inputs[j][2], nn.inputs[j][3]));
            
            if(o1!=nn.trainData[j][0] || o2!=nn.trainData[j][1] || o3!=nn.trainData[j][2]){
                errRate++;
            }
            
            System.out.println(Arrays.toString(nn.trainData[j])+": "+Math.round(o1)+","+Math.round(o2)+","+Math.round(o3));
        }
        
        System.out.println("\nNo. of iterations: "+iter);
        System.out.println((nn.inputs.length-errRate) +" out of "+nn.inputs.length+" matches");
    
    }
}
