package br.com.pcsist.wta.usuario.client.application.home;

import javax.inject.Inject;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.client.RestDispatch;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import br.com.pcsist.wta.usuario.client.application.ApplicationPresenter;
import br.com.pcsist.wta.usuario.client.place.Tokens;
import br.com.pcsist.wta.usuario.shared.usuario.UsuarioRest;
import br.com.pcsist.wta.usuario.shared.usuario.Usuarios;

/**
 * @author guilherme.pacheco
 */
public class HomePagePresenter extends
    Presenter<HomePagePresenter.MyView, HomePagePresenter.MyProxy> implements HomePageUiHandlers {

  interface MyView extends View, HasUiHandlers<HomePageUiHandlers> {
    void showUsuario(Usuarios usuarios);

    void showErro(String message);
  }

  private final RestDispatch dispatcher;
  private final UsuarioRest usuarioRest;
  private final PlaceManager placeManager;

  @ProxyStandard
  @NameToken(Tokens.HOME)
  interface MyProxy extends ProxyPlace<HomePagePresenter> {}

  @Inject
  HomePagePresenter(EventBus eventBus, MyView view, MyProxy proxy, RestDispatch dispatcher,
      UsuarioRest usuarioRest, PlaceManager placeManager) {
    super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
    getView().setUiHandlers(this);
    this.usuarioRest = usuarioRest;
    this.dispatcher = dispatcher;
    this.placeManager = placeManager;
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

  @Override
  public void cadastrarUsuario() {
    placeManager.revealPlace(new PlaceRequest.Builder().nameToken(Tokens.CADASTRO).build());
  }

}
