import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

class Account {
    String ac;
    String name;
    int balance = 100;

    public void credit(int money) {
        balance += money;
    }

    public void debit(int money) {
        if (money > balance) {
            System.out.println("INSUFFICIENT BALANCE");
        } else {
            balance -= money;
        }

    }

    public void view() {
        System.out.println(balance);
    }
    ArrayList<Transaction>tc=new ArrayList<>();
   
}
class Transaction{
    String type;
    int amount;
}

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Account> ac = new ArrayList<>();
        
        Account a = new Account();
        int i = 0;
        int k = 0;
        do {

            System.out.println("ENTER THE NAME");
            String name = sc.next();
            System.out.println("ENTER ACCOUNT NUMBER");
            a.ac = sc.next();
            a.name = name;
            ac.add(a);
            int j = 1;
            do {

                System.out.println("1.FOR CREDIT");
                System.out.println("2.FOR DEBIT");
                System.out.println("3.FOR CHECKBALAKCE");
                System.out.println("4.MINISTATEMENT");
                System.out.println("5.EIXT");
                int choice = sc.nextInt();
                

                switch (choice) {
                    case 1: {
                    }
                        System.out.println("ENTER MONEY TO CREDIT");
                        int money = sc.nextInt();
                        ac.get(k).credit(money);
                        ac.get(k).view();
                        Transaction t=new Transaction();
                        t.type="CREDITED";
                        t.amount=money;
                        ac.get(k).tc.add(t);
                        break;
                    case 2:
                        System.out.println("ENTER MONEY TO DEBIT");
                        int money1 = sc.nextInt();
                        ac.get(k).debit(money1);
                        ac.get(k).view();
                         Transaction t2=new Transaction();
                        t2.type="DEBITED";
                        t2.amount=money1;
                        ac.get(k).tc.add(t2);
                        break;
                    case 3:

                        ac.get(k).view();
                        break;
                    case 4:

                        int n=ac.get(k).tc.size();
                        if(n==0)
                        {
                            System.out.println("NO RECENT TRASACTIONS FOUND");
                        }
                        else{

                            for(int m=0;m<n;m++)
                            {
                                System.out.println(ac.get(k).tc.get(m).type +"  RUPEES "+ac.get(k).tc.get(m).amount);
                            }
                        }
                        break;
                    default:
                        j=0;
                        break;
                }

            } while (j == 1);
            System.out.println("PRESS 1 TO ADD MORE");
            i = sc.nextInt();
            k++;
        } while (i == 1);

    }
}
