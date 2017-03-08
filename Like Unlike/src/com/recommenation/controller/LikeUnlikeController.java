package com.recommenation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recmmendation.connection.ConnectionManager;

/**
 * Servlet implementation class LikeUnlikeController
 */
@WebServlet("/LikeUnlikeController")
public class LikeUnlikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeUnlikeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.getParameter("call");
		PrintWriter out = response.getWriter();
		String likeUnlike = request.getParameter("call");
		String mainId = request.getParameter("id");
		String id = ","+mainId;
		int imgid = 1;
		out.print(request.getParameter("call")+""+request.getParameter("id"));
		try {
			Connection conn = ConnectionManager.getConnectin();
			Statement st = conn.createStatement();
			
			if("like".equals(likeUnlike)) {
				System.out.println("in Like");
				
				String sql = "update likes set userid = concat(ifnull(userid,''),'"+id+"') where id="+imgid;
				
				int row = st.executeUpdate(sql);
				//request.set("call", "Unlike");
				HttpSession sess = request.getSession();
				sess.setAttribute("call", "unlike");
				response.sendRedirect("like button.jsp");
				
			}else {
				
				String sql = "select * from likes where id="+imgid;
			ArrayList<String> idList = new ArrayList<String>();
				ResultSet rs = st.executeQuery(sql);
				if(rs.next()) {
					
					String ids = rs.getString(2);
					String arr[] = ids.split(",");
					
				//	idList = (ArrayList<String>) Arrays.asList(arr);
					List<String> aa = new LinkedList<String>(Arrays.asList(arr));
					System.out.println("Before:"+aa);
					if(aa.contains(mainId)); {
						System.out.println("User liked the Image");
						//String a = id.re;
						System.out.println("ID"+mainId);
						aa.remove(mainId);
						System.out.println(aa);
						
						
						
					}String data = 	Arrays.toString(aa.toArray()).replace("[", "").replace("]", "");
					data= data.replaceAll("\\s+","");	
							
							
							System.out.println(data);
					// = Arrays.toString(aa.toArray()).replace("[", "").replace("]", "");
					 sql = "update likes set userid = '"+data+"' where id="+imgid;
					 int row = st.executeUpdate(sql);
					
					System.out.println(aa);
					HttpSession sess = request.getSession();
					sess.removeAttribute("call");
					sess.setAttribute("call", "like");
					response.sendRedirect("like button.jsp");
				}
				
				//System.out.println(aa);
				//Check on the imgId and recomve Id from the likes
				
				
				
				
				
				
				
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
