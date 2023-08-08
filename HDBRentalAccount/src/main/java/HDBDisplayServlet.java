
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import HDBDAO.HDBRentalDAO;
import HDBDTO.HDBRentalDTO;

/**
 * Servlet implementation class HDBDisplayServlet
 */
@WebServlet("/HDBDisplayServlet")
public class HDBDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HDBDisplayServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		System.out.println("into dis");

		HDBRentalDAO dao = new HDBRentalDAO();

		System.out.println("into disto");

		ArrayList<HDBRentalDTO> Applicantlist = dao.Applicantinfo();
		if (Applicantlist != null)
			System.out.println("list size---" + Applicantlist.size());

		HttpSession session = request.getSession();

		session.setAttribute("Applicantlist", Applicantlist);

		System.out.println("into dis3");

		response.sendRedirect("HDBDisplayAccount.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
