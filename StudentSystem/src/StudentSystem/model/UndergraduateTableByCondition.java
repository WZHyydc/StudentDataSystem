package StudentSystem.model;

import StudentSystem.bean.Undergraduate;
import StudentSystem.dao.ManageHelper;

import javax.swing.*;
import java.util.ArrayList;

public class UndergraduateTableByCondition {
    private String[] columName;
    private ArrayList<Undergraduate> allUndergraduate;
    private ManageHelper helper;
    private JTable jTable ;
    public JTable getTable(String condition)
    {
        helper = new ManageHelper();
        allUndergraduate = helper.getAllUndergraduate();
        Sort.undergraduateBy(allUndergraduate,condition);
        columName =new String[] {"学号","姓名","年龄","班级","专业","省份","城市","街道","门牌号","数学","Java","英语","总分"};
        int width = allUndergraduate.size();

        Object[][] a = new Object[width+1][13];
        a[0] = columName;
        for (int i = 0; i < width; i++) {
            a[i+1][0] = allUndergraduate.get(i).getId();
            a[i+1][1] = allUndergraduate.get(i).getName();
            a[i+1][2] = allUndergraduate.get(i).getAge();
            a[i+1][3] = allUndergraduate.get(i).getClassS();
            a[i+1][4] = allUndergraduate.get(i).getMajor();
            a[i+1][5] = allUndergraduate.get(i).getAddress().getProvince();
            a[i+1][6] = allUndergraduate.get(i).getAddress().getCity();
            a[i+1][7] = allUndergraduate.get(i).getAddress().getStreet();
            a[i+1][8] = allUndergraduate.get(i).getAddress().getDoor();
            a[i+1][9] = allUndergraduate.get(i).getScore().MathS;
            a[i+1][10] = allUndergraduate.get(i).getScore().Java;
            a[i+1][11] = allUndergraduate.get(i).getScore().English;
            a[i+1][12] = allUndergraduate.get(i).getSumScore();
        }
        jTable = new JTable(a,columName);
        jTable.setRowHeight(40);
        return jTable;
    }
}
