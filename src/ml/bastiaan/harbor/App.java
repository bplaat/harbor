// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.harbor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
        ContainerShip containerShip = simulation.getContainerShip();
        ArrayList<ContainerCrane> containerCranes = simulation.getContainerCranes();
        OilShip oilShip = simulation.getOilShip();
        ArrayList<OilPump> oilPumps = simulation.getOilPumps();
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
        JScrollPane rootScrollPane = new JScrollPane(root);
        rootScrollPane.setBorder(null);
        frame.add(rootScrollPane);

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
        JPanel box = new JPanel(new GridBagLayout());
        root.add(box);

        // Container Ship
        Box containerShipBox = Box.createVerticalBox();
        Insets insets = new Insets(8, 8, 8, 8);
        int columnMinWidth = 200;
        int columnMinHeight = 275;
        containerShipBox.setPreferredSize(new Dimension(columnMinWidth, columnMinHeight));
        box.add(containerShipBox, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0));

        JLabel containerShipImage = new JLabel(Utils.loadImage("containership.jpg", 96, 96));
        containerShipImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        containerShipBox.add(containerShipImage);
        containerShipBox.add(Box.createVerticalStrut(16));

        JLabel containerShipLabel = new JLabel();
        containerShipLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        Font font = new Font(containerShipLabel.getFont().getName(), Font.BOLD, 16);
        containerShipLabel.setFont(font);
        containerShipBox.add(containerShipLabel);
        containerShipBox.add(Box.createVerticalStrut(16));

        JList<String> containerShipList = new JList<String>();
        containerShipBox.add(new JScrollPane(containerShipList));

        // Container Cranes
        Box containerCranesBox = Box.createVerticalBox();
        containerCranesBox.setPreferredSize(new Dimension(columnMinWidth, columnMinHeight));
        box.add(containerCranesBox, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0));

        JLabel containerCranesImage = new JLabel(Utils.loadImage("containercrane.jpg", 96, 96));
        containerCranesImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        containerCranesBox.add(containerCranesImage);
        containerCranesBox.add(Box.createVerticalStrut(16));

        JLabel containerCranesLabel = new JLabel();
        containerCranesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        containerCranesLabel.setFont(font);
        containerCranesBox.add(containerCranesLabel);
        containerCranesBox.add(Box.createVerticalGlue());

        JLabel[] containerCraneLabels = new JLabel[containerCranes.size()];
        for (int i = 0; i < containerCranes.size(); i++) {
            JLabel containerCraneLabel = new JLabel();
            containerCraneLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            containerCraneLabel.setFont(font);
            containerCraneLabels[i] = containerCraneLabel;
            containerCranesBox.add(containerCraneLabel);
            if (i == containerCranes.size() - 1) {
                containerCranesBox.add(Box.createVerticalGlue());
            } else {
                containerCranesBox.add(Box.createVerticalStrut(16));
            }
        }

        // Oil Ship
        Box oilShipBox = Box.createVerticalBox();
        oilShipBox.setPreferredSize(new Dimension(columnMinWidth, columnMinHeight));
        box.add(oilShipBox, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0));

        JLabel oilShipImage = new JLabel(Utils.loadImage("oilship.jpg", 96, 96));
        oilShipImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        oilShipBox.add(oilShipImage);
        oilShipBox.add(Box.createVerticalStrut(16));

        JLabel oilShipLabel = new JLabel();
        oilShipLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        oilShipLabel.setFont(font);
        oilShipBox.add(oilShipLabel);
        oilShipBox.add(Box.createVerticalStrut(16));

        JList<String> oilShipList = new JList<String>();
        oilShipBox.add(new JScrollPane(oilShipList));

        // Oil Pumps
        Box oilPumpsBox = Box.createVerticalBox();
        oilPumpsBox.setPreferredSize(new Dimension(columnMinWidth, columnMinHeight));
        box.add(oilPumpsBox, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0));

        JLabel oilPumpsImage = new JLabel(Utils.loadImage("oilpump.jpg", 96, 96));
        oilPumpsImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        oilPumpsBox.add(oilPumpsImage);
        oilPumpsBox.add(Box.createVerticalStrut(16));

        JLabel oilPumpsLabel = new JLabel();
        oilPumpsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        oilPumpsLabel.setFont(font);
        oilPumpsBox.add(oilPumpsLabel);
        oilPumpsBox.add(Box.createVerticalGlue());


        JLabel[] oilPumpLabels = new JLabel[oilPumps.size()];
        for (int i = 0; i < oilPumps.size(); i++) {
            JLabel oilPumpLabel = new JLabel();
            oilPumpLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            oilPumpLabel.setFont(font);
            oilPumpLabels[i] = oilPumpLabel;
            oilPumpsBox.add(oilPumpLabel);
            if (i == oilPumps.size() - 1) {
                oilPumpsBox.add(Box.createVerticalGlue());
            } else {
                oilPumpsBox.add(Box.createVerticalStrut(16));
            }
        }

        // Quay
        Box quayBox = Box.createVerticalBox();
        quayBox.setPreferredSize(new Dimension(columnMinWidth, columnMinHeight));
        box.add(quayBox, new GridBagConstraints(2, 0, 1, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0));

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
        trucksBox.setPreferredSize(new Dimension(columnMinWidth, columnMinHeight));
        box.add(trucksBox, new GridBagConstraints(3, 0, 1, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0));

        JLabel truckImage = new JLabel(Utils.loadImage("truck.jpg", 96, 96));
        truckImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        trucksBox.add(truckImage);
        trucksBox.add(Box.createVerticalStrut(16));

        JLabel trucksLabel = new JLabel();
        trucksLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        trucksLabel.setFont(font);
        trucksBox.add(trucksLabel);
        trucksBox.add(Box.createVerticalGlue());

        JLabel[] truckLabels = new JLabel[trucks.size()];
        for (int i = 0; i < trucks.size(); i++) {
            JLabel truckLabel = new JLabel();
            truckLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            truckLabel.setFont(font);
            truckLabels[i] = truckLabel;
            trucksBox.add(truckLabel);
            if (i == trucks.size() - 1) {
                trucksBox.add(Box.createVerticalGlue());
            } else {
                trucksBox.add(Box.createVerticalStrut(16));
            }
        }

        // Warehouse
        Box warehouseBox = Box.createVerticalBox();
        warehouseBox.setPreferredSize(new Dimension(columnMinWidth, columnMinHeight));
        box.add(warehouseBox, new GridBagConstraints(4, 0, 1, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0));

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
                    if (!containerShip.isRunning()) {
                        containerShipLabel.setText("Container Ship: Stoped");
                    } else {
                        ArrayList<Item> containerShipItems = containerShip.getItems();
                        if (containerShipItems != null) {
                            if (!containerShip.isPlaying()) {
                                containerShipLabel.setText("Container Ship: Paused");
                            } else {
                                containerShipLabel.setText("Container Ship: " + containerShipItems.size() + " / " + containerShip.getMaxCount());
                            }

                            DefaultListModel<String> containerShipListItems = new DefaultListModel<String>();
                            for (int i = containerShipItems.size() - 1; i >= 0; i--) {
                                containerShipListItems.addElement(containerShipItems.get(i).getName());
                            }
                            containerShipList.setModel(containerShipListItems);

                            if (containerShipItems.size() == 1) {
                                JOptionPane.showMessageDialog(null, "The container ship is cleared!");
                            }
                        }
                    }

                    // Container Cranes
                    int containerCranesItemCount = 0;
                    for (int i = 0; i < containerCranes.size(); i++) {
                        ContainerCrane containerCrane = containerCranes.get(i);
                        if (!containerCrane.isRunning()) {
                            containerCraneLabels[i].setText(containerCrane.getName() + ": Stoped");
                        } else if (!containerCrane.isPlaying()) {
                            containerCraneLabels[i].setText(containerCrane.getName() + ": Paused");
                        } else if (containerCrane.isWaiting()) {
                            containerCraneLabels[i].setText(containerCrane.getName() + ": Waiting...");
                        } else {
                            containerCraneLabels[i].setText(containerCrane.getName() + ": " + containerCranes.get(i).getItem().getName());
                            containerCranesItemCount++;
                        }
                    }
                    if (!containerCranes.get(0).isRunning()) {
                        containerCranesLabel.setText("Container Cranes: Stoped");
                    } else if (!containerCranes.get(0).isPlaying()) {
                        containerCranesLabel.setText("Container Cranes: Paused");
                    } else {
                        containerCranesLabel.setText("Container Cranes: " + containerCranesItemCount + " / " + containerCranes.size());
                    }

                    // Oil ship
                    if (!oilShip.isRunning()) {
                        oilShipLabel.setText("Oil Ship: Stoped");
                    } else {
                        ArrayList<Item> oilShipItems = oilShip.getItems();
                        if (oilShipItems != null) {
                            if (!oilShip.isPlaying()) {
                                oilShipLabel.setText("Oil Ship: Paused");
                            } else {
                                oilShipLabel.setText("Oil Ship: " + oilShipItems.size() + " / " + oilShip.getMaxCount());
                            }

                            DefaultListModel<String> oilShipListItems = new DefaultListModel<String>();
                            for (int i = oilShipItems.size() - 1; i >= 0; i--) {
                                oilShipListItems.addElement(oilShipItems.get(i).getName());
                            }
                            oilShipList.setModel(oilShipListItems);

                            if (oilShipItems.size() == 1) {
                                JOptionPane.showMessageDialog(null, "The oil ship is cleared!");
                            }
                        }
                    }

                    // Oil Pumps
                    int oilPumpsItemCount = 0;
                    for (int i = 0; i < oilPumps.size(); i++) {
                        OilPump oilPump = oilPumps.get(i);
                        if (!oilPump.isRunning()) {
                            oilPumpLabels[i].setText(oilPump.getName() + ": Stoped");
                        } else if (!oilPump.isPlaying()) {
                            oilPumpLabels[i].setText(oilPump.getName() + ": Paused");
                        } else if (oilPump.isWaiting()) {
                            oilPumpLabels[i].setText(oilPump.getName() + ": Waiting...");
                        } else {
                            oilPumpLabels[i].setText(oilPump.getName() + ": " + oilPumps.get(i).getItem().getName());
                            oilPumpsItemCount++;
                        }
                    }
                    if (!oilPumps.get(0).isRunning()) {
                        oilPumpsLabel.setText("Oil Pumps: Stoped");
                    } else if (!oilPumps.get(0).isPlaying()) {
                        oilPumpsLabel.setText("Oil Pumps: Paused");
                    } else {
                        oilPumpsLabel.setText("Oil Pumps: " + oilPumpsItemCount + " / " + oilPumps.size());
                    }

                    // Quay
                    if (!quay.isRunning()) {
                        quayLabel.setText("Quay: Stoped");
                    } else {
                        ArrayList<Item> quayItems = quay.getItems();
                        if (quayItems != null) {
                            if (!quay.isPlaying()) {
                                quayLabel.setText("Quay: Paused");
                            } else {
                                quayLabel.setText("Quay: " + quayItems.size() + " / " + quay.getMaxCount());
                            }

                            DefaultListModel<String> quayListItems = new DefaultListModel<String>();
                            for (int i = quayItems.size() - 1; i >= 0; i--) {
                                quayListItems.addElement(quayItems.get(i).getName());
                            }
                            quayList.setModel(quayListItems);
                        }
                    }

                    // Trucks
                    int trucksItemCount = 0;
                    for (int i = 0; i < trucks.size(); i++) {
                        Truck truck = trucks.get(i);
                        if (!truck.isRunning()) {
                            truckLabels[i].setText(truck.getName() + ": Stoped");
                        } else if (!truck.isPlaying()) {
                            truckLabels[i].setText(truck.getName() + ": Paused");
                        } else if (truck.isWaiting()) {
                            truckLabels[i].setText(truck.getName() + ": Waiting...");
                        } else {
                            truckLabels[i].setText(truck.getName() + ": " + trucks.get(i).getItem().getName());
                            trucksItemCount++;
                        }
                    }
                    if (!trucks.get(0).isRunning()) {
                        trucksLabel.setText("Trucks: Stoped");
                    } else if (!trucks.get(0).isPlaying()) {
                        trucksLabel.setText("Trucks: Paused");
                    } else {
                        trucksLabel.setText("Trucks: " + trucksItemCount + " / " + trucks.size());
                    }

                    // Warehouse
                    if (!warehouse.isRunning()) {
                        warehouseLabel.setText("Warehouse: Stoped");
                    } else {
                        ArrayList<Item> warehouseItems = warehouse.getItems();
                        if (warehouseItems != null) {
                            if (!warehouse.isPlaying()) {
                                warehouseLabel.setText("Warehouse: Paused");
                            } else {
                                warehouseLabel.setText("Warehouse: " + warehouseItems.size() + " / " + warehouse.getMaxCount());
                            }

                            DefaultListModel<String> warehouseListItems = new DefaultListModel<String>();
                            for (int i = warehouseItems.size() - 1; i >= 0; i--) {
                                warehouseListItems.addElement(warehouseItems.get(i).getName());
                            }
                            warehouseList.setModel(warehouseListItems);

                            if (warehouseItems.size() == warehouse.getMaxCount() - 1) {
                                JOptionPane.showMessageDialog(null, "The warehouse is full!");
                            }
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
