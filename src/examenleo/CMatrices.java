/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenleo;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author sergiososa
 */
public class CMatrices {
    public CMatrices(){
        
    }
    
    public int[][] generateArrays(int pFila,int pColumnas){
        int[][] randomArray = new int[pFila][pColumnas];
        Random random = new Random();
        for (int i = 0;i<randomArray.length;i++){
            for(int j=0;j<randomArray[i].length;j++){
                randomArray[i][j] = random.nextInt(101);
            }
        }
        return randomArray;
    } 
    
    public String formatString(int[][] pArray){
        String arrayString = String.format("");
        for (int i = 0;i<pArray.length;i++){
            arrayString += Arrays.toString(pArray[i]) +"\n\n";   
        }
        return arrayString;
    }
}
