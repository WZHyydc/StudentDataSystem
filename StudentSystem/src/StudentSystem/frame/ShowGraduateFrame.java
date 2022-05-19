package StudentSystem.frame;

import StudentSystem.bean.Graduate;
import StudentSystem.util.WindowUtil;

import javax.swing.*;

public class ShowGraduateFrame extends JDialog {
    private JLabel student_ID;    //"学号"标签。
    private JLabel student_Name;	//"姓名"标签。
    private JLabel student_Age;	//"年龄"标签。
    private JLabel classS_Label;	//"班级"标签。
    private JLabel major_Label;	//"专业"标签。
    private JLabel province_Label;	//"省份标签。
    private JLabel city_Label;	//"城市"标签。
    private JLabel  street_Label;	//"街道"标签。
    private JLabel  door_Label;	//"门牌号"标签。
    private JLabel  math_Label;	//"数学"标签。
    private JLabel  mysql_Label;	//"数据库"标签。
    private JLabel  english_Label;	//"英语"标签。
    private JLabel tutor_Label;	//"导师"标签。

    private JTextField student_IDText;	    //"学号"文本域。
    private JTextField student_NameText;	//"姓名"文本域。
    private JTextField student_AgeText;
    private JTextField classS_Text;
    private JTextField major_Text;
    private JTextField province_Text;
    private JTextField city_Text;
    private JTextField street_Text;
    private JTextField door_Text;
    private JTextField math_Text;
    private JTextField mysql_Text;
    private JTextField english_Text;
    private JTextField tutor_Text;
    private JDialog jd;	//当前窗口。
    ShowGraduateFrame(JDialog owner, String title, Graduate graduate)
    {
        super(owner,title,true);
        this.jd = this;
        this.setSize(350, 689);    //设置窗体大小。
        this.setLayout(null);    //设置空布局。
        student_ID = new JLabel("学号:");
        student_ID.setBounds(78, 48, 30, 20);
        this.add(student_ID);

        student_IDText = new JTextField();
        student_IDText.setBounds(146, 48, 150, 20);
        this.add(student_IDText);

        student_Name = new JLabel("姓名:");
        student_Name.setBounds(78, 88, 30, 20);
        this.add(student_Name);

        student_NameText = new JTextField();
        student_NameText.setBounds(146, 88, 150, 20);
        this.add(student_NameText);

        student_Age = new JLabel("年龄:");
        student_Age.setBounds(78, 128, 30, 20);
        this.add(student_Age);

        student_AgeText = new JTextField();
        student_AgeText.setBounds(146, 128, 150, 20);
        this.add(student_AgeText);



        classS_Label = new JLabel("班级:");
        classS_Label.setBounds(78, 168, 30, 20);
        this.add(classS_Label);

        classS_Text = new JTextField();
        classS_Text.setBounds(146, 168, 150, 20);
        this.add(classS_Text);

        major_Label = new JLabel("专业:");
        major_Label.setBounds(78, 208, 30, 20);
        this.add(major_Label);


        major_Text = new JTextField();
        major_Text.setBounds(146, 208, 150, 20);
        this.add(major_Text);

        province_Label = new JLabel("省份:");
        province_Label.setBounds(78, 248, 30, 20);
        this.add(province_Label);


        province_Text = new JTextField();
        province_Text.setBounds(146, 248, 150, 20);
        this.add(province_Text);

        city_Label = new JLabel("城市:");
        city_Label.setBounds(78, 288, 30, 20);
        this.add(city_Label);


        city_Text = new JTextField();
        city_Text.setBounds(146, 288, 150, 20);
        this.add(city_Text);

        street_Label = new JLabel("街道:");
        street_Label.setBounds(78, 328, 30, 20);
        this.add(street_Label);


        street_Text = new JTextField();
        street_Text.setBounds(146, 328, 150, 20);
        this.add(street_Text);

        door_Label = new JLabel("门牌号:");
        door_Label.setBounds(78, 368, 60, 20);
        this.add(door_Label);


        door_Text = new JTextField();
        door_Text.setBounds(146, 368, 150, 20);
        this.add(door_Text);

        math_Label = new JLabel("数学:");
        math_Label.setBounds(78, 408, 30, 20);
        this.add(math_Label);


        math_Text = new JTextField();
        math_Text.setBounds(146, 408, 150, 20);
        this.add(math_Text);

        mysql_Label = new JLabel("数据库:");
        mysql_Label.setBounds(78, 448, 60, 20);
        this.add(mysql_Label);


        mysql_Text = new JTextField();
        mysql_Text.setBounds(146, 448, 150, 20);
        this.add(mysql_Text);

        english_Label = new JLabel("英语:");
        english_Label.setBounds(78, 488, 30, 20);
        this.add(english_Label);


        english_Text = new JTextField();
        english_Text.setBounds(146, 488, 150, 20);
        this.add(english_Text);

        tutor_Label = new JLabel("导师:");
        tutor_Label.setBounds(78, 528, 30, 20);
        this.add(tutor_Label);

        tutor_Text= new JTextField();
        tutor_Text.setBounds(146, 528, 150, 20);
        this.add(tutor_Text);

        student_IDText.setText(String.valueOf(graduate.getId()));
        student_NameText.setText(graduate.getName());
        student_AgeText.setText(String.valueOf(graduate.getAge()));
        classS_Text.setText(String.valueOf(graduate.getClassS()));
        major_Text.setText(graduate.getMajor());
        province_Text.setText(graduate.getAddress().getProvince());
        city_Text.setText(graduate.getAddress().getCity());
        street_Text.setText(graduate.getAddress().getStreet());
        door_Text.setText(graduate.getAddress().getDoor());
        math_Text.setText(String.valueOf(graduate.getMathS()));
        mysql_Text.setText(String.valueOf(graduate.getMySQL()));
        english_Text.setText(String.valueOf(graduate.getEnglish()));
        tutor_Text.setText(String.valueOf(graduate.getTutor()));

        WindowUtil.setFrameCenter(this);
        this.setResizable(false);
        this.setVisible(true);
    }
}
