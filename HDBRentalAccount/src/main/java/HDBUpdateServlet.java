
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
 * Servlet implementation class HDBUpdateServlet
 */
@WebServlet("/HDBUpdateServlet")
public class HDBUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HDBUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String userID = request.getParameter("id");
		if (userID != null) {
			HDBRentalDTO dto = new HDBRentalDTO();

			System.out.println("uID=" + userID);

			HDBRentalDAO dao = new HDBRentalDAO();

			ArrayList<HDBRentalDTO> Specificlist = dao.Specificinfo(userID);
			if (Specificlist != null)
				System.out.println("list size---" + Specificlist.size());

			HttpSession session = request.getSession();

			session.setAttribute("Specificlist", Specificlist);

			String Show = "Show";
			response.sendRedirect("HDBUpdateAccount.jsp?Show=" + Show);

		}

		String Zone = request.getParameter("zone");
		String Id = request.getParameter("userid");

		System.out.println("uZone=" + Zone);
		System.out.println("uId=" + Id);

		if (Zone != null) {

			HDBRentalDAO dao = new HDBRentalDAO();

			boolean result = dao.updateaccount(Id, Zone);
			String massage = "Account Updated  Successful";

			response.sendRedirect("HDBUpdateAccount.jsp?message=" + massage);

		}

	}

}
