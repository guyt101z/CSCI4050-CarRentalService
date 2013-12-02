package edu.uga.csci4050.group3.core;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uga.csci4050.group3.db.DatabaseAbstraction;
import edu.uga.csci4050.group3.db.RecordNotFoundException;
import edu.uga.csci4050.group3.db.SessionManagement;
import edu.uga.csci4050.group3.template.Alert;
import edu.uga.csci4050.group3.template.LayoutRoot;
import edu.uga.csci4050.group3.template.SimpleTemplate;

public class UserAccountUI implements Boundary {
	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response, ServletContext context,
			RequestType type) {
		LayoutRoot lr = new LayoutRoot(context, request, response);
		SimpleTemplate accountForm = new SimpleTemplate(context, "UserAccountForm.mustache");
		lr.setTitle("Account Information");
		
		// Get the current user
		SessionManagement sessMan = new SessionManagement(request, response);
		UserEntity user = null;
		try {
			user = DatabaseAbstraction.getUserByUsername(sessMan.getLoggedinUsername());
		} catch (AuthenticationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		if(!sessMan.isUserLoggedIn()){
			try {
				response.sendRedirect(CarRentalServlet.getFullURL(context, "/user/home"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		if(type == RequestType.GET) {
			accountForm.setVariable("username", user.getUsername());
			accountForm.setVariable("password", user.getPassword());
			accountForm.setVariable("email", user.getEmail());
			lr.setContent(accountForm.render());
			lr.render(response);
		} else {
			UserAccountControl uac = new UserAccountControl();
			try {
				uac.update(request, response);
				accountForm.setVariable("alerts", "Account Updated!");
				lr.setContent(accountForm.render());
				lr.render(response);
			} catch (InvalidInputException e) {
				// Invalid input
				accountForm.setVariable("alerts", e.getMessagesHtml(context));
				lr.setContent(accountForm.render());
				lr.render(response);
			} catch (Exception e){
				Alert error = new Alert(context);
				error.setContent("Something went wrong!");
				accountForm.setVariable("alerts", error.render());
				lr.setContent(accountForm.render());
				lr.render(response);
			}
			
		}
	}

}