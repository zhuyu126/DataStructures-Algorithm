/**
 * 第五版Union-Find基于第四版Union-Find通过路径压缩实现优化
 */
public class UnionFindByPath implements UF {
    // parent[i]表示第i个元素所指向的父节点
    private int[] parent;
    // rank[i]表示以i为根的集合所表示的树的层数
    // 在后续的代码中, 我们并不会维护rank的语意, 也就是rank的值在路径压缩的过程中, 有可能不在是树的层数值
    // 这也是我们的rank不叫height或者depth的原因, 他只是作为比较的一个标准
    private int[] rank;
    public UnionFindByPath(int size) {
        parent=new int[size];
        rank=new int[size];
        //初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
        for (int i=0;i<size;i++){
            parent[i]=i;
            rank[i]=1;
        }
    }
    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查看元素p和元素q是否所属一个集合 O(h)复杂度, h为树的高度
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }

    /**
     * 查找过程, 查找元素p所对应的集合编号 O(h)复杂度, h为树的高度
     * @param p
     * @return
     */
    private int find(int p){
        if(p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        //不断去查询自己的父亲节点, 直到到达根节点 根节点的特点: parent[p] == p
        while (p!=parent[p]){
            //实现路径压缩
            parent[p]=parent[parent[p]];
            p=parent[p];
        }
        return p;
    }

    /**
     * 合并元素p和元素q所属的集合 O(h)复杂度, h为树的高度
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot=find(p);
        int qRoot=find(q);
        if (pRoot==qRoot){
            return;
        }
        // 根据两个元素所在树的rank不同判断合并方向
        // 将rank低的集合合并到rank高的集合上
        if(rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if(rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else{ // rank[pRoot] == rank[qRoot]
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;   // 此时, 我维护rank的值
        }
    }
}
