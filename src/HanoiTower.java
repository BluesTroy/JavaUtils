/**
 * Created by Troy on 2016/9/21.
 */
public class HanoiTower {
    /**
     *
     * @param start  初始塔
     * @param mid   借用塔
     * @param end   目标塔
     * @param n     盘子数
     */
    public static void hanoi(String start,String mid,String end, int n){
        //只有一个盘子时直接将初塔上的盘子移动到目标塔
        if(n==1){
            System.out.println(start+"->"+end);
        }else {
            hanoi(start,end,mid,n-1);//将初始塔的n-1个盘子借助目的塔移动到借用塔
            System.out.println(start+"->"+end);//将剩下最大的盘移动到目标塔
            hanoi(mid, start, end, n-1);//将借用塔上的n-1个盘子借用初始塔移动到目标塔
        }
    }
    public static void main(String[] args){
        hanoi("A","B","C",4);
    }
}
