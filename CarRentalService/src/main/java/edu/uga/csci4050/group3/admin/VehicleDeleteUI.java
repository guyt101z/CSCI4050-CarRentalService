package edu.uga.csci4050.group3.admin;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uga.csci4050.group3.core.Boundary;
import edu.uga.csci4050.group3.core.CarRentalServlet;
import edu.uga.csci4050.group3.core.RequestType;
import edu.uga.csci4050.group3.core.UserType;
import edu.uga.csci4050.group3.db.RecordNotFoundException;
import edu.uga.csci4050.group3.db.SessionManagement;
import edu.uga.csci4050.group3.template.Alert;
import edu.uga.csci4050.group3.template.ConfirmationDialog;
import edu.uga.csci4050.group3.template.LayoutRoot;

public class VehicleDeleteUI implements Boundary{

	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response, ServletContext context,
			RequestType type) {
		
		// Check if the user is authorized
		if(new SessionManagement(request, response).requireRole(UserType.ADMIN, CarRentalServlet.getFullURL(context, "/user/home"))){
			return;
		}
		
		// Check that we got a UID
		if(!request.getParameterMap().containsKey("uid")){
			new Alert(context, "UID wasn't specified.").render(response);
			return;
		}
		
		// Show confirmation dialog
		if(request.getParameterMap().containsKey("confirm") && request.getParameterMap().get("confirm")[0].equals("yes")){
			// Request confirmed. Delete
			VehicleDeleteControl control = new VehicleDeleteControl();
			try {
				control.deleteVehicle(request.getParameter("uid"));
				CarRentalServlet.redirect(context, response, "/vehicles");
				return;
			} catch (RecordNotFoundException e) {
				// Not found. Show error
				new Alert(context, "Unable to find vehicle with UID: " + request.getParameter("uid")).render(response);
				return;
			}
		}else{
			// Show dialog
			LayoutRoot lr = new LayoutRoot(context, request, response);
			ConfirmationDialog dialog = new ConfirmationDialog(context, "Delete vehicle with UID: " + request.getParameter("uid"),
					CarRentalServlet.getFullURL(context, "/vehicle/delete?confirm=yes&uid=" + request.getParameter("uid")), 
					CarRentalServlet.getFullURL(context, "/vehicles"));
			lr.setContent(dialog.render());
			lr.render(response);
		}
	}

}
