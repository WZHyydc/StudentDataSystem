package StudentSystem.frame;

import StudentSystem.dao.ManageHelper;
import StudentSystem.util.WindowUtil;

import javax.swing.*;

public class DeleteGraduateFrame extends JDialog {
    private JButton delete_Button;	//"删除"按钮。
    private JButton cancel_Button;	//"取消"按钮。
    private JLabel student_ID;    //"学号"标签。
    private JTextField student_IDText;	    //"学号"文本域。
    private JDialog jd;	//当前窗口。
    private ManageHelper helper;

    public DeleteGraduateFrame (JFrame owner, String title, boolean modal)
    {
        super(owner, title, modal);
        helper = new ManageHelper();    //创建数据库业务处理对象
        this.jd = this;
        this.setSize(400, 300);    //设置窗体大小。
        this.setLayout(null);    //设置空布局。
        student_ID = new JLabel("请输入学号:");
        student_ID.setBounds(78, 48, 100, 20);
        this.add(student_ID);

        student_IDText = new JTextField();
        student_IDText.setBounds(146, 48, 100, 20);
        this.add(student_IDText);
        delete_Button = new JButton("删除");
        delete_Button.setBounds(70, 88, 60, 25);
        delete_Button.addActionListener(e -> {
            if (helper.deleteGraduate(Integer.parseInt(student_IDText.getText())))
            {
                    JOptionPane.showMessageDialog(jd, "删除成功！");
                    jd.dispose();	//关闭当前窗口
                    return ;
            }else
            {
                JOptionPane.showMessageDialog(jd, "删除失败！", "", JOptionPane.WARNING_MESSAGE);
                jd.dispose();	//关闭当前窗口
                return;
            }
        });
        this.add(delete_Button);

        cancel_Button = new JButton("取消");
        cancel_Button.setBounds(230, 88, 60, 25);
        //注册"取消"按钮事件监听
        cancel_Button.addActionListener(arg0 -> jd.dispose());
        this.add(cancel_Button);
        WindowUtil.setFrameCenter(this);
        this.setResizable(false);
        this.setVisible(true);
    }

}
