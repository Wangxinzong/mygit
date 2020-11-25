package main.java.digui;

/**
 * 迷宫回溯问题
 * */
public class MiGong {

    public static void main(String[] args){
        //制作迷宫地图
        int[][] map = new int[8][7];
      //设置墙体，用1表示
        for(int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        for(int i=0;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }
        map[3][1] =1;
        map[3][2] = 1;

        System.out.println("-----打印地图------");
        printMap(map);

        //执行
        walk(map,1,1);
        System.out.println("-----打印执行过后的地图------");
        printMap(map);
    }

    //打印地图
    public static void printMap(int[][] map){
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println("");
        }
    }

    /**
     * map:地图
     * i&j: 从哪个位置开始
     * */
    public static boolean walk(int[][]map, int i,int j){
        if(map[1][2]==2){
            return  true;
        }
        else if(map[i][j]==0){
            map[i][j] = 2;
            //约定走路方式，右——》下——》左——》上
            if(walk(map,i,j+1)){
                return true;
            }
            else if(walk(map,i+1,j)){
                return  true;
            }
            else if(walk(map,i,j-1)){
                return true;
            }
            else if(walk(map,i+1,j)){
                return true;
            }
            else {
                map[i][j] =3;
                return false;
            }
        }
        else {
            return false;
        }
    }
}
