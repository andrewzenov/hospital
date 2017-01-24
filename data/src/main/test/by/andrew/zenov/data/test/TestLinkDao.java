//package by.andrew.zenov.data.test;
//
//import by.andrew.zenov.data.TestUtil;
//import by.andrew.zenov.data.dao.departmentDao;
//import by.andrew.zenov.data.dao.DepartmentDao;
//import by.andrew.zenov.data.model.Department;
//import by.andrew.zenov.data.model.Department;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.HashSet;
//import java.util.Set;
//
//
//@ContextConfiguration(locations = "classpath:data-spring-context-test.xml")
//@RunWith(SpringJUnit4ClassRunner.class)
//public class TestDepartmentDao {
//
//    @Autowired
//    private DepartmentDao departmentDao;
//
//    @Autowired
//    private TestUtil testUtil;
//
//    @Test
//    @Transactional
//    @Rollback(true)
//    public void testInsertDepartment() {
//
//        Set<Department> DepartmentSet = testUtil.createDepartmentSet();
//        for (Department Department : DepartmentSet) {
//            DepartmentDao.insert(Department);
//        }
//
//        Set<Department> departmentSetDb = new HashSet<>();
//        for (Department department : DepartmentDao.getAll()) {
//            DepartmentSet.add(Department);
//        }
//
//        Department Department = testUtil.createDepartment();
//        Department.setDepartments(DepartmentSetDb);
//
//        int startCount = departmentDao.getAll().size();
//
//        departmentDao.insert(Department);
//        int endCount = departmentDao.getAll().size();
//
//        Assert.assertEquals(1, endCount - startCount);
//
//    }
//
//    @Test
//    @Transactional
//    @Rollback(true)
//    public void testGetById() {
//        Department Department = testUtil.createDepartment();
//        departmentDao.insert(Department);
//        Department DepartmentDb = departmentDao.getAll().get(0);
//        String id = DepartmentDb.getShortUrl();
//
//        Assert.assertEquals(DepartmentDb, departmentDao.get(id));
//    }
//
//    @Test
//    @Transactional
//    @Rollback(true)
//    public void testGetAll() {
//
//        Set<String> shortUrlSet = new HashSet<>();
//        int size = testUtil.getRandomInteger(0, 100);
//
//        Department Department;
//        for (int i = 0; i < size; i++) {
//            Department = testUtil.createDepartment();
//            if (shortUrlSet.add(Department.getShortUrl())) {
//                departmentDao.insert(Department);
//            }
//        }
//
//        Assert.assertEquals(shortUrlSet.size(), departmentDao.getAll().size());
//    }
//
//    @Test
//    @Transactional
//    @Rollback(true)
//    public void testUpdateDepartment() {
//        Department Department = testUtil.createDepartment();
//        departmentDao.insert(Department);
//
//        String sourceUrl = testUtil.getRandomString(1000);
//        String description = testUtil.getRandomString(10000);
//        Long clickCount = (long) testUtil.getRandomInteger(10, 100);
//
//        DepartmentDao.insert(testUtil.createAddress());
//        Department Department = DepartmentDao.getAll().get(0);
//        Set<Department> DepartmentSet = new HashSet<>();
//        DepartmentSet.add(Department);
//
//        Department DepartmentDb = departmentDao.getAll().get(0);
//        DepartmentDb.setDepartments(DepartmentSet);
//        DepartmentDb.setClickCount(clickCount);
//        DepartmentDb.setDescription(description);
//        DepartmentDb.setSourceUrl(sourceUrl);
//
//        departmentDao.update(DepartmentDb);
//
//        Department DepartmentDb2 = departmentDao.get(DepartmentDb.getShortUrl());
//
//        Assert.assertEquals(DepartmentDb2, DepartmentDb);
//    }
//
//    @Test
//    @Transactional
//    @Rollback(true)
//    public void testDeleteUser() {
//        Department Department = testUtil.createDepartment();
//        departmentDao.insert(Department);
//        int size = departmentDao.getAll().size();
//        Department DepartmentDb = departmentDao.getAll().get(0);
//        departmentDao.delete(DepartmentDb.getShortUrl());
//
//        Assert.assertEquals(size - 1, departmentDao.getAll().size());
//    }
//}
