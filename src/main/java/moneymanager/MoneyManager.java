package moneymanager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoneyManager {
    JPanel mainPanel;
    JList<Transaction> transactionsList;
    JTextField sumField;
    JButton spendMoneyButton;
    JComboBox selectCategoryComboBox;

    MoneyManager() {
        final DefaultListModel<Transaction> listModel = new DefaultListModel<>();
        transactionsList.setModel(listModel);

        spendMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Transaction t = new Transaction();
                t.category = selectCategoryComboBox.getSelectedItem().toString();
                t.sum = Double.valueOf(sumField.getText());
                listModel.addElement(t);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Домашняя бухгалтерия");
        frame.setContentPane(new MoneyManager().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    static class Transaction {
        String category;
        Double sum;

        @Override
        public String toString() {
            return String.format("%s %f", category, sum);
        }
    }
}
