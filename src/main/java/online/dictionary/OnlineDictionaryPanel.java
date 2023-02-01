package online.dictionary;

import javax.swing.*;
import java.awt.*;

public class OnlineDictionaryPanel extends JPanel {
    public OnlineDictionaryPanel() {
        // 表单
        JPanel formPanel = new JPanel();
        JTextField wordTextField = new JTextField();
        JButton lookUpButton = new JButton("查询");
        formPanel.setLayout(new BorderLayout());
        formPanel.add(wordTextField, BorderLayout.CENTER);
        formPanel.add(lookUpButton, BorderLayout.EAST);
        // 查询结果
        JLabel resultLabel = new JLabel();
        // 整体布局
        setLayout(new BorderLayout());
        add(formPanel, BorderLayout.NORTH);
        add(resultLabel, BorderLayout.CENTER);

        resultLabel.setText("123");
    }
}
