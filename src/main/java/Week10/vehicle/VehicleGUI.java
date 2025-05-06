package Week10.vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VehicleGUI extends JFrame {

    private JPanel mainPanel;
    private JTextField nameTextField;
    private JTextField makeTextField;
    private JTextField modelTextField;
    private JCheckBox electricCheckBox;
    private JButton addButton;
    private JList<Vehicle> vehicleList;
    private JButton deleteButton;

    private DefaultListModel<Vehicle> vehicleListModel;

    VehicleGUI() {
        setTitle("Vehicle List");
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(600, 600));
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        vehicleListModel = new DefaultListModel<>();
        vehicleList.setModel(vehicleListModel);
        vehicleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        addButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String name = nameTextField.getText();
               String make = modelTextField.getText();
               String model = makeTextField.getText();

               if (name.isEmpty() || make.isEmpty() || model.isEmpty()) {
                   JOptionPane.showMessageDialog(VehicleGUI.this, "Please fill all the fields");
                   return;
               }

               boolean isElectric = electricCheckBox.isSelected();
               Vehicle vehicle = new Vehicle(name, make, model, isElectric);
               vehicleListModel.addElement(vehicle);

               nameTextField.setText("");
               makeTextField.setText("");
               modelTextField.setText("");
               electricCheckBox.setSelected(false);
           }
        });

        deleteButton.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {

               // will be null if nothing is selected
               Vehicle selectedVehicle = vehicleList.getSelectedValue();

               if (selectedVehicle != null) {
                   if (JOptionPane.showConfirmDialog(VehicleGUI.this,
                           "Delete " + selectedVehicle.getName() + "?",
                           "Delete Vehicle",
                           JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                       vehicleListModel.removeElement(selectedVehicle);
                   }
               } else {
                   JOptionPane.showMessageDialog(VehicleGUI.this, "Please select a vehicle to delete.");
               }


               // -1 if nothing is selected
//               int selectedVehicleIndex = vehicleList.getSelectedIndex();
           }
        });
    }

}
