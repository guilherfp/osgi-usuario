package br.com.pcsist.wta.usuario.client.gin;

import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.annotations.ErrorPlace;
import com.gwtplatform.mvp.client.annotations.UnauthorizedPlace;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.gwtplatform.mvp.shared.proxy.RouteTokenFormatter;

import br.com.pcsist.wta.usuario.client.application.ApplicationModule;
import br.com.pcsist.wta.usuario.client.dispatch.RestDispatchModule;
import br.com.pcsist.wta.usuario.client.place.Tokens;

/**
 * @author guilherme.pacheco
 */
public class ClientModule extends AbstractPresenterModule {

  @Override
  protected void configure() {
    install(new DefaultModule.Builder().tokenFormatter(RouteTokenFormatter.class).build());

    bindConstant().annotatedWith(DefaultPlace.class).to(Tokens.HOME);
    bindConstant().annotatedWith(ErrorPlace.class).to(Tokens.HOME);
    bindConstant().annotatedWith(UnauthorizedPlace.class).to(Tokens.HOME);

    install(new RestDispatchModule());
    install(new ApplicationModule());
  }

}
