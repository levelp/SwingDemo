package moneymanager;

import moneymanager.MoneyManager.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

public class MoneyManagerTest extends Assert {
    private MoneyManager form;

    @Before
    public void setUp() {
        form = new MoneyManager();
    }

    /**
     * Просто добавляем данные в форму
     */
    @Test
    public void testSimpleEnterData() {
        // Вводим сумму
        form.sumField.setText("10.0");
        // Нажимаем на кнопку Расход
        form.spendMoneyButton.doClick();
        // Получаем модель для списка
        ListModel<Transaction> model = form.transactionsList.getModel();
        assertEquals("Должна быть одна транзакция", 1, model.getSize());
        // Проверяем сумму транзакции
        Transaction t = model.getElementAt(0);
        assertEquals(10.0, t.sum, 1e-15);
        // Проверяем категорию транзакции
        assertEquals(form.selectCategoryComboBox.getSelectedItem().toString(), t.category);
    }
}
