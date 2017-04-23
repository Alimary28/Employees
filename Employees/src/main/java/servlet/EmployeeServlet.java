package servlet;


import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ListIterator;


@WebServlet("/emp")
public class EmployeeServlet extends HttpServlet {

    private static final String ACTION = "action";
    private static final String INFO_LIST = "list";

    public void service (HttpServletRequest request , HttpServletResponse response){

        HttpSession session = request.getSession(true);
      //   String name = (String)session.getAttribute("name");

        String name = request.getParameter("employees");





        if (name == null){
            System.out.println("Please select a name !");

        }
        else {

            String action = request.getParameter(ACTION);
            if (action != null && action.equals(INFO_LIST)){
                infoList(request , response);
            }
        }
    }

    private void infoList (HttpServletRequest request , HttpServletResponse response){

        HttpSession session = request.getSession(true);

        AccessInfo emp = new AccessInfo();
        //String n = (String)session.getAttribute("name");
         String n = request.getParameter("employees");
        System.out.println("Employee :"+n);

        List<EmployeeBean> l = emp.getInfoList(n);

        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        for (ListIterator<EmployeeBean> iterator = l.listIterator();iterator.hasNext();){
            EmployeeBean e = iterator.next();
            if ( e != null){
                System.out.println(e.getName());
                System.out.println(e.getEmp_id()+":");
                System.out.println(e.getCity());
                System.out.println(e.getJob());
                arrayBuilder.add(Json.createObjectBuilder()
                .add("name" ,e.getName())
                .add("city" , e.getCity())
                .add("job" , e.getJob())
                .add("emp_id" , e.getEmp_id())
                );
            }
        }
        objectBuilder.add("employees" , arrayBuilder);
        JsonObject jsonFinal = objectBuilder.build();

        System.out.println(" Info list :" + jsonFinal.toString());
        returnJsonResponse(response , jsonFinal.toString());

    }


    private void returnJsonResponse(HttpServletResponse response, String jsonResponse) {
        response.setContentType("application/json");
        PrintWriter pr = null;
        try {
            pr = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert pr != null;
        pr.write(jsonResponse);
        pr.close();
    }
}
