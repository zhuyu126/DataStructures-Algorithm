/**
 * 第二版Union-Find,使用一个数组构建一棵指向父节点的树
 */
public class QuickUnion implements UF {
    private int[] parent;
    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return false;
    }

    @Override
    public void unionElements(int p, int q) {

    }
}
