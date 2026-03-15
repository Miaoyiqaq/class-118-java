public class HashBuck {
    static class Node {
        public int key;
        public int val;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node[] array;
    public int usedSize;//有效键值对的数量
    public double load_factor = 0.75;//负载因子:触发扩容的阈值
    public HashBuck() {
        array = new Node[10];
    }
    public void put(int key, int val) {
        //哈希函数:将key映射到数组的索引位置
        int index = key % array.length;
        //遍历链表,查找是否已有对应的key
        Node cur = array[index];
        while (cur != null) {
            if(cur.key == key) {
                cur.val = val;
                return;//找到对应key就更新val并退出该方法
            }
            cur = cur.next;
        }
        //运行到此处说明没有对应key,创建该key
        Node newNode = new Node(key,val);
        newNode.next = array[index];
        array[index] = newNode;
        this.usedSize++;
        /***
         * 检查负载因子
         */
        if(doFactor() >= load_factor) {
            grow();
        }
    }

    /***
     * 获取key对应的val
     * @param key 键值
     * @return key对应的val
     */
    public int get(int key) {
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if(cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }

    /***
     * 扩容数组
     */
    private void grow() {
        Node[] newArray = new Node[2* array.length];
        //遍历原数组元素
        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            //重新计算每一个key在新桶中的位置
            while (cur != null) {
                int newIndex = cur.key % newArray.length;
                //放入新的桶中
                Node curNext = cur.next;//备份原cur
                cur.next = newArray[newIndex];
                newArray[newIndex] = cur;
                cur = curNext;
            }
        }
        this.array = newArray;
    }
    private double doFactor() {//查询负载因子
        return usedSize*1.0 / array.length;
    }
}
