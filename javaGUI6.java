package chapter13practice;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class lab5Task2 extends JFrame{
    private final String[] styles = {"Regular Shades", "Folding Shades", "Roman Shades"};
    private final String[] size = {"25 Inches Wide", "27 Inches Wide","32 Inches Wide"};
    private JLabel banner;
    private JPanel bannerPanel;
    private JPanel stylesPanel;
    private JPanel sizePanel;
    private JPanel container;
    private JPanel buttonPanel;

    private JComboBox stylesList;
    private JComboBox sizeList;

    private JButton calcButton;
    private JButton ExitButton;

    private double totalCharges = 50.00;
    private final double foldingCost = 10.00;
    private final double romanCost = 15.00;
    private final double twentySevenInCost = 2.00;
    private final double thirtyTwoInCost = 4.00;

public lab5Task2()
{
    setTitle("Windos Shade Designer");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    buildBannerPanel();
    add(bannerPanel, BorderLayout.NORTH);

    stylesPanel();
    add(container, BorderLayout.CENTER);
    buttonPanel();
    add(buttonPanel, BorderLayout.SOUTH);
    setSize(400, 200);
    setVisible(true);
    setLocationRelativeTo(null);
}
private void buildBannerPanel()
{
    bannerPanel = new JPanel();
    bannerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    banner = new JLabel("Welcome to Window Shade Designer");
    bannerPanel.add(banner);
}

    private void stylesPanel()
    {
    container=new JPanel();
    stylesPanel = new JPanel();
    stylesPanel.setBorder(BorderFactory.createTitledBorder("Shade style"));
    stylesList = new JComboBox (styles);
    JScrollPane stylesScrollPane = new JScrollPane(stylesList);
    stylesPanel.add(stylesScrollPane);
    sizePanel=new JPanel();
    sizePanel.setBorder(BorderFactory.createTitledBorder("Shade size"));
    sizeList = new JComboBox (size);
    JScrollPane sizeScrollPane = new JScrollPane(sizeList);
    sizePanel.add(sizeScrollPane);
    container.add(stylesPanel);
    container.add(sizePanel);
    }
 private void buttonPanel()
    {
    calcButton= new JButton ("Calculate");
    calcButton.addActionListener(new calcButtonListener());
    ExitButton = new JButton ("Exit");
    ExitButton.addActionListener(new ExitButtonListener());
    buttonPanel = new JPanel();
    buttonPanel.add(calcButton);
    buttonPanel.add(ExitButton);
    }

    private class calcButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int  style =stylesList.getSelectedIndex();
            int size =  sizeList.getSelectedIndex();
            if (style==1){
                totalCharges+=foldingCost;
            }
            else if(style==2){
                totalCharges+=romanCost;
            }
            if(size==1){
                totalCharges+=twentySevenInCost;
            }else if(size==2){
                totalCharges+=thirtyTwoInCost;
            }
      
            JOptionPane.showMessageDialog(null, "TotalCharges: $" +totalCharges );
        }
}

private class ExitButtonListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.exit(0);
    }
}
public static void main(String[] args){
        new lab5Task2();
    }
}
