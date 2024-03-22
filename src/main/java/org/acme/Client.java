package org.acme;

import ar.com.osde.services.administracion.empleado.Empleado;
import ar.com.osde.services.administracion.empleado.Empleado_Service;
import ar.com.osde.services.administracion.empleado.GetEmpleadoByUsername;
import ar.com.osde.services.administracion.empleado.GetEmpleadoByUsernameResponse;
import io.quarkiverse.cxf.annotation.CXFClient;
import jakarta.jws.WebParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
@Path("/getFilial")
public class Client {

    @CXFClient("empleado")
    Empleado empleado;

    @GET
    @Path("{username}")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer getFilial(@PathParam("username") String username){

        ar.com.osde.entities.empleado.Empleado empl = empleado.getEmpleadoByUsername(username);
        return empl.getCodFilial();
    }
}
