import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LoginServlet extends HttpServlet
{
     Connection con;
     
     public void service(HttpServletRequest request,HttpServletResponse response)
     {
       try{
               Class.forName("oracle.jdbc.driver.OracleDriver");
           con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
            String s1=request.getParameter("uname");        
            String s2=request.getParameter("pwd");    
             PreparedStatement pstmt=con.prepareStatement("select * from uinfo where uname=?  and pwd=?"); 
             pstmt.setString(1,s1);
             pstmt.setString(2,s2);
             ResultSet rs=pstmt.executeQuery();  
            PrintWriter  pw=response.getWriter();
            pw.println("<html><body bgcolor=lightyellow text=red><center><h1>");
            if(rs.next())
            {
            pw.println("wellcome"+s1);
             }
            else
             {
              pw.println("invalid username and passward");
               pw.println("<a href=registration.html>Registration</a>");
              }
               pw.println("</h1></center></body></html>");
          }
        catch(Exception e)
        {
          System.out.println(e);
        }

     }

}