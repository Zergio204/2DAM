package Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ServletFich
 */
@WebServlet("/ServletFich")
public class ServletFich extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletFich() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fact1 = request.getParameter("fact1") != null ? request.getParameter("fact1") : "";
		String fact2 = request.getParameter("fact2") != null ? request.getParameter("fact2") : "";
		String fact3 = request.getParameter("fact3") != null ? request.getParameter("fact3") : "";
		String fact4 = request.getParameter("fact4") != null ? request.getParameter("fact4") : "";
		String fact5 = request.getParameter("fact5") != null ? request.getParameter("fact5") : "";
		String fact6 = request.getParameter("fact6") != null ? request.getParameter("fact6") : "";
		
		String page = "";
		
		switch(request.getParameter("readingWriting")) {
		case "lectura":
			if(!fact1.isBlank() || !fact2.isBlank() || !fact3.isBlank() || !fact4.isBlank() || !fact5.isBlank() || !fact6.isBlank()) {
				request.setAttribute("emptyError", "(*)Los campos no pueden contener ningun dato");
				page = "TratamientoFich.jsp";
			}else {
				switch(request.getParameter("fileTypes")) {
				case "XLS":
				
					
				case "CSV":
				    readCSV(request);
				    break;
					
				case "JSON":
					
					
				case "XML":

					
				case "RDF":

					
				}
				page = "AccesoDatosA.jsp";
			}
			break;
			
		case "escritura":
			if(fact1.isBlank() || fact2.isBlank() || fact3.isBlank() || fact4.isBlank() || fact5.isBlank() || fact6.isBlank()) {
				request.setAttribute("emptyError", "(*)Los campos no pueden estar vacios");
				page = "TratamientoFich.jsp";
			}else {
				switch(request.getParameter("fileTypes")) {
				case "XLS":
				
				
				case "CSV":
					
					
				case "JSON":
					
				
				case "XML":
					
					
				case "RDF":
					
					
				}
				page = "AccesoDatosA.jsp";
			}
			break;
			
		}
		request.getRequestDispatcher(page).forward(request, response);
	}
	
	//Metodo para leer un archivo CSV
	private void readCSV(HttpServletRequest request) {
		
		File file = new File("/ArchivosDatosAbiertos/ArchivoCSV.csv");
		
		List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
            String line;

            // Leer cada línea del archivo
            while ((line = br.readLine()) != null) {
                // Dividir la línea en columnas usando coma como separador
                String[] row = line.split(",");
                data.add(row);
            }
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        request.setAttribute("data", data);
        
        
	}
	
}
	



