import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class app extends JFrame {
    private Inventory inventory;
    private Cart cart;
    private JTextArea orderTextArea;

    public app() {
        setTitle("Agrovet Order Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize inventory and cart
        inventory = new Inventory();
        cart = new Cart();

        // Create components
        JTabbedPane tabbedPane = createTabbedPane();
        orderTextArea = new JTextArea(10, 30);
        JButton checkoutButton = new JButton("Checkout");

        // Add action listener to checkout button
        checkoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double totalCost = new Transaction().processOrder(cart);
                orderTextArea.append("\nTotal Cost: $" + totalCost);
            }
        });

        // Add components to frame
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        mainPanel.add(new JScrollPane(orderTextArea), BorderLayout.EAST);
        mainPanel.add(checkoutButton, BorderLayout.SOUTH);
        add(mainPanel);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    private JTabbedPane createTabbedPane() {
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Seeds", createCategoryPanel(inventory.getSeeds()));
        tabbedPane.addTab("Fertilizers", createCategoryPanel(inventory.getFertilizers()));
        tabbedPane.addTab("Tools", createCategoryPanel(inventory.getTools()));
        return tabbedPane;
    }

    private JPanel createCategoryPanel(MenuItem[] items) {
        JPanel panel = new JPanel(new GridLayout(0, 2));
        for (MenuItem item : items) {
            JButton addButton = new JButton("Add to Cart");
            addButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity:"));
                    cart.addItem(item, quantity);
                    updateOrderTextArea();
                }
            });
            panel.add(new JLabel(item.getProduct()));
            panel.add(addButton);
        }
        return panel;
    }

    private void updateOrderTextArea() {
        orderTextArea.setText("");
        orderTextArea.append("Your Order:\n");
        for (MenuItem item : cart.getItems()) {
            orderTextArea
                    .append(item.getProduct() + "\t$" + item.getPrice() + "\tQuantity: " + item.getQuantity() + "\n");
        }
    }

}
