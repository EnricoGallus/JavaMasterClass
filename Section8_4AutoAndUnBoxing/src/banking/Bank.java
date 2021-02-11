package banking;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String name) {
        Branch branch = findBranch(name);
        if (branch != null) {
            return false;
        }

        branch = new Branch(name);
        branches.add(branch);
        return true;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            return false;
        }

        return branch.newCustomer(customerName, initialAmount);
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            return false;
        }

        return branch.addCustomerTransaction(customerName, amount);
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            return false;
        }

        System.out.println("Customer details for branch " + branch.getName());
        ArrayList<Customer> customers = branch.getCustomers();
        for (int i = 0, customersSize = customers.size(); i < customersSize; i++) {
            Customer customer = customers.get(i);
            System.out.println("Customer: " + customer.getName() + "[" + (i + 1) + "]");
            if (printTransactions) {
                System.out.println("Transactions");
                for (int j = 0; j < customer.getTransactions().size(); j++) {
                    double transaction = customer.getTransactions().get(j);
                    System.out.println("[" + (j + 1) + "]  Amount " + transaction);
                }
            }
        }

        return true;
    }

    private Branch findBranch(String name) {
        for (Branch branch : branches) {
            if (branch.getName().equals(name)) {
                return branch;
            }
        }

        return null;
    }
}
