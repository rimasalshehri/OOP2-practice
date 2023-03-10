package chapter13practice;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class lab5Task1 extends JFrame
{
    private JPanel seasonPanel; 
    private JPanel selectedSeasonPanel; 
    private JList seasonList; 
    private JScrollPane scrollPane; 
    private JTextField selectedSeason; 
    private JLabel label;
    private JLabel title; 
    private String[] season = { "Summer","winter","autumn","spring" };
    public lab5Task1()
    {
        
        setTitle("List Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildSeasonPanel();
        buildSelectedSeasonPanel();
        title=new JLabel("Please select your faviorate season:");
        add(title,BorderLayout.NORTH);
        add(seasonPanel, BorderLayout.CENTER);
        add(selectedSeasonPanel, BorderLayout.SOUTH);
        setSize(300, 160);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    private void buildSeasonPanel()
    {
        seasonPanel = new JPanel();
        seasonList = new JList(season);
        seasonList.setSelectionMode(
        ListSelectionModel.SINGLE_SELECTION);
        seasonList.addListSelectionListener( new ListListener());
        seasonList.setVisibleRowCount(3);
        scrollPane = new JScrollPane(seasonList);
        seasonPanel.add(scrollPane);
    }
    
    private void buildSelectedSeasonPanel()
    {
      
        selectedSeasonPanel = new JPanel();
        label = new JLabel("You selected: ");
        selectedSeason = new JTextField(10);
        selectedSeason.setEditable(false);
        selectedSeasonPanel.add(label);
        selectedSeasonPanel.add(selectedSeason);
    }
    private class ListListener implements ListSelectionListener
    {
        public void valueChanged(ListSelectionEvent e)
        {
            
            String selection = (String) seasonList.getSelectedValue();
           
            selectedSeason.setText(selection);
        }
    }
   
    public static void main(String[] args)
    {
         new lab5Task1();
    }
  }


