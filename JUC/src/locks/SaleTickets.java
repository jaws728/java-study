package locks;

public class SaleTickets {
    public static void main(String[] args) {
        Tickets tickets = new Tickets();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                tickets.sale();
            }
            }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                tickets.sale();
            }
            }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                tickets.sale();
            }
            }, "C").start();
    }
}

/*
 * 资源类OOP
 * @author  pkcrazy
 * @date  2022/7/2 08:20
 * @param
 * @return
 */
class Tickets{
    private int number = 20;

    // synchronized本质：队列、锁
    public synchronized void sale() {
        if (number > 0){
            System.out.println(Thread.currentThread().getName() + " 剩余：" + (--number));
        }
    }
}
