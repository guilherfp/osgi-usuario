package br.com.pcsist.wta.usuario.client.application.home;

import javax.inject.Inject;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.client.RestDispatch;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import br.com.pcsist.wta.usuario.client.application.ApplicationPresenter;
import br.com.pcsist.wta.usuario.client.place.Tokens;
import br.com.pcsist.wta.usuario.shared.usuario.UsuarioRest;
import br.com.pcsist.wta.usuario.shared.usuario.Usuarios;

public class HomePagePresenter extends
    Presenter<HomePagePresenter.MyView, HomePagePresenter.MyProxy> {

  interface MyView extends View {
    void showUsuario(Usuarios usuarios);

    void showErro(String message);
  }

  private final RestDispatch dispatcher;
  private final UsuarioRest usuarioRest;

  @ProxyStandard
  @NameToken(Tokens.HOME)
  interface MyProxy extends ProxyPlace<HomePagePresenter> {}

  @Inject
  HomePagePresenter(EventBus eventBus, MyView view, MyProxy proxy, RestDispatch dispatcher,
      UsuarioRest usuarioRest) {
    super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
    this.usuarioRest = usuarioRest;
    this.dispatcher = dispatcher;
  }

  @Override
  protected void onReveal() {
    dispatcher.execute(usuarioRest.todos(), new AsyncCallback<Usuarios>() {

      @Override
      public void onFailure(Throwable caught) {
        getView().showErro(caught.getMessage());
      }

      @Override
      public void onSuccess(Usuarios result) {
        getView().showUsuario(result);
      }
    });
  }

}
