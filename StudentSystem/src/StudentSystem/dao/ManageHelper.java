package StudentSystem.dao;

import StudentSystem.bean.Graduate;
import StudentSystem.bean.Undergraduate;
import StudentSystem.bean.User;

import java.util.ArrayList;

//数据库业务处理类
public class ManageHelper {
    private JdbcHelper helper;	//与数据库通信的对象
    /**
     * 登陆业务处理
     * @param user	用户对象
     * @return 返回是否成功登陆
     */
    public boolean Login(User user){
        boolean b = true;
        helper = new JdbcHelper();	//创建与数据库通信的对象
        User newUser = helper.getUser(user);	//获得用户数据
        if(!user.getPassword().equals(newUser.getPassword())){	//比对密码与数据库中的对应密码是否一致
            b = false;
        }
        helper.close();//关闭资源
        return b;
    }

    /**
     * 注册业务处理
     * @param user 用户对象
     * @return	返回是否注册成功
     */
    public boolean Register(User user){
        helper = new JdbcHelper();//创建与数据库通信的对象
        boolean b = helper.register(user);
        helper.close();//关闭资源
        return b;
    }

    /**
     * 修改密码业务处理
     * @param user	用户对象
     * @param new_Password	新密码
     * @return 返回是否修改成功
     */
    public boolean update_Password(User user,String new_Password){
        boolean b;
        helper = new JdbcHelper();//创建与数据库通信的对象
        b = helper.update_Password(user, new_Password);
        helper.close();//关闭资源
        return b;
    }

    /**
     * 添加研究生
     * @param graduate	研究生对象
     * @return	返回是否添加成功
     */
    public boolean addGraduate(Graduate graduate)
    {
        boolean b = true;
        helper = new JdbcHelper();
        b = helper.addGraduate(graduate);
        helper.close();
        return b;
    }

    /**
     * 添加本科生
     * @param undergraduate	本科生对象
     * @return	返回是否添加成功
     */
    public boolean addUndergraduate(Undergraduate undergraduate)
    {
        boolean b = true;
        helper = new JdbcHelper();
        b = helper.addUndergraduate(undergraduate);
        helper.close();
        return b;
    }

    /**
     * 修改研究生信息
     * @param graduate	新研究生对象
     * @param oldGraduateID	旧研究生信息
     * @return	是否修改成功
     */
    public boolean updateGraduate (Graduate graduate,int oldGraduateID)
    {
        boolean b = true;
        helper = new JdbcHelper();
        b = helper.updateGraduate(graduate,oldGraduateID);
        helper.close();
        return b;
    }

    /**
     * 修改本科生信息
     * @param undergraduate	新本科生对象
     * @param oldGraduateID	旧本科生信息
     * @return	是否修改成功
     */
    public boolean updateUndergraduate (Undergraduate undergraduate,int oldGraduateID)
    {
        boolean b = true;
        helper = new JdbcHelper();
        b = helper.updateUndergraduate(undergraduate,oldGraduateID);
        helper.close();
        return b;
    }

    /**
     * 根据学号从数据库移除该学生
     * @return	返回是否删除成功
     */

    public boolean deleteGraduate(int graduateID)
    {
        boolean b = true;
        helper = new JdbcHelper();
        b = helper.deleteGraduate(graduateID);
        return b;
    }

    public boolean deleteUndergraduate(int undergraduateID)
    {
        boolean b = true;
        helper = new JdbcHelper();
        b = helper.deleteUndergraduate(undergraduateID);
        return b;
    }

    /**
     *得到所有的研究生信息
     * @return arrayList<Graduate>
     **/
    public ArrayList<Graduate> getAllGraduate ()
    {
        helper = new JdbcHelper();
        return helper.getAllGraduate();
    }

    /**
     *得到所有的本科生信息
     * @return arrayList<Undergraduate>
     **/
    public ArrayList<Undergraduate> getAllUndergraduate ()
    {
        helper = new JdbcHelper();
        return helper.getAllUndergraduate();
    }

    /**
     *根据学号查找研究生信息
     * @return graduate or null
     **/

    public Graduate getGraduate (int newStudentID)
    {
        helper = new JdbcHelper();
        return helper.getGraduate(newStudentID);
    }

    /**
     *根据班级姓名查找研究生信息
     * @return graduate or null
     **/
    public Graduate getGraduate (int newStudentClassS,String newStudentName)
    {
        helper = new JdbcHelper();
        return helper.getGraduate(newStudentClassS,newStudentName);
    }

    /**
     *根据学号查找本科生信息
     * @return undergraduate or null
     **/

    public Undergraduate getUndergraduate (int newStudentID)
    {
        helper = new JdbcHelper();
        return helper.getUndergraduate(newStudentID);
    }

    /**
     *根据班级姓名查找本科生信息
     * @return undergraduate or null
     **/

    public Undergraduate getUndergraduate (int newStudentClassS,String newStudentName)
    {
        helper = new JdbcHelper();
        return helper.getUndergraduate(newStudentClassS,newStudentName);
    }

    }

