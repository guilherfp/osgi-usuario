package br.com.pcsist.wta.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * @author guilherme.pacheco
 */
public abstract class AbstractRest {

  protected Response response(Object obj) {
    return obj == null ? Response.status(Status.NOT_FOUND).build() : Response.ok(obj).build();
  }

}
