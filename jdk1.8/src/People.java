abstract class People {
    public abstract void eat();

}
 class Demo {
    public static void main(String[] args) {
        People p = new People() {
            public void eat() {
                System.out.println("I can eat ");
            }
        };
        p.eat();
    }
}