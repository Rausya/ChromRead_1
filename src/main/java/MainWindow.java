import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainWindow {

    private static MainWindow mainWindow = new MainWindow();

    public static MainWindow getMainWindow() {
        return mainWindow;
    }

    public ToolsPanel toolsPanel;
    public CentralPanel centerPanel;

    public JLabel statusBar;

    private MainWindow() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(700, 350));

//        toolsPanel = new ToolsPanel();
        centerPanel = new CentralPanel();
        statusBar = new JLabel("Information");


//        frame.getContentPane().add(BorderLayout.WEST, toolsPanel);
        frame.getContentPane().add(BorderLayout.CENTER, centerPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, statusBar);
        frame.setSize(1200, 600);
        frame.setVisible(true);
    }

    public void fillStatusBar(String text){
        statusBar.setText(text);
    }


}

