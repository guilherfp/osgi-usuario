package br.com.pcsist.wta.usuario.client.application;

import javax.inject.Inject;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.Proxy;

/**
 * @author guilherme.pacheco
 */
public class ApplicationPresenter extends
    Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy>
    implements ApplicationUiHandlers {

  interface MyView extends View, HasUiHandlers<ApplicationUiHandlers> {}

  public static final NestedSlot SLOT_MAIN = new NestedSlot();

  @ProxyStandard
  interface MyProxy extends Proxy<ApplicationPresenter> {}

  @Inject
  ApplicationPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
    super(eventBus, view, proxy, RevealType.Root);
    getView().setUiHandlers(this);
  }

}
