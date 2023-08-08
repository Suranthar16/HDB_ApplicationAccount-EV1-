

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import HDBDTO.HDBRentalDTO;
import HDBDAO.HDBRentalDAO;

/**
 * Servlet implementation class Create_Servlet
 */
@WebServlet("/HDBCreateServlet")
public class HDBCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HDBCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HDBRentalDTO dto=new HDBRentalDTO();
		
		String Name=request.getParameter("name");
		String NRIC=request.getParameter("nric");
		String date=request.getParameter("dob");
		
		String DOB = date.replaceAll("-", "");
			
		String Choice=request.getParameter("choice");
		String Zone=request.getParameter("zone");
		
		dto.setName(Name);
		dto.setNRIC(NRIC);
		dto.setDOB(DOB);
		dto.setChoice(Choice);
		dto.setZone(Zone);
		
		System.out.println("cName="+Name);
		System.out.println("cNRIC="+NRIC);
		System.out.println("cDOB="+DOB);
		System.out.println("cChoice="+Choice);
		System.out.println("cZone="+Zone);
		
		HDBRentalDAO dao=new HDBRentalDAO();
		boolean result=dao.create(dto);
		
		if(result) {
			String massage="Account Created Successful"	;
		
			response.sendRedirect("HDBCreateAccount.jsp?message="+massage);
		}else {
			String massage="Account Creation Faild"	;
			
			response.sendRedirect("HDBCreateAccount.jsp?message="+massage);
		}
		
	}

}
