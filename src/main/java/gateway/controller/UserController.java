package gateway.controller;

import gateway.model.User;
import gateway.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by yangyue on 2016/9/10.
 * Class UserController
 * 用于后期超级管理员管理登录用户及权限扩展
 * (时未用到)
 * 提供增删改查
 * QAQ没有测试
 */
@Controller
public class UserController {

  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  @RequestMapping(value="/query")
  @ResponseBody
  public String query(){
    User user = userDao.query();
    return user.getPassword().toString();
  }

  /**
   * Create a new user with an auto-generated id and password and name as passed
   * values.
   */
  @RequestMapping(value="/create")
  @ResponseBody
  public String create(String username, String password) {
    try {
      User user = new User(username, password);
      userDao.create(user);
    }
    catch (Exception ex) {
      return "Error creating the user: " + ex.toString();
    }
    return "User succesfully created!";
  }
  
  /**
   * Delete the user with the passed id.
   */
  @RequestMapping(value="/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      User user = new User(id);
      userDao.delete(user);
    }
    catch (Exception ex) {
      return "Error deleting the user: " + ex.toString();
    }
    return "User succesfully deleted!";
  }
  
  /**
   * Created by yangyue on 2016/9/10.
   * Retrieve the id for the user with the passed username
   */
  @RequestMapping(value="/get-by-username")
  @ResponseBody
  public String getByUsername(String username) {
    String userId;
    try {
      User user = userDao.getByUsername(username);
      userId = String.valueOf(user.getId());
    }
    catch (Exception ex) {
      return "User not found: " + ex.toString();
    }
    return "The user id is: " + userId;
  }
  
  /**
   * Update the username and the password for the user indentified by the passed id.
   */
  @RequestMapping(value="/update")
  @ResponseBody
  public String updateName(long id, String password, String username) {
    try {
      User user = userDao.getById(id);
      user.setUsername(username);
      user.setPassword(password);
      userDao.update(user);
    }
    catch (Exception ex) {
      return "Error updating the user: " + ex.toString();
    }
    return "User updated succesfully!";
  }

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  // Wire the UserDao used inside this controller.
  @Autowired
  private UserDao userDao;
  
} // class UserController
