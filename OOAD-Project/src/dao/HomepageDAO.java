package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import po.Course;
import util.DBHelper;

//  Display the list of courses sorted by NO. of course	
public class HomepageDAO {

	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	public static List<Course> displayCourses() {
		List<Course> res = new LinkedList<>(); 
		con = DBHelper.getConnection();// 通过DBHelper得到Connection
		System.out.println("start query course list");
		String sql = "select * from course";// 查询语句，先把username设置为？，后面在赋值
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();// 执行查询语句，返回一个ResultSet
			while (rs.next()) {
				Course course=new Course();  
				course.setId(rs.getLong("course_id"));  
				course.setName(rs.getString("course_name"));  
				course.setDescription(rs.getString("description")); 
				course.setNumber(rs.getLong("course_number")); 
				course.setTrack(rs.getString("track"));  
                res.add(course);  
                
			}
			// todo: sort by course number
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 这里是一些操作数据库之后的一些关闭操作
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				rs = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				ps = null;
			}
		}
		return res;
	}
}
