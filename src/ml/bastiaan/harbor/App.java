// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.harbor;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.util.ArrayList;

public class App {
    public App() {
        Simulation simulation = new Simulation();
        ContainerShip containership = simulation.getContainerShip();
        ArrayList<Crane> cranes = simulation.getCranes();
        Quay quay = simulation.getQuay();
        ArrayList<Truck> trucks = simulation.getTrucks();
        Warehouse warehouse = simulation.getWarehouse();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}

        JFrame frame = new JFrame("Harbor Simulation");
        frame.setIconImage(Utils.loadImage("containership.jpg", 64, 64).getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);

        Box root = Box.createVerticalBox();
        root.setBorder(BorderFactory.createEmptyBorder(16, 8, 16, 8));
        frame.add(root);

        Box buttonsBox =  Box.createHorizontalBox();
        buttonsBox.add(new JButton("Start / Stop"));
        buttonsBox.add(new JButton("Play / pause"));
        root.add(buttonsBox);
        root.add(Box.createVerticalStrut(8));

        JPanel box = new JPanel();
        box.setLayout(new GridLayout(1, 5));
        root.add(box);

        JLabel footerLabel = new JLabel("Made by Bastiaan van der Plaat");
        footerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        footerLabel.setFont(new Font(footerLabel.getFont().getName(), Font.PLAIN, 16));
        root.add(Box.createVerticalStrut(8));
        root.add(footerLabel);

        Box containershipBox = Box.createVerticalBox();
        Border border = BorderFactory.createEmptyBorder(8, 8, 8, 8);
        containershipBox.setBorder(border);
        box.add(containershipBox);

        JLabel containershipImage = new JLabel(Utils.loadImage("containership.jpg", 96, 96));
        containershipImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        containershipBox.add(containershipImage);
        containershipBox.add(Box.createVerticalStrut(16));

        JLabel containershipLabel = new JLabel();
        containershipLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        Font font = new Font(containershipLabel.getFont().getName(), Font.BOLD, 18);
        containershipLabel.setFont(font);
        containershipBox.add(containershipLabel);
        containershipBox.add(Box.createVerticalStrut(16));

        JList<String> containershipList = new JList<String>();
        containershipBox.add(new JScrollPane(containershipList));

        Box cranesBox = Box.createVerticalBox();
        cranesBox.setBorder(border);
        box.add(cranesBox);

        JLabel cranesImage = new JLabel(Utils.loadImage("crane.jpg", 96, 96));
        cranesImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        cranesBox.add(cranesImage);
        cranesBox.add(Box.createVerticalStrut(16));

        JLabel cranesLabel = new JLabel("Cranes: " + cranes.size());
        cranesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cranesLabel.setFont(font);
        cranesBox.add(cranesLabel);
        cranesBox.add(Box.createVerticalGlue());

        JLabel crane1Label = new JLabel();
        crane1Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        crane1Label.setFont(font);
        cranesBox.add(crane1Label);
        cranesBox.add(Box.createVerticalStrut(16));

        JLabel crane2Label = new JLabel();
        crane2Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        crane2Label.setFont(font);
        cranesBox.add(crane2Label);
        cranesBox.add(Box.createVerticalGlue());

        Box quayBox = Box.createVerticalBox();
        quayBox.setBorder(border);
        box.add(quayBox);

        JLabel quayImage = new JLabel(Utils.loadImage("quay.jpg", 96, 96));
        quayImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        quayBox.add(quayImage);
        quayBox.add(Box.createVerticalStrut(16));

        JLabel quayLabel = new JLabel();
        quayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        quayLabel.setFont(font);
        quayBox.add(quayLabel);
        quayBox.add(Box.createVerticalStrut(16));

        JList<String> quayList = new JList<String>();
        quayBox.add(new JScrollPane(quayList));

        Box trucksBox = Box.createVerticalBox();
        trucksBox.setBorder(border);
        box.add(trucksBox);

        JLabel truckImage = new JLabel(Utils.loadImage("truck.jpg", 96, 96));
        truckImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        trucksBox.add(truckImage);
        trucksBox.add(Box.createVerticalStrut(16));

        JLabel trucksLabel = new JLabel("Trucks: " + trucks.size());
        trucksLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        trucksLabel.setFont(font);
        trucksBox.add(trucksLabel);
        trucksBox.add(Box.createVerticalGlue());

        JLabel truck1Label = new JLabel();
        truck1Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        truck1Label.setFont(font);
        trucksBox.add(truck1Label);
        trucksBox.add(Box.createVerticalStrut(16));

        JLabel truck2Label = new JLabel();
        truck2Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        truck2Label.setFont(font);
        trucksBox.add(truck2Label);
        trucksBox.add(Box.createVerticalStrut(16));

        JLabel truck3Label = new JLabel();
        truck3Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        truck3Label.setFont(font);
        trucksBox.add(truck3Label);
        trucksBox.add(Box.createVerticalGlue());

        Box warehouseBox = Box.createVerticalBox();
        warehouseBox.setBorder(border);
        box.add(warehouseBox);

        JLabel warehouseImage = new JLabel(Utils.loadImage("warehouse.jpg", 96, 96));
        warehouseImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        warehouseBox.add(warehouseImage);

        JLabel warehouseLabel = new JLabel();
        warehouseLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        warehouseLabel.setFont(font);
        warehouseBox.add(warehouseLabel);
        warehouseBox.add(Box.createVerticalStrut(16));

        JList<String> warehouseList = new JList<String>();
        warehouseBox.add(new JScrollPane(warehouseList));

        frame.setVisible(true);

        System.out.println("Container Ship Simulation");
        simulation.start();

        Thread updateThread = new Thread() {
            public void run() {
                while (true) {
                    containershipLabel.setText("Container Ship: " + containership.getContainers().size() + " / " + containership.getMaxCount());
                    DefaultListModel<String> containershipListItems = new DefaultListModel<String>();
                    ArrayList<Container> containershipContainers = containership.getContainers();
                    for (int i = containershipContainers.size() - 1; i >= 0; i--) {
                        containershipListItems.addElement(containershipContainers.get(i).getName());
                    }
                    containershipList.setModel(containershipListItems);

                    String waitingString = "Waiting...";

                    crane1Label.setText("Crane 1: " + (cranes.get(0).isWaiting() ? waitingString : cranes.get(0).getContainer().getName()));
                    crane2Label.setText("Crane 2: " + (cranes.get(1).isWaiting() ? waitingString : cranes.get(1).getContainer().getName()));

                    quayLabel.setText("Quay: " + quay.getContainers().size() + " / " + quay.getMaxCount());
                    DefaultListModel<String> quayListItems = new DefaultListModel<String>();
                    ArrayList<Container> quayContainers = quay.getContainers();
                    for (int i = quayContainers.size() - 1; i >= 0; i--) {
                        quayListItems.addElement(quayContainers.get(i).getName());
                    }
                    quayList.setModel(quayListItems);

                    truck1Label.setText("Truck 1: " + (trucks.get(0).isWaiting() ? waitingString : trucks.get(0).getContainer().getName()));
                    truck2Label.setText("Truck 2: " + (trucks.get(1).isWaiting() ? waitingString : trucks.get(1).getContainer().getName()));
                    truck3Label.setText("Truck 3: " + (trucks.get(2).isWaiting() ? waitingString : trucks.get(2).getContainer().getName()));

                    warehouseLabel.setText("Warehouse: " + warehouse.getContainers().size() + " / " + warehouse.getMaxCount());
                    DefaultListModel<String> warehouseListItems = new DefaultListModel<String>();
                    ArrayList<Container> warehouseContainers = warehouse.getContainers();
                    for (int i = warehouseContainers.size() - 1; i >= 0; i--) {
                        warehouseListItems.addElement(warehouseContainers.get(i).getName());
                    }
                    warehouseList.setModel(warehouseListItems);

                    if (containershipContainers.size() == 1) {
                        JOptionPane.showMessageDialog(null, "The container ship is cleared!");
                    }

                    Utils.threadWait();
                }
            }
        };
        updateThread.start();
    }

    public static void main(String[] args) {
        new App();
    }
}
