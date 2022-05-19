package StudentSystem.model;

import StudentSystem.bean.Graduate;
import StudentSystem.dao.ManageHelper;

import javax.swing.*;
import java.util.ArrayList;

public class GraduateTableByCondition {
    private String[] columName;
    private ArrayList<Graduate> allGraduate;
    private ManageHelper helper;

    private JTable jTable ;
    public JTable getTable(String condition)
    {
        helper = new ManageHelper();
        allGraduate = helper.getAllGraduate();
        Sort.graduateBy(allGraduate,condition);
        columName =new String[] {"学号","姓名","年龄","班级","专业","导师","省份","城市","街道","门牌号","数学","数据库","英语","总分"};
        int width = allGraduate.size();

        Object[][] a = new Object[width+1][14];
        a[0] = columName;
        for (int i = 0; i < width; i++) {
            a[i+1][0] = allGraduate.get(i).getId();
            a[i+1][1] = allGraduate.get(i).getName();
            a[i+1][2] = allGraduate.get(i).getAge();
            a[i+1][3] = allGraduate.get(i).getClassS();
            a[i+1][4] = allGraduate.get(i).getMajor();
            a[i+1][5] = allGraduate.get(i).getTutor();
            a[i+1][6] = allGraduate.get(i).getAddress().getProvince();
            a[i+1][7] = allGraduate.get(i).getAddress().getCity();
            a[i+1][8] = allGraduate.get(i).getAddress().getStreet();
            a[i+1][9] = allGraduate.get(i).getAddress().getDoor();
            a[i+1][10] = allGraduate.get(i).getScore().MathS;
            a[i+1][11] = allGraduate.get(i).getScore().MySQL;
            a[i+1][12] = allGraduate.get(i).getScore().English;
            a[i+1][13] = allGraduate.get(i).getSumScore();
        }
        jTable = new JTable(a,columName);
        jTable.setRowHeight(40);
        return jTable;
    }
}
