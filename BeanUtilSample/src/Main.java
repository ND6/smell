import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        beanCopy2Test();
    }

    public static void beanCopy2Test() {
        ClazzA a =new  ClazzA();
        a.setName("a");
        a.setLevel("INFO");
        ClazzB b = new ClazzB();
        BeanUtil.copyProperties(b, a, CopyOptions.create());

        System.out.println(b.getName());
        System.out.println(b.getLevel());
    }
}