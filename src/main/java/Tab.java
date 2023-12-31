import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tab {

        public JPanel getTabHead(String tabName){

        JButton closeBtn = new JButton("x");
        closeBtn.setOpaque(false);
        closeBtn.setBorderPainted(false);
        closeBtn.setBackground(Color.WHITE);

        JLabel tab = new JLabel(tabName);
        JPanel tabCap = new JPanel(new GridBagLayout());
        tabCap.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 2;
        tabCap.add(tab,gbc);

        gbc.gridx++;
        gbc.weightx = 0;
        tabCap.add(closeBtn,gbc);
        closeBtn.addActionListener(new CloseBtnHandler(tabName));


        return tabCap;
    }

    public JPanel getTabBody(String path){
            JPanel tabPanel = new JPanel();
            tabPanel.setMinimumSize(new Dimension(700, 350));
            tabPanel.setSize(1200, 600);
//            ToolsPanel toolsPanel = new ToolsPanel(path);
        NormalizationPanel normPanel = new NormalizationPanel();
        DataTable normalPhase = new DataTable(path);
        DataPlotter plot = new DataPlotter();
        XYChart graph = plot.createPlot(normalPhase.time,normalPhase.values);
        XChartPanel<XYChart> tabBody = new XChartPanel<XYChart>(graph);
        tabPanel.setLayout(new BorderLayout());
        tabPanel.add(BorderLayout.CENTER,tabBody);
//        tabPanel.add(BorderLayout.WEST,normPanel);
        return tabPanel;
    }

    public class CloseBtnHandler implements ActionListener {
        private String tabName;
        public CloseBtnHandler(String tabName) {
            this.tabName = tabName;
        }
        public String getTabName() {
            return tabName;
        }
        public void actionPerformed(ActionEvent evt) {
            int index = MainWindow.getMainWindow().centerPanel.getTabPane().indexOfTab(getTabName());
            if (index >= 0) {
//                openedTabs.remove(getTabName());
//                tabPane.removeTabAt(index);
                MainWindow.getMainWindow().centerPanel.removeTab(index,getTabName());
            }
        }
    }
}
