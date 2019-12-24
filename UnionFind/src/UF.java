/**
 * @Author: ck
 * @Date: 2019/12/24 21:09
 */
public interface UF {
    int getSize();
    boolean isConnected(int p,int q);
    void unionElements(int p,int q);
}
