package br.com.pcsist.wta.usuario.client.application.home;

import javax.inject.Inject;

import org.gwtbootstrap3.extras.notify.client.constants.NotifyType;
import org.gwtbootstrap3.extras.notify.client.ui.Notify;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import br.com.pcsist.wta.usuario.shared.usuario.Usuario_;
import br.com.pcsist.wta.usuario.shared.usuario.Usuarios;

/**
 * @author guilherme.pacheco
 */
class HomePageView extends ViewWithUiHandlers<HomePageUiHandlers>
    implements HomePagePresenter.MyView {

  interface Binder extends UiBinder<Widget, HomePageView> {}

  @Inject
  HomePageView(Binder uiBinder) {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @Override
  public void showUsuario(Usuarios usuarios) {
    for (Usuario_ usuario : usuarios.usuario) {
      Notify.notify(usuario.toString());
    }
  }

  @Override
  public void showErro(String message) {
    Notify.notify(message, NotifyType.DANGER);
  }

  @UiHandler("aCadastrarUsuario")
  void cadastrarUsuario(ClickEvent event) {
    getUiHandlers().cadastrarUsuario();
  }

}
