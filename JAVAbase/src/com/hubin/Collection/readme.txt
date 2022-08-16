Collection 接口的接口 对象的集合（单列集合）
        ├——-List 接口：元素按进入先后有序保存，可重复
        │—————-├ LinkedList 接口实现类， 链表， 插入删除， 没有同步， 线程不安全
        │—————-├ ArrayList 接口实现类， 数组， 随机访问， 没有同步， 线程不安全
        │—————-└ Vector 接口实现类 数组， 同步， 线程安全
        │ ———————-└ Stack 是Vector类的实现类
        └——-Set 接口： 仅接收一次，不可重复，并做内部排序
        ├—————-└HashSet 使用hash表（数组）存储元素
        │————————└ LinkedHashSet 链表维护元素的插入次序
        └ —————-TreeSet 底层实现为二叉树，元素排好序
        ————————————————
        版权声明：本文为CSDN博主「feiyanaffection」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
        原文链接：https://blog.csdn.net/feiyanaffection/article/details/81394745