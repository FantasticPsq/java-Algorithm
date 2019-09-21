package recursionDemo;

public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        //用1表示地图中的墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i]=1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6]=1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        MiGong miGong = new MiGong();
        miGong.setWay(map,1,1);
        miGong.showMap(map);
    }

    //map[i][j]=1表示墙，map[i][j]=2表示已经走过。map[i][j]=3表示路已走过但是此路不通。
    public static boolean setWay(int[][] Map, int i, int j) {
        if(Map[6][5]==2){
            return true;
        }
        if (Map[i][j] == 0) {
            Map[i][j]=2;
            if (setWay(Map, i + 1, j)) {
                return true;
            } else if (setWay(Map, i, j + 1))
                return true;
            else if (setWay(Map, i - 1, j)) return true;
            else if (setWay(Map, i, j - 1)) return true;
            else {
                Map[i][j] = 3;
                return false;
            }

        } else {//Map[i][j]==1,2,3都不行。
            return false;
        }
    }
    public void showMap(int[][] map){
        for(int i=0;i<8;i++){
            for(int j=0;j<7;j++)
                System.out.print(map[i][j]+" ");
            System.out.println();
        }
    }
}
