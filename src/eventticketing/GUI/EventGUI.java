/*
This file runs the main GUI. This is where all the main functions of the GUI
are. This runs the Event and Booked events tabs and sets up the jtables.
 */
package eventticketing.GUI;

import eventticketing.Models.Event;
import eventticketing.DBManager;
import eventticketing.DBOperations;
import javax.swing.*;
import java.sql.*;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Adhay
 */
public class EventGUI extends javax.swing.JFrame {

    /**
     * Creates new form EventGUI
     */
    static EventGUI eventGui;
    private static ArrayList<Event> eventList = new ArrayList<Event>();
    CardLayout cardLayout;
    DefaultTableModel eTable;

    private EventGUI() {
        initComponents();
        cardLayout = (CardLayout) (cardPanel.getLayout());
    }

    /*
    This function creates a singleton for the EventGUI. As only 1 is needed.
     */
    public static EventGUI getInstance() {
        if (eventGui == null) {
            eventGui = new EventGUI();
        }
        return eventGui;
    }

    /*
    This creates the rows for the jtable according to the events arraylist.
     */
    public void setEventsTable() {
        DefaultTableModel tableModel = (DefaultTableModel) eventTable.getModel();
        for (Event event : eventList) {
            Object[] row = {event.getId(), event.getName(), event.getDate(), event.getTime(), event.getLocation()};
            tableModel.addRow(row);
        }

    }

    /*
    getEventById searches for the event needed by ID within the events arraylist.
     */
    private Event getEventById(int id) {
        for (Event event : eventList) {
            if (id == event.getId()) {
                return event;
            }
        }
        return null;
    }

    /*
    This allows the eventlist to be used in this file.
     */
    public static void setEventList(ArrayList<eventticketing.Models.Event> elist) {
        eventList = elist;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        eventsButton = new javax.swing.JButton();
        bookingsButton = new javax.swing.JButton();
        cardPanel = new javax.swing.JPanel();
        eventsPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        filterTable = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        bookingsPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        bookedEventsTable = new javax.swing.JTable();
        bookedTeventTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        eventsButton.setText("Events");
        eventsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventsButtonActionPerformed(evt);
            }
        });

        bookingsButton.setText("Bookings");
        bookingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bookingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(eventsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(bookingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        cardPanel.setBackground(new java.awt.Color(255, 255, 255));
        cardPanel.setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Search");

        filterTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterTableKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(filterTable);

        eventTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Date", "Time", "Location"
            }
        ));
        eventTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eventTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(eventTable);
        if (eventTable.getColumnModel().getColumnCount() > 0) {
            eventTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel3.setText("Click on an event for details/booking.");

        javax.swing.GroupLayout eventsPanelLayout = new javax.swing.GroupLayout(eventsPanel);
        eventsPanel.setLayout(eventsPanelLayout);
        eventsPanelLayout.setHorizontalGroup(
            eventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventsPanelLayout.createSequentialGroup()
                .addGroup(eventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eventsPanelLayout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(eventsPanelLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(eventsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        eventsPanelLayout.setVerticalGroup(
            eventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventsPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(eventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        cardPanel.add(eventsPanel, "card2");

        bookedEventsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Date", "Time", "Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(bookedEventsTable);
        if (bookedEventsTable.getColumnModel().getColumnCount() > 0) {
            bookedEventsTable.getColumnModel().getColumn(0).setResizable(false);
            bookedEventsTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            bookedEventsTable.getColumnModel().getColumn(1).setResizable(false);
            bookedEventsTable.getColumnModel().getColumn(2).setResizable(false);
            bookedEventsTable.getColumnModel().getColumn(3).setResizable(false);
            bookedEventsTable.getColumnModel().getColumn(4).setResizable(false);
        }

        bookedTeventTitle.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        bookedTeventTitle.setText("These are your Booked Events");

        javax.swing.GroupLayout bookingsPanelLayout = new javax.swing.GroupLayout(bookingsPanel);
        bookingsPanel.setLayout(bookingsPanelLayout);
        bookingsPanelLayout.setHorizontalGroup(
            bookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookingsPanelLayout.createSequentialGroup()
                .addGroup(bookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bookingsPanelLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bookingsPanelLayout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(bookedTeventTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        bookingsPanelLayout.setVerticalGroup(
            bookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bookingsPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(bookedTeventTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );

        cardPanel.add(bookingsPanel, "card4");

        jSplitPane1.setRightComponent(cardPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /*
    This function switches between the different panels in the main GUI, from 
    the Events page to the Booked Events page.
     */
    public void switchPanels(JPanel panel) {
        cardPanel.removeAll();
        cardPanel.add(panel);
        cardPanel.repaint();
        cardPanel.revalidate();
    }

    /*
    This function is used to search in the JTable of events to make it easier
    to search for different events.
     */
    public void filterSearch(String filtering) {
        eTable = (DefaultTableModel) eventTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(eTable);
        eventTable.setRowSorter(trs);

        trs.setRowFilter(RowFilter.regexFilter("(?i)" + filtering));
    }

    public JTable getEventTable() {
        return eventTable;
    }

    public JTable getBookedEventTable() {
        return bookedEventsTable;
    }

    private void eventsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventsButtonActionPerformed
        switchPanels(eventsPanel);
    }//GEN-LAST:event_eventsButtonActionPerformed

    private void bookingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingsButtonActionPerformed
        switchPanels(bookingsPanel);
        ResultSet rs1 = DBOperations.bookedEventsData();
        setBooked(rs1);
    }//GEN-LAST:event_bookingsButtonActionPerformed
    /*
    When the user types in this field, their text is searched in the JTable
     */
    private void filterTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterTableKeyReleased
        String filtering = filterTable.getText();
        filterSearch(filtering);
    }//GEN-LAST:event_filterTableKeyReleased
    /*
    When the user clicks on the table table the ID is taken from the row
    and is searched for the in the event array which then opents the "DetailFrame".
    This then displays extra data for each event.
     */
    private void eventTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventTableMouseClicked
        int row = eventTable.getSelectedRow();
        int id = Integer.parseInt(eventTable.getValueAt(row, 0).toString());
        Event event = getEventById(id);
        DetailEventFrame detailFrame = new DetailEventFrame(event);
        detailFrame.writeDetails();
        detailFrame.setVisible(true);

    }//GEN-LAST:event_eventTableMouseClicked

    /*
    This sets up the booked events jtable with the data that is in the bookedevents
    database. Each time the tab is changed back to the events tab the data is reset
    in the Jtable as to not keep adding in data.
     */
    private void setBooked(ResultSet rs) {
        DefaultTableModel tableModel = (DefaultTableModel) bookedEventsTable.getModel();
        tableModel.setRowCount(0);
        try {
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                Date date = rs.getDate("Date");
                Time time = rs.getTime("Time");
                String location = rs.getString("Location");
                Object[] row = {id, name, date, time, location};
                tableModel.addRow(row);
                bookedEventsTable.setModel(tableModel);
            }

        } catch (SQLException ex) {
            System.out.println("Error Main: " + ex);
            ex.printStackTrace();

        }
    }

//    private static EventGUI eventGUI;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bookedEventsTable;
    private javax.swing.JLabel bookedTeventTitle;
    private javax.swing.JButton bookingsButton;
    private javax.swing.JPanel bookingsPanel;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JTable eventTable;
    private javax.swing.JButton eventsButton;
    private javax.swing.JPanel eventsPanel;
    private javax.swing.JTextPane filterTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}
