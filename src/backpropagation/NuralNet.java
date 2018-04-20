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
public class NuralNet {
    Nuron n1=new Nuron(0.3, 0.2, 0.4, 0.4);
    Nuron n2=new Nuron(0.2, 0.5, 0.1, 0.5);
    Nuron n3=new Nuron(0.5, 0.3, 0.5, 0.1);
    
    int[][] inputs = new int[][]{
        {0,0,0,0},
        {0,0,1,1},
        {0,0,1,0},
        {0,1,0,1},
        {0,1,0,0},
        {0,1,1,1},
        {0,1,1,0},
        {1,0,0,1},
        {1,0,0,0},
        {1,0,1,1},
        {1,0,1,0},
        {1,1,0,1},
        {1,1,0,0},
        {0,0,0,1},
        {1,1,1,0},
        {1,1,1,1}
    };
    
    int[][] trainData = new int[][]{
        {1,0,0},
        {0,1,1},
        {0,1,0},
        {1,0,1},
        {1,0,0},
        {1,1,1},
        {1,1,0},
        {0,0,1},
        {0,0,0},
        {0,1,1},
        {0,1,0},
        {1,0,1},
        {1,0,0},
        {1,1,1},
        {1,1,0},
        {1,1,1}
    };
}
