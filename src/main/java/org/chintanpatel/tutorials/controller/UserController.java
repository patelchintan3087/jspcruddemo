package org.chintanpatel.tutorials.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.chintanpatel.tutorials.bean.UserBean;
import org.chintanpatel.tutorials.dao.UserDao;

import java.io.IOException;

@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {
	private static final String INSERT_OR_UPDATE = "user.jsp";
	private static final String USER_LIST = "user.jsp";
	private static final String ERROR = "error.jsp";
	private UserDao userDao;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardCall;
		String actionCall = request.getParameter("action");
		if (actionCall.equalsIgnoreCase("delete")) {
			forwardCall = USER_LIST;
			int userId = Integer.parseInt(request.getParameter("userId"));
			boolean isDelete = userDao.deleteUserById(userId);
			if (isDelete) {
				request.setAttribute("userList",userDao.getAllUserList());
			} else {
				request.getRequestDispatcher(ERROR).include(request,response);
			}
		} else if (actionCall.equalsIgnoreCase("edit")) {
			forwardCall = INSERT_OR_UPDATE;
			int userId = Integer.parseInt(request.getParameter("userId"));
			UserBean userBean = userDao.getUserById(userId);
			request.setAttribute("userBean",userBean);
			request.setAttribute("userList",userDao.getAllUserList());
		} else if (actionCall.equalsIgnoreCase("insert")) {
			forwardCall = INSERT_OR_UPDATE;
			request.setAttribute("userList",userDao.getAllUserList());
		} else {
			forwardCall = USER_LIST;
			request.setAttribute("userList",userDao.getAllUserList());
		}
		RequestDispatcher viewCall = request.getRequestDispatcher(forwardCall);
		viewCall.forward(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserBean userBean = new UserBean();
		userBean.setFirstName(request.getParameter("firstName"));
		userBean.setLastName(request.getParameter("lastName"));
		userBean.setEmailId(request.getParameter("emailId"));
		userBean.setMobile(Long.parseLong(request.getParameter("mobile")));
		userBean.setUserName(request.getParameter("userName"));
		userBean.setPassword(request.getParameter("password"));
		String userId = request.getParameter("userId");

		if (userId == null || userId.isEmpty()) {
			boolean isInsert = userDao.insertUser(userBean);
			if (isInsert) {
				RequestDispatcher viewCall = request.getRequestDispatcher(USER_LIST);
				request.setAttribute("userList",userDao.getAllUserList());
				viewCall.forward(request,response);
			} else {
					request.getRequestDispatcher(ERROR).include(request,response);
			}
		} else {
			userBean.setUserId(Integer.parseInt(userId));
			boolean isUpdate = userDao.updateUser(userBean);
			if (isUpdate) {
				RequestDispatcher viewCall = request.getRequestDispatcher(USER_LIST);
				request.setAttribute("userList",userDao.getAllUserList());
				viewCall.forward(request,response);
			} else {
				request.getRequestDispatcher(ERROR).include(request,response);
			}
		}
	}
}
