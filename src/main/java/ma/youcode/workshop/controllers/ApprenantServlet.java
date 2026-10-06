package ma.youcode.workshop.controllers;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.youcode.workshop.dao.ApprenantDao;
import ma.youcode.workshop.models.Apprenant;


@WebServlet (name = "ApprenantServlet", urlPatterns = {"/apprenants/*"})
public class ApprenantServlet extends HttpServlet {
    private final ApprenantDao dao=new ApprenantDao();

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
        super.doDelete(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // /apprenants/new -> formulaire d'ajout
        if("/new".equals(req.getPathInfo())){
            req.getRequestDispatcher("/WEB-INF/views/index.html").forward(req, resp);
            return;
        }

        List<Apprenant> apprenants=dao.findAll();

        // PrintWriter out=resp.getWriter();
        // out.println("La Liste des Apprenants");
        // resp.setContentType("text/html;charset:UTF-8");
        // if(apprenants.size()!=0){
        //     out.print("<ul>");
        //     for (Apprenant apprenant : apprenants) {

        //         out.println("<li>" + apprenant.getNom() + " " + apprenant.getPrenom() + " " + apprenant.getFiliere() + "</li>");
                
        //     }
        //     out.print("</ul>");
        // }

        req.setAttribute("apprenants", apprenants);
        req.getRequestDispatcher("/WEB-INF/views/apprenants.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String nom=req.getParameter("nom");
        String prenom=req.getParameter("prenom");
        String email=req.getParameter("email");
        String filiere=req.getParameter("filiere");

        dao.save(new Apprenant(null, nom, prenom, email, filiere));

        // redirection vers la liste (évite de renvoyer le formulaire avec F5)
        resp.sendRedirect(req.getContextPath() + "/apprenants");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPut(req, resp);
    }
    
}
