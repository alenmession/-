import java.util.ArrayList;
import java.util.List;

public class Main{
    public bintree left;
    public bintree right;
    public bintree root;
//    ������
    private Object data;
    //    ��ڵ�
    public List<bintree> datas;

    public void bintree(bintree left, bintree right, Object data){
        this.left=left;
        this.right=right;
        this.data=data;
    }
//    ����ʼ�����Һ���ֵΪ��
    public void bintree(Object data){
        this(null,null,data);
    }

    public void bintree() {

    }

    public void creat(Object[] objs){
        datas=new ArrayList<bintree>();
        //        ��һ�������ֵ����ת��ΪNode�ڵ�
        for(Object o:objs){
            datas.add(new bintree(o));
        }
//        ��һ����Ϊ���ڵ�
        root=datas.get(0);
//        ����������
        for (int i = 0; i <objs.length/2; i++) {
//            ����
            datas.get(i).left=datas.get(i*2+1);
//            �Һ���
            if(i*2+2<datas.size()){//����ż����ʱ�� �±�Խ��
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