package com.mlma.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.mlma.model.Add;
import com.mlma.service.BaseService;

@Controller
public class BaseController {
	private BaseService baseService;

	public BaseService getBaseService() {
		return baseService;
	}
	@Autowired
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}


	@RequestMapping("getAll")
	public void getAddInfoAll(HttpServletRequest request,HttpServletResponse response){
		try {			
			List<Add> list = baseService.getAll();
			request.setAttribute("addLists", list);
			Gson gson = new Gson();
			StringBuffer sb = new StringBuffer();
			String json = gson.toJson(list);
			sb = new StringBuffer();
			sb.append("{");
			sb.append("\"code\":");
			sb.append("0");
			sb.append(",");
			sb.append("\"list\":");
			sb.append(json);
			sb.append("}");
			System.out.println(sb.toString());
			renderJson(sb.toString(), response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
		}
	}
	protected void renderJson(String json,HttpServletResponse response) {

		try {
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
