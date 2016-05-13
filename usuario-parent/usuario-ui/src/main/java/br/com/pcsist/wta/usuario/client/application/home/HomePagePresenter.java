package br.com.pcsist.wta.usuario.client.application.home;

import javax.inject.Inject;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import br.com.pcsist.wta.usuario.client.application.ApplicationPresenter;
import br.com.pcsist.wta.usuario.client.place.Tokens;

public class HomePagePresenter extends
    Presenter<HomePagePresenter.MyView, HomePagePresenter.MyProxy> {

  interface MyView extends View {}

  @ProxyStandard
  @NameToken(Tokens.HOME)
  interface MyProxy extends ProxyPlace<HomePagePresenter> {}

  @Inject
  HomePagePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
    super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);
  }

}
