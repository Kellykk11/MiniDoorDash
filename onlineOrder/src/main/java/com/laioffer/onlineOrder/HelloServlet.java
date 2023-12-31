package com.laioffer.onlineOrder;


import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


import org.apache.commons.io.IOUtils;
import org.json.JSONObject;


@WebServlet(name = "helloServlet", value = "/hello-servlet")//用来接受网页的请求
public class HelloServlet extends HttpServlet {
    private String message;


    public void init() {
        message = "Hello World!";
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");


        // Hello
        JSONObject customer = new JSONObject();
        customer.put("email","kelly@gamil");
        customer.put("age",18);
        response.getWriter().println(customer);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Read customer information from request body
        JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));
        String email = jsonRequest.getString("email");
        String firstName = jsonRequest.getString("first_name");
        String lastName = jsonRequest.getString("last_name");
        int age = jsonRequest.getInt("age");
        // Print customer information to IDE console
        System.out.println("Email is: " + email);
        System.out.println("First name is: " + firstName);
        System.out.println("Last name is: " + lastName);
        System.out.println("Age is: " + age);
        // Return status = ok as response body to the client
        response.setContentType("application/json");
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "ok");
        response.getWriter().print(jsonResponse);
    }
    public void destroy() {
    }
}
