package StudentSystem.frame;

import StudentSystem.bean.Graduate;
import StudentSystem.dao.ManageHelper;
import StudentSystem.util.WindowUtil;

import javax.swing.*;
import java.awt.*;

public class ModifyGraduateFrame extends JDialog {
    private JLabel find_Label;
    private JTextField find_Text;
    private JButton select_Button;	//"确认"按钮。
    private JButton cancel_Button;	//"取消"按钮。
    private JDialog jd;	//当前窗口
    private ManageHelper helper;
    ModifyGraduateFrame (JFrame owner, String title, boolean modal)
    {
        super(owner, title, modal);
        this.jd = this;
        Container c = this.getContentPane();
        find_Label = new JLabel("请输入学生学号");
        find_Label.setBounds(120,100,100,25);
        find_Text = new JTextField(10);
        find_Text.setBounds(120,150,100,25);
        c.add(find_Label);
        c.add(find_Text);
        select_Button = new JButton("确认");
        select_Button.setBounds(70, 268, 60, 25);
        select_Button.addActionListener(e -> {
            if (!find_Text.getText().equals(""))
            {
                helper = new ManageHelper();
                Graduate graduate = helper.getGraduate(Integer.parseInt(find_Text.getText()));
                if(graduate != null)
                {
                    ModifyGraduateDetailFrame modifyGraduateDetailFrame =
                        new ModifyGraduateDetailFrame(jd,"修改界面",true,Integer.parseInt(find_Text.getText()),graduate);
                }
                else
                {
                    JOptionPane.showMessageDialog(jd,"没有该学生！","提示",JOptionPane.WARNING_MESSAGE);
                }

            }
            else
            {
                JOptionPane.showMessageDialog(jd,"输入不能为空！","提示",JOptionPane.WARNING_MESSAGE);
            }

        });
        c.add(select_Button);


        cancel_Button = new JButton("取消");
        cancel_Button.setBounds(230, 268, 60, 25);
        //注册"取消"按钮事件监听
        cancel_Button.addActionListener(arg0 -> jd.dispose());
        c.add(cancel_Button);

        c.validate();
        this.setSize(350, 389);    //设置窗体大小。
        this.setLayout(null);    //设置空布局。
        WindowUtil.setFrameCenter(this);
        this.setResizable(false);
        this.setVisible(true);
    }
}
