import java.util.ArrayList;
import java.util.List;

public class Main{
    public bintree left;
    public bintree right;
    public bintree root;
//    数据域
    private Object data;
    //    存节点
    public List<bintree> datas;

    public void bintree(bintree left, bintree right, Object data){
        this.left=left;
        this.right=right;
        this.data=data;
    }
//    将初始的左右孩子值为空
    public void bintree(Object data){
        this(null,null,data);
    }

    public void bintree() {

    }

    public void creat(Object[] objs){
        datas=new ArrayList<bintree>();
        //        将一个数组的值依次转换为Node节点
        for(Object o:objs){
            datas.add(new bintree(o));
        }
//        第一个数为根节点
        root=datas.get(0);
//        建立二叉树
        for (int i = 0; i <objs.length/2; i++) {
//            左孩子
            datas.get(i).left=datas.get(i*2+1);
//            右孩子
            if(i*2+2<datas.size()){//避免偶数的时候 下标越界
                datas.get(i).right=datas.get(i*2+2);
            }
        }
        public static void main(String[] args) {
			        bintree bintree=new bintree();
			        Object []a={2,4,5,7,1,6,12,32,51,22};
			        bintree.creat(a);
			        bintree.preorder(bintree.root);
	    }
    }

}