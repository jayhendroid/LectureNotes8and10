package Week10;

import javax.swing.*;
// import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TShirtGUI extends JFrame{
    private JPanel mainPanel;
    private JComboBox sizeComboBox;
    private JLabel selectedSizeLabel;
    private JComboBox<String> colorComboBox;
    private JLabel selectedColorLabel;

    TShirtGUI(){
        setTitle("T-Shirt Order Form");
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(800,150));
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        sizeComboBox.addItem("Small");
        sizeComboBox.addItem("Medium");
        sizeComboBox.addItem("Large");

        sizeComboBox.setSelectedIndex(-1);


        sizeComboBox.addActionListener(event -> {
            String sizeSelected = (String) sizeComboBox.getSelectedItem();
            selectedSizeLabel.setText("Thanks, you chose " + sizeSelected);
        });

        String[] colors = {"Red", "Blue", "Green", "Yellow", "Orange", "Violet"};

        // new combobox model with array of colors
        DefaultComboBoxModel<String> colorModel = new DefaultComboBoxModel<>(colors);
        colorComboBox.setModel(colorModel);

        colorComboBox.setSelectedIndex(-1);


        colorModel.addElement("Pink");
        colorModel.insertElementAt("Maroon", 0);
        colorModel.removeElementAt(2);

        List<String> moreColors = List.of("Black", "Turqoise", "Cyan");
        colorModel.addAll(moreColors);

        System.out.println(colorModel.getIndexOf("Blue "));
        if (colorModel.getIndexOf("White ") == -1) {
            colorModel.addElement("White");
        }

        colorComboBox.addActionListener(event -> {
            String colorSelected = (String) colorModel.getSelectedItem();
            selectedColorLabel.setText("Thanks, you chose " + colorSelected);
        });

    }
}
