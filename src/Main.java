import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static char[][] grid;
    static int row =12;
    static int column =10;


    public static void main(String[] args) {

        grid= new char[][]{
                {'B','B','G','B','B','R','R','B','R','B'},
                {'B','R','R','R','G','R','R','R','G','B'},
                {'G','G','G','G','R','G','R','G','G','G'},
                {'G','G','G','B','G','B','B','B','R','G'},
                {'B','B','B','R','G','R','B','R','G','R'},
                {'R','B','B','R','R','B','B','R','G','R'},
                {'R','B','B','R','R','B','B','R','G','R'},
                {'R','G','B','R','B','R','G','B','B','B'},
                {'B','G','R','R','R','R','B','B','R','R'},
                {'R','R','G','B','G','G','B','R','R','G'},
                {'R','B','B','B','B','B','R','B','B','G'},
                {'B','R','B','B','R','B','B','B','R','R'},
                {'B','R','B','B','G','B','B','B','G','R'}};

        findblock(12,10);
    }

    public static void findblock(int row, int column){

        int noOfBlock = 0;

        for (int x = 0; x<row;x++){
            for(int y = 0; y<column ; y++){
                if(grid[x][y]!='X'){
                    char c = grid[x][y];
//                    System.out.println("position: " + x+":"+y + c);
                    int temp = checkneighbour(x,y,0);
                    if(noOfBlock < temp){
                        noOfBlock = temp;
                        System.out.println("Largest Block in Colour : "+ c + " Starting from: Row: "+x
                        +"Column: "+y + " Block Count: " + noOfBlock);
                    }
                }
            }
        }

    }

    public static int checkneighbour(int x, int y,int noOfBlock){
//        System.out.println("checking element x:" +x+" Y: "+y);
        char c = grid[x][y];
        grid[x][y]='X';
//        noOfBlock++;
        //Checking if the next column has the same value
        if(column>(y+1)  && c==grid[x][y+1]){
            noOfBlock = noOfBlock + checkneighbour(x,y+1,noOfBlock);
        }
        //Checking if the next row has the same value
        if(row>(x+1)  && c==grid[x+1][y]){
            noOfBlock = noOfBlock +checkneighbour(x+1,y,noOfBlock);
        }
        //Checking if the previous column has the same value
        if((y-1)>=0  && c==grid[x][y-1]){
            noOfBlock = noOfBlock +checkneighbour(x,y-1,noOfBlock);
        }
        //Checking if the previous column has the same value
        if((x-1)>=0  && c==grid[x-1][y]){
            noOfBlock = noOfBlock +checkneighbour(x-1,y,noOfBlock);
        }
//        System.out.println("Returning no: " +noOfBlock);
        return noOfBlock;
    }
}