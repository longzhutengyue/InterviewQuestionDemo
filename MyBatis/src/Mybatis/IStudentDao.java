package Mybatis;

import java.util.List;
import java.util.Map;

public interface IStudentDao {
    void insertStudent(Student student); //���
 
    void insertStudentCacheId(Student student);//��Ӳ����ش�ѧ��id
 
    void deleteStudentById(int id);//ɾ��ѧ��
 
    void updateStudentById(Student student);//�޸�ѧ��
 
    List<Student> selectAllStudents();//��ѯ����ѧ��������List
 
    Map<String, Object> selectAllStudentsMap();//��ѯ����ѧ��������Map
 
    Student selectById(int id);//����id��ѯ
 
    List<Student> selectByName(String name);//����name��ѯ
}
