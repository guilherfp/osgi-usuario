package br.com.pcsist.wta.usuario.client.application.home;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

/**
 * @author guilherme.pacheco
 */
public class HomeModule extends AbstractPresenterModule {

  @Override
  protected void configure() {
    bindPresenter(HomePagePresenter.class, HomePagePresenter.MyView.class, HomePageView.class,
      HomePagePresenter.MyProxy.class);
  }

}
