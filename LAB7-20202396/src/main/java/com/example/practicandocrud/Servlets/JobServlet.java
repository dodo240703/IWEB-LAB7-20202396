package com.example.practicandocrud.Servlets;

import com.example.practicandocrud.Beans.Job;
import com.example.practicandocrud.Daos.JobDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "JobServlet",value = {"/JobServlet","/JobServlet1"})
public class JobServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*JobDao jobDao = new JobDao();
        ArrayList<Job> lisaTrabajos = jobDao.obtenerListaTrabajos();

        request.setAttribute("lista",lisaTrabajos);

        RequestDispatcher viwe = request.getRequestDispatcher("listaTrabajos.jsp");
        viwe.forward(request,response);*/

        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        JobDao jobDao = new JobDao();
        RequestDispatcher view;

        switch (action) {
            case "lista":
                ArrayList<Job> listaTrabajos = jobDao.obtenerListaTrabajos();
                request.setAttribute("lista", listaTrabajos);

                view = request.getRequestDispatcher("listaTrabajos.jsp");
                view.forward(request, response);
                break;
            case "formCrear":
                view = request.getRequestDispatcher("nuevoTrabajo.jsp");
                view.forward(request, response);
                break;
            case "editar":
                String jobId = request.getParameter("id");
                Job Job = jobDao.obtenerTrabajo(jobId);
                if(Job == null){
                    response.sendRedirect(request.getContextPath() + "/JobServlet");
                }else{
                    request.setAttribute("job",Job);
                    view = request.getRequestDispatcher("editarTrabajo.jsp");
                    view.forward(request, response);
                }
                break;

            case "borrar":
                String idd = request.getParameter("id");
                if(jobDao.obtenerTrabajo(idd) != null){
                    jobDao.borrarTrabajo(idd);
                }
                response.sendRedirect(request.getContextPath() + "/JobServlet");
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        JobDao jobDao = new JobDao();
        RequestDispatcher view;

        switch(action) {
            case "crear":
                String jobId = request.getParameter("jobId");
                String jobTitle = request.getParameter("jobTitle");
                int minSalary = Integer.parseInt(request.getParameter("minSalary"));
                int maxSalary = Integer.parseInt(request.getParameter("maxSalary"));

                jobDao.crearTrabajo(jobId, jobTitle, minSalary, maxSalary);


                response.sendRedirect(request.getContextPath() + "/JobServlet");

                break;
            case "edit":
                String jobId2 = request.getParameter("jobId");
                String jobTitle2 = request.getParameter("jobTitle");
                String minSalary2 = request.getParameter("minSalary");
                String maxSalary2 = request.getParameter("maxSalary");



                Job job2 = new Job();
                job2.setJobId(jobId2);
                job2.setJobTitle(jobTitle2);
                job2.setMinSalary(Integer.parseInt(minSalary2));
                job2.setMaxSalary(Integer.parseInt(maxSalary2));

                jobDao.actualizarTrabajo(job2.getJobId(), job2.getJobTitle(), job2.getMinSalary(), job2.getMaxSalary());
                response.sendRedirect(request.getContextPath() + "/JobServlet");

                break;


        }
    }
}
