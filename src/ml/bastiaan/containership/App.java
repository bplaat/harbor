package ml.bastiaan.containership;

import java.awt.Font;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.util.ArrayList;

public class App {
    public App() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}

        JFrame frame = new JFrame("Container Ship Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);

        Box box = Box.createHorizontalBox();
        frame.add(box);

        Box containershipBox = Box.createVerticalBox();
        box.add(containershipBox);

        JLabel containershipLabel = new JLabel();
        Font font = new Font(containershipLabel.getFont().getName(), Font.BOLD, 24);
        containershipLabel.setFont(font);
        containershipBox.add(containershipLabel);

        JList<String> containershipList = new JList<String>();
        containershipBox.add(new JScrollPane(containershipList));

        Box cranesBox = Box.createVerticalBox();
        box.add(cranesBox);

        JLabel crane1Label = new JLabel();
        crane1Label.setFont(font);
        cranesBox.add(crane1Label);

        JLabel crane2Label = new JLabel();
        crane2Label.setFont(font);
        cranesBox.add(crane2Label);

        Box quayBox = Box.createVerticalBox();
        box.add(quayBox);

        JLabel quayLabel = new JLabel();
        quayLabel.setFont(font);
        quayBox.add(quayLabel);

        JList<String> quayList = new JList<String>();
        quayBox.add(new JScrollPane(quayList));

        Box trucksBox = Box.createVerticalBox();
        box.add(trucksBox);

        JLabel truck1Label = new JLabel();
        truck1Label.setFont(font);
        trucksBox.add(truck1Label);

        JLabel truck2Label = new JLabel();
        truck2Label.setFont(font);
        trucksBox.add(truck2Label);

        JLabel truck3Label = new JLabel();
        truck3Label.setFont(font);
        trucksBox.add(truck3Label);

        Box warehouseBox = Box.createVerticalBox();
        box.add(warehouseBox);

        JLabel warehouseLabel = new JLabel();
        warehouseLabel.setFont(font);
        warehouseBox.add(warehouseLabel);

        JList<String> warehouseList = new JList<String>();
        warehouseBox.add(new JScrollPane(warehouseList));

        frame.setVisible(true);

        Quay quay = new Quay();
        quay.start();

        ContainerShip containership = quay.getContainerShip();

        Warehouse warehouse = quay.getWarehouse();

        while (true) {
            containershipLabel.setText("Container Ship: " + containership.getContainers().size());
            DefaultListModel<String> containershipListItems = new DefaultListModel<String>();
            ArrayList<Container> containershipContainers = containership.getContainers();
            for (int i = containershipContainers.size() - 1; i >= 0; i--) {
                containershipListItems.addElement(containershipContainers.get(i).getName());
            }
            containershipList.setModel(containershipListItems);

            crane1Label.setText("Crane 1: " + (quay.getCranes().get(0).isWaiting() ? "Waiting" : quay.getCranes().get(0).getContainer().getName()));
            crane2Label.setText("Crane 2: " + (quay.getCranes().get(1).isWaiting() ? "Waiting" : quay.getCranes().get(1).getContainer().getName()));

            quayLabel.setText("Quay: " + quay.getContainers().size());
            DefaultListModel<String> quayListItems = new DefaultListModel<String>();
            ArrayList<Container> quayContainers = quay.getContainers();
            for (int i = quayContainers.size() - 1; i >= 0; i--) {
                quayListItems.addElement(quayContainers.get(i).getName());
            }
            quayList.setModel(quayListItems);

            truck1Label.setText("Truck 1: " + (quay.getTrucks().get(0).isWaiting() ? "Waiting" : quay.getTrucks().get(0).getContainer().getName()));
            truck2Label.setText("Truck 2: " + (quay.getTrucks().get(1).isWaiting() ? "Waiting" : quay.getTrucks().get(1).getContainer().getName()));
            truck3Label.setText("Truck 3: " + (quay.getTrucks().get(2).isWaiting() ? "Waiting" : quay.getTrucks().get(2).getContainer().getName()));

            warehouseLabel.setText("Warehouse: " + warehouse.getContainers().size());
            DefaultListModel<String> warehouseListItems = new DefaultListModel<String>();
            ArrayList<Container> warehouseContainers = warehouse.getContainers();
            for (int i = warehouseContainers.size() - 1; i >= 0; i--) {
                warehouseListItems.addElement(warehouseContainers.get(i).getName());
            }
            warehouseList.setModel(warehouseListItems);

            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Container Ship Simulation");
        new App();
    }
}
