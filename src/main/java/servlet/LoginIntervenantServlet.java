package servlet;

import Compte.Client;
import Compte.Intervenant;
import CompteDataBase.ClientDB;
import CompteDataBase.IntervenantDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/LoginIntervenantServlet") // Récupère les informations du formulaire de connexion de l'intervenant
public class LoginIntervenantServlet extends HttpServlet {
    // La structure est la même pour toutes les classes Servlet
    @Override
    // Pour recupérer toutes les informations du formulaire et envoie une réponse à la page
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String email=req.getParameter("username");
        String password=req.getParameter("password");

        Intervenant intervenant = new Intervenant();
        intervenant.setMailI(email);
        intervenant.setMdpI(password);



        //
        IntervenantDB db=new IntervenantDB();
        Intervenant result=db.login(intervenant);

        if(result==null){
            resp.getWriter().write("Echec de la connexion");

            resp.addHeader ("refresh", "1;URL=/PROJET_war/loginInter.jsp");


        }else{
            HttpSession session = req.getSession(true);
            session.setAttribute("mail",email);
            resp.addHeader ("refresh", "1;URL=/PROJET_war/AccueilInter.jsp");

        }
    }

    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
