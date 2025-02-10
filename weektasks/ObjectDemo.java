package weektasks;

public class ObjectDemo {
	public static void main(String[] args) {
        User user1 = new User("Alice", 30);
        User user2 = new User("Alice", 30);
        SecondUser secondUser1 = new SecondUser("Alice", 30);

        System.out.println("User1: " + user1);
        System.out.println("User2: " + user2);
        System.out.println("SecondUser1: " + secondUser1);


        System.out.println("");
	}
}
