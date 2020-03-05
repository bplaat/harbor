// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.harbor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        System.out.println("The Harbor Simulation");

        // Simulation
        Simulation simulation = new Simulation();
        ContainerShip containership = simulation.getContainerShip();
        ArrayList<Crane> cranes = simulation.getCranes();
        Quay quay = simulation.getQuay();
        ArrayList<Truck> trucks = simulation.getTrucks();
        Warehouse warehouse = simulation.getWarehouse();

        // Window
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}

        JFrame frame = new JFrame("The Harbor Simulation");
        frame.setIconImage(Utils.loadImage("containership.jpg", 64, 64).getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);

        // Root
        Box root = Box.createVerticalBox();
        root.setBorder(BorderFactory.createEmptyBorder(16, 8, 16, 8));
        frame.add(root);

        // Buttons
        Box buttonsBox =  Box.createHorizontalBox();
        root.add(buttonsBox);
        root.add(Box.createVerticalStrut(8));

        JButton startStopButton = new JButton("Start");
        JButton playPauseButton = new JButton("Play");
        startStopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (simulation.isRunning()) {
                    simulation.stop();
                    startStopButton.setText("Start");
                    playPauseButton.setText("Play");
                } else {
                    simulation.start();
                    startStopButton.setText("Stop");
                    playPauseButton.setText("Pause");
                }
            }
        });
        buttonsBox.add(startStopButton);

        playPauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (simulation.isPlaying()) {
                    simulation.pause();
                    playPauseButton.setText("Play");
                } else {
                    simulation.play();
                    playPauseButton.setText("Pause");
                }
            }
        });
        buttonsBox.add(playPauseButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        buttonsBox.add(exitButton);

        // Main
        JPanel box = new JPanel();
        box.setLayout(new GridLayout(1, 5));
        root.add(box);

        // Container Ship
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
        Font font = new Font(containershipLabel.getFont().getName(), Font.BOLD, 16);
        containershipLabel.setFont(font);
        containershipBox.add(containershipLabel);
        containershipBox.add(Box.createVerticalStrut(16));

        JList<String> containershipList = new JList<String>();
        containershipBox.add(new JScrollPane(containershipList));

        // Cranes
        Box cranesBox = Box.createVerticalBox();
        cranesBox.setBorder(border);
        box.add(cranesBox);

        JLabel cranesImage = new JLabel(Utils.loadImage("crane.jpg", 96, 96));
        cranesImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        cranesBox.add(cranesImage);
        cranesBox.add(Box.createVerticalStrut(16));

        JLabel cranesLabel = new JLabel();
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

        // Quay
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

        // Trucks
        Box trucksBox = Box.createVerticalBox();
        trucksBox.setBorder(border);
        box.add(trucksBox);

        JLabel truckImage = new JLabel(Utils.loadImage("truck.jpg", 96, 96));
        truckImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        trucksBox.add(truckImage);
        trucksBox.add(Box.createVerticalStrut(16));

        JLabel trucksLabel = new JLabel();
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

        // Warehouse
        Box warehouseBox = Box.createVerticalBox();
        warehouseBox.setBorder(border);
        box.add(warehouseBox);

        JLabel warehouseImage = new JLabel(Utils.loadImage("warehouse.jpg", 96, 96));
        warehouseImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        warehouseBox.add(warehouseImage);
        warehouseBox.add(Box.createVerticalStrut(16));

        JLabel warehouseLabel = new JLabel();
        warehouseLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        warehouseLabel.setFont(font);
        warehouseBox.add(warehouseLabel);
        warehouseBox.add(Box.createVerticalStrut(16));

        JList<String> warehouseList = new JList<String>();
        warehouseBox.add(new JScrollPane(warehouseList));

        // Footer
        JLabel footerLabel = new JLabel("Made by Bastiaan van der Plaat");
        footerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        footerLabel.setFont(new Font(footerLabel.getFont().getName(), Font.PLAIN, 14));
        root.add(Box.createVerticalStrut(8));
        root.add(footerLabel);

        Thread updateThread = new Thread() {
            public void run() {
                while (true) {
                    // Container ship
                    if (!containership.isRunning()) {
                        containershipLabel.setText("Container Ship: Stoped");
                    } else {
                        ArrayList<Container> containershipContainers = containership.getContainers();
                        if (containershipContainers != null) {
                            if (!containership.isPlaying()) {
                                containershipLabel.setText("Container Ship: Paused");
                            } else {
                                containershipLabel.setText("Container Ship: " + containershipContainers.size() + " / " + containership.getMaxCount());
                            }

                            DefaultListModel<String> containershipListItems = new DefaultListModel<String>();
                            for (int i = containershipContainers.size() - 1; i >= 0; i--) {
                                containershipListItems.addElement(containershipContainers.get(i).getName());
                            }
                            containershipList.setModel(containershipListItems);

                            if (containershipContainers.size() == 1) {
                                JOptionPane.showMessageDialog(null, "The container ship is cleared!");
                            }
                        }
                    }

                    // Cranes
                    int cranesContainerCount = 0;

                    // Crane 1
                    if (!cranes.get(0).isRunning()) {
                        crane1Label.setText("Crane 1: Stoped");
                    } else if (!cranes.get(0).isPlaying()) {
                        crane1Label.setText("Crane 1: Paused");
                    } else if (cranes.get(0).isWaiting()) {
                        crane1Label.setText("Crane 1: Waiting...");
                    } else {
                        cranesContainerCount++;
                        crane1Label.setText("Crane 1: " + cranes.get(0).getContainer().getName());
                    }

                    // Crane 2
                    if (!cranes.get(1).isRunning()) {
                        crane2Label.setText("Crane 2: Stoped");
                    } else if (!cranes.get(1).isPlaying()) {
                        crane2Label.setText("Crane 2: Paused");
                    } else if (cranes.get(1).isWaiting()) {
                        crane2Label.setText("Crane 2: Waiting...");
                    } else {
                        cranesContainerCount++;
                        crane2Label.setText("Crane 2: " + cranes.get(1).getContainer().getName());
                    }

                    // Cranes
                    if (!cranes.get(0).isRunning() && !cranes.get(1).isRunning()) {
                        cranesLabel.setText("Cranes: Stoped");
                    } else if (!cranes.get(0).isPlaying() && !cranes.get(1).isPlaying()) {
                        cranesLabel.setText("Cranes: Paused");
                    } else {
                        cranesLabel.setText("Cranes: " + cranesContainerCount + " / " + cranes.size());
                    }

                    // Quay
                    if (!quay.isRunning()) {
                        quayLabel.setText("Quay: Stoped");
                    } else {
                        ArrayList<Container> quayContainers = quay.getContainers();
                        if (quayContainers != null) {
                            if (!quay.isPlaying()) {
                                quayLabel.setText("Quay: Paused");
                            } else {
                                quayLabel.setText("Quay: " + quayContainers.size() + " / " + quay.getMaxCount());
                            }

                            DefaultListModel<String> quayListItems = new DefaultListModel<String>();
                            for (int i = quayContainers.size() - 1; i >= 0; i--) {
                                quayListItems.addElement(quayContainers.get(i).getName());
                            }
                            quayList.setModel(quayListItems);
                        }
                    }

                    // Trucks
                    int trucksContainerCount = 0;

                    // Truck 1
                    if (!trucks.get(0).isRunning()) {
                        truck1Label.setText("Truck 1: Stoped");
                    } else if (!trucks.get(0).isPlaying()) {
                        truck1Label.setText("Truck 1: Paused");
                    } else if (trucks.get(0).isWaiting()) {
                        truck1Label.setText("Truck 1: Waiting...");
                    } else {
                        trucksContainerCount++;
                        truck1Label.setText("Truck 1: " + trucks.get(0).getContainer().getName());
                    }

                    // Truck 2
                    if (!trucks.get(1).isRunning()) {
                        truck2Label.setText("Truck 2: Stoped");
                    } else if (!trucks.get(1).isPlaying()) {
                        truck2Label.setText("Truck 2: Paused");
                    } else if (trucks.get(1).isWaiting()) {
                        truck2Label.setText("Truck 2: Waiting...");
                    } else {
                        trucksContainerCount++;
                        truck2Label.setText("Truck 2: " + trucks.get(1).getContainer().getName());
                    }

                    // Truck 3
                    if (!trucks.get(2).isRunning()) {
                        truck3Label.setText("Truck 3: Stoped");
                    } else if (!trucks.get(2).isPlaying()) {
                        truck3Label.setText("Truck 3: Paused");
                    } else if (trucks.get(2).isWaiting()) {
                        truck3Label.setText("Truck 3: Waiting...");
                    } else {
                        trucksContainerCount++;
                        truck3Label.setText("Truck 3: " + trucks.get(2).getContainer().getName());
                    }

                    // Trucks
                    if (!trucks.get(0).isRunning() && !trucks.get(1).isRunning() && !trucks.get(2).isRunning()) {
                        trucksLabel.setText("Cranes: Stoped");
                    } else if (!trucks.get(0).isPlaying() && !trucks.get(1).isPlaying() && !trucks.get(2).isPlaying()) {
                        trucksLabel.setText("Cranes: Paused");
                    } else {
                        trucksLabel.setText("Trucks: " + trucksContainerCount + " / " + trucks.size());
                    }

                    // Warehouse
                    if (!warehouse.isRunning()) {
                        warehouseLabel.setText("Warehouse: Stoped");
                    } else {
                        ArrayList<Container> warehouseContainers = warehouse.getContainers();
                        if (warehouseContainers != null) {
                            if (!warehouse.isPlaying()) {
                                warehouseLabel.setText("Warehouse: Paused");
                            } else {
                                warehouseLabel.setText("Warehouse: " + warehouseContainers.size() + " / " + warehouse.getMaxCount());
                            }

                            DefaultListModel<String> warehouseListItems = new DefaultListModel<String>();
                            for (int i = warehouseContainers.size() - 1; i >= 0; i--) {
                                warehouseListItems.addElement(warehouseContainers.get(i).getName());
                            }
                            warehouseList.setModel(warehouseListItems);
                        }
                    }

                    Utils.threadWait();
                }
            }
        };
        updateThread.start();

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }
}
