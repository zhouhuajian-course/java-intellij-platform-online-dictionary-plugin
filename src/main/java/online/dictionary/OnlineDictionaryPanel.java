package online.dictionary;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

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
        resultLabel.setHorizontalAlignment(JLabel.LEFT);
        resultLabel.setVerticalAlignment(JLabel.TOP);
        resultLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // 整体布局
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout());
        add(formPanel, BorderLayout.NORTH);
        add(resultLabel, BorderLayout.CENTER);

        // resultLabel.setText("123");
        lookUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // resultLabel.setText("这是" + wordTextField.getText() + "单词的查询结果");
                String word = wordTextField.getText();
                String result;
                try {
                    Document document = Jsoup.connect("https://cn.bing.com/dict/search?q=" + word).get();
                    String part1 = document.select("div.qdef div.hd_area").first().toString();
                    String part2 = document.select("div.qdef ul").first().toString();
                    result = part1 + part2;
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                resultLabel.setText("<html>" + result + "</html>");
            }
        });

        wordTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    lookUpButton.doClick();
                }
            }
        });
    }
}
