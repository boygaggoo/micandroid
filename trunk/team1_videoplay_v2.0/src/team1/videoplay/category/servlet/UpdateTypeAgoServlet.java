package team1.videoplay.category.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team1.videoplay.category.model.VideoType;
import team1.videoplay.category.service.VideoTypeService;
import team1.videoplay.category.service.impl.VideoTypeServiceImpl;
import team1.videoplay.utils.MyException;

public class UpdateTypeAgoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int typeID = Integer.parseInt(request.getParameter("typeID"));
		VideoTypeService videoTypeService = VideoTypeServiceImpl.getInstance();
		VideoType videoType = null;
		try {
			 videoType = videoTypeService.findVideoTypeById(typeID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("videoType", videoType);
		request.getRequestDispatcher("manage/typeUpdate.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
	}

}
