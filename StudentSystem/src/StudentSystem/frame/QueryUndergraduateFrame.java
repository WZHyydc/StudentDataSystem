package StudentSystem.frame;

import StudentSystem.dao.ManageHelper;
import StudentSystem.util.WindowUtil;

import javax.swing.*;
import java.awt.*;

public class QueryUndergraduateFrame extends JDialog {
    private ButtonGroup buttonGroup;
    private JRadioButton radioID,radioCN;
    private JButton query_Button;//"查询"按钮
    private JPanel jp1,jp2,jp3;	//面板
    private JTextField ID_Text;	//"查询"文本域
    private JTextField C_Text;	//"查询"文本域
    private JTextField N_Text;	//"查询"文本域
    private JLabel query_Label;	//标签
    private JLabel ID_Label;
    private JLabel N_Label;
    private JLabel C_Label;
    private JDialog jd;	//当前窗口
    private ManageHelper helper;
    QueryUndergraduateFrame(JFrame owner, String title, boolean modal)
    {


        super(owner, title, modal);
        this.jd = this;
        Container c = this.getContentPane();
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        buttonGroup = new ButtonGroup();
        radioID = new JRadioButton("学号");
        radioCN = new JRadioButton("班级和姓名");
        jp1.add(radioID);
        jp1.add(radioCN);
        buttonGroup.add(radioID);
        buttonGroup.add(radioCN);



        query_Label = new JLabel("请输入查询信息:");
        N_Label = new JLabel("姓名:");
        ID_Label = new JLabel("学号:");
        C_Label = new JLabel("班级:");
        ID_Text = new JTextField(10);
        C_Text =  new JTextField(10);
        N_Text =  new JTextField(10);

        Box boxH = Box.createVerticalBox();
        Box boxI = Box.createHorizontalBox();
        Box boxC = Box.createHorizontalBox();
        Box boxN = Box.createHorizontalBox();
        boxI.add(ID_Label);
        boxI.add(ID_Text);
        boxC.add(C_Label);
        boxC.add(C_Text);
        boxN.add(N_Label);
        boxN.add(N_Text);
        boxH.add(boxI);
        boxH.add(Box.createVerticalStrut(10));
        boxH.add(boxC);
        boxH.add(Box.createVerticalStrut(10));
        boxH.add(boxN);
        jp2.add(boxH);

        buttonGroup.setSelected(radioID.getModel(),true);
        buttonGroup.setSelected(radioCN.getModel(), true);
        query_Button = new JButton("查询");
        //注册"查询"按钮事件监听
        query_Button.addActionListener(e -> {
            helper = new ManageHelper();
            if (radioID.isSelected()) {
                if (!ID_Text.getText().equals("")) {
                    if (helper.getUndergraduate(Integer.parseInt(ID_Text.getText())) != null) {
                        ShowUndergraduateFrame showUndergraduateFrame =
                                new ShowUndergraduateFrame(jd, "学生信息展示", helper.getUndergraduate(Integer.parseInt(ID_Text.getText())));
                    } else {
                        JOptionPane.showMessageDialog(jd, "没有找到此学生！");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(jd, "学号输入不能为空！");
                    return;
                }
            } else
            {
                if (!C_Text.getText().equals("") && !C_Label.getText().equals(""))
                {
                    if (helper.getUndergraduate(Integer.parseInt(C_Text.getText()), N_Text.getText()) != null)
                    {
                        ShowUndergraduateFrame showUndergraduateFrame =
                                new ShowUndergraduateFrame(jd, "学生信息展示", helper.getUndergraduate(Integer.parseInt(C_Text.getText()), N_Text.getText()));
                    } else
                    {
                        JOptionPane.showMessageDialog(jd, "没有找到此学生！");
                        return;
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(jd,"班级和姓名输入不能为空！");
                    return;
                }
            }
        });
        jp3.add(query_Button,BorderLayout.CENTER);
        c.add(jp1,BorderLayout.NORTH);
        c.add(jp2,BorderLayout.CENTER);
        c.add(jp3,BorderLayout.SOUTH);
        c.validate();
        this.setSize(400,240);

        WindowUtil.setFrameCenter(this);
        this.setResizable(false);
        this.setVisible(true);
    }
}
