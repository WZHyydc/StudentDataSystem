package StudentSystem.frame;

import StudentSystem.dao.ManageHelper;
import StudentSystem.model.*;
import StudentSystem.util.WindowUtil;

import javax.swing.*;
import java.awt.*;

public class BrowseUndergraduateFrame extends JFrame {
    private JFrame jf ;
    private JPanel jp1;
    private JPanel jp2;
    private JPanel jp3;
    private JLabel number;//学生人数标签
    private JLabel condition_Label;//条件排序标签
    private JComboBox<String> comboBox;//下拉列表
    private JScrollPane scrollPane;//滚动窗格
    private ManageHelper helper;
    BrowseUndergraduateFrame (String title)
    {
        super(title);
        this.jf = this;
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        helper = new ManageHelper();

        number = new JLabel("本科生总人数："+ helper.getAllUndergraduate().size());
        jp2.add(number);
        jf.add(jp2, BorderLayout.SOUTH);


        condition_Label = new JLabel("排序方式选择：");
        jp1.add(condition_Label);

        comboBox = new JComboBox<>();
        comboBox.addItem("学号");
        comboBox.addItem("总成绩");
        comboBox.addItem("数学成绩");
        comboBox.addItem("英语成绩");
        comboBox.addItem("Java成绩");
        comboBox.setPreferredSize(new Dimension(100,20));
        jp1.add(comboBox);
        jf.add(jp1,BorderLayout.NORTH);

        JTable jTable = new UndergraduateTableByCondition().getTable("学号");
        jf.getContentPane().add(jp3);
        jp3.add(jTable);//默认为按学号排序
        scrollPane = new JScrollPane(jp3);
        jf.getContentPane().add(scrollPane);

        comboBox.addItemListener(e -> {

            switch (comboBox.getSelectedIndex())
            {
                case 0 -> {jp3.removeAll();jp3.updateUI();jp3.add(new UndergraduateTableByCondition().getTable("学号"));}
                case 1 -> {jp3.removeAll();jp3.updateUI();jp3.add(new UndergraduateTableByCondition().getTable("总成绩"));}
                case 2 -> {jp3.removeAll();jp3.updateUI();jp3.add(new UndergraduateTableByCondition().getTable("数学"));}
                case 3 -> {jp3.removeAll();jp3.updateUI();jp3.add(new UndergraduateTableByCondition().getTable("英语"));}
                case 4 -> {jp3.removeAll();jp3.updateUI();jp3.add(new UndergraduateTableByCondition().getTable("Java"));}
            }
            return;
        });

        jf.setBounds(200,200,1500,600);
        WindowUtil.setFrameCenter(jf);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jf.validate();
    }
}
