package servlets;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ej4
 */
@WebServlet("/Ej4")
public class Ej4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ej4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String,String[]> mapa = request.getParameterMap();
		mapa.forEach((k,v)->{
			try{
				response.getWriter().append("<tr><td>" + k + "</td></tr><tr><td>" + Arrays.toString(v) + "</td></tr>");
			}catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

}
