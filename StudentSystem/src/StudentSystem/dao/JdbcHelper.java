package StudentSystem.dao;

import StudentSystem.bean.*;

import java.sql.*;
import java.util.ArrayList;

public class JdbcHelper implements JdbcConfig{
    //定义连接数据库所需要的对象
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Connection ct = null;


    //获得数据库的连接
    private  void init(){
        try {
            Class.forName(DRIVER);
            ct = DriverManager.getConnection(URL, USERNAME, PASSWORD);// 获得数据库连接
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //无参构造函数
    public JdbcHelper(){
        this.init();
    }

    /**
     * 获取用户对象
     * 根据传入的用户名，获取对应的用户，并返回用户对象
     * @return 用户对象
     */
    public User getUser(User user){
        User newUser = new User();
        try {
            ps = ct.prepareStatement("select * from tb_User where User_name=?");
            ps.setString(1, user.getUsername());
            rs = ps.executeQuery();
            if(rs.next()){
                newUser.setUsername(rs.getString(1));	//设置用户名
                newUser.setPassword(rs.getString(2));	//设置密码
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newUser;
    }

    /**
     * 注册处理
     * @param user	用户对象
     * @return	返回是否注册成功
     */
    public boolean register(User user){
        boolean b = true;
        try {
            ps = ct.prepareStatement("insert into tb_User(User_Name,Password) values(?,?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            if(ps.executeUpdate()!=1){	//执行sql语句
                b = false;
            }
        } catch (SQLException e) {
            b = false;
            e.printStackTrace();
        }
        return b;
    }

    /**
     * 修改密码
     * @param user  用户对象
     * @param new_Password 新密码
     * @return	返回是否修改成功
     */
    public boolean update_Password(User user,String new_Password){
        boolean b = true;
        try {
            ps = ct.prepareStatement("update tb_User set Password =? where User_name=?");
            ps.setString(1, new_Password);
            ps.setString(2, user.getUsername());
            if(ps.executeUpdate()!=1){	//执行sql语句
                b = false;
            }
        } catch (SQLException e) {
            b = false;
            e.printStackTrace();
        }
        return b;
    }

    /**
     * 添加研究生
     * @param graduate	研究生对象
     * @return	返回是否添加成功
     */
    public boolean addGraduate(Graduate graduate){
        boolean b = true;
        try {
            ps = ct.prepareStatement("insert into graduate(StudentID,StudentName,StudentAge,StudentClass," +
                    "StudentMajor," +"StudentTutor,"+
                    "StudentAdP,StudentAdC,StudentAdS,StudentAdD,StudentSMath,StudentSMySQL,StudentSEng) " +
                    "values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            psSet(graduate);

            if(ps.executeUpdate()!=1){
                b = false;
            }
        } catch (SQLException e) {
            b = false;
            e.printStackTrace();
        }
        return b;
    }
    /**
     * 添加本科生
     * @param undergraduate 本科生对象
     * @return	返回是否添加成功
     */
    public boolean addUndergraduate(Undergraduate undergraduate){
        boolean b = true;
        try {
            ps = ct.prepareStatement("insert into undergraduate(UStudentID,UStudentName,UStudentAge,UStudentClass," +
                    "UStudentMajor," +
                    "UStudentAdP,UStudentAdC,UStudentAdS,UStudentAdD,UStudentSMath,UStudentSJava,UStudentSEng) " +
                    "values(?,?,?,?,?,?,?,?,?,?,?,?)");
            psSet(undergraduate);

            if(ps.executeUpdate()!=1){
                b = false;
            }
        } catch (SQLException e) {
            b = false;
            e.printStackTrace();
        }
        return b;
    }

    /**
     * 修改研究生信息
     * @param graduate	新研究生对象
     * @param oldGraduateID	旧研究生信息
     * @return	是否修改成功
     */
    public boolean updateGraduate(Graduate graduate,int oldGraduateID){
        boolean b = true;
        try {
            //update
            ps = ct.prepareStatement("update graduate set StudentID=?, StudentName=?, StudentAge=? ,StudentClass=? ," +
                    "StudentMajor=?  ,StudentTutor=? ," +
                    "StudentAdP=? ,StudentAdC=? ,StudentAdS=?,StudentAdD=?,StudentSMath=?,StudentSMySQL=?,StudentSEng=?" +
                    " where StudentId=?");
            psSet(graduate);
            ps.setInt(14,oldGraduateID);
            if(ps.executeUpdate()!=1){
                b = false;
            }
        } catch (SQLException e) {
            b = false;
            e.printStackTrace();
        }
        return b;
    }

    /**
     * 修改本科生信息
     * @param undergraduate	新本科生对象
     * @param oldUndergraduateID	旧本科生信息
     * @return	是否修改成功
     */
    public boolean updateUndergraduate(Undergraduate undergraduate,int oldUndergraduateID){
        boolean b = true;
        try {
            //update
            ps = ct.prepareStatement("update undergraduate set UStudentID=?, UStudentName=?, UStudentAge=? ,UStudentClass=? ," +
                    "UStudentMajor=?  ," +
                    "UStudentAdP=? ,UStudentAdC=? ,UStudentAdS=?,UStudentAdD=?,UStudentSMath=?,UStudentSJava=?,UStudentSEng=?" +
                    " where UStudentID=?");
            psSet(undergraduate);
            ps.setInt(13,oldUndergraduateID);
            if(ps.executeUpdate()!=1){
                b = false;
            }
        } catch (SQLException e) {
            b = false;
            e.printStackTrace();
        }
        return b;
    }

    /**
     * 根据学号从数据库移除该学生
     * 实现方法重载
     * @return	返回是否删除成功
     */

    public boolean deleteGraduate(int graduateID){
        boolean b = true;
        try {
            ps = ct.prepareStatement("delete from graduate where StudentId=?");
            ps.setInt(1, graduateID);
            if(ps.executeUpdate()!=1){
                b = false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            b = false;
            e.printStackTrace();
        }
        return b;
    }

    public boolean deleteUndergraduate(int undergraduateID){
        boolean b = true;
        try {
            ps = ct.prepareStatement("delete from undergraduate where UStudentId=?");
            ps.setInt(1, undergraduateID);
            if(ps.executeUpdate()!=1){
                b = false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            b = false;
            e.printStackTrace();
        }
        return b;
    }


    private void psSet(Graduate graduate) throws SQLException {
        ps.setInt(1, graduate.getId());
        ps.setString(2, graduate.getName());
        ps.setInt(3, graduate.getAge());
        ps.setInt(4, graduate.getClassS());
        ps.setString(5, graduate.getMajor());
        ps.setString(6, graduate.getTutor());
        ps.setString(7, graduate.getAddress().getProvince());
        ps.setString(8, graduate.getAddress().getCity());
        ps.setString(9, graduate.getAddress().getStreet());
        ps.setString(10, graduate.getAddress().getDoor());
        ps.setInt(11, graduate.getMathS());
        ps.setInt(12, graduate.getMySQL());
        ps.setInt(13, graduate.getEnglish());
    }
    //实现方法抽象，减少代码数量
    private void psSet(Undergraduate undergraduate) throws SQLException {
        ps.setInt(1, undergraduate.getId());
        ps.setString(2, undergraduate.getName());
        ps.setInt(3, undergraduate.getAge());
        ps.setInt(4, undergraduate.getClassS());
        ps.setString(5, undergraduate.getMajor());
        ps.setString(6, undergraduate.getAddress().getProvince());
        ps.setString(7, undergraduate.getAddress().getCity());
        ps.setString(8, undergraduate.getAddress().getStreet());
        ps.setString(9, undergraduate.getAddress().getDoor());
        ps.setInt(10, undergraduate.getMathS());
        ps.setInt(11, undergraduate.getJava());
        ps.setInt(12, undergraduate.getEnglish());
    }

    /**
    *得到所有的研究生信息
     * @return arrayList<Graduate>
     **/
    public ArrayList<Graduate> getAllGraduate ()
    {
        ArrayList<Graduate> arrayList = new ArrayList<>();
        try {
            ps = ct.prepareStatement("select * from graduate");
            rs = ps.executeQuery();
            while (rs.next())
            {
                Address address = new Address(rs.getString(7),rs.getString(8),
                        rs.getString(9),rs.getString(10));
                Graduate graduate = new Graduate();
                graduate.setId(rs.getInt(1));
                graduate.setName(rs.getString(2));
                graduate.setAge(rs.getInt(3));
                graduate.setClassS(rs.getInt(4));
                graduate.setMajor(rs.getString(5));
                graduate.setTutor(rs.getString(6));
                graduate.setAddress(address);
                graduate.setMathS(rs.getInt(11));
                graduate.setMySQL(rs.getInt(12));
                graduate.setEnglish(rs.getInt(13));
                arrayList.add(graduate);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return arrayList;
    }

    /**
     *得到所有的本科生信息
     * @return arrayList<Undergraduate>
     **/
    public ArrayList<Undergraduate> getAllUndergraduate ()
    {
        ArrayList<Undergraduate> arrayList = new ArrayList<>();
        try {
            ps = ct.prepareStatement("select * from undergraduate");
            rs = ps.executeQuery();
            while (rs.next())
            {
                Address address = new Address(rs.getString(6),rs.getString(7),
                        rs.getString(8),rs.getString(9));
                Undergraduate undergraduate = new Undergraduate();
                undergraduate.setId(rs.getInt(1));
                undergraduate.setName(rs.getString(2));
                undergraduate.setAge(rs.getInt(3));
                undergraduate.setClassS(rs.getInt(4));
                undergraduate.setMajor(rs.getString(5));
                undergraduate.setAddress(address);
                undergraduate.setMathS(rs.getInt(10));
                undergraduate.setJava(rs.getInt(11));
                undergraduate.setEnglish(rs.getInt(12));
                arrayList.add(undergraduate);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return arrayList;
    }
    /**
     *根据学号查找研究生信息
     * @return graduate or null
     **/

    public Graduate getGraduate (int newStudentID)
    {
        try {
            ps = ct.prepareStatement("select * from graduate where StudentID = ?");
            ps.setInt(1,newStudentID);
            rs = ps.executeQuery();

            return getGraduate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    /**
     *根据班级姓名查找研究生信息
     * @return graduate or null
     **/
    public Graduate getGraduate (int newStudentClassS,String newStudentName)
    {
        try {
            ps = ct.prepareStatement("select * from graduate where StudentClass = ? & StudentName = ?");

            ps.setInt(1,newStudentClassS);
            ps.setString(2,newStudentName);
            rs = ps.executeQuery();
            return getGraduate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //对重复代码进行提取，减少代码量
    private Graduate getGraduate() throws SQLException {
        if(rs.next()){
            Address address = new Address(rs.getString(7),rs.getString(8),
                    rs.getString(9),rs.getString(10));
            Graduate graduate = new Graduate();
            graduate.setId(rs.getInt(1));
            graduate.setName(rs.getString(2));
            graduate.setAge(rs.getInt(3));
            graduate.setClassS(rs.getInt(4));
            graduate.setMajor(rs.getString(5));
            graduate.setTutor(rs.getString(6));
            graduate.setAddress(address);
            graduate.setMathS(rs.getInt(11));
            graduate.setMySQL(rs.getInt(12));
            graduate.setEnglish(rs.getInt(13));
            return graduate;
        }
        else {
            return null;
        }
    }

    /**
     *根据学号查找本科生信息
     * @return undergraduate or null
     **/

    public Undergraduate getUndergraduate (int newStudentID)
    {
        try {
            ps = ct.prepareStatement("select * from undergraduate where UStudentID = ?");

            ps.setInt(1,newStudentID);
            rs = ps.executeQuery();
            return getUndergraduate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *根据班级姓名查找本科生信息
     * @return undergraduate or null
     **/

    public Undergraduate getUndergraduate (int newStudentClassS,String newStudentName)
    {
        try {
            ps = ct.prepareStatement("select * from undergraduate where UStudentClass = ? & UStudentName = ?");

            ps.setInt(1,newStudentClassS);
            ps.setString(2,newStudentName);
            rs = ps.executeQuery();
            return getUndergraduate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    private Undergraduate getUndergraduate() throws SQLException {
        if(rs.next()){
            Address address = new Address(rs.getString(6),rs.getString(7),
                    rs.getString(8),rs.getString(9));
           Undergraduate undergraduate = new Undergraduate();
            undergraduate.setId(rs.getInt(1));
            undergraduate.setName(rs.getString(2));
            undergraduate.setAge(rs.getInt(3));
            undergraduate.setClassS(rs.getInt(4));
            undergraduate.setMajor(rs.getString(5));
            undergraduate.setAddress(address);
            undergraduate.setMathS(rs.getInt(10));
            undergraduate.setJava(rs.getInt(11));
            undergraduate.setEnglish(rs.getInt(12));
            return undergraduate;
        }
        else {
            return null;
        }
    }

    //关闭数据库资源
    public void close()	{
        try {
            if(rs!=null) rs.close();
            if(ps!=null) ps.close();
            if(ct!=null) ct.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
