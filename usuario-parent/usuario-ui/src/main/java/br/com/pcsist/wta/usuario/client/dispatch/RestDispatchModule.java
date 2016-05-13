package br.com.pcsist.wta.usuario.client.dispatch;

import com.google.gwt.inject.client.AbstractGinModule;
import com.gwtplatform.dispatch.rest.client.RestApplicationPath;
import com.gwtplatform.dispatch.rest.client.gin.RestDispatchAsyncModule;

/**
 * @author guilherme.pacheco
 */
public class RestDispatchModule extends AbstractGinModule {

  @Override
  protected void configure() {
    install(new RestDispatchAsyncModule.Builder().build());
    bindConstant().annotatedWith(RestApplicationPath.class).to("/cxf");
  }

}
