package Mybatis;

import java.util.List;
import java.util.Map;

public interface IStudentDao {
    void insertStudent(Student student); //添加
 
    void insertStudentCacheId(Student student);//添加并返回此学生id
 
    void deleteStudentById(int id);//删除学生
 
    void updateStudentById(Student student);//修改学生
 
    List<Student> selectAllStudents();//查询所有学生，返回List
 
    Map<String, Object> selectAllStudentsMap();//查询所有学生，返回Map
 
    Student selectById(int id);//根据id查询
 
    List<Student> selectByName(String name);//根据name查询
}
