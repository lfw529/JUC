import org.openjdk.jol.info.ClassLayout;

public class ClassLayoutExample {
    public static void main(String[] args) {
        ClassLayoutExample example = new ClassLayoutExample();
        //使用 JOL 工具打印对象的内存布局
        System.out.println(ClassLayout.parseInstance(example).toPrintable());
    }
}
