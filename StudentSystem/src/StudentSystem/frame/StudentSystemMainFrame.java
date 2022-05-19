package StudentSystem.frame;

import StudentSystem.bean.User;
import StudentSystem.util.WindowUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class StudentSystemMainFrame extends JFrame {
//    private User user;
//    ???
    private JFrame jf;
    private JMenuBar menuBar;	//应用菜单条。
    private JMenu graduate_Management;	    //"研究生管理"菜单
    private JMenuItem add_graduate;	        //"添加研究生"菜单项
    private JMenuItem query_graduate;       //"查询研究生"菜单项
    private JMenuItem delete_graduate;      //"删除研究生"菜单项
    private JMenuItem modify_graduate;      //"修改研究生"菜单项
    private JMenu undergraduate_Management;	//"本科生管理"菜单
    private JMenuItem add_undergraduate;	//"添加本科生"菜单项
    private JMenuItem delete_undergraduate;      //"删除本科生"菜单项
    private JMenuItem query_undergraduate; //"查询本科生"菜单项
    private JMenuItem modify_undergraduate;      //"修改研究生"菜单项
    private JMenu browse_information;	//"信息浏览"菜单
    private JMenuItem browse_graduate;          //"浏览研究生菜单项"
    private JMenuItem browse_undergraduate;     //"浏览本科生菜单项"
    public StudentSystemMainFrame(User user)
    {
        super("学生成绩管理系统,欢迎你"+user.getUsername());

        this.jf = this;
        menuBar = new JMenuBar();	//创建菜单条。
        this.setJMenuBar(menuBar);	//添加菜单条。

        graduate_Management = new JMenu("研究生管理");
        menuBar.add(graduate_Management);
        undergraduate_Management = new JMenu("本科生管理");
        menuBar.add(undergraduate_Management);
        browse_information = new JMenu("信息总览");
        menuBar.add(browse_information);


        add_graduate = new JMenuItem("添加学生");//创建"添加学生"菜单项。
        //注册"添加学生"菜单项事件监听
        add_graduate.addActionListener(e -> {
            // TODO Auto-generated method stub
            AddGraduateFrame addStudentFrame = new AddGraduateFrame(jf,"添加学生",true);
        });
        graduate_Management.add(add_graduate);

        delete_graduate = new JMenuItem("删除学生");//创建"删除学生"菜单项。
        //注册"删除学生"菜单项事件监听
        delete_graduate.addActionListener(e -> {
            // TODO Auto-generated method stub
           DeleteGraduateFrame deleteGraduateFrame = new DeleteGraduateFrame(jf,"删除学生",true);
        });
        graduate_Management.add(delete_graduate);

        query_graduate = new JMenuItem("查找学生");
        query_graduate.addActionListener(e -> {
            QueryGraduateFrame queryGraduateFrame = new QueryGraduateFrame(jf,"查找学生",true);
        });
        graduate_Management.add(query_graduate);

        modify_graduate = new JMenuItem("修改学生信息");      //创建"修改研究生"菜单项
        modify_graduate.addActionListener(e -> {
            ModifyGraduateFrame modifyGraduateFrame = new ModifyGraduateFrame(jf,"选择学生",true);
        });
        graduate_Management.add(modify_graduate);



        add_undergraduate = new JMenuItem("添加学生");//创建"添加学生"菜单项。
        //注册"添加学生"菜单项事件监听
        add_undergraduate.addActionListener(e -> {
            AddUndergraduateFrame addStudentFrame = new AddUndergraduateFrame(jf,"添加学生",true);
        });
        undergraduate_Management.add(add_undergraduate);

        delete_undergraduate = new JMenuItem("删除学生");//创建"删除学生"菜单项。
        //注册"删除学生"菜单项事件监听
        delete_undergraduate.addActionListener(e -> {
            // TODO Auto-generated method stub
            DeleteUndergraduateFrame deleteUndergraduateFrame = new DeleteUndergraduateFrame(jf,"删除学生",true);
        });
        undergraduate_Management.add(delete_undergraduate);

        query_undergraduate = new JMenuItem("查找学生");
        query_undergraduate.addActionListener(e -> {
            QueryUndergraduateFrame queryUndergraduateFrame= new QueryUndergraduateFrame(jf,"查找学生",true);
        });
        undergraduate_Management.add(query_undergraduate);

        modify_undergraduate = new JMenuItem("修改学生信息");      //创建"修改研究生"菜单项
        modify_undergraduate.addActionListener(e -> {
            ModifyUndergraduateFrame modifyUndergraduateFrame = new ModifyUndergraduateFrame(jf,"选择学生",true);
        });
        undergraduate_Management.add(modify_undergraduate);


        browse_graduate = new JMenuItem("研究生信息总览");
        browse_graduate.addActionListener(e -> {
            BrowseGraduateFrame browseGraduateFrame = new BrowseGraduateFrame("研究生信息一览表");
        });
        browse_information.add(browse_graduate);

        browse_undergraduate = new JMenuItem("本科生信息总览");
        browse_undergraduate.addActionListener(e -> {
            BrowseUndergraduateFrame browseUndergraduateFrame = new BrowseUndergraduateFrame("本科生信息一览表");
        });
        browse_information.add(browse_undergraduate);

        this.setSize(578, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        WindowUtil.setFrameCenter(this);//设置窗体居中。
        ImagePanel imagePanel = new ImagePanel();
        setContentPane(imagePanel);

        try {
            Image img = ImageIO.read(this.getClass().getResource("/2.png"));
            this.setIconImage(img);

        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        this.setVisible(true);//设置窗体可见。
    }



}
