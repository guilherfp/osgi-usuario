package br.com.pcsist.wta.usuario.client.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

import br.com.pcsist.wta.usuario.client.application.cadastro.CadastroModule;
import br.com.pcsist.wta.usuario.client.application.home.HomeModule;

/**
 * @author guilherme.pacheco
 */
public class ApplicationModule extends AbstractPresenterModule {

  @Override
  protected void configure() {
    install(new HomeModule());
    install(new CadastroModule());

    bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class,
      ApplicationView.class, ApplicationPresenter.MyProxy.class);
  }

}
