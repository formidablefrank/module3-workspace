package com.example.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Cart;
import com.example.model.Category;
import com.example.model.Inventory;
import com.example.model.Product;
import com.example.model.User;
import com.example.service.ServiceException;
import com.example.service.login.LoginService;
import com.example.service.admin.AdminService;
import com.example.service.cust.CustomerService;

@Controller
public class HomeController {
	
	@Autowired LoginService loginService;
	@Autowired AdminService adminService;
	@Autowired CustomerService customerService;
	
	@RequestMapping(value = "/home")
	public String home(
			HttpServletRequest request,
			HttpSession session){
		request.setAttribute("none", request.getSession().getAttribute("username") == null);
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(
			HttpServletRequest request,
			HttpSession session,
			@RequestParam("username") String username,
			@RequestParam("password") String password){
		User user = null;
		try {
			user = loginService.getUser(username);
		} catch (ServiceException e) {
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		if(user != null && user.getPassword().equals(password)){
			request.getSession(true);
			HttpSession hs = request.getSession();
			hs.setAttribute("username", user.getUsername());
			return "redirect:" + user.getRole().getRoleType();
		}
		else{
			request.setAttribute("loginMsg", "Invalid credentials!");
		}
		return "forward:/home";
	}
	
	@RequestMapping("/logout")
	public String logout(
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session){
		session = request.getSession();
		session.invalidate();
		return "redirect:home";
	}
	
	@RequestMapping("/admin")
	public String admin(
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session){
		return "admin";
	}
	
	@RequestMapping("/categories")
	private String categories(
			HttpServletRequest request,
			HttpSession session){
		List<Category> categoryList = null;
		try {
			categoryList = adminService.getCategories();
			request.setAttribute("categoryList", categoryList);
		} catch (ServiceException e) {
			request.setAttribute("errorMsg", e.getMessage());
		}
		return "categories";
	}
	
	@RequestMapping("/inventory")
	private String inventory(
			HttpServletRequest request,
			@RequestParam(value = "categoryName", required = false) String categoryName){
		if(categoryName == null) categoryName = "";
		Inventory inventory = null;
		Category category = new Category(new Long(0), categoryName);
		List<Category> categoryList = null;
		try {
			categoryList = adminService.getCategories();
			inventory = adminService.viewProducts(category);
			request.setAttribute("inventory", inventory);
			request.setAttribute("category", category);
			request.setAttribute("categoryList", categoryList);
		} catch (ServiceException e) {
			request.setAttribute("errorMsg", e.getMessage());
		}
		return "inventory";
	}
	
	@RequestMapping("/addProduct")
	private String addProduct(
			HttpServletRequest request,
			HttpSession session){
		List<Category> categoryList = null;
		try {
			categoryList = adminService.getCategories();
			request.setAttribute("categoryList", categoryList);
		} catch (ServiceException e) {
			request.setAttribute("errorMsg", e.getMessage());
		}
		return "addProduct";
	}
	
	@RequestMapping("/processAddProduct")
	private String processAddProduct(
			HttpServletRequest request,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "price", required = false) String price,
			@RequestParam(value = "category", required = false) String category,
			@RequestParam(value = "qty", required = false) String quantity){
		if(name == null || price == null || category == null || quantity == null
				|| name.trim().equals("") || price.trim().equals("") || category.trim().equals("") || quantity.trim().equals("")){
			request.setAttribute("errorMsg", "One or more fields are blank!");
		}
		else if(!price.matches("[0-9]+(.[0-9]{1,2})?")){
			request.setAttribute("errorMsg", "Invalid argument for price! Up to two decimal places only.");
		}
		else if(!quantity.matches("[0-9]+")){
			request.setAttribute("errorMsg", "Invalid argument for quantity!");
		}
		else {
			Product pro = new Product();
			pro.setProductName(name);
			pro.setPrice(new BigDecimal(price));
			pro.setImageURL("img/product.jpg");
			Category cat = adminService.getCategory(category);
			pro.setCategory(cat);
			try {
				adminService.addProduct(pro, Integer.parseInt(quantity));
				request.setAttribute("successMsg", "Success!");
			} catch (ServiceException e) {
				request.setAttribute("errorMsg", e.getMessage());
			}
		}
		return "forward:/addProduct";
	}
	
	@RequestMapping("/addCategory")
	private String addCategory(
			HttpServletRequest request){
		return "addCategory";
	}
	
	@RequestMapping("/processAddCategory")
	private String processAddCategory(
			HttpServletRequest request,
			@RequestParam(value = "categoryName", required = false) String categoryName){
		if(categoryName == null || categoryName.trim().equals("")){
			request.setAttribute("errorMsg", "Field is blank!");
		}
		else{
			Category cat = new Category();
			cat.setCategoryName(categoryName);
			try {
				adminService.addCategory(cat);
				request.setAttribute("successMsg", "Success!");
			} catch (ServiceException e) {
				request.setAttribute("errorMsg", e.getMessage());
			}
		}
		return "forward:/addCategory";
	}
	
	@RequestMapping("/cust")
	private String cust(
			HttpServletRequest request,
			@RequestParam(value = "categoryName", required = false) String categoryName){
		if(categoryName == null) categoryName = "";
		Inventory inventory = null;
		Category category = new Category(new Long(0), categoryName);
		List<Category> categoryList = null;
		try {
			categoryList = adminService.getCategories();
			inventory = adminService.viewProducts(category);
			request.setAttribute("inventory", inventory);
			request.setAttribute("category", category);
			request.setAttribute("categoryList", categoryList);
		} catch (ServiceException e) {
			request.setAttribute("errorMsg", e.getMessage());
		}
		return "cust";
	}
	
	@RequestMapping("/viewCart")
	private String viewCart(
			HttpServletRequest request
			){
		User user;
		Cart cart;
		try {
			user = loginService.getUser((String) request.getSession().getAttribute("username"));
			cart = customerService.getCartFromUser(user);
			request.setAttribute("cart", cart);
		} catch (ServiceException e) {
			request.setAttribute("errorMsg", e.getMessage());
		}
		return "viewCart";
	}
	
	@RequestMapping("/clearCart")
	private String clearCart(HttpServletRequest request){
		User user;
		try {
			user = loginService.getUser((String) request.getSession().getAttribute("username"));
			customerService.clearCart(user);
			request.setAttribute("successMsg", "Success!");
		} catch (ServiceException e) {
			request.setAttribute("errorMsg", e.getMessage());
		}
		return "forward:/viewCart";
	}
	
}