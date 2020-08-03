package main.java.sparse;

/**
 * 稀疏数组
 * */
public class SparseMain {

    public static void main(String[] args){
        //创建原始二维数组
        //1代表黑子，2代表蓝子
        int[][] arr1= new int[11][11];
        arr1[0][0] = 1;
        arr1[1][1] =2;
        arr1[2][2] =2;
        //输出原始二维数组
        System.out.println("---------输出原始二维数组------------");
        for(int[] row:arr1){
            for(int num:row){
                System.out.print(num+"\t");
            }
            System.out.println("");
        }

        SparseMain sparseMain = new SparseMain();
        //转换成稀疏数组
        int[][] sparseArray = sparseMain.originalToSparse(arr1);
        //输出稀疏数组
        System.out.println("---------输出稀疏数组------------");
        for(int[] row:sparseArray){
            for(int num:row){
                System.out.print(num+"\t");
            }
            System.out.println("");
        }

        //稀疏数组还原
        int[][] original = sparseMain.sparseToOriginal(sparseArray);
        System.out.println("---------输出还原的二维数组------------");
        for(int[] row:original){
            for(int num:row){
                System.out.print(num+"\t");
            }
            System.out.println("");
        }
    }

    //将原始二维数组转换为稀疏数组
    public int[][] originalToSparse(int[][] originalArray){
        //获取二维数组的行、列
        int rowNum = originalArray.length;
        int collNum = originalArray[0].length;
        //获取不同值的个数
        int sum = 0;
        for(int[] row:originalArray){
            for(int num:row){
                if(num!=0){
                    sum++;
                }
            }
        }
        //创建稀疏数组
        int[][] sparseArray = new int[sum+1][3];
        //初始化第一行
        sparseArray[0][0] = rowNum;
        sparseArray[0][1] = collNum;
        sparseArray[0][2] = sum;
        //将不同的值存入稀疏数组中
        int index=1;
        for(int i=0;i<originalArray.length;i++){
            for(int j=0;j<originalArray[i].length;j++){
                if(originalArray[i][j]!=0){
                    sparseArray[index][0]=i;
                    sparseArray[index][1]=j;
                    sparseArray[index][2]=originalArray[i][j];
                    index++;
                }
            }
        }
        return sparseArray;
    }

    //将稀疏数组转换为原始数组
    public int[][] sparseToOriginal(int[][] sparseArray){
        //获取原始数组的行列长度
        int rowLength = sparseArray[0][0];
        int collLength = sparseArray[0][1];
        //初始化原始数组
        int[][] originalArray = new int[rowLength][collLength];
        //将有效值放入原始数组中
        int rowIndex=0;
        int collIndex=0;
        int value=0;
        for(int i=1;i<sparseArray.length;i++){
//            for(int j=0;j<sparseArray[i].length;j++){
//                if(j==0){
//                    rowIndex=sparseArray[i][j];
//                }
//                if(j==1){
//                    collIndex=sparseArray[i][j];
//                }
//                if(j==2){
//                    value=sparseArray[i][j];
//                }
//            }
            rowIndex = sparseArray[i][0];
            collIndex = sparseArray[i][1];
            value = sparseArray[i][2];
            originalArray[rowIndex][collIndex]=value;
        }

        return  originalArray;
    }
}
