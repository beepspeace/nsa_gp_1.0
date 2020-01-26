import java.util.Scanner;
import java.util.Vector;
//Dont write this kind of shit.
//randi ko chak
//Design a class Bank that has a vector of bankAccounts and a set of methods to
//manipulate those accounts.
//createAccount(), removeAccount(), showAccount()
//lisrt all accounts
//find an account, modifyAccount() (can modify everything except the account number)
public class test {
    //BankAccount Vector
    Vector<HBankAccount>nbank = new Vector<HBankAccount>(100,1);
    //scanner
    Scanner key;
///test new 
    //Constructor
    public  Bank () {
        nbank = new Vector<HBankAccount>();
    }

    // Method to create new bank acccount
    public void createAccount(Scanner nkey)    {
        // create new object of HBankAccount
        HBankAccount cAccount= new HBankAccount(nkey);
        nbank.addElement(cAccount);

    }
    //method to remove account
    public void removeAccount(int accountNumber){
        if(nbank.size()>=1) {
            for(int i=0; i<nbank.size(); i++) {
                if(nbank.elementAt(i).getAccountNum()== accountNumber){
                    nbank.removeElementAt(i);
                    System.out.println("The account " +accountNumber+" has removed");
                    break; }
                System.out.print("\nThe Account Number "+accountNumber+ " doesnot Exist." );
            }}else{
            System.out.print("\nThe Account Number "+accountNumber+ " doesnot Exist." );
        }

    }

    //Method to show details of account
    public void showAccount(int accountNumber) {
        if(nbank.size()>=1) {
            for (int i=0; i<nbank.size(); i++) {
                if (nbank.elementAt(i).getAccountNum() == accountNumber) {
                    System.out.print(nbank.elementAt(i).toString());
                    for(int j=0;j<nbank.elementAt(i).newHolder.size();j++){
                        System.out.print("\n\nSecondary Holders\n"+nbank.elementAt(i).newHolder.elementAt(j).toString());
                    }
                    break;

                }
//                System.out.print("\nThe Account Number " + accountNumber + " doesnot Exist.");
//                break;
            }
        }else{
            System.out.print("\nThe Account Number " + accountNumber + " doesnot Exist.");
        }

    }
    public void modifyAccount(int accountNumber) {
        //find method to check account
        if(nbank.size()>=1) {
            System.out.println("\n1. Add Owner \n2. Remove Owner\n3. Update Account Information\n ");
            int numberModefyAccount;
            System.out.print("Enter a Choice:");
            key =new Scanner(System.in);
            numberModefyAccount = key.nextInt();
            //addOwner in Account
            if (numberModefyAccount == 1) {
                for (int i=0; i<nbank.size(); i++) {
                    if (nbank.elementAt(i).getAccountNum() == accountNumber) {
                        {
                            nbank.elementAt(i).addHolder();

                        }
                    }

                }
                System.out.print("\nThe Account Number " + accountNumber + " doesnot Exist.");
            }
            //removeOwner from account
            else if (numberModefyAccount == 2) {
                for (int i=0; i<nbank.size(); i++) {
                    if (nbank.elementAt(i).getAccountNum() == accountNumber) {
                        System.out.print("\nEnter a Social Security Number: ");
                        key = new Scanner(System.in);
                        int ssn = key.nextInt();
                        for (int j = 0; j < nbank.elementAt(i).newHolder.size(); j++) {
                            if (ssn == nbank.elementAt(i).newHolder.elementAt(j).getSSN()) {
                                nbank.elementAt(i).newHolder.remove(j);
                                System.out.println("Account Holder has removed");
                                break;
                            }
                        } break; } else {System.out.println("\nThe Holder doesnot Exist");}
                }//Modify Details of Primary Account Holder
            } else if (numberModefyAccount == 3) {
                for (int i=0; i<nbank.size(); i++) {
                    if (nbank.elementAt(i).getAccountNum() == accountNumber) {
                        key =new Scanner(System.in);
                        System.out.println("Enter New Updates on Account");
                        System.out.print("First Name: \t");
                        nbank.elementAt(i).setFirstName(key.nextLine());
                        System.out.print("Last Name: \t");
                        nbank.elementAt(i).setLastName(key.nextLine());
                        System.out.print("Date of Birth (mm/dd/yyy or yyyy-mm-dd):\t");
                        nbank.elementAt(i).setDate(key.nextLine());
                        System.out.print("SSN : \t");
                        nbank.elementAt(i).setSSN(Integer.parseInt(key.nextLine()));
                        System.out.print("Address : \t");
                        nbank.elementAt(i).setnAddress(key.nextLine());
                        System.out.print("Balance : \t");
                        nbank.elementAt(i).setBalance(Double.parseDouble(key.nextLine()));
                        break;
                    }
                }
            }
        }
        else { System.out.print("\nThe Account Number " + accountNumber + " doesnot Exist."); }
    }
    //list of All Account numbers
    public  void listAccount()
    {
        for (int i=0;i<nbank.size();i++)
        {
            System.out.println("Account Number\t "+nbank.elementAt(i).getAccountNum());
        }
    }
    //Deposit amount
    public void depositAmount(int accountNumber) {
        if(nbank.size()>=1) {
            for (int i = 0; i < nbank.size(); i++) {
                if (nbank.elementAt(i).getAccountNum() == accountNumber) {
                    key = new Scanner(System.in);
                    System.out.print("Enter Deposit Amount:");
                    double Amount = key.nextDouble();
                    nbank.elementAt(i).deposit(Amount);
                    break;
                }
            }
        }
        else{
            System.out.print("\nThe Account Number " + accountNumber + " doesnot Exist."); }
    }
    //Withdraw amount
    public void withdrawAmount(int accountNumber) {
        if(nbank.size()>=1) {
            for (int i = 0; i < nbank.size(); i++) {
                if (nbank.elementAt(i).getAccountNum() == accountNumber) {
                    key = new Scanner(System.in);
                    System.out.print("Enter Withdraw Amount:");
                    double Amount = key.nextDouble();
                    nbank.elementAt(i).withdraw(Amount);
                    break;
                }
            }
        }
        else{
            System.out.print("\nThe Account Number " + accountNumber + " doesnot Exist."); }
    }
    //showInterest Amount method
    public void showInterestAmount(int accountNumber) {
        if(nbank.size()>=1) {
            for (int i = 0; i < nbank.size(); i++) {
                if (nbank.elementAt(i).getAccountNum() == accountNumber) {
                    key = new Scanner(System.in);
                    System.out.print("\nThe Interest Amount: $ "+ nbank.elementAt(i).payInterest());
                    System.out.print("\nThe Balance Amount: $ "+ (nbank.elementAt(i).payInterest()+nbank.elementAt(i).getBalance()));
                    break;
                }
            }
        }
        else{
            System.out.print("\nThe Account Number " + accountNumber + " doesnot Exist."); }
    }
}
