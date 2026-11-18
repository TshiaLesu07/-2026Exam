import javax.swing.*;
import java.awt.*;

public class ProductApp extends JFrame {

        private JTextField txtCustomer = new JTextField(20);
    private JComboBox<String> cmbProduct = new JComboBox<>( new String[]{"Cozy Nights Monarch",
    "Testonic Barbados", "Sealy Phuket"});
        private JTextField txtPrice = new JTextField(20);
    private JButton btnProcess = new JButton("PROCESS");

    private SaleCalculator calc = new SaleCalculator();

    public ProductApp(){

        // Form settings
        setTitle("Product App");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));
        file.add(exit);

        JMenu edit = new JMenu("Edit");
        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.addActionListener(e -> clearFields());
        edit.add(clearItem);

        menuBar.add(file);
        menuBar.add(edit);
        setJMenuBar(menuBar);

        JPanel form = new JPanel(new GridLayout(4,2,5,5));
        form.add(new JLabel("Customer Name:"));
        form.add(txtCustomer);
        form.add(new JLabel("Select Product:"));
        form.add(cmbProduct);
        form.add(new JLabel("Enter Price:"));
        form.add(txtPrice);
        form.add(new JLabel());
        form.add(btnProcess);
        add(form, BorderLayout.CENTER);

        //adding buttons
        btnProcess.addActionListener(e ->process());
        setVisible(true);

    }

    private void process(){
        String customer = txtCustomer.getText().trim();
        if (customer.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter customer name");
            return;
        }
        double price;
        try {
            price = Double.parseDouble(txtPrice.getText().trim());
            if (price <= 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price.");
            return;
        }

        String msg = String.format(
                "Customer Name: %s%nProduct Name: %s%nVAT Amount: R%.2f%n"
                        + "Commission Amount: R%.2f%nTotal Sale Amount: R%.2f",
                customer, cmbProduct.getSelectedItem(),
                calc.calculateVat(price), calc.calculateComission(price),
                calc.calculateTotal(price));
        JOptionPane.showMessageDialog(this, msg, "Sale Summary",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void clearFields() {
        txtCustomer.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }
    private SaleCalculator calc = new SaleCalculator();

}
